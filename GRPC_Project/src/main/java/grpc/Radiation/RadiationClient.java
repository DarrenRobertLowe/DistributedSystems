
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
		
		
		trackRadiation();
		
		getRadiationLevels();
		
		GetRadiationWarnings();
	}
	
	
	
	
	
	
	private static void trackRadiation() throws InterruptedException {
		StreamObserver<containsString> responseObserver = new StreamObserver<containsString>() {
			
			@Override
			public void onNext(containsString msg) {
				System.out.println("receiving radiation numbers " + msg.getFirstString() );
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... receiveing confirmation");
			}
		};
		
		
		
		StreamObserver<radiationMeasurements> requestObserver = asyncStub.streamRadiation(responseObserver);
		try {
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

			
			Thread.sleep(10000);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	private static void getRadiationLevels() {
		System.out.println("Finish implementing me!");
	}
	
	
	private static void GetRadiationWarnings() {
		System.out.println("Finish implementing me too!");
	}
	
}