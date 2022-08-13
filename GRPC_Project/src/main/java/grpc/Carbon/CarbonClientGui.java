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


//GUI
import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import grpc.Carbon.carbonServiceGrpc.carbonServiceBlockingStub;
import grpc.Carbon.carbonServiceGrpc.carbonServiceStub;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;



public class CarbonClientGui {
	
	static ServiceInfo carbonServiceInfo; // jmdns
	
	public static carbonServiceBlockingStub blockingStub;
	public static carbonServiceStub asyncStub;
	
	JFrame frame;
	JTextField textNumber1;
	JTextField textNumber2;
	JTextArea textResponse;
	
	
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
		
		
		
		
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarbonClientGui window = new CarbonClientGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		/*
		// call the rpc methods
		calculateCarbonFlight(5);					// parameter is the number of hours
		calculateCarbonDrive(100, 40, "diesel"); 	// 100 miles at 40mpg
		*/
		
		// terminate the channel so we don't get errors
		//channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
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
	
	
	
	/**
	 * Create the application.
	 */
	public void CarbonClientGUI() {
		String service_type = "_carbonservice_http._tcp.local.";
		discoverCarbonService(service_type);
		
		String host = carbonServiceInfo.getHostAddresses()[0];
		int port = carbonServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = carbonServiceGrpc.newBlockingStub(channel);

		asyncStub = carbonServiceGrpc.newStub(channel);
		
		initialize();
	}
	
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Number 1");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number 2");
		panel_service_1.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
		
		JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
		panel_service_1.add(comboOperation);
	
		
		JButton btnCalculate = new JButton("Calculate");
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(textNumber1.getText());
				int num2 = Integer.parseInt(textNumber2.getText());

				int index = comboOperation.getSelectedIndex();
				//Operation operation = Operation.forNumber(index);
				
				carbonFlightRequest request = carbonFlightRequest.newBuilder().setHoursInput(num1).build();
				
				responseString response = blockingStub.calculateCarbonFlight(request);
				
				textResponse.append("reply:"+ response.getMessage() + " mes:"+ response.getMessage() + "\n");
				
				System.out.println("res: " + response.getMessage() + " mes: " + response.getMessage());
				
			}
		});
		
		
		panel_service_1.add(btnCalculate);
		
		textResponse = new JTextArea(3, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
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
		responseString response = blockingStub.calculateCarbonFlight(request);
		
		
		//printout the response
		System.out.println(response.getMessage());
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
		responseString response = blockingStub.calculateCarbonDrive(request);
		
		
		//printout the response
		System.out.println(response.getMessage());
	}
}