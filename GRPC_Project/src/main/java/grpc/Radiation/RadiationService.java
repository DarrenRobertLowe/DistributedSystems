package grpc.Radiation;


import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import grpc.Radiation.RadiationService;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import grpc.Radiation.radiationServiceGrpc.radiationServiceImplBase;
import grpc.Radiation.containsString;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Properties;				// needed for properties file



public class RadiationService {

	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		RadiationService ourServer = new RadiationService();
		ourServer.start(ourServer);
	}
	
	
	
	private void start(RadiationService ourServer) throws IOException, InterruptedException {
		System.out.println("Starting grpc server");
		Properties prop = ourServer.getProperties();
		
		int port = Integer.valueOf( prop.getProperty("service_port") );	// 50051;
		server = ServerBuilder.forPort(port).addService(new RadiationServiceImpl()).build().start();	
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	
	
	private Properties getProperties() {
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/radiationserver.properties")) {
			
			prop = new Properties();
			
	        // load properties file
	        prop.load(input);
	        
	        // get the property value and print it out
	        System.out.println("Carbon Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
	        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return prop;
	}
	
	
	//Extend abstract base class for our own implementation
	static class RadiationServiceImpl extends radiationServiceImplBase {
		// method for client streaming
		// As we are the server, we are going to get a stream of messages coming in from the client
		// For the incoming messages we need to implement a StreamObserver
		// which we then pass back to the GRPC library.
		
		
		
		@Override
		// method for client streaming
		// As we are the server, we are going to get a stream of messages coming in from the client
		// For the incoming messages we need to implement a StreamObserver
		// which we then pass back to the GRPC library.
		// rpc StreamRadiation(stream radiationMeasurements) returns (containsString){}
		public StreamObserver<radiationMeasurements> streamRadiation(StreamObserver<containsString> responseObserver) {
			
			return new StreamObserver<radiationMeasurements>() {
				
				@Override
				public void onNext(radiationMeasurements request) {
					// The U.S. Environmental Protection Agency's (EPA) Radionuclides Rule has four
					// federal standards for radionuclides in drinking water. Safe drinking water should 
					// have: 15 picocuries of alpha particles per liter of water (pCi/L) or less.
					
					System.out.println("Incoming radiation numbers from client: " + request.getPicocuries());
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
					
					responseBuilder.setFirstString("Server: confirmation receipt of receiving radiation numbers. ");
					
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
				}
			};
		}
		
		
		
		//rpc GetRadiationLevels(radiationLevels) returns (stream levelsStream){}
		@Override
		public void getRadiationLevels(radiationLevels request, StreamObserver<levelsStream> responseObserver) {
			String[] listOfCounties = {"Carlow", "Cavan", "Clare", "Cork", "Donegal", 
					"Dublin", "Galway", "Kerry", "Kildare", "Kilkenny", "Laois", 
					"Leitrim", "Limerick", "Longford", "Louth", "Mayo", "Meath", 
					"Monaghan", "Offaly", "Roscommon", "Sligo", "Tipperary", 
					"Waterford", "Westmeath", "Wexford", "Wicklow"};
			
			// import collections sort
			// the counties should be objects that we can arrange by danger level
			//sort()
			String[] listOfCountiesSorted = listOfCounties;
			Random rand = new Random();
			double max = 1.0;
			
			for(int i=0; i<listOfCounties.length; i++) {
				String county = listOfCountiesSorted[i];
				double rando = (rand.nextDouble(max)*10);
				levelsStream reply = levelsStream.newBuilder().setDangerousRegions(county + ": " + rando).build();
				responseObserver.onNext(reply);
				
				
				try {
					//wait for a second
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			responseObserver.onCompleted();
		}
		
		
		
		
		//rpc GetRadiationWarnings(requestRadiationAlerts) returns (stream radiationAlert){}
		@Override
		public void getRadiationWarnings(requestRadiationAlerts request, StreamObserver<radiationAlert> responseObserver) {
			// do stuff
		}
		
		
		
		
		
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
