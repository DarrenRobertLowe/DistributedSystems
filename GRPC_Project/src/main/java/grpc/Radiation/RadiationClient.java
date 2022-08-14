
package grpc.Radiation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;


import grpc.Radiation.radiationServiceGrpc.radiationServiceBlockingStub;
import grpc.Radiation.radiationServiceGrpc.radiationServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
// jmdns
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


public class RadiationClient {

	public static radiationServiceBlockingStub blockingStub;
	public static radiationServiceStub asyncStub;
	
	
	private static ServiceInfo radiationServiceInfo;
	
	
	public static void main(String[] args) throws InterruptedException {
		String radiation_service_type = "_radiationservice_http._tcp.local.";
		discoverRadiationService(radiation_service_type);
		
		
		// Build a channel - a channel connect the client to the server
		int port 	= radiationServiceInfo.getPort();					// e.g. 50051;
		String host = radiationServiceInfo.getHostAddresses()[0];		// i.e. "localhost";
		
		
		// create the channels
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		// create the sync and async stubs
		blockingStub = radiationServiceGrpc.newBlockingStub(channel);
		asyncStub = radiationServiceGrpc.newStub(channel);
		
		
		streamRadiation();			// note: the name of the methods here have no relation to the proto
		
		getRadiationLevels();
		
		int threshold = 5;
		getRadiationWarnings(threshold);
		
		
		
		// terminate the channel so we don't get errors
		channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
		System.out.println();
		System.out.println("Program ended.");
	}
	
	
	
	// JmDNS
	private static void discoverRadiationService(String service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Radiation Service resolved: " + event.getInfo());

					radiationServiceInfo = event.getInfo();

					int port = radiationServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + radiationServiceInfo.getNiceTextString());
					System.out.println("\t host: " + radiationServiceInfo.getHostAddresses()[0]);
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Radiation Service removed: " + event.getInfo());
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Radiation Service added: " + event.getInfo());
				}
			});
			
			// Wait for 2 seconds
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
	
	
	
	
	
	
	
	
	
	
	// client to server streaming
	private static void streamRadiation() throws InterruptedException {
		StreamObserver<measurementsResponse> responseObserver = new StreamObserver<measurementsResponse>() {
			
			@Override
			public void onNext(measurementsResponse msg) {
				System.out.println(msg.getMessage()); // get and print the response from the server
				msg.getMessage();
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
		
		
		
		StreamObserver<radiationMeasurements> requestObserver = asyncStub.streamRadiation(responseObserver);
		try {
			System.out.println("");
			System.out.println("");
			System.out.println("Sending radiation measurement data to server...");
			System.out.println("================================================");
			
			String name = "dev02";
			
			// send the measurement data
			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(20).build());
			Thread.sleep(500);
			
			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(12).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(-4).build()); // for demonstration
			Thread.sleep(500);
			
			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(11).build());
			Thread.sleep(500);
			
			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(8).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(17).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setClientID(name).setPicocuries(13).build());
			Thread.sleep(500);
			
			
			// Mark the end of requests
			requestObserver.onCompleted();
			
			
			Thread.sleep(500);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	
	
	// server to client streaming
	// clients request a stream of all radiation levels
	// as they happen, arranged by severity.
	private static void getRadiationLevels() {
		System.out.println("");
		System.out.println("");
		
		System.out.println("Receiving radiation levels in order of severity: ");
		System.out.println("=================================================");
		
		int clientID = 23;
		radiationLevels request = radiationLevels.newBuilder().setClientID(clientID).build();
		
		StreamObserver<levelsStream> responseObserver = new StreamObserver<levelsStream>() {
			int count = 0;
			
			@Override
			public void onNext(levelsStream value) {
				System.out.println(value.getDangerousRegions());
				count += 1;
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received "+ count+ " radiation values");
			}
		};
		
		
		asyncStub.withDeadlineAfter(20,TimeUnit.SECONDS).getRadiationLevels(request, responseObserver); // deadline of 20 seconds
		
		try {
			Thread.sleep(10000); // leave enough time for all counties to be sent
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	// server to client streaming
	public static void getRadiationWarnings(int threshold) {
		System.out.println("");
		System.out.println("");
		
		System.out.println("Requesting Radiation Warnings of threshold " + threshold);
		System.out.println("===========================================");
		
		
		requestRadiationAlerts request = requestRadiationAlerts
				.newBuilder()
				.setThreshold(threshold)
				.build();
		
		
		StreamObserver<radiationAlert> responseObserver = new StreamObserver<radiationAlert>() {
			
			
			int count = 0;
			
			@Override
			public void onNext(radiationAlert value) {
				System.out.println(value.getRadiationAlerts());	//e.g. "Alert in Carlow:7.075986495087796 picocuries per litre detected!"
				count++;
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}
			
			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received "+ count+ " counties with alerts for threshold " + threshold);
			}
		};
		
		asyncStub.withDeadlineAfter(20,TimeUnit.SECONDS).getRadiationWarnings(request, responseObserver);
		
		
		try {
			Thread.sleep(10000); // leave enough time for all counties
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}