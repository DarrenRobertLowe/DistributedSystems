package grpc.Carbon;



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
import grpc.Carbon.carbonServiceGrpc.carbonServiceBlockingStub;
import grpc.Carbon.carbonServiceGrpc.carbonServiceStub;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Darren Robert Lowe
 *
 * This is the GUI client for the Carbon Service.
 * 
 * The Carbon Service is an environmental footprint calculator wherein a user can
 * calculate an estimated amount of air pollution (C02) a given journey would create.
 * For example a ten hours flight in a Boeing 737-400 airplane, or 30 mile drive in
 * an average petrol or diesel car. The user provides the system with the required
 * information and the service responds accordingly. In the case of a flight the
 * number of hours of the flight is the input, whereas with the vehicle journey the
 * miles per gallon, drive distance and fuel type (petrol or diesel) are required.
 * 
 * This class is to demonstrate using a GUI to interact with a grpc service and
 * allows the user to calculate the total carbon emissions for a car journey.
 */
public class CarbonGUI {

	private static ServiceInfo carbonServiceInfo; // jmdns
	
	private static carbonServiceBlockingStub blockingStub;
	private static carbonServiceStub asyncStub;
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextArea textResponse ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarbonGUI window = new CarbonGUI();
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
	public CarbonGUI() {
		
		// jmdns resoultion
		String carbon_service_type = "_carbonservice_http._tcp.local.";
		discoverCarbonService(carbon_service_type);
		
		String host = carbonServiceInfo.getHostAddresses()[0];
		int port = carbonServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = carbonServiceGrpc.newBlockingStub(channel);
		asyncStub = carbonServiceGrpc.newStub(channel);
		initialize(channel);
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
		
		
		JLabel lblNewLabel_1 = new JLabel("Distance in Miles");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Mpg");
		panel_service_1.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
		
		
		
		
		// dropdown menu
		JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"Petrol", "Diesel"}));
		panel_service_1.add(comboOperation);
		
		// calculate button
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int miles = 0;
				int mpg = 0;
				
				try {
					miles = Integer.parseInt(textNumber1.getText());
				} catch (NumberFormatException e1) {
					System.out.println("Invalid number input for miles.");
					miles = 0;
				}
				
				try {
					mpg = Integer.parseInt(textNumber2.getText());
				} catch (NumberFormatException e2) {
					System.out.println("Invalid number input for mpg.");
					mpg = 0;
				}
				
				
				int index = comboOperation.getSelectedIndex();
				
				String fuelType = "Petrol";
				
				if (index == 0)
					fuelType = "Petrol";
				if (index == 1)
					fuelType = "Diesel";
				
				
				carbonDriveRequest request = carbonDriveRequest.newBuilder().setMilesInput(miles).setMpgInput(mpg).setFuelType(fuelType).build();
				responseString response = blockingStub.calculateCarbonDrive(request);
				textResponse.append(response.getMessage() + "\n");
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
