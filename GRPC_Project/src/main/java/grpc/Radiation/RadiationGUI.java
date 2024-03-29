package grpc.Radiation;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import grpc.Carbon.carbonDriveRequest;
import grpc.Carbon.responseString;
import grpc.Radiation.radiationServiceGrpc.radiationServiceBlockingStub;
import grpc.Radiation.radiationServiceGrpc.radiationServiceStub;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Darren Robert Lowe
 * 
 * This is the GUI client for the Radiation Service
 * 
 * The Radiation Service deals with radiation in the water supply. IoT 
 * devices (hypothetically) collect data and forward it to a server, where 
 * it can be arranged by danger level and relayed to any interested clients.
 * The service also provides a system where a client can input a threshold
 * for radiation and receive a list of all regions that exceed that match
 * or exceed that threshold, or in another service they can simply receive
 * a list of all entries arranged by severity.
 * 
 * This class is to demonstrate using a GUI to interact with a grpc service and
 * allows the user to get a list of counties that have radiation levels above
 * a given threshold.
 */

public class RadiationGUI {

	static int threshold = -1;	// because otherwise the try-catch for validation causes errors
	
	private static ServiceInfo radiationServiceInfo; // jmdns
	
	private static radiationServiceBlockingStub blockingStub;
	private static radiationServiceStub asyncStub;
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextArea textResponse ;
	
	static ManagedChannel channel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadiationGUI window = new RadiationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public RadiationGUI() {
		
		// jmdns resolution
		String service_type = "radiationservice_http._tcp.local.";
		discoverService(service_type);
		
		String host = "localhost";//radiationServiceInfo.getHostAddresses()[0];
		int port = 50052;//radiationServiceInfo.getPort();
		
		channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = radiationServiceGrpc.newBlockingStub(channel);

		asyncStub = radiationServiceGrpc.newStub(channel);

		
		initialize(channel);
	}
	
	
	
	// JmDNS
	private static void discoverService(String service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Radiation Service resolved: " + event.getInfo());

					radiationServiceInfo = event.getInfo();

					int port = radiationServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + radiationServiceInfo.getNiceTextString());
					System.out.println("\t host: " + radiationServiceInfo.getHostAddresses()[0]);
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Radiation Service removed: " + event.getInfo());
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Radiation Service added: " + event.getInfo());
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
	 * Initialize the contents of the frame.
	 */
	private void initialize(ManagedChannel channel) { // passed channel here so we can close the window without causing an error
		
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		
		
		
		
		// RADIATION WARNINGS
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel lblNewLabel_1 = new JLabel("Threshold");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
		
		
		
		/// Gracefully handle the window closing event
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Window closed by user.");
				channel.shutdown(); 	// this avoids errors in the console
			}
		});
		
		
		
		// calculate button
		JButton btnCalculate = new JButton("Get Warnings");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					threshold = Integer.parseInt(textNumber1.getText());
				} catch (NumberFormatException e1) {
					System.out.println("Invalid threshold entered.");
					threshold = -1;
				}
				
				System.out.println("Requesting Radiation Warnings of threshold " + threshold);
				System.out.println("===========================================");
				
				
				requestRadiationAlerts request = requestRadiationAlerts
						.newBuilder()
						.setThreshold(threshold)
						.build();
				
				
				StreamObserver<radiationAlert> responseObserver = new StreamObserver<radiationAlert>() {
					int count = 0;
					@Override
					public void onNext(radiationAlert value) {
						System.out.println(value.getRadiationAlerts());	//e.g. "Alert in Carlow:7.075986495087796 picocuries per litre detected!"
						textResponse.append(value.getRadiationAlerts() + "\n");
						count++;
					}
					
					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
	
					}
					
					@Override
					public void onCompleted() {
						System.out.println("stream is completed ... received "+ count+ " counties with alerts for threshold " + threshold);
					}
				};
				
				asyncStub.getRadiationWarnings(request, responseObserver);
			}
		});
		panel_service_1.add(btnCalculate);
		
		textResponse = new JTextArea(16, 30);
		textResponse.selectAll();
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		panel_service_1.add(scrollPane);
		
		
		/*
		// RADIATION WARNINGS
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JButton btnCalculate = new JButton("Get Radiation Levels");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radiationLevels request = radiationLevels.newBuilder().build();
				
				StreamObserver<levelsStream> responseObserver = new StreamObserver<levelsStream>() {
					int count = 0;
					
					@Override
					public void onNext(levelsStream value) {
						textResponse.append(value.getDangerousRegions() +"\n");
					}
					
					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}
					
					@Override
					public void onCompleted() {
						System.out.println("stream is completed");
					}
				};
				
				asyncStub.withDeadlineAfter(20,TimeUnit.SECONDS).getRadiationLevels(request, responseObserver); // deadline of 20 seconds
			}
		});
		panel_service_3.add(btnCalculate);
		
		textResponse = new JTextArea(8, 30);
		textResponse .setLineWrap(false);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
	*/
	}

}
