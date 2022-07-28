package grpc.newService.Carbon;

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

import grpc.newService.Carbon.CarbonService;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;



import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
*/


import java.io.IOException;

import grpc.newService.Carbon.carbonServiceGrpc.carbonServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class CarbonService {

	private Server server;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		CarbonService ourServer = new CarbonService();
		ourServer.start();
		
	}

	public void start() throws IOException, InterruptedException {
		System.out.println("Starting grpc server");
		
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new CarbonServiceImpl()).build().start();	
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	}
	
	
	//Extend abstract base class for our own implementation
	static class CarbonServiceImpl extends carbonServiceImplBase {
		
		@Override
		public void calculateCarbonFlight(carbonFlightRequest request, StreamObserver<containsString> responseObserver) {
			
			//Find out what was sent by the client
			int firstInt = request.getHoursInput();
			System.out.println("FirstInt is: " + firstInt);
			
			
			/* CALCULATION
			 * This calculation is based on CO2 emissions from aviation fuel being 3.15
			 * grams per gram of fuel and using a Boeing 737-400 as the type of plane.
			 * From research this appears to equate to 115 g per passenger per km.
			 * Cruising speed is reportedly 780 km per hour. So per passenger, we
			 * have ... (hours * 780 * 115)/1000 to get kg
			 */
			int result = ((firstInt * 780 * 115)/1000);
			
			
			//now build our response
			containsString.Builder responseBuilder = containsString.newBuilder();	//create a builder
			
			responseBuilder.setFirstString("The amount of carbon emmited for this flight is about " + result + "kg.");
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
		}
		
		
		
		@Override
		public void calculateCarbonDrive(carbonDriveRequest request, StreamObserver<containsString> responseObserver) {
			
			//Find out what was sent by the client
			int distance = request.getMilesInput(); // we should probably change this to kilometers
			int mpg = request.getMpgInput();
			System.out.println("distance is: " + distance);
			System.out.println("mpg is: " + mpg);
			
			
			/* CALCULATION
			 * According to eta.co.uk, we can get the grams per km by dividing
			 * 6760 for petrol (or 7440 for diesel) by the mpg of the car.
			 * So if we do that, we can then multiply it by the journey length.
			 */
			double kmRatio = 1.609; // we asked for miles so we'll need to convert things
			double result = (((6760 / mpg) * (distance * kmRatio))/1000); // we divide by 1000 to get kgs
			
			
			//now build our response
			containsString.Builder responseBuilder = containsString.newBuilder();	//create a builder
			
			responseBuilder.setFirstString("The amount of carbon emmited for this drive is about " + result + "kg");
			
			responseObserver.onNext(responseBuilder.build());
			responseObserver.onCompleted();
			
			
			/* NOTE: For this would could actually take a string in that reads either "petrol" or "diesel",
			 * and we could have a GUI button to switch between them. That would be a nice addition.
			 */
		}
		
		
		
		
		/*
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
		
		*/
	}
}


/*
public class CarbonService extends CarbonServiceImplBase {

	private Server server;
	
	// MAIN METHOD
	public static void main(String[] args) throws IOException, InterruptedException {
		
		CarbonService thisServer = new CarbonService();
		thisServer.start();
	}
	
	
	// STARTING THE SERVER
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting grpc server");
		
		
		Properties prop = thisServer.getProperties();
		
		
		//thisServer.registerService(prop); // !!!! WE NEED TO ADD THIS BACK IN WHEN WE GET TO DOING JMDNS !!!!
		
		
		// get the port
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
		
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(thisServer)
					.build()
					.start();

			System.out.println("Carbon Footprint Server started, listening on " + port);

			server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//server = ServerBuilder.forPort(port).addService(new CarbonServiceImpl()).build().start();	
		//System.out.println("Server running on port: " + port);
		//server.awaitTermination();
	}
	
	
	
	
	
	
	private Properties getProperties() {
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/carbonserver.properties")) {

			prop = new Properties();

	        // load a properties file
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
	
	
	static class CarbonServiceImpl extends CarbonServiceImplBase {
	
	public void calculateCarbonFlight(CarbonFlightRequest request, StreamObserver<constainsString> responseObserver) {
		
		System.out.println("receiving flight method " + request.getHoursInput()); //+ " , " + request.getNumber2() + " " + request.getOperation() );
		
		
//		  CO2 emissions from aviation fuel are 3.15 grams per gram of fuel [38] , 
//		  which gives CO2 emissions from a Boeing 737-400 of 115 g per passenger km. 
//		  At a cruising speed of 780 km per hour [Wikipedia, 28.2. 08], this is 
//		  equivalent to 90 kg CO2 per hour.
		 
		int value = 0;
		String msg= "ok " + request.getHoursInput() * 115 + " total grams CO2 emitted.";//getOperation().name() + " result ";
		
		
		
		
//		if(	request.getOperation()==Operation.ADDITION)
//			value = request.getNumber1() + request.getNumber2();
//		else if(	request.getOperation()==Operation.SUBTRACTION)
//			value = request.getNumber1() - request.getNumber2();
//		else if(	request.getOperation()==Operation.MULTIPLICATION)
//			value = request.getNumber1() * request.getNumber2();
//		else if(	request.getOperation()==Operation.DIVISION)
//			value = request.getNumber1() / request.getNumber2();
//		else {
//			value = Float.NaN;
//			msg = "no supported/implemented operation";
//		}		
		
		CarbonFlightResponse reply = CarbonFlightResponse.newBuilder().setResult(value).setMessage(msg).build();

		responseObserver.onNext(reply);

		responseObserver.onCompleted();
		
		
		
		//now build our response
		//Step one create a builder
		//containsString.Builder responseBuilder = containsString.newBuilder();
		
		//responseBuilder.setFirstString("we are now responding to the user input.");
		
		//responseObserver.onNext(responseBuilder.build());
		//responseObserver.onCompleted();
	}
	
	
	
	
	//static class CarbonServiceImpl extends CarbonServiceImplBase {
		// this is where our methods will go
	//}
	
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
	            System.out.println("Math Service properties ...");
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
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
	            
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
	public void calculate(CalculateRequest request, StreamObserver<CalculateResponse> responseObserver) {

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

	//service implementation for 
	public void generateRandomNumbers(RandomRequest request, StreamObserver<NumberResponse> responseObserver) {


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
	
	
	public StreamObserver<NumberMessage> averageValues(StreamObserver<CalculateResponse> responseObserver) {

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
//	}
//}

