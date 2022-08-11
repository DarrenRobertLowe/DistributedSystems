package grpc.pollution;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

//JmDNS
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.pollution.PollutionService;
import grpc.pollution.PollutionService.PollutionServiceImpl;
import grpc.pollution.pollutionServiceGrpc.pollutionServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


// import custom classes
import grpc.pollution.objects.IoTDevice;
import algorithms.*;



public class PollutionService{
	static Random rand = new Random(); // used for delaying the stream messages
	
	private static ArrayList<IoTDevice> listOfIoTDevices = new ArrayList<IoTDevice>();
	private static IoTDevice[] sortedListOfIoTDevices;
	
	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		// create example IoTDevices for this service
		listOfIoTDevices.add(new IoTDevice("dev08"));
		listOfIoTDevices.add(new IoTDevice("dev01"));
		listOfIoTDevices.add(new IoTDevice("dev02"));
		listOfIoTDevices.add(new IoTDevice("dev03"));
		listOfIoTDevices.add(new IoTDevice("dev10"));
		listOfIoTDevices.add(new IoTDevice("dev05"));
		listOfIoTDevices.add(new IoTDevice("dev06"));
		listOfIoTDevices.add(new IoTDevice("dev09"));
		listOfIoTDevices.add(new IoTDevice("dev07"));
		listOfIoTDevices.add(new IoTDevice("dev04"));
		
		
		// Sort the devices by name
		sortedListOfIoTDevices = new IoTDevice[listOfIoTDevices.size()];
		sortIoTDevicesByID(sortedListOfIoTDevices);
		
		// add back to the arraylist
		arrayToList(sortedListOfIoTDevices, listOfIoTDevices);
		
		
		// print the devices
		printIoTDevices(sortedListOfIoTDevices);
		
		
		// create and start the server
		PollutionService ourServer = new PollutionService();
		ourServer.start(ourServer);
	}
	
	
	
	
	private void start(PollutionService ourServer) throws IOException, InterruptedException {
		System.out.println("Starting grpc server for air pollution services");
		
		
		// get the properties for this server
		Properties prop = ourServer.getProperties();
				
		// start jmdns service
		registerService(prop);
		
		
		int port = Integer.valueOf( prop.getProperty("service_port") );	// 50051;
		server = ServerBuilder.forPort(port).addService(new PollutionServiceImpl()).build().start();	
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	
	
	
	
	
	private Properties getProperties() {
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/pollutionserver.properties")) {
			
			prop = new Properties();
			
	        // load properties file
	        prop.load(input);
	        
	        // get the property value and print it out
	        System.out.println("Pollution Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " + prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " + prop.getProperty("service_port"));
	        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return prop;
	}
	
	
	
	/// JMDNS
	private  void registerService(Properties prop) {
		
		 try {
			System.out.println("Please wait while jmDNS registers this service...");
			
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            
            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name")  ;// "example";
            // int service_port = 1234;
            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
            
            
            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
            
            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);
            
            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
            
            // Wait a bit
            Thread.sleep(1000);
            
            // Unregister all services
            //jmdns.unregisterAllServices();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//Extend abstract base class for our own implementation
	static class PollutionServiceImpl extends pollutionServiceImplBase {
		/* streamPollution													// client to server streaming
		 * 
		 * for rpc StreamPollution(stream airPollution) returns (response){}	
		 * 
		 * This method takes a stream of carbon dioxide measurements and returns 
		 * confirmation and the average of the streamed numbers.
		 */
		@Override
		public StreamObserver<airPollution> streamPollution(StreamObserver<response> responseObserver) {
			System.out.println();
			System.out.println();
			
			System.out.println("Running streamPollution()");
			System.out.println("=========================");
			
			
			return new StreamObserver<airPollution>() {
				String carbonString = "";
				int count = 0;
				int total = 0;
				String clientID = "";
				
				@Override
				public void onNext(airPollution request) {
					clientID = request.getId();
					System.out.println("Incoming carbon numbers from client '" + clientID +"' "+ request.getCarbon());
					carbonString += request.getCarbon() +" ";
					total += request.getCarbon();
					count++;
				}
				
				
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
				}
				
				
				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					//Step one create a builder
					response.Builder responseBuilder = response.newBuilder();
					
					responseBuilder.setReceived("Server: confirmation receipt of receiving carbon dioxide ppm: " + carbonString + "   Average: " + (total/count) + "ppm");
					
					responseObserver.onNext(responseBuilder.build());
					
					System.out.println("Finished receiving emissions data from device id: " + clientID);
					responseObserver.onCompleted();
				}
			};
		}
		
		
		
		/* getLocalAirPollution													// bi-directional streaming
		 * 
		 * for rpc GetLocalAirPollution(stream locationRequest) returns (stream regionalPollutionResponse){}
		 * 
		 * This method takes a latitude and longitude and returns
		 * a value for the pollution there using the combined numbers 
		 * as a seed for the random generation.
		 */
		public StreamObserver<locationRequest> getLocalAirPollution(StreamObserver<regionalPollutionResponse> responseObserver) {
			System.out.println();
			System.out.println();
			
			System.out.println("Running getLocalAirPollution()");
			System.out.println("==============================");
			
			
			return new StreamObserver<locationRequest> () {
				
				@Override
				public void onNext(locationRequest msg) {
					
					int latitude  = msg.getLatitude();
					int longitude = msg.getLongitude();
					
					int seed = latitude + longitude;
					Random randomizer = new Random(seed);
					
					
					System.out.println("receiving location latitude: "+ latitude + "   longitude: "+ longitude);
					
					
					// get a randomized carbon result
					int maxPPM = 1000; 							// the max ppm of carbon we're allowing for the example
					int carbon = randomizer.nextInt(maxPPM);	// get a random ppm
					
					String result = "Carbon for latitude:" + latitude + " longitude:" + longitude + " is " + carbon + " ppm";
					
					regionalPollutionResponse reply = regionalPollutionResponse.newBuilder().setRegionalStatus(result).build();
					
					responseObserver.onNext(reply);
				}

				@Override
				public void onError(Throwable t) {
					
					t.printStackTrace();
					
				}

				@Override
				public void onCompleted() {
					System.out.println("Finished location carbon data.");
					
					//completed too
					responseObserver.onCompleted();
				}
				
			};
		}
		
		
		
		/* getDeviceStatus													// Unary
		 * 
		 * for rpc GetDeviceStatus(deviceStatusRequest) returns (deviceStatusResponse);	
		 * 
		 * This method returns the device health status
		 * of a given IoT device
		 */
		@Override
		public void getDeviceStatus(deviceStatusRequest request, StreamObserver<deviceStatusResponse> responseObserver) {
			System.out.println();
			System.out.println();
			
			System.out.println("Running getDeviceStatus()");
			System.out.println("=========================");
			
			//Find out what was sent by the client
			String statusRequestedID = request.getStatusRequestedID();
			System.out.println("client is requesting health status for IoT device : " + statusRequestedID);
			
			
			// if it doesn't exist the result will be a message to that effect since we're using a string
			String result = "Device id not recognised.";
			
			
			// binary search for the given id in the list
			BinarySearch searcher = new BinarySearch();
			IoTDevice device = searcher.search(sortedListOfIoTDevices, statusRequestedID);
			
			if (device != null) { // if the IoT device is found
				System.out.println("Device found : " + device.getID());
				System.out.println("Returning health status for device : " + device.getID());
				
				// fill the result string that we will send
				result = "Health for device " + device.getID() + ": " + device.getHealth();
			}
			
			
			// return the result
			deviceStatusResponse.Builder responseBuilder = deviceStatusResponse.newBuilder();	//create a builder
			responseBuilder.setStatus(result);
		
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
		}
		
		
		/* GetAllDeviceStatus 												// server to client streaming
		 * 
		 * for rpc GetAllDeviceStatus(allDeviceStatusRequest) returns (stream allDeviceStatusResponse){}
		 * 
		 * This method gets the health status of every iot 
		 * device and returns the average value.
		 */
		@Override
		public void getAllDeviceStatus(allDeviceStatusRequest request, StreamObserver<allDeviceStatusResponse> responseObserver) {
			System.out.println();
			System.out.println();
			
			System.out.println("Running getAllDeviceStatus()");
			System.out.println("============================");
			
			

			// get the health from every iot device
			float overallHealth = 0.0f;
			
			int length = sortedListOfIoTDevices.length;
			
			for(int i=0; i<length; i++) {
				overallHealth += sortedListOfIoTDevices[i].getHealth();
				System.out.println(sortedListOfIoTDevices[i].getID() + " : " + sortedListOfIoTDevices[i].getHealth() + "%") ;
			}
			overallHealth /= length;	// get the average
			
			
			for(int i=0; i<5; i++) {
				allDeviceStatusResponse reply = allDeviceStatusResponse.newBuilder().setOverallDeviceHealth(overallHealth).build();
				responseObserver.onNext(reply);
				
				
				// delay each message
				try {
					Thread.sleep(rand.nextInt(2500));	// wait for some time
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Finished.");
			responseObserver.onCompleted();
		}
	}
	
	
	
	
	
	////// Private methods //////
	/* 
	 * sortIoTDevicesByID
	 */
	private static void sortIoTDevicesByID(IoTDevice[] sortedListOfIoTDevices) {
		/// Use MergeSort to sort IoTDevices alphabetically ///
		// convert the ArrayList into an array
		
		
		for(int i=0; i<listOfIoTDevices.size(); i++) {
			sortedListOfIoTDevices[i] = listOfIoTDevices.get(i);
		}
		
		System.out.println("Sorting list of IoT devices by name...");
        MergeSort.sort(sortedListOfIoTDevices);
	}
	
	
	/*
	 * printIoTDevices
	 */
	private static void printIoTDevices(IoTDevice[] sortedListOfIoTDevices) {
		System.out.println("IoT Devices:");
		
		for(int i=0; i < sortedListOfIoTDevices.length; i++) {
			System.out.println(sortedListOfIoTDevices[i].getID());
		}
	}
	
	
	/*
	 * arrayToList
	 */
	private static void arrayToList(IoTDevice[] array, ArrayList<IoTDevice> list) {
		list.clear();
		for(int i=0; i<array.length; i++) {
			list.add(array[i]);
		}
	}
	
	
}