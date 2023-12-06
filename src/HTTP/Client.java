package HTTP;
import java.net.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Client {
	public static void main(String args[]) 
	{
		try
		{
			       InetAddress ip = InetAddress.getByName("localhost");
					Socket clientSocket = new Socket (ip,6005);
					System.out.println("connecting to the server....");
					 DataInputStream input = new DataInputStream(clientSocket.getInputStream());
					 DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
					 FileOutputStream web = new FileOutputStream("C:\\Users\\RS3\\Desktop\\test.html");
				     FileReader fr = new FileReader("C:\\Users\\RS3\\Desktop\\test.html");
				     FileOutputStream web2 = new FileOutputStream("C:\\Users\\omarm\\OneDrive\\Desktop\\http\\test2.txt");
				     FileReader fr2 = new FileReader("C:\\Users\\RS3\\Desktop\\test2.txt");
				     FileReader fr3 = new FileReader("C:\\Users\\RS3\\Desktop\\mm.txt");
				     DateFormat dateformat= new SimpleDateFormat("E,dd MMM yyyy HH:mm:ss");
				     Date date=new Date();

					 Scanner scanner = new Scanner (System.in);
					 Scanner usernam = new Scanner (System.in);
					 Scanner pas = new Scanner (System.in);
					 Scanner UR = new Scanner (System.in);
					 Scanner choic = new Scanner (System.in);
					 String connectionconfirm = input.readUTF();
					 System.out.println("server:" + connectionconfirm);
					 while (true)
					 {
						 String serverAsk = input.readUTF();
						 System.out.println("server:" + serverAsk);
						 String request = scanner.nextLine();
						 output.writeUTF(request);
						 String serverAsk2 = input.readUTF();
						 System.out.println("server:" + serverAsk2);
						 String username = usernam.nextLine();
						 output.writeUTF(username);
						 String serverAsk3 = input.readUTF();
						 System.out.println("server:" + serverAsk3);
						 String pass = pas.nextLine();
						 output.writeUTF(pass);
						 String serverAsk4 = input.readUTF();
						 System.out.println("server:" + serverAsk4);
						 String serverAsk5 = input.readUTF();
						 System.out.println("server:" + serverAsk5);
						 String URL = UR.nextLine();
						 output.writeUTF(URL);
						 String serverAsk6 = input.readUTF();
						 System.out.println("server:" + serverAsk6);
						 String choice = choic.nextLine();
						// output.writeUTF(choice);
					//	 char length[]=new char[100];
						 if(choice.equals("G")) 
						   {
							  System.out.println(("Username: "+username+","+"Password: "+pass));
							  System.out.println("Date :"+dateformat.format(date));
							  int k;
							  int i=0;
							   while((k=fr3.read())!=-1)
							   {
								   System.out.print((char)k);
								   i++;
							   }
							   System.out.println();
							   System.out.println("Length= "+i);
							   /*for(int j=0;j<100;j++)
							   {
								   int str+=lenght[i].length;
							   }*/
							   
						   }
						 else if(choice.equals("P")) {
						   int k;
						   web.write(("Username: "+username+","+"Password: "+pass+"    ").getBytes());
						   web.write(("Date :").getBytes());
						   web.write((dateformat.format(date)).getBytes());
						   web.write("Your Data: ".getBytes());
						   int j=0;
						   while((k=fr3.read())!=-1)
						   {
							   web.write((char)k);
							   j++;
						   }
						   web.write("Length= ".getBytes());
						   String n=Integer.toString(j);
						   web.write(n.getBytes());
						   System.out.println("Ur data is Posted on HTML");
						   }
						   
						 if(request.equals("close"))
						 {
							 System.out.println("closing the connection with the server");
							 clientSocket.close();
							 System.out.println("the connection with the server is closed");
							 break;
						 }
						 String reply = input.readUTF();
						 System.out.println("server: "+ reply);
					 }
					 scanner.close();
					 usernam.close();
					 pas.close();
					 UR.close();
					 input.close();
					 output.close();
					 
		}			
		catch(IOException e)
		{
			System.out.println("connection with the server is terminated");
		}
	  }
	}

