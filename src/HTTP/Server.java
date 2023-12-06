package HTTP;
import java.net.ServerSocket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Server {
		static ServerSocket serverSocket ;
		public static void main(String arg[])
		{
			try
			{
			
				serverSocket = new ServerSocket (6005);
				System.out.println("the server is booted up");
		
	   
	   while (true)
	   {
		   Socket clientSocket = serverSocket.accept();
		   System.out.println("A new client [" + clientSocket + "]is connected to the server");
		   Thread client = new ClientConnection (clientSocket);
		   client.start();
	   }
			}
			catch(Exception e)
			{ System.out.println("problem with socket server");
			}
			}
		static class ClientConnection extends Thread
		{
			final private Socket clientSocket;
			public ClientConnection ( Socket clientSocket) 
			{ this.clientSocket = clientSocket;
			}
			public void run() 
			{
				try {
		   DataInputStream input = new DataInputStream(clientSocket.getInputStream());
		   DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
		   FileOutputStream web = new FileOutputStream("C:\\Users\\RS3\\Desktop\\test.html");
		   FileReader fr = new FileReader("C:\\Users\\RS3\\Desktop\\test.html");
		   FileOutputStream web2 = new FileOutputStream("C:\\Users\\omarm\\OneDrive\\Desktop\\http\\test2.txt");
		   FileReader fr2 = new FileReader("C:\\Users\\RS3\\Desktop\\test2.txt");
		   FileReader fr3 = new FileReader("C:\\Users\\RS3\\Desktop\\mm.txt");
		   output.writeUTF("connected");
		   
		   while(true)
		   {
			   
			   output.writeUTF("send your request or 'close' to terminate the connection");
			   String request = input.readUTF();
			   //System.out.println(" Client:["+ clientSocket+"]"+request);
			   String usernames[]={"omar","dokhana","hania","farah","lara"};
			   String passwords[]= {"1","20186025","333","123","222"};
			   output.writeUTF("Please Enter Ur Username:");
			   String username= input.readUTF();
			   int x=0;
			   for(int i=0;i<5;i++) 
			   {
				   if(username.equals(usernames[i])) 
				   {
					   output.writeUTF("Please Enter Ur password");
					   String pass=input.readUTF();
					   if(pass.equals(passwords[i]))
					   {
						   output.writeUTF("login successfully");
						   output.writeUTF("Please Enter the URL ends with '/'");
						   String URL=input.readUTF();
						   output.writeUTF("Please Enter 'G' to GET 'P' to POST");
						   String choice =input.readUTF();
						  // web.write(("Username: "+username+","+"Password: "+pass).getBytes());
						   //web.write("\n".getBytes());
						   /*if(choice.equals("G")) 
						   {
							   web.write(("Username: "+username+","+"Password: "+pass).getBytes());
							   web.write("\n".getBytes());
						   }
						   int k;
						   
						   while((k=fr3.read())!=-1)
						   {
							   web.write((char)k);
						   }*/
						   
					   }
					   else {x++;}
				   }
			   }
			   if(x>4) {output.writeUTF("wrong");}
			   if(request.equals("close"))
			   {
				   System.out.println("closing the connection with this client["+ clientSocket+"]");
				   System.out.println("the connection with this client["+ clientSocket+ "] is closed");
				   clientSocket.close();
				   break;
			   }
			   
		   }
			 input.close();
			 output.close();
				} catch (IOException e)
				{ System.out.println("connection wuth this client ["+ clientSocket+"]is closed");
				}
				}
			}
	 	}

