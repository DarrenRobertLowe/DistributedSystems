
package grpc.pollution;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import grpc.pollution.pollutionServiceGrpc.pollutionServiceBlockingStub;
import grpc.pollution.pollutionServiceGrpc.pollutionServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

//jmdns
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


public class PollutionClient {
	
	private static ServiceInfo pollutionServiceInfo; // jmdns

	public static pollutionServiceBlockingStub blockingStub;
	public static pollutionServiceStub asyncStub;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// jmdns resoultion
		String radiation_service_type = "_pollutionservice_http._tcp.local.";
		discoverPollutionService(radiation_service_type);
				
				
		// Build a channel (JmDNS) - a channel connect the client to the server
		int port 	= pollutionServiceInfo.getPort();					// e.g. 50051;
		String host = pollutionServiceInfo.getHostAddresses()[0];		// i.e. "localhost";
		
		
		// create the channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		
		// create the sync and async stubs
		blockingStub = pollutionServiceGrpc.newBlockingStub(channel);
		asyncStub = pollutionServiceGrpc.newStub(channel);
		
		
		// run the rpc calls
		streamPollution();			// note: the name of the methods here have no relation to the proto

		getLocalAirPollution();
		
		getDeviceStatus();
		
		getAllDeviceStatus();
		
		
		// terminate the channel so we don't get errors
		channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
		System.out.println();
		System.out.println("Program ended.");
	}
	
	
	
	
	
	
	// JmDNS
	private static void discoverPollutionService(String service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Radiation Service resolved: " + event.getInfo());

					pollutionServiceInfo = event.getInfo();

					int port = pollutionServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + pollutionServiceInfo.getNiceTextString());
					System.out.println("\t host: " + pollutionServiceInfo.getHostAddresses()[0]);
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Carbon Service removed: " + event.getInfo());
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Carbon Service added: " + event.getInfo());
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/* StreamPollution // client to server streaming
	 * Each IoT device will track air pollution in their vicinity
	 * and forward the information to the server via this method
	 */
	private static void streamPollution() throws InterruptedException {
		System.out.println();
		System.out.println();
		System.out.println("Streaming pollution data to the server");
		System.out.println("======================================");
		
		StreamObserver<response> responseObserver = new StreamObserver<response>() {
			@Override
			public void onNext(response msg) {
				System.out.println(msg.getReceived()); 	// get and print the response from the server
				msg.getReceived();
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("stream is completed.");
			}
		};
		
		
		
		StreamObserver<airPollution> requestObserver = asyncStub.streamPollution(responseObserver);
		try {
			String deviceID = "dev02";
			System.out.println("");
			System.out.println("");
			System.out.println("Sending radiation measurement data to server...");
			System.out.println("================================================");
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(25).setId(deviceID).build());
			Thread.sleep(100);
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(112).setId(deviceID).build());
			Thread.sleep(100);
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(34).setId(deviceID).build());
			Thread.sleep(100);
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(34).setId(deviceID).build());
			Thread.sleep(100);
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(200).setId(deviceID).build());
			Thread.sleep(100);
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(40).setId(deviceID).build());
			Thread.sleep(100);
			
			requestObserver.onNext(airPollution.newBuilder().setCarbon(85).setId(deviceID).build());
			Thread.sleep(100);
			
			
			// Mark the end of requests
			requestObserver.onCompleted();
			
			
			Thread.sleep(500);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* GetDeviceStatus	// unary
	 * This gets the health status of a specific
	 * IoT device which is returned as a string
	 * containing the float % out of 100.
	 */
	public static void getDeviceStatus() {
		System.out.println();
		System.out.println();
		
		String device = "dev04";
		
		System.out.println("Getting health status for '" + device + "'");
		System.out.println("=====================================");
		
	
		deviceStatusRequest request = deviceStatusRequest.newBuilder().setStatusRequestedID(device).build();
		deviceStatusResponse response = blockingStub.getDeviceStatus(request);
		System.out.println(response.getStatus()); // e.g.: "Health for device dev04: 77.14953"
	}
	
	
	
	
	
	/* GetLocalAirPollution
	 * With this method, clients send their geographic location to
	 * the server so that the server can respond with information
	 * regarding air pollution in the area of the client.
	 */
	public static void getLocalAirPollution() {
		System.out.println();
		System.out.println();
		
		System.out.println("Getting air pollution for local region...");
		System.out.println("=========================================");
		
		
		StreamObserver<regionalPollutionResponse> responseObserver = new StreamObserver<regionalPollutionResponse>() {
			@Override
			public void onNext(regionalPollutionResponse msg) {
				System.out.println("Carbon emmissions in your region: " + msg.getRegionalStatus());
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("stream is completed.");
			}
		};



		StreamObserver<locationRequest> requestObserver = asyncStub.getLocalAirPollution(responseObserver);

		try {
			// give variations in the location
			
			requestObserver.onNext(locationRequest.newBuilder().setLatitude(100).setLongitude(100).build());
			requestObserver.onNext(locationRequest.newBuilder().setLatitude(100).setLongitude(101).build());
			requestObserver.onNext(locationRequest.newBuilder().setLatitude(101).setLongitude(102).build());
			requestObserver.onNext(locationRequest.newBuilder().setLatitude(102).setLongitude(103).build());
			requestObserver.onNext(locationRequest.newBuilder().setLatitude(101).setLongitude(104).build());
			
			
			// Mark the end of requests
			requestObserver.onCompleted();
			
			
			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}



		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/* GetAllDeviceStatus	// server to client streaming
	 * This calculates the overall health of the system
	 * of IoT devices as an float out of 100%.
	 */
	// NOTE: This is a blocking stub
	public static void getAllDeviceStatus() {
		System.out.println();
		System.out.println();
		
		System.out.println("Getting overall average health status for all devices.");
		System.out.println("======================================================");
		
		
		allDeviceStatusRequest request = allDeviceStatusRequest
				.newBuilder()
				.setStatusRequested(true)
				.build();
		
		
		try {
			Iterator<allDeviceStatusResponse> responses = blockingStub.getAllDeviceStatus(request);
			
			while(responses.hasNext()) {
				allDeviceStatusResponse temp = responses.next();
				System.out.println(temp.getOverallDeviceHealth());
			}
			
			System.out.println("Finished.");

		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* GetAllDeviceStatus	// server to client streaming
	 * This calculates the overall health of the system
	 * of IoT devices as an float out of 100%.
	 */
	/*
	public static void getAllDeviceStatus() {
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("Requesting Health Status of All Devices Overall");
		System.out.println("===============================================");
		
		allDeviceStatusRequest request = allDeviceStatusRequest
				.newBuilder()
				.setStatusRequested(true)
				//.setAnotherVariable(0)
				.build();
		
		
		StreamObserver<allDeviceStatusResponse> responseObserver = new StreamObserver<allDeviceStatusResponse>() {
			int count = 0;
			
			@Override
			public void onNext(allDeviceStatusResponse value) {
				System.out.println(value.getOverallDeviceHealth());
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... health status based on "+ count+ " devices");
			}
		};
		
		
		asyncStub.getAllDeviceStatus(request, responseObserver);
		
		// finish tidily
		responseObserver.onCompleted();
		
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}