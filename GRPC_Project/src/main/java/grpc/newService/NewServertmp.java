package grpc.newService;

import java.io.IOException;

import grpc.newService.newServiceGrpc.newServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
//import io.grpc.ServerBuilder;

public class NewServertmp {

	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		NewServertmp ourServer = new NewServertmp();
		ourServer.start();

	}
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		int port = 50052;
		
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		System.out.println("Server running on port: " + port );
		
		server.awaitTermination();
		
		
	}
	
	//Extend abstract base class for our own implementation
	static class NewServerImpl extends newServiceImplBase{
		
		@Override
		public void getFirsttString(containsString request, StreamObserver<containsString> responseObserver) {
			//Find out what was the content of the message sent by the client
			String firstString =  request.getFirstString();
			System.out.println("Our first request string is: " + firstString);
			
			//Now build up our response
			containsString.Builder responseBuilder = containsString.newBuilder();
			
			responseBuilder.setFirstString("Our First Response String is: " + firstString);
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
			
			
		}
		

		
		
	}

}
