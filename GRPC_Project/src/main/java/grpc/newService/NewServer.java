package grpc.newService;

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
		
		
		
		// method for client streaming
		// As we are the server, we are going to get a stream of messages coming in from the client
		// For the incoming messages we need to implement a StreamObserver
		// which we then pass back to the GRPC library.
		@Override
		public StreamObserver<containsString> sendStringClientStreaming(StreamObserver<containsString> responseObserver) {
			return new StreamObserver<containsString>() {
				
				@Override
				public void onNext(containsString request) {
					// TODO Auto-generated method stub
					System.out.println("On server side message that we received from the client is: FirstString is: " + request.getFirstString());
				}
				
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					//Step one create a builder
					containsString.Builder responseBuilder = containsString.newBuilder();
					
					responseBuilder.setFirstString("On server side: Server says that it got our completed message");
					
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
				}
				
			};
		}
	}
}