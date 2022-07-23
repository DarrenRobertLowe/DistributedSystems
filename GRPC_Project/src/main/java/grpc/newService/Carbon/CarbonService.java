package grpc.newService.Carbon;


import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import grpc.newService.Carbon.CarbonService;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//import grpc.newService.Carbon.Operation;
import grpc.newService.Carbon.CarbonServiceGrpc.CarbonServiceImplBase;
import grpc.newService.newServiceGrpc.newServiceImplBase;
import grpc.newService.Carbon.CarbonServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CarbonService extends CarbonServiceImplBase {


	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		CarbonService ourServer = new CarbonService();
		ourServer.start();
		

	}

	private void start() throws IOException, InterruptedException {
		System.out.println("Starting grpc server");
		
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new CarbonServiceImpl()).build().start();	
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
		
	static class CarbonServiceImpl extends CarbonServiceImplBase {
		// this is where are methods will go
	}
	
		/*
		CarbonService thisServer = new CarbonService();
		
		Properties prop = thisServer.getProperties();
		
		thisServer.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(thisServer)
					.build()
					.start();

			System.out.println("Math Server started, listening on " + port);

			server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/math.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Math Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	
	/*
	/// JMDNS Stuff
	private  void registerService(Properties prop) {
		
		 try {
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
	
	
	
	// THESE CORRESPOND TO THE PROTO'S RPCs
	public void calculate(CalculateRequest request, 
			StreamObserver<CalculateResponse> responseObserver) {

		System.out.println("receiving calculate method " + request.getNumber1() + " , " + request.getNumber2() + " " + request.getOperation() );

		float value = Float.NaN;
		String msg= "ok " + request.getOperation().name() + " result ";

		if(	request.getOperation()==Operation.ADDITION)
			value = request.getNumber1() + request.getNumber2();
		else if(	request.getOperation()==Operation.SUBTRACTION)
			value = request.getNumber1() - request.getNumber2();
		else if(	request.getOperation()==Operation.MULTIPLICATION)
			value = request.getNumber1() * request.getNumber2();
		else if(	request.getOperation()==Operation.DIVISION)
			value = request.getNumber1() / request.getNumber2();
		else {
			value = Float.NaN;
			msg = "no supported/implemented operation";
		}		
		
		CalculateResponse reply = CalculateResponse.newBuilder().setResult(value).setMessage(msg).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
	}

	//service implmentation for 
	public void generateRandomNumbers(RandomRequest request,
			StreamObserver<NumberResponse> responseObserver) {


		System.out.printf("receiving generateRandom method num: %d from: %d to: %d \n",
				request.getNumbers(), request.getMin(), request.getMax()  );

		Random rand = new Random();

		for(int i=0; i<request.getNumbers(); i++) {

			int random_value = rand.nextInt(request.getMax() - request.getMin()) + request.getMin() + 1;

			NumberResponse reply = NumberResponse.newBuilder().setNumber(random_value).build();

			responseObserver.onNext(reply);

			try {
				//wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		responseObserver.onCompleted();


	}


	public StreamObserver<NumberMessage> averageValues(
			StreamObserver<CalculateResponse> responseObserver) {


		return new StreamObserver<NumberMessage>() {

			ArrayList<Float> list = new ArrayList();

			@Override
			public void onNext(NumberMessage request) {

				System.out.println("receiving averageValues method num: "+ request.getNumber()  );

				list.add(request.getNumber());		           

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stubal

			}

			@Override
			public void onCompleted() {
				System.out.printf("receiving averageValues method complete \n" );

				// System.out.println("mean "+ list.size());

				double temp = 0;	
				for(float v:  list) {
					temp = temp + v;
				}
				float mean = (float) (temp/list.size());

				CalculateResponse reply = CalculateResponse.newBuilder().setResult(mean).build();

				// System.out.println("mean "+ mean);
				responseObserver.onNext(reply);

				responseObserver.onCompleted();

			}

		};

	}

	public StreamObserver<ConvertMessage> convertBase(StreamObserver<ConvertResponse> responseObserver) {
		
		return new StreamObserver<ConvertMessage> () {

			@Override
			public void onNext(ConvertMessage msg) {
				System.out.println("receiving convertBase method num: "+ msg.getNumber() + " from-base: "+ msg.getFromBase() + " to-base: "+ msg.getToBase()  );
				
				String converted =  Integer.toString(Integer.parseInt(msg.getNumber(), msg.getFromBase()), msg.getToBase());
				
				ConvertResponse reply = ConvertResponse.newBuilder().setNumber(converted).setBase(msg.getToBase()).build();
				
				responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println("receiving convertBase completed ");
				
				//completed too
				responseObserver.onCompleted();
			}
			
		};
	}
	
	*/
}

