/*
Zongliang Han
1166050
 */


package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    private String host;
    private int port;
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
//        Socket socket = null;
        try {
            // Create a stream socket bounded to any port and connect it to the
            // socket bound to localhost on port 4444
            Socket socket = new Socket(host, port);
            System.out.println("Connection established");
            this.socket = socket;
//            ConnectionMonitor monitor = new ConnectionMonitor(socket);
//            monitor.start();
//            System.out.println("Connection established");

        } catch (UnknownHostException ex) {
//            throw new RuntimeException(ex);
            System.out.println("Error: Unknown Host");
        } catch (IOException ex) {
//            throw new RuntimeException(ex);
            System.out.println("Error: Cannot connect to the server");
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public static String sendRequest(String clientMsg) {
        // Get the input/output streams for reading/writing data from/to the socket

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

//            Scanner scanner = new Scanner(System.in);
//            String inputStr = null;

            //While the user input differs from "exit"

            // Send the input string to the server by writing to the socket output stream
            out.write(clientMsg + "\n");
            out.flush();
            System.out.println("Message sent");

            // Receive the reply from the server by reading from the socket input stream
            String received = in.readLine(); // This method blocks until there  is something to read from the
            // input stream
            System.out.println("Message received: " + received);
            return received;
        }
        catch (UnsupportedEncodingException ex)
        {
            System.out.println("Error");
            return "Error: Cannot decode the content. Please enter another word.";
        }
        catch (IOException ex)
        {
            System.out.println("Error");
            return "Error: Bad Connection. Please refresh.";
//            throw new RuntimeException(ex);

        }
    }

}
