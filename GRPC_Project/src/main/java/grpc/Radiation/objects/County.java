package grpc.Radiation.objects;

public class County <T> implements algorithms.GenericsInterface {
	private String name;
	private double value;
	
	
	public County(String name) {
		this.name  = name;
		this.value = 0.0;
	}
	
	public County(String name, double value) {
		this.name  = name;
		this.value = value;
	}
	
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}


}