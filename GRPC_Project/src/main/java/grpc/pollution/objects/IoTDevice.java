package grpc.pollution.objects;

import java.util.Random;

/* This is a class that represents the
 * IoT devices that would be used in the
 * tracking of air pollution.
 */

public class IoTDevice <T> implements algorithms.GenericsInterface {
	float health;
	String id;
	
	// constructor
	public IoTDevice(String id) {
		this.id = id;
		this.health = calculateHealth();
	}
	
	
	// getters
	public String getID() {
		return id;
	}
	
	public float getHealth() {
		return health;
	}
	
	public double getValue() {
		return 0.0;
	}
	
	
	// sets a random amount of health for testing purposes
	private float calculateHealth() {
		Random rando = new Random();
		return rando.nextFloat(100);
	}
}