package client;

import java.io.IOException;
import java.net.Socket;

class ConnectionMonitor extends Thread {
    private Socket socket;

    public ConnectionMonitor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
//            System.out.println("connected");
            try {
                // Check the connection status periodically
                if (!socket.isConnected() || socket.isClosed()) {
                    System.out.println("Connection disrupted.");
                    // Handle the disruption here, e.g., reconnect or show an error message.
                    break;
                }
                Thread.sleep(200); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                // Handle interruption (e.g., thread is interrupted during shutdown)
                System.out.println("Connection disrupted.");
                break;
            }

        }
    }
}

