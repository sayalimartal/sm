import java.util.*;
public class VehicleTest 
{

	public static void main(String args[])
	{
		
	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of vehicles");
		int numberOfVehicle=scanner.nextInt();
		Vehicle vehicle[]= new Vehicle[numberOfVehicle];
		
		
		
		for(int i=0; i<numberOfVehicle; i++)
		{
			vehicle[i]= new Vehicle();
		}
		Vehicle vehiclecons=new Vehicle(scanner.next());
		
		for(int i=0; i<numberOfVehicle; i++)
		{
			
			System.out.println("Enter the name of vehicle "+(i+1)+"'s initial owner");
			vehiclecons.setInitialOwnerName(scanner.next());
			
			System.out.println("Enter the name of vehicle "+(i+1)+"'s owner");
			vehicle[i].setOwnerName(scanner.next());
			
			System.out.println("Enter current speed  of vehicle "+(i+1));
			vehicle[i].setSpeed(scanner.nextInt());
			
			System.out.println("Enter current direction of vehicle "+(i+1));
			vehicle[i].setDirection(scanner.nextInt());
			
			
			System.out.println("do you want to turn?");
			{
				String answerTurn=scanner.next();
				if(answerTurn.equals("Yes")) 
				{
					System.out.println("left or right?");
					String answerTurnValue=scanner.next();
					if(answerTurnValue.equals("left")) 
					{
						System.out.println("By what value you want to change?");
						int change=scanner.nextInt();
						if(change>=180)
						{
							System.out.println("Invalid Input");
							System.exit(0);
						
						}
						else
						{
							vehicle[i].changeDirection(change);
						}
					}
					if(answerTurnValue.equals("right")) 
					{
						System.out.println("By what value you want to change?");
						int change=scanner.nextInt();
						if(change>=180)
						{
							System.out.println("Invalid Input");
							System.exit(0);
						
						}
						else
						{
							vehicle[i].changeDirection(0-change);
						}
					}
				}
			}
			
			
			
		}
		
		for(int i=0; i<numberOfVehicle; i++)
		{
			//System.out.println("the initial owner's name of "+(i+1)+" vehicle is "+ vehicle[i].getInitialOwnerName());
			System.out.println("the name of  vehicle "+(i+1)+"'s owner is "+vehicle[i].getOwnerName());
			System.out.println("current speed  of  vehicle "+(i+1)+"  is "+vehicle[i].getSpeed());
			System.out.println("current direction of vehicle "+(i+1)+"  is "+vehicle[i].getDirection() );
			System.out.println("identification number of  vehicle "+(i+1)+" is "+vehicle[i].getVehicleIdNo() );
			
		}
		
		
		System.out.println("The highest Idenmtification number so far is "+ Vehicle.getIdentificationNumber());
		
		
		
	}
}
