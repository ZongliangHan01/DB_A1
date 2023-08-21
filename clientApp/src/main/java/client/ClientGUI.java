package client;

import javax.swing.*;
import java.awt.*;

public class ClientGUI {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private static String host;
    private static int port;

//    private MainPanel mainPanel;
//
    public ClientGUI(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public  ClientGUI() {

    }

    public static void main(String[] args) {
//        ClientGUI clientGUI = new ClientGUI();
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        ClientGUI clientGUI = new ClientGUI(host, port);
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI(host, port);
        });
    }

    private static void createAndShowGUI(String host, int port) {

        Client client = new Client(host, port);
        // Create a JFrame
        JFrame frame = new JFrame("Three Button GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

//        JPanel buttonPanel = new ButtonPanel();
        // Create a JPanel to hold the buttons
//        JPanel buttonPanel = new JPanel();
//        JPanel buttonPanel = new ButtonPanel();


        MainPanel mainPanel = new MainPanel();
        // Add the main panel to the JFrame
        frame.add(mainPanel);

        // Center the JFrame on the screen
        frame.setLocationRelativeTo(null);

        // Make the JFrame visible
        frame.setVisible(true);
    }

    public static void refresh() {
        Client client = new Client(host, port);
    }

    //    public void getClientMsg {
//
//    }
}
