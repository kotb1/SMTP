package server;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ClientConnectionThread extends Thread {
    protected Socket socket;
    private String path = "C:\\Users\\RS3\\Desktop\\3amooor.txt";


    public ClientConnectionThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    System.out.println("closing");
                    socket.close();
                    return;
                } else {
                    String response = response(line);
                    out.writeBytes(response);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
    private String response (String message) {
        String response = "";
        String fileName = "";
        String httpVersion = "";
        String [] messageContent = message.split("\\s+");
        if (messageContent.length <3){
            response = httpVersion + " 400 (wrong URL) " + " "+ new Date();
            return response;
        }
        for (int i =0; i <messageContent.length; i++){
            try {
                fileName = messageContent[1];
                httpVersion = messageContent[2];
                System.out.println(messageContent[i]);
            }catch (Exception ex){

            }
        }
        FileReader fr = null;
        try {
            fr = new FileReader(path+fileName);
            int i;
            while ((i=fr.read()) != -1) {

                response += (char)i;
            }
            System.out.println("File content ");
            System.out.println(response);
            response = httpVersion + " 200 OK " + response + " " + new Date();
        } catch (FileNotFoundException e) {
            response = httpVersion + "400 (wrong URL)" + " "+ new Date();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}