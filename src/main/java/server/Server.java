package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
public class Server {
    public static void main(String[] args) {

        ServerSocket listeningSocket = null;

        try {
            //Create a server socket listening on port 4444
            listeningSocket = new ServerSocket(4444);
            int i = 0; //counter to keep track of the number of clients


            //Listen for incoming connections forever
            while (true)
            {
                System.out.println("server.Server listening on port 4444 for a connection");
                //Accept an incoming client connection request
                Socket clientSocket = listeningSocket.accept(); //This method will block until a connection request is received
                i++;
                System.out.println("com.myapp.client.Client conection number " + i + " accepted:");
                //System.out.println("Remote Port: " + clientSocket.getPort());
                System.out.println("Remote Hostname: " + clientSocket.getInetAddress().getHostName());
                System.out.println("Local Port: " + clientSocket.getLocalPort());
                ClientHandler clientHandler = new ClientHandler(clientSocket, i);
                new Thread(clientHandler).start();

            }
        }
        catch (SocketException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("here");
            e.printStackTrace();
        }
        finally
        {
            if(listeningSocket != null)
            {
                try
                {
                    // close the server socket
                    listeningSocket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
