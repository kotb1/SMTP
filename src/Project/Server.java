package Project;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

	public class Server {
		static ServerSocket serverSocket ;
		public static void main(String arg[])throws IOException
		{
			try
			{
			
				serverSocket = new ServerSocket (25);
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
		   output.writeUTF("connected");
		   while(true) 
		   {
			    FileOutputStream out= new FileOutputStream("C:\\Users\\RS3\\Desktop\\mailbox.txt");
			    FileReader fr =new FileReader("C:\\Users\\RS3\\Desktop\\mailbox.txt");
		   		output.writeUTF("send your request or 'close' to terminate the connection");
				String request = input.readUTF();
				String usernames[]= {"batoot","joe","hoss"};
				String passwords[]= {"b20186052","1","h20186023"};
				output.writeUTF("Do u want to Sign up 'S' or Log in'L'?");
				String request2 = input.readUTF();
				if(request2.equals("S")) 
				{
					output.writeUTF("Please Enter ur username");
					String username2=input.readUTF(); 
					output.writeUTF("Please Enter ur Password");
					String password2=input.readUTF();
				}
				output.writeUTF("Please Enter ur username");
				String username = input.readUTF();
				String mails_id[]=new String[100];
				int x=0;
				String count="0";
				//for(int q=0;q<100;q++) {
				for(int i=0;i<3;i++) 
				   {
					   if(username.equals(usernames[i])) 
					   {
						   output.writeUTF("Please enter ur password");			   
						   String password = input.readUTF();
						   if(password.equals(passwords[i])) 
						   
						   {   for(int p=0;p<100;p++) {
							   output.writeUTF("Press N for Send a New mail OR Press S to show mail box OR Press I change ur Username OR Q to quit ");
							   String choice = input.readUTF();
							   String rcp[]=new String[100];
							   String data[]= new String[100];
							   if(choice.equals("N")) 
							   {
								    String wk = "250";
								    output.writeUTF(wk);
								    output.writeUTF("Please enter the Recepient Email");
								    rcp[p] = input.readUTF();
								    /*for(int k=0;k<3;k++) {
								    	if(rcp[p].equals(usernames[k]))
								    		continue;
								    	else{break;}
								    	}
								    System.out.println("Username is Wrong):");*/
								    out.write("Mail ".getBytes());
								    int n = Integer.parseInt(count);
								    n++;
								    count=Integer.toString(n);
								    out.write(count.getBytes());
								    out.write("\n".getBytes());
								    out.write("Mail From: ".getBytes());
								    out.write(username.getBytes());
								    out.write("\t".getBytes());
								    out.write("Mail To: ".getBytes());
								    out.write(rcp[p].getBytes());
								    out.write("\n".getBytes());
							   		System.out.println(" Client:["+ clientSocket+"]"+choice);
							   		output.writeUTF(wk);
							   		output.writeUTF("Please Enter The Message");
							   		int u=1;
								    for(int k=0;k<1000;k++){
								    String input1=input.readUTF();
								    if(input1.equalsIgnoreCase(".")) {
								    	output.writeUTF(wk);
								    	break;
								      }							 
								      data[k] = input1;
								      out.write(data[k].getBytes());
								      out.write("\n".getBytes());
								      u++;
								  
								  if (data[k].length() >0)
									  data[k] = data[k].substring(0, data[k].length());
								  }
								    output.writeUTF("Do u Want to forward this mail to other rcp?");
								    String rcp2=input.readUTF();
								    if(rcp2.equals("yes")) 
								    {
								    	output.writeUTF("Please enter the Recepient Email");
									    rcp[p+1] = input.readUTF();
									    out.write("Mail ".getBytes());
									    int n2 = Integer.parseInt(count);
									    n++;
									    count=Integer.toString(n);
									    out.write(count.getBytes());
									    out.write("\n".getBytes());
									    out.write("Mail From: ".getBytes());
									    out.write(username.getBytes());
									    out.write("\t".getBytes());
									    out.write("Mail To: ".getBytes());
									    out.write(rcp[p+1].getBytes());
									    out.write("\n".getBytes());
									    for(int q=0;q<u-1;q++) 
									    {
									    	out.write(data[q].getBytes());
									    	out.write("\n".getBytes());
									    	//if(q==(u-1)) {break;}
									    	//break;
									    	
									    	
									    }
								    }								    								    
							   }
							   else if(choice.equals("Q")) 
							   {
								   request =("close");
								   break;
							   }
							   else if(choice.equals("S")) 
							   {
								   int k;
								   while((k=fr.read()) != -1) {}
							   }
							   else if(choice.equals("I")) 
							   {
								  output.writeUTF("Enter ur new Username: ");
								  String newusername = input.readUTF();
								  username=newusername;						  
							   }
							   
						   }
						   }
						   else
						   {
							   x++;
						   }
					      
					   }
					   if(x>2)
					   {
						   output.writeUTF("Your password is Wrong ):");
						   break;
					   }
		               }
		   			//}
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
