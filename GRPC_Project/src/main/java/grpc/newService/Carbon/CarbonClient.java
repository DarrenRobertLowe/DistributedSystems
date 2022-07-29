package grpc.newService.Carbon;

import java.util.concurrent.TimeUnit;

//import grpc.newService.Carbon.containsString;
import grpc.newService.Carbon.carbonServiceGrpc.carbonServiceBlockingStub;
import grpc.newService.Carbon.carbonServiceGrpc.carbonServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
//import io.grpc.stub.StreamObserver;


public class CarbonClient {

	public static carbonServiceBlockingStub blockingStub;
	public static carbonServiceStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException {
		// setup the server address and port
		int port = 50051;
		String host = "localhost";
		
		//Build a channel - a channel connects the client to the server
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		
		
		//unary rpc
		int hoursInput = 5;
		carbonFlightRequest req = carbonFlightRequest.newBuilder().setHoursInput(hoursInput).build();
		System.out.println("The request we're sending is: " + req);
		
		
		
		//create a stub
		//the stub is a local representation of our remote object or service
		carbonServiceBlockingStub bstub = carbonServiceGrpc.newBlockingStub(newChannel);
		containsString response = bstub.calculateCarbonFlight(req);
		
		
		//printout the response
		System.out.println("This is the client: " +response.getFirstString());
		
		// terminate properly or the server will crash
		newChannel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
	}
}