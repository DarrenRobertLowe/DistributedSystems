package grpc.pollution;



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
import grpc.pollution.pollutionServiceGrpc.pollutionServiceBlockingStub;
import grpc.pollution.pollutionServiceGrpc.pollutionServiceStub;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Darren Robert Lowe
 *
 * This is the GUI client for the Pollution Service.
 * 
 * The Pollution Service deals with air pollution. This is broken into four rpcs,
 * StreamPollution, GetLocalAirPollution, GetDeviceStatus and GetAllDeviceStatus.
 * StreamPollution is for IoT devices to stream their carbon dioxide numbers to
 * the server. GetLocalAirPollution is a bi-directional stream where a user sends
 * GPS data to the server and the server in turn responds with the air pollution
 * in the area (in ppm). GetDeviceStatus returns the health status of a given IoT
 * device and lastly GetAllDeviceStatus returns the average health over all the
 * IoT devices.
 * 
 * This class is to demonstrate using a GUI to interact with a grpc service and
 * allows the user to get the health status of a single (hypothetical) IoT Device.
 */

public class PollutionGUI {

	private static ServiceInfo pollutionServiceInfo; // jmdns
	
	private static pollutionServiceBlockingStub blockingStub;
	private static pollutionServiceStub asyncStub;
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextField textNumber3;
	private JTextArea textResponse ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PollutionGUI window = new PollutionGUI();
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
	public PollutionGUI() {
		
		// jmdns resoultion
		String carbon_service_type = "_pollutionService_http._tcp.local.";
		discoverpollutionService(carbon_service_type);
		
		String host = pollutionServiceInfo.getHostAddresses()[0];
		int port = pollutionServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = pollutionServiceGrpc.newBlockingStub(channel);

		asyncStub = pollutionServiceGrpc.newStub(channel);

		
		initialize(channel);
	}
	
	
	
	// JmDNS
	private static void discoverpollutionService(String service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Radiation Service resolved: " + event.getInfo());

					pollutionServiceInfo = event.getInfo();

					int port = pollutionServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + pollutionServiceInfo.getNiceTextString());
					System.out.println("\t host: " + pollutionServiceInfo.getHostAddresses()[0]);
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
	 * Initialize the contents of the frame.
	 */
	private void initialize(ManagedChannel channel) { // passed channel here so we can close the window without causing an error
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		
		
		/// Gracefully handle the window closing event
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Window closed by user.");
				channel.shutdown(); 	// this avoids errors in the console
			}
		});
				
				
		
		// CAR CALCULATION
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel lblNewLabel_1 = new JLabel("Device ID to check health of");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
		
		
		
		// calculate button
		JButton btnCalculate = new JButton("Get Health Status");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String device = textNumber1.getText().toString();
				
				
				System.out.println();
				System.out.println();
				
				System.out.println("Getting health status for '" + device + "'");
				System.out.println("=====================================");
				
			
				deviceStatusRequest request = deviceStatusRequest.newBuilder().setStatusRequestedID(device).build();
				deviceStatusResponse response = blockingStub.withDeadlineAfter(4,TimeUnit.SECONDS).getDeviceStatus(request);	// deadline of 4 seconds
				
				textResponse.append(response.getStatus() + "\n");
				System.out.println(response.getStatus()); // e.g.: "Health for device dev04: 77.14953"
			}
		});
		panel_service_1.add(btnCalculate);
		
		textResponse = new JTextArea(12, 30);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
	}

}
