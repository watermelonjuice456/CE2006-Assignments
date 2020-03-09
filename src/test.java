import java.util.Scanner;

public class test {
	
	
	public static void main(String[] args)
	{
		int choice;
		String result;
		String userInfo;
		String driverName;
		System.out.println("Enter your choice(-1 for exit)");
		System.out.println("1 for userRegister");
		System.out.println("2 for bookingUpdate");
		System.out.println("3 for findDriver");
		System.out.println("4 for verifyLogin");
		System.out.println("5 for getPassengerDetail");
		System.out.println("6 for getDriverDetail");
		System.out.println("7 for getBookingStatus");
		System.out.println("8 for acceptBooking");
		System.out.println("9 for cancelBooking");
		System.out.println("10 for findAllDrivers");
		
		String dummmy;
		
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		dummmy = sc.nextLine();
		
		while(choice != -1)
		{
			switch(choice) {
			case 1:
				System.out.println("userRegister");
				System.out.println("Please enter user information in the format of: name&age&email&password&passenger/Driver&phone");
				userInfo = sc.nextLine();
				result = HttpConnection.userRegister(userInfo);
				System.out.println(result);
				break;
				
			case 2:
				System.out.println("bookingUpdate");
				System.out.println("Please enter updateDetails in the format of : id&pickupAddreaa&coordinateLlong&coordinateLat&destAddress&driverName&price");
				userInfo = sc.nextLine();
				result = HttpConnection.bookingUpdate(userInfo);
				System.out.println(result);
				break;
				
			case 3:
				System.out.println("findDriver");
				System.out.println("Please enter driver name:");
				driverName = sc.nextLine();
				result = HttpConnection.findDriver(driverName);
				System.out.println(result);
				break;
				
			case 4:
				System.out.println("verifyLogin");
				System.out.println("Please enter userInfo in the format of: email&password&passengerDriver");
				userInfo = sc.nextLine();
				result = HttpConnection.verifyLogin(userInfo);
				System.out.println(result);
				break;
				
			case 5:
				System.out.println("getPassengerDetail");
				System.out.println("Please enter row number: ");
				userInfo = sc.nextLine();
				result = HttpConnection.getPassengerDetail(userInfo);
				System.out.println(result);
				break;
				
			case 6:
				System.out.println("getDriverDetail");
				System.out.println("Please enter row number: ");
				userInfo = sc.nextLine();
				result = HttpConnection.getPassengerDetail(userInfo);
				System.out.println(result);
				break;
				
			case 7:
				System.out.println("getBookingStatus");
				System.out.println("Please enter row number: ");
				userInfo = sc.nextLine();
				result = HttpConnection.getBookingStatus(userInfo);
				System.out.println(result);
				break;
				
			case 8:
				System.out.println("acceptBooking");
				System.out.println("Please enter driver name");
				userInfo = sc.nextLine();
				result = HttpConnection.acceptBooking(userInfo);
				System.out.println(result);
				break;
				
			case 9:
				System.out.println("cancelBooking");
				System.out.println("Please enter driver name");
				userInfo = sc.nextLine();
				result = HttpConnection.cancelBooking(userInfo);
				System.out.println(result);
				break;
				
			case 10:
				System.out.println("findAllDrivers");
		        result = HttpConnection.findAllDrivers();
		        System.out.println(result);
		        break;
				
			default:
				break;
				
			}
			
			System.out.println("Enter your choice(-1 for exit)");
			System.out.println("1 for userRegister");
			System.out.println("2 for bookingUpdate");
			System.out.println("3 for findDriver");
			System.out.println("4 for verifyLogin");
			System.out.println("5 for getPassengerDetail");
			System.out.println("6 for getDriverDetail");
			System.out.println("7 for getBookingStatus");
			System.out.println("8 for acceptBooking");
			System.out.println("9 for cancelBooking");
			System.out.println("10 for findAllDrivers");
			
			choice = sc.nextInt();
			dummmy = sc.nextLine();
			
		}
		
	
		
	}
 
}
