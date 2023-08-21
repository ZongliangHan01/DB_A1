package server;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final int clientId;

    private final File file;

    public ClientHandler(Socket socket, int clientId, File file) {
        this.clientSocket = socket;
        this.clientId = clientId;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            Controller controller = new Controller(file);
            String clientMsg = "";
            try
            {
                while((clientMsg = in.readLine()) != null)
                {
                    String response = controller.getCommand(clientMsg);
                    System.out.println("Message from client " + clientId + ": " + clientMsg);
                    out.write(response+"\n");
                    out.flush();
                    // need to have a way to parse the data to the correct format
                    System.out.println("Response sent");
                }
            }

            catch(SocketException e)
            {
                System.out.println("closed...");
            }
            // close the client connection
            clientSocket.close();
            System.out.println("server.Server closed the client connection!!!!! - received null");
        }

        catch (IOException e)
        {
            System.out.println("here");
            e.printStackTrace();
        }
    }
}
