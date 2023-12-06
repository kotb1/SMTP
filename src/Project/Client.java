package Project;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {
		public static void main(String args[]) 
		{
			try
			{
				        InetAddress ip = InetAddress.getByName("localhost");
						Socket clientSocket = new Socket (ip,25);
						System.out.println("connecting to the server....");
						DataInputStream input = new DataInputStream(clientSocket.getInputStream());
						DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
						Scanner reques = new Scanner (System.in);
						Scanner reques2 = new Scanner (System.in);
						Scanner usernam = new Scanner (System.in);
						Scanner passwor = new Scanner (System.in);
						Scanner usernam2 = new Scanner (System.in);
						Scanner usernam3 = new Scanner (System.in);
						Scanner passwor2 = new Scanner (System.in);
						Scanner choic = new Scanner (System.in);
						Scanner recp = new Scanner (System.in);
						Scanner msg = new Scanner (System.in);
						Scanner recp2 = new Scanner (System.in);
						String connectionconfirm = input.readUTF();
						System.out.println("server:" + connectionconfirm);
						while (true)
						 {
							FileReader fr =new FileReader("C:\\Users\\RS3\\Desktop\\mailbox.txt"); 
							 String serverAsk1= input.readUTF();
							 System.out.println("server:" + serverAsk1);
							 String request = reques.nextLine();
							 output.writeUTF(request);
							 String serverAsk11= input.readUTF();
							 System.out.println("server:" + serverAsk11);
							 String request2 = reques2.nextLine();
							 output.writeUTF(request2);
							 if(request2.equals("S")) 
							 {
								 String serverAsk12= input.readUTF();
								 System.out.println("server:" + serverAsk12);
								 String username2 = usernam2.nextLine();
								 output.writeUTF(username2);
								 String serverAsk13= input.readUTF();
								 System.out.println("server:" + serverAsk13);
								 String password2 = passwor2.nextLine();
								 output.writeUTF(password2);
							 }
							 //for(int q=0;q<100;q++) {
							 String serverAsk2 = input.readUTF();
							 System.out.println("server:" + serverAsk2);
							 String username = usernam.nextLine();
							 output.writeUTF(username);
							 String serverAsk3 = input.readUTF();
							 System.out.println("server:" + serverAsk3);
							 String password = passwor.nextLine();
							 output.writeUTF(password);
							 for(int p=0;p<100;p++) {
							 String serverAsk4 = input.readUTF();
							 System.out.println("server:" + serverAsk4);
							 String choice = choic.nextLine();
		  					 output.writeUTF(choice);
		  					if(choice.equals("N")) {
		  					 String serverAsk5 = input.readUTF();
							 System.out.println("server:" + serverAsk5);
							 //for(int y=0;y<50;y++) {
							 String serverAsk6 = input.readUTF();
							 String rcp[]=new String[100];
							 System.out.println("server:" + serverAsk6);
							 rcp[p] = recp.nextLine();
		  					 output.writeUTF(rcp[p]);
							 //}
		  					 String serverAsk7 = input.readUTF();
							 System.out.println("server:" + serverAsk7);
							 String serverAsk8 = input.readUTF();
							 System.out.println("server:" + serverAsk8);
							 for(int k=0;k<100;k++) 
							 {
								String input1=msg.nextLine();
								output.writeUTF(input1);
								System.out.println("Client: " + input1);
								if(input1.equalsIgnoreCase(".")) {
									String serverAsk9 = input.readUTF();
									System.out.println("server: " + serverAsk9);
							    	break;
							      }	
							 }
							 String serverAsk10= input.readUTF();
							 System.out.println("server:" + serverAsk10);
							 String rcp2 = recp2.nextLine();
							 output.writeUTF(rcp2);
							 //if(rcp2.equals("yes")) 
							 //{
								 //String serverAsk11= input.readUTF();
								 //System.out.println("server:" + serverAsk11); 
							 //}
							 }
		  					
							 else if(choice.equals("S")) 
							 {
								 int k;
								 while((k=fr.read()) != -1) {System.out.print((char)k);}								
							 }
							 else if(choice.equals("I")) 
							 {
								 String serverAsk22 = input.readUTF();
								 System.out.println("server:" + serverAsk22);
								 String newusername = usernam3.nextLine();
								 output.writeUTF(newusername);
							 }
							 }
							 
							 
							 
							 //}
		  	if(request.equals("close"))
			{
			  System.out.println("closing the connection with the server");
			  clientSocket.close();
			  System.out.println("the connection with the server is closed");
			  break;
			}				 
		  }
		  reques.close();
		  reques2.close();
		  usernam.close();
		  passwor.close();
		  usernam2.close();
		  usernam3.close();
		  passwor2.close();
		  choic.close();
		  recp.close();
		  msg.close();
		  recp2.close();
		  input.close();
		  output.close();					 
		}					 
		catch(IOException e)
		{
			System.out.println("connection with the server is terminated");
		}					 
	  }
	}					
