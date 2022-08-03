package grpc.Radiation;

import grpc.Carbon.carbonFlightRequest;
import grpc.Carbon.carbonServiceGrpc.carbonServiceImplBase;
/*
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import grpc.newService.Carbon.RadiationService;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;



import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
*/
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
		
		
	}
}
