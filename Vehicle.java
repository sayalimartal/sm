
public class Vehicle {

	private int speed;
	private int direction;
	private String ownerName;
	private static int identificationNumber=100000;
	private int vehicleIdNo;
	private String initialOwnerName;
	
	
	

	public Vehicle()
	{
		
	}
	
	public Vehicle(String name)
	{
		initialOwnerName=name;
		
	}
	
	
	public static int getIdentificationNumber() {
		return identificationNumber;
	}

	public void setInitialOwnerName(String initialOwnerName) {
		
		this.initialOwnerName = initialOwnerName;
	}
	public String getInitialOwnerName() {
		return initialOwnerName;
	}
	public int getVehicleIdNo(){
		return vehicleIdNo;
	}
	
	public int getSpeed() {
		vehicleIdNo=identificationNumber+1;
		identificationNumber+=1;
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public int changeDirection(int change)
	{
		direction+=change;
		return direction;
	}
	
	
	
	
}
