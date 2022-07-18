package grpc.newService;

/*
 * 
 * [18:57] Jack Bolger

Mayara Regio Melo - download BloomRPC-1.5.3.dmg and open it. Drag into your applications folder and then that should work on Mac

[18:57] Jack Bolger
You might need to change some security settings to open it
 like 1

 */

import java.io.IOException;

import grpc.newService.newServiceGrpc.newServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {

	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		NewServer ourServer = new NewServer();
		ourServer.start();
		

	}

	private void start() throws IOException, InterruptedException {
		System.out.println("Starting grpc server");
		
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();	
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
		
		
	}
	
	//Extend abstract base class for our own implementation

	static class NewServerImpl extends newServiceImplBase{
		
		@Override
		public void getFirsttString(containsString request, StreamObserver<containsString> responseObserver) {
			
			//Find out what was sent by the client
			String firstString = request.getFirstString();
			System.out.println("FirstString is: " + firstString);
			
			//now build our response
			//Step one create a builder
			containsString.Builder responseBuilder = containsString.newBuilder();
			
			responseBuilder.setFirstString("we are now responding to the text " + firstString);
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
			
		}
		
		@Override
		public void getFirstInteger(containsString request, StreamObserver<newResponseInteger> responseObserver) {
			
			//Find out what was sent by the client
			String firstString = request.getFirstString();
			System.out.println("FirstString is: " + firstString);
			
			//now build our response
			//Step one create a builder in order to build a message
			newResponseInteger.Builder responseBuilder = newResponseInteger.newBuilder();
			
			responseBuilder.setFirstInteger(25);
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
			
		}
		
		@Override
		public void getFirsttStringServerStreaming(containsString request, StreamObserver<containsString> responseObserver) {
			
			//Find out what was sent by the client
			String firstString = request.getFirstString();
			System.out.println("FirstString is: " + firstString);
			
			//now build our response
			//Step one create a builder
			containsString.Builder responseBuilder = containsString.newBuilder();
			
			responseBuilder.setFirstString("Server Streaming: Our First response is " + firstString);
			
			responseObserver.onNext(responseBuilder.build());
			
			//later messages
			responseBuilder.setFirstString("Server Streaming: Our Second response is " + firstString);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setFirstString("Server Streaming: Our Third response is " + firstString);
			responseObserver.onNext(responseBuilder.build());
			responseBuilder.setFirstString("Server Streaming: Our Fourth response is " + firstString);
			responseObserver.onNext(responseBuilder.build());
			
			responseObserver.onCompleted();
			
			
		}
		
		
	}
	
}
