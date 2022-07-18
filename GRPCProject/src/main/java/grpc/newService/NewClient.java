package grpc.newService;

import java.util.concurrent.TimeUnit;

import grpc.newService.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NewClient {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1. create a chan;ll
		//2 create a message
		//create a stub
		
		//Build a channel - a chanell connnect the client to the server
		int port = 50051;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		// now build our message
		
		containsString cString = containsString.newBuilder().setFirstString("test").build();
		
		//create a stub
		//the stub is a local representation of our remot object or service
		
		newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		
		//
		
		containsString response = bstub.getFirsttString(cString);
		
		//printout the response
		System.out.println("This is the client: " +response.getFirstString());
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		

	}

}
