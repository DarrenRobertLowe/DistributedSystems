
package grpc.pollution;


import java.util.Iterator;
import java.util.Random;

import grpc.pollution.pollutionServiceGrpc.pollutionServiceBlockingStub;
import grpc.pollution.pollutionServiceGrpc.pollutionServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;



public class PollutionClient {

	public static pollutionServiceBlockingStub blockingStub;
	public static pollutionServiceStub asyncStub;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		//Build a channel - a channel connect the client to the server
		int port = 50051;
		String host = "localhost";
		
		
		// create the channels
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		// create the sync and async stubs
		blockingStub = pollutionServiceGrpc.newBlockingStub(channel);
		asyncStub = pollutionServiceGrpc.newStub(channel);
		
		
		streamPollution();			// note: the name of the methods here have no relation to the proto
		
		getLocalAirPollution();
		
		getDeviceStatus();
		
		getAllDeviceStatus();
		
		
		channel.shutdown(); 		// gracefully shutdown so the server doesn't throw an error
		
		System.out.println("Program ended.");
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