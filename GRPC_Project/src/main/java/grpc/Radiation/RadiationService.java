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
import grpc.Radiation.objects.County;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Properties;				// needed for properties file
import algorithms.BubbleSort;
import algorithms.MergeSort;


public class RadiationService {
	static Random rand = new Random();
	
	static County[] listOfCounties = {
			new County("Carlow", rand.nextDouble(20)),
			new County("Cavan", rand.nextDouble(20)), 
			new County("Clare", rand.nextDouble(20)),
			new County("Cork", rand.nextDouble(20)),
			new County("Donegal", rand.nextDouble(20)),
			new County("Dublin", rand.nextDouble(20)),
			new County("Galway", rand.nextDouble(20)),
			new County("Kerry", rand.nextDouble(20)),
			new County("Kildare", rand.nextDouble(20)),
			new County("Kilkenny", rand.nextDouble(20)),
			new County("Laois", rand.nextDouble(20)),
			new County("Leitrim", rand.nextDouble(20)),
			new County("Limerick", rand.nextDouble(20)),
			new County("Longford", rand.nextDouble(20)),
			new County("Louth", rand.nextDouble(20)),
			new County("Mayo", rand.nextDouble(20)),
			new County("Meath", rand.nextDouble(20)),
			new County("Monaghan", rand.nextDouble(20)),
			new County("Offaly", rand.nextDouble(20)),
			new County("Roscommon", rand.nextDouble(20)),
			new County("Sligo", rand.nextDouble(20)),
			new County("Tipperary", rand.nextDouble(20)),
			new County("Waterford", rand.nextDouble(20)),
			new County("Westmeath", rand.nextDouble(20)),
			new County("Wexford", rand.nextDouble(20)),
			new County("Wicklow", rand.nextDouble(20))
			};
	
	
	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		RadiationService ourServer = new RadiationService();
		ourServer.start(ourServer);
	}
	
	
	
	private void start(RadiationService ourServer) throws IOException, InterruptedException {
		System.out.println("Starting grpc server for radiation services");
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
	        System.out.println("Radiation Service properies ...");
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
		
		
		
		@Override
		/* This method takes in a stream of radiation numbers
		 * and returns calculates an average value, which is
		 * returned as part of the response message.
		 */
		// rpc StreamRadiation(stream radiationMeasurements) returns (containsString){}
		public StreamObserver<radiationMeasurements> streamRadiation(StreamObserver<measurementsResponse> responseObserver) {
			
			return new StreamObserver<radiationMeasurements>() {
				String radiationString = "";
				int count = 0;	// used to get an average value
				int total = 0;	// used to get an average value
				
				@Override
				public void onNext(radiationMeasurements request) {
					// The U.S. Environmental Protection Agency's (EPA) Radionuclides Rule has four
					// federal standards for radionuclides in drinking water. Safe drinking water should 
					// have: 15 picocuries of alpha particles per liter of water (pCi/L) or less.
					
					System.out.println("Incoming radiation numbers from client: " + request.getPicocuries());
					
					radiationString += request.getPicocuries() +" ";
					total += request.getPicocuries();	// add to the total
					count++;							// add to the count
				}
				
				
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}
				
				
				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					//Step one create a builder
					measurementsResponse.Builder responseBuilder = measurementsResponse.newBuilder();
					
					String message = ("Server: confirmation receipt of receiving radiation numbers: " + radiationString + "   Average: " + (total/count) +" picocuries");
					measurementsResponse reply = measurementsResponse.newBuilder().setMessage(message).build();
					
					responseObserver.onNext(reply);
					
					responseObserver.onCompleted();
				}
			};
		}
		
		
		
		
		//rpc GetRadiationLevels(radiationLevels) returns (stream levelsStream){}
		/* In this method, clients request a stream of all radiation
		 * levels for each county, arranged by severity.
		 */
		@Override
		public void getRadiationLevels(radiationLevels request, StreamObserver<levelsStream> responseObserver) {
			int clientID = request.getClientID();
			System.out.println("Request for radiation levels of all counties from clientID: " + clientID);
			
			int length = listOfCounties.length;
			County[] listOfCountiesSorted = new County[length];
			System.arraycopy(listOfCounties, 0, listOfCountiesSorted, 0, length);
			
			MergeSort.sort(listOfCountiesSorted);
			
			
			for(int i=0; i<listOfCounties.length; i++) {
				String county = listOfCountiesSorted[i].getName();
				double value = listOfCountiesSorted[i].getValue();
				
				levelsStream reply = levelsStream.newBuilder().setDangerousRegions(county + ": " + value).build();
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
		/* This method returns only the subset of radiation levels
		 * that exceed a given value
		 */
		@Override
		public void getRadiationWarnings(requestRadiationAlerts request, StreamObserver<radiationAlert> responseObserver) {
			System.out.println("We have received a request for the radiation warnings..");
			int threshold = request.getThreshold(); // get the picocuries per litre threshold from the client
			System.out.println("Threshold: " + threshold);
			
			County[] list = listOfCounties;
			String replyString = "";
			
			
			int length = listOfCounties.length;
			
			int index = rand.nextInt(length);
			
			
			for(int i=0; i<length; i++) {
				System.out.println("Running loop of size " + length + ": i is " + i);
				
				if (list[i].getValue() >= threshold) {
					System.out.println("Alert in "+ list[i].getName() + ":" + list[i].getValue() + " picocuries per litre detected!");
					replyString = "Alert in "+ list[i].getName() + ":" + list[i].getValue() + " picocuries per litre detected!";
					
					// because this is a stream we'll just send it now
					radiationAlert reply = radiationAlert.newBuilder().setRadiationAlertSet(replyString).build();
					responseObserver.onNext(reply);
					
					// delay each message
					try {
						//wait for a second
						Thread.sleep(rand.nextInt(1));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("Loop complete!");
			
			
			responseObserver.onCompleted();
		}
		
		
		
	}
}