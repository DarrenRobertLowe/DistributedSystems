package grpc.Carbon;

// needed for properties file
import java.util.Properties;

import grpc.Carbon.carbonServiceGrpc.carbonServiceImplBase;

import java.io.InputStream;
import java.net.InetAddress;
import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

//JmDNS
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


public class CarbonService {

	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		CarbonService ourServer = new CarbonService();
		ourServer.start(ourServer);
	}
	
	
	
	private void start(CarbonService ourServer) throws IOException, InterruptedException {
		System.out.println("Starting grpc server for carbon footprint services");
		
		// get the properties for this server
		Properties prop = ourServer.getProperties();
		
		// start jmdns service
		registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );	// 50051;
		server = ServerBuilder.forPort(port).addService(new CarbonServiceImpl()).build().start();	
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	
	
	private Properties getProperties() {
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/carbonserver.properties")) {
			
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
	
	
	
	/// JMDNS
	private  void registerService(Properties prop) {
		 try {
			System.out.println("Please wait while jmDNS registers this service...");
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			String service_type = prop.getProperty("service_type");	//"_http._tcp.local.";
			String service_name = prop.getProperty("service_name");	// "example";
			
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
	static class CarbonServiceImpl extends carbonServiceImplBase {
		
		@Override
		public void calculateCarbonFlight(carbonFlightRequest request, StreamObserver<responseString> responseObserver) {
			System.out.println();
			System.out.println();
			System.out.println("Carbon footprint for flight requested.");
			System.out.println("======================================");
			
			
			//Find out what was sent by the client
			int hours = request.getHoursInput();
			
			
			System.out.println("Hours flight input received : " + hours);
			
			
			/* CALCULATION
			 * This calculation is based on CO2 emissions from aviation fuel being 3.15
			 * grams per gram of fuel and using a Boeing 737-400 as the type of plane.
			 * From research this appears to equate to 115 g per passenger per km.
			 * Cruising speed is reportedly 780 km per hour. So per passenger, we
			 * have ... (hours * 780 * 115)/1000 to get kg
			 */
			int result = ((hours * 780 * 115)/1000);
			
			//now build our response
			responseString.Builder responseBuilder = responseString.newBuilder();	//create a builder
			
			System.out.println("Returning value of : " + result + "kg.");
			responseBuilder.setMessage("The amount of carbon emmited for this flight is about " + result + "kg.");
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
		}
		
		
		
		@Override
		public void calculateCarbonDrive(carbonDriveRequest request, StreamObserver<responseString> responseObserver) {
			System.out.println();
			System.out.println();
			System.out.println("Carbon footprint for drive requested.");
			System.out.println("======================================");
			
			
			//Find out what was sent by the client
			int distance = request.getMilesInput(); 	// we should probably change this to kilometers
			int mpg = request.getMpgInput();
			String fuelType = request.getFuelType().toLowerCase();
			
			System.out.println("distance is: " + distance);
			System.out.println("mpg is: " + mpg);
			
			String invalidFuelTypeMessage = "Carbon emissions could not be determined. Fuel type Must be either petrol or diesel.";
			
			int emissions = 0;
			switch (fuelType) {
				case "petrol":
					System.out.println("FuelType is petrol.");
					emissions = 6760;
					break;
				
				case "diesel":
					System.out.println("FuelType is diesel.");
					emissions = 7440;
					break;
					
				default:
					System.out.println(invalidFuelTypeMessage);
					emissions = 0;
					break;
			}
			
			
			
			/* CALCULATION
			 * According to eta.co.uk, we can get the grams per km by dividing
			 * 6760 for petrol (or 7440 for diesel) by the mpg of the car.
			 * So if we do that, we can then multiply it by the journey length.
			 */
			double kmRatio = 1.609; // we asked for miles so we'll need to convert things
			double result = (((emissions / mpg) * (distance * kmRatio))/1000); // we divide by 1000 to get kgs
			
			
			//now build our response
			responseString.Builder responseBuilder = responseString.newBuilder();	//create a builder
			System.out.println("Returning value of : " + result + " kg.");
			
			if (emissions == 0) {
				responseBuilder.setMessage(invalidFuelTypeMessage);
			} else {
				responseBuilder.setMessage("The amount of carbon emmited for this drive is about " + result + " kg");
			}
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
			
			/* NOTE: For this would could actually take a string in that reads either "petrol" or "diesel",
			 * and we could have a GUI button to switch between them. That would be a nice addition.
			 */
		}
		
		
		
		
	}
}

