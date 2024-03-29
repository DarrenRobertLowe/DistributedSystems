package grpc.Carbon;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

// jmdns
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import grpc.Carbon.carbonServiceGrpc.carbonServiceBlockingStub;
import grpc.Carbon.carbonServiceGrpc.carbonServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


/**
 * 
 * @author Darren Robert Lowe
 *
 * This is the client for the Carbon Service.
 * The Carbon Service is an environmental footprint calculator wherein a user can
 * calculate an estimated amount of air pollution (C02) a given journey would create.
 * For example a ten hours flight in a Boeing 737-400 airplane, or 30 mile drive in
 * an average petrol or diesel car. The user provides the system with the required
 * information and the service responds accordingly. In the case of a flight the
 * number of hours of the flight is the input, whereas with the vehicle journey the
 * miles per gallon, drive distance and fuel type (petrol or diesel) are required.
 */

public class CarbonClient {
	
	private static ServiceInfo carbonServiceInfo; // jmdns
	
	public static carbonServiceBlockingStub blockingStub;
	public static carbonServiceStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException {
		
		// jmdns resoultion
		String carbon_service_type = "_carbonservice_http._tcp.local.";
		discoverCarbonService(carbon_service_type);
		
		// Build a channel (JmDNS) - a channel connect the client to the server
		int port 	= carbonServiceInfo.getPort();					// e.g. 50051;
		String host = carbonServiceInfo.getHostAddresses()[0];		// i.e. "localhost";
		
		
		//Build a channel - a channel connects the client to the server
		ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext().build();
		
		
		// create the sync (blocking) stub
		blockingStub = carbonServiceGrpc.newBlockingStub(channel);
		
		
		// call the rpc methods
		calculateCarbonFlight(5);					// parameter is the number of hours
		calculateCarbonDrive(10, 40, "diesel"); 	// 100 miles at 40mpg
		
		
		// terminate the channel so we don't get errors
		channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
		System.out.println();
		System.out.println("Program ended.");
	}
	
	
	
	
	
	// JmDNS
	private static void discoverCarbonService(String service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Radiation Service resolved: " + event.getInfo());

					carbonServiceInfo = event.getInfo();

					int port = carbonServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + carbonServiceInfo.getNiceTextString());
					System.out.println("\t host: " + carbonServiceInfo.getHostAddresses()[0]);
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Carbon Service removed: " + event.getInfo());
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Carbon Service added: " + event.getInfo());
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	private static void calculateCarbonFlight(int hours) {
		System.out.println();
		System.out.println();
		System.out.println("Requesting carbon emission per flight hour calculation");
		System.out.println("======================================================");
				
		//create the request
		carbonFlightRequest request = carbonFlightRequest.newBuilder().setHoursInput(hours).build();
		System.out.println("Requesting calculation for " + hours + " hour flight");	
		
		
		// request a response using our carbonFlightRequest 'request'
		try {
			responseString response = blockingStub.withDeadlineAfter(2,TimeUnit.SECONDS).calculateCarbonFlight(request);	// note the deadline of 2 seconds
			System.out.println(response.getMessage());	//printout the response
		} catch (StatusRuntimeException e) {
			System.out.println("Server request timed out.");
		}
		
		
	}
	
	
	
	
	
	public static void calculateCarbonDrive(int miles, int mpg, String fuelType) {
		System.out.println();
		System.out.println();
		System.out.println("Requesting carbon emissions for a drive");
		System.out.println("=======================================");
		
		
		//create the request
		carbonDriveRequest request = carbonDriveRequest.newBuilder().setMilesInput(miles).setMpgInput(mpg).setFuelType(fuelType).build();
		
		System.out.println("Requesting calculation for " + miles + " mile drive drive at " + mpg + " mpg" + " using " + fuelType);	
		
		
		// request a response using our carbonFlightRequest 'request'
		try {
			responseString response = blockingStub.withDeadlineAfter(2,TimeUnit.SECONDS).calculateCarbonDrive(request);	// note the deadline of 2 seconds
			System.out.println(response.getMessage());	//printout the response
		} catch (StatusRuntimeException e) {
			System.out.println("Server request timed out.");
		}
		
		
	}
}