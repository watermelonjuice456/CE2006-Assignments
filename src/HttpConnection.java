import java.io.*;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
//import javax.net.ssl.HttpsURLConnection;

import java.net.URLEncoder;
import java.net.URLDecoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpConnection {
	//function1
	//input: string userDetail(email&password&passengerDriver) 
 	//return: String id(corresponding row number for success, -1 or others for error)
	@SuppressWarnings("deprecation")
	public static String verifyLogin(String userDetail) {
	
	  String url = "URL address"; //replace the URL address with your own URL address
	  String urlParameters = null;
	  
	  BufferedReader in = null;
	  PrintWriter out = null;
	  String buffer = "";
	  
	  String [] info = null;
	  String email = null;
	  String password = null;
	  String passengerDriver = null;
	  
	  
	  String id = "-1";
	  int dummy;
	   
	  try {
	   URL obj = new URL(url);

	   //create connection 
	   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
	   //trigger POST 
	   connection.setDoOutput(true);
	   connection.setDoInput(true);
	   connection.setUseCaches(false);
	   connection.setInstanceFollowRedirects(true);
	   connection.setRequestMethod("POST");
	   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

	   if (userDetail != null) {
		   info = userDetail.split("&");
		   email = info[0];
		   password = info[1];
		   passengerDriver = info[2];
		   
		   email = URLEncoder.encode(email);
		   password = URLEncoder.encode(password);
		   
		   passengerDriver = URLEncoder.encode(passengerDriver);
		   
		   urlParameters = "email="+email+"&password="+password+"&passengerDriver="+passengerDriver;
	   }
	   
	   else urlParameters = null;
	   
	   out = new PrintWriter(connection.getOutputStream());
	   out.print(urlParameters);
	   out.flush();
	   out.close();
	   
	   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
	   String line;
	   while (((line = in.readLine()) != null)) {
	    buffer = buffer + line;
	   }

	   System.out.println(buffer);

	   JSONObject jsonObject = new JSONObject(buffer);
	   
	   if (jsonObject.has("id"))
	   {
		   dummy = jsonObject.getInt("id");
		   id = Integer.toString(dummy);
	   }
	   
	   else if(jsonObject.has("error"))
	   {
		  //String error = jsonObject.getString("error");
		  //System.out.println(error);
		  id = "-1";
	   }
	   

	  } catch (Exception e) {
	   System.out.println("Error in sending POST!" + e);
	   e.printStackTrace();
	  } finally {
	   try {
	    if (out != null) 
	     out.close();

	    if (in != null) {
	     in.close();
	    }
	   } catch (IOException ex) {
	    ex.printStackTrace();
	   }
	  }
	  return id;
	}
	
   //function2 
   //input: String id
   //return: return the whole row (-1 for error)
	@SuppressWarnings("deprecation")
	public static String getPassengerDetail(String id) {
		String url = "URL address";
		String urlParameters = null;
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String userID = null;
		  String name = null;
		  String age = null;
		  String phone = null;
		  String email = null;
		  String password = null;
		  String driverPassenger = null;
		  String coordinateLong = null;
		  String coordinateLat = null;
		  String pickupAddress = null;
		  String destAddress = null;
		  String driverName = null;
		  String price = null;
		  String bookingStatus = null;
		  String result = "-1";
		  
		  id =URLEncoder.encode(id);
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (id != null) {
			   id =URLEncoder.encode(id);
			   urlParameters = "id=" + id;
		   }
		   
		   else urlParameters = null;
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }
		   
		   
           
           int dummy;
           
		   JSONObject jsonObject = new JSONObject(buffer);
		   if (jsonObject.isNull("error"))
		   {
			   dummy = jsonObject.getInt("id");
			   userID = Integer.toString(dummy);
			   
			   //id = jsonObject.getString("id");
			   //id = URLDecoder.decode(id);
			   
			   name = jsonObject.getString("name");
			   name = URLDecoder.decode(name);
			   
			   age = jsonObject.getString("age");
			   age = URLDecoder.decode(age);
			   
			   phone = jsonObject.getString("phone_number");
			   phone = URLDecoder.decode(phone);
			   
			   email = jsonObject.getString("email");
			   email = URLDecoder.decode(email);
			   
			   password = jsonObject.getString("password");
			   password = URLDecoder.decode(password);
			   
			   driverPassenger = jsonObject.getString("user_type");
			   driverPassenger = URLDecoder.decode(driverPassenger);
			   
			   coordinateLong = jsonObject.getString("longitude");
			   coordinateLong = URLDecoder.decode(coordinateLong);
			   
			   coordinateLat = jsonObject.getString("latitude");
			   coordinateLat = URLDecoder.decode(coordinateLat);
			   
			   pickupAddress = jsonObject.getString("pickupAddress");
			   pickupAddress = URLDecoder.decode(pickupAddress);
			   
			   destAddress = jsonObject.getString("destAddress");
			   destAddress = URLDecoder.decode(destAddress);
			   
			   driverName = jsonObject.getString("driverName");
			   driverName = URLDecoder.decode(driverName);
			   
			   price = jsonObject.getString("price");
			   price = URLDecoder.decode(price);
			   
			   dummy = jsonObject.getInt("status");
			   bookingStatus = Integer.toString(dummy);
			   
			   
			   result = userID + "&" + name + "&" + age +"&"+phone+"&" + email + "&" + password + "&" + driverPassenger + "&" + coordinateLong +"&" + coordinateLat + "&" + pickupAddress + "&" + destAddress + "&" + driverName + "&" + price + "&" + bookingStatus;
			   
			   
		   }

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return result;
		
	}
	
	
	//function3
	//input: int id
	//return: return the whole row, -1 for error
	public static String getDriverDetail(String id) {
		String url = "URL address";
		String urlParameters = null;
		  
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String userID = null;
		  String name = null;
		  String age = null;
		  String phone = null;
		  String email = null;
		  String password = null;
		  String driverPassenger = null;
		  String coordinateLong = null;
		  String coordinateLat = null;
		  String pickupAddress = null;
		  String destAddress = null;
		  String driverName = null;
		  String price = null;
		  String bookingStatus = null;
		  String result = "-1";
		  
		  
		  id =URLEncoder.encode(id);
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (id != null) {
			   id =URLEncoder.encode(id);
			   
			   urlParameters = "id=" + id;
		   }
		   
		   else urlParameters = null;
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }

           int dummy;
		   JSONObject jsonObject = new JSONObject(buffer);
		   if (jsonObject.isNull("error"))
		   {
			   
			   dummy = jsonObject.getInt("id");
			   userID = Integer.toString(dummy);
			   
			   //id = jsonObject.getString("id");
			   //id = URLDecoder.decode(id);
			   
			   name = jsonObject.getString("name");
			   name = URLDecoder.decode(name);
			   
			   age = jsonObject.getString("age");
			   age = URLDecoder.decode(age);
			   
			   phone = jsonObject.getString("phone_number");
			   phone = URLDecoder.decode(phone);
			   
			   email = jsonObject.getString("email");
			   email = URLDecoder.decode(email);
			   
			   password = jsonObject.getString("password");
			   password = URLDecoder.decode(password);
			   
			   driverPassenger = jsonObject.getString("user_type");
			   driverPassenger = URLDecoder.decode(driverPassenger);
			   
			   coordinateLong = jsonObject.getString("longitude");
			   coordinateLong = URLDecoder.decode(coordinateLong);
			   
			   coordinateLat = jsonObject.getString("latitude");
			   coordinateLat = URLDecoder.decode(coordinateLat);
			   
			   pickupAddress = jsonObject.getString("pickupAddress");
			   pickupAddress = URLDecoder.decode(pickupAddress);
			   
			   destAddress = jsonObject.getString("destAddress");
			   destAddress = URLDecoder.decode(destAddress);
			   
			   driverName = jsonObject.getString("driverName");
			   driverName = URLDecoder.decode(driverName);
			   
			   price = jsonObject.getString("price");
			   price = URLDecoder.decode(price);
			   
			   dummy = jsonObject.getInt("status");
			   bookingStatus = Integer.toString(dummy);
			   
			   
			   result = userID + "&" + name + "&" + age +"&"+phone+"&" + email + "&" + password + "&" + driverPassenger + "&" + coordinateLong +"&" + coordinateLat + "&" + pickupAddress + "&" + destAddress + "&" + driverName + "&" + price + "&" + bookingStatus;
			   
			   
			   
		   }

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return result;
	}
	
	//function4
	//input: String id&pickupAddress&coordinateLong&coordinateLat&destaddress&driverName&price)
	//return: String result(1 for successful, -1 or others for error)
	@SuppressWarnings("deprecation")
	public static String bookingUpdate(String updateDetails)
	{
		 String url = "URL address";
		  String urlParameters = null;
		  
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String [] info = null;
		  String id = null;
		  String pickupAddress = null;
		  String coordinateLong = null;
		  String coordinateLat = null;
		  String destAddress = null;
		  String driverName = null;
		  String price = null;
		  String bookingStatus = "0";
		  
		  
		  String result = "-1";
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (updateDetails != null) {
			   info = updateDetails.split("&");
			   
			   id = info[0];
			   id = URLEncoder.encode(id);
			   
			   pickupAddress = info[1];
			   pickupAddress = URLEncoder.encode(pickupAddress);
			   
			   coordinateLong = info[2];
			   coordinateLong = URLEncoder.encode(coordinateLong);
			   
			   coordinateLat = info[3];
			   coordinateLat = URLEncoder.encode(coordinateLat);
			   
			   destAddress = info[4];
			   destAddress = URLEncoder.encode(destAddress);
			   
			   driverName = info[5];
			   driverName = URLEncoder.encode(driverName);
			   
			   price = info[6];
			   price = URLEncoder.encode(price);
			   
			   urlParameters = "id=" + id +"&pickupAddress=" + pickupAddress +"&coordinateLong=" + coordinateLong + "&coordinateLat=" + coordinateLat + "&destAddress=" + destAddress + "&driverName="+driverName + "&price=" +price + "&bookingStatus="+bookingStatus;
		   }
		   
		   else urlParameters = null;
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }


		   JSONObject jsonObject = new JSONObject(buffer);
		   
			   if (!jsonObject.isNull("error"))
			   {
				   result = "-1";
			   }
			   
			   else result = "1";
		   
	
		   

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return result;
	}
	
	//function 5
	//input: String driverName
	//return: String id (corresponding index number for successful search, -1 for unsuccessful search)
	@SuppressWarnings("deprecation")
	public static String findDriver(String driverName)
	{
		String url = "URL address";
		String urlParameters = null;
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  
		  String id = "-1";
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (driverName != null) {
			   driverName =URLEncoder.encode(driverName);
			   
			   urlParameters = "driverName=" + driverName;
		   }
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }

		   JSONObject jsonObject = new JSONObject(buffer);
		   if (jsonObject.has("id"))
		   {
			   int dummy = jsonObject.getInt("id");
			   id = Integer.toString(dummy);
		   }
		   
		   

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return id;
	}
	
	//function 6 - to delete the driverName from the row >>> update row from 0 to -1 for booking.
	//input: String driverName
	//return: String 1 for success -1 for unsuccess
	@SuppressWarnings("deprecation")
	public static String cancelBooking(String driverName) {
		String url = "URL address";
		String urlParameters = null;
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String result = "-1";
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (driverName != null) {
			   driverName =URLEncoder.encode(driverName);
			   urlParameters = "driverName=" + driverName;
		   }
		   
		  
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }

          
		   JSONObject jsonObject = new JSONObject(buffer);
		   if (jsonObject.has("success"))
		   {
			   result = "1";
		   }

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return result;
	         
	}
	
	//function 7 -initial =0, -1 for cancelled, 0 for empty status, 1 for accepted)
	//input: int id
	//return: String bookingStatus ( -1 for cancelled, 0 for empty status, 1 for accepted, error string for error)
	public static String getBookingStatus(String id)
	{
		String url = "URL address";
		String urlParameters = null;
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String bookingStatus = null;
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (id != null) {
			   id =URLEncoder.encode(id);
			   urlParameters = "id=" + id;
		   }
		   
		  
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line = null;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }
		  
		   System.out.println(buffer);

		   JSONObject jsonObject = new JSONObject(buffer);
		   
		   if(jsonObject.has("error"))
		   {
			   bookingStatus = jsonObject.getString("error");
			   bookingStatus = URLDecoder.decode(bookingStatus);
			   
		   }
		   else if (jsonObject.has("status"))
		   {
			  bookingStatus = jsonObject.getString("status");
			  bookingStatus = URLDecoder.decode(bookingStatus);
		   }
		   
		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return bookingStatus;
	}
	
	//function 8 - update the booking status of the row from 0 to 1 for booking at table
	//input: string driverName
	//return: String(1 for success, -1 for unsuccess)
	public static String acceptBooking (String driverName)
	{
		String url = "URL address";
		String urlParameters = null;
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String result = "-1";
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (driverName != null) {
			   driverName =URLEncoder.encode(driverName);
			   urlParameters = "driverName=" + driverName;
		   }
		   
		  
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }

		  

		   JSONObject jsonObject = new JSONObject(buffer);
		   if (jsonObject.isNull("error"))
		   {
			   result = "1";
		   }
		  /* else if(jsonObject.has("error"))
		   {
			   result = jsonObject.getString("error");
			   result = URLEncoder.encode(result);
		   }
		   */

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return result;
		
	}
	
	//function 9 - for driver/passenger register
	//input: String userInfo(name&age&email&password&driver/passenger&phone)
	//output:1 for success -1 for unsuccess  
	@SuppressWarnings("deprecation")
	public static String userRegister(String userInfo)
	{
		String url = "URL address";
		String urlParameters = null;
		  
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String name = null;
		  String age = null;
		  String phone = null;
		  String email = null;
		  String password = null;
		  String driverPassenger = null;
		  
		  
		  String result = null;
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		   if (userInfo != null) {
			   String []info = userInfo.split("&");
				  
				  name = info[0];
				  age = info[1];
				  email = info[2];
				  password = info[3];
				  driverPassenger = info[4];
				  phone = info[5];
				  
			      name = URLEncoder.encode(name);
			      age = URLEncoder.encode(age);
			      email = URLEncoder.encode(email);
			      password = URLEncoder.encode(password);
			      driverPassenger = URLEncoder.encode(driverPassenger);
			      phone = URLEncoder.encode(phone);
			   
			   urlParameters = "name="+name+"&age="+age+"&email="+email+"&password="+password+"&driverPassenger="+driverPassenger+"&phone="+phone;
		   }
		   
		   else urlParameters = null;
		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }
		   
           System.out.println("buffer");
		   System.out.println(buffer);
		  
           
           
           
		       JSONObject jsonObject = new JSONObject(buffer);
		       
		       
		       if(jsonObject.has("success"))
		    	   result = "1";
		       
		       else if(jsonObject.has("error"))
		       {
		    	   result = jsonObject.getString("error");
		    	   result = URLEncoder.encode(result);
		    	   //result = "-1";
		       }
			   
		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		  return result;
	}
	
	//function9
	//input: void 
	//return:String id1&id2&id3...
	public static String findAllDrivers()
	{
		String url = "URL address";
		String urlParameters = null;
		  BufferedReader in = null;
		  PrintWriter out = null;
		  String buffer = "";
		  
		  String result = "-1";
		   
		  try {
		   URL obj = new URL(url);

		   //create connection 
		   HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		   //trigger POST 
		   connection.setDoOutput(true);
		   connection.setDoInput(true);
		   connection.setUseCaches(false);
		   connection.setInstanceFollowRedirects(true);
		   connection.setRequestMethod("POST");
		   connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		 		   
		   out = new PrintWriter(connection.getOutputStream());
		   out.print(urlParameters);
		   out.flush();
		   out.close();
		   
		   in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		   String line;
		   while (((line = in.readLine()) != null)) {
		    buffer = buffer + line;
		   }
		   
		   System.out.println("buffer");
		   System.out.println(buffer);
		   //format string
		   buffer = buffer.substring(1, buffer.length()-1);
		   buffer = buffer.replaceAll( "\\\\",  "");
           System.out.println("buffer");
		   System.out.println(buffer);
		   

		   JSONArray jsonArray = new JSONArray(buffer);
		   if (jsonArray.length() >= 0)
		   {
			   String id = "";
			   String dummy2 = "";
			   int dummy = -1;
			   for(int i = 0; i<jsonArray.length();i++)
			   {
				   JSONObject jsonObject = jsonArray.getJSONObject(i);
				   
				   if(jsonObject.has("error"))
					   return result;
				   
				   dummy = jsonObject.getInt("pk");
				   dummy2 = Integer.toString(dummy);
				   id = id + "&" + dummy2;
			   }
			  
			  id = id.substring(1, id.length());
			  result = id;
		   }
		   

		 /*  JSONObject jsonObject = new JSONObject(buffer);
		   if (jsonObject.isNull("error"))
		   {
			   result = "1";
		   }
		   else if(jsonObject.has("error"))
		   {
			   result = jsonObject.getString("error");
			   result = URLEncoder.encode(result);
		   }
		   */
		 

		  } catch (Exception e) {
		   System.out.println("Error in sending POST!" + e);
		   e.printStackTrace();
		  } finally {
		   try {
		    if (out != null) 
		     out.close();

		    if (in != null) {
		     in.close();
		    }
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
		
		
		return result;
	}
}
