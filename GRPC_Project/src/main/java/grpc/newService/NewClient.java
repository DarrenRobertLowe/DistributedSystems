package grpc.newService;

import java.util.concurrent.TimeUnit;

import grpc.newService.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import grpc.newService.newServiceGrpc.newServiceStub;

public class NewClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1. create a channel
		//2 create a message
		//create a stub
		
		//Build a channel - a channel connect the client to the server
		int port = 50051;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		// now build our message
		
		containsString cString = containsString.newBuilder().setFirstString("test").build();
		
		//create a stub
		//the stub is a local representation of our remote object or service
		
		newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		newServiceStub asyncstub = newServiceGrpc.newStub(newChannel);
		
		//
		
		containsString response = bstub.getFirsttString(cString);
		
		//printout the response
		System.out.println("This is the client: " +response.getFirstString());
		
		StreamObserver<containsString> responseServer = new StreamObserver<containsString> () {
			
			@Override
			public void onNext(containsString response) {
				// TODO Auto-generated method stub
				System.out.println("The response from the server is : " + response.getFirstString());
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		// GRPC library returns a streamObserver to us: requestObserver
		// we use this to send outgoing messages
		StreamObserver<containsString> requestObserver = asyncstub.sendStringClientStreaming(responseServer);
		
		requestObserver.onNext(containsString.newBuilder().setFirstString("test").build());
		requestObserver.onNext(containsString.newBuilder().setFirstString("test").build());
		requestObserver.onNext(containsString.newBuilder().setFirstString("test").build());
		
		requestObserver.onCompleted();
		
		Thread.sleep(5000); // we need this or things might appear to not be happening
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
