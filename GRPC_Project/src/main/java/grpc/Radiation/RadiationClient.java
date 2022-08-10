
package grpc.Radiation;

import java.util.concurrent.TimeUnit;


import grpc.Radiation.radiationServiceGrpc.radiationServiceBlockingStub;
import grpc.Radiation.radiationServiceGrpc.radiationServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;



public class RadiationClient {

	public static radiationServiceBlockingStub blockingStub;
	public static radiationServiceStub asyncStub;
	
	
	
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
		blockingStub = radiationServiceGrpc.newBlockingStub(channel);
		asyncStub = radiationServiceGrpc.newStub(channel);
		
		
		streamRadiation();			// note: the name of the methods here have no relation to the proto
		
		getRadiationLevels();
		
		GetRadiationWarnings();
		
		
		
		channel.shutdown(); 		// gracefully shutdown so the server doesn't throw an error
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
			
			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(125).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(112).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(34).build());
			Thread.sleep(500);
			
			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(34).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(200).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(40).build());
			Thread.sleep(500);

			requestObserver.onNext(radiationMeasurements.newBuilder().setPicocuries(85).build());
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
		
		asyncStub.getRadiationLevels(request, responseObserver);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void GetRadiationWarnings() {
		System.out.println("");
		System.out.println("");
		
		
		int threshold = 2;	// the server will only return to us the counties with radiation levels above this amount
		System.out.println("Requesting Radiation Warnings of threshold " + threshold);
		System.out.println("===========================================");
		
		
		
		requestRadiationAlerts request = requestRadiationAlerts
				.newBuilder()
				.setThreshold(threshold)
				//.setVariable(0)
				//.setVariable(0)
				.build();
		
		
		StreamObserver<radiationAlert> responseObserver = new StreamObserver<radiationAlert>() {
			int count = 0;

			@Override
			public void onNext(radiationAlert value) {
				System.out.println(value.getRadiationAlertSet());	//e.g. "Alert in Carlow:7.075986495087796 picocuries per litre detected!"
				count++;
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received "+ count+ " counties");
			}
		};
		
		asyncStub.getRadiationWarnings(request, responseObserver);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}