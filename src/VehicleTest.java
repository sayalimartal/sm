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
						
			System.out.println("Enter the name of vehicle "+(i+1)+"'s owner");
			vehicle[i]= new Vehicle(scanner.next());
			
			System.out.println("Enter current speed  of vehicle "+(i+1));
			vehicle[i].changeSpeed(scanner.nextInt());
			
			System.out.println("Enter current direction of vehicle "+(i+1)+" in degrees");
			vehicle[i].setDegree(scanner.nextInt());
			
			System.out.println("Do you want to change the vehicle speed? Yes/No");
			String changeSpeed=scanner.next();
			if(changeSpeed.equals("Yes")) {
				System.out.println("Enter the desired speed");
				vehicle[i].changeSpeed(scanner.nextInt());
			}
			
			System.out.println("Do you want to turn? Yes/No");
			String answerTurn=scanner.next();
			if(answerTurn.equals("Yes")) 
			{
				System.out.println("Directly turn Left or Right?");
				String answerTurnValue=scanner.next();
				if(answerTurnValue.equals("Left")) 
					vehicle[i].turnLeftRight(Vehicle.TURN_LEFT);
				else if(answerTurnValue.equals("Right")) 
					vehicle[i].turnLeftRight(Vehicle.TURN_RIGHT);
				else
				{
				System.out.println("Turn by certain degrees? Yes/No");
				String turn=scanner.next();
				if(turn.equals("Yes")) 
				{
					System.out.println("By what value you want to change? Enter positive value to turn left,negative to turn right");
					int change=scanner.nextInt();
					vehicle[i].changeDirection(change);
				}
				}
			}
			System.out.println("Do you want to stop the vehicle? Yes/No");
			String stop=scanner.next();
			if(answerTurn.equals("Yes")) 
				vehicle[i].stop();
		}
		
		System.out.println("The highest identification number is "+ Vehicle.getIdentificationNumber());

		for(int i=0; i<numberOfVehicle; i++)
			System.out.println(vehicle[i].toString());	
		
	}		
}
