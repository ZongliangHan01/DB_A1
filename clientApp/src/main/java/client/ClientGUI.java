package client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

public class ClientGUI {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    private static ConnectPanel connectPanel;

    private static String host;
    private static int port;

//    private MainPanel mainPanel;
//
//    public ClientGUI(String host, int port) {
//        this.host = host;
//        this.port = port;
//    }
    public  ClientGUI() {

    }

    public static void main(String[] args) {
//        ClientGUI clientGUI = new ClientGUI();
//        String host = args[0];
//        int port = Integer.parseInt(args[1]);
        ClientGUI clientGUI = new ClientGUI();
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {


        // Create a JFrame
        JFrame frame = new JFrame("E-Dictionary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        frame.getContentPane().add(cardPanel);

        MainPanel mainPanel = new MainPanel();
        connectPanel = new ConnectPanel();
        // Add the main panel to the JFrame
//        frame.add(mainPanel);

        cardPanel.add(mainPanel, "mainPanel");
        cardPanel.add(connectPanel, "connectPanel");

        host = connectPanel.getIP();
        port = 0;

//        Client client = new Client(host, port);

//        if (client.getSocket() != null) {
//            cardLayout.show(cardPanel, "mainPanel");
//        } else {
            cardLayout.show(cardPanel, "connectPanel");
//        }


        // Center the JFrame on the screen
        frame.setLocationRelativeTo(null);

        // Make the JFrame visible
        frame.setVisible(true);
    }

    public static String refresh() {
        host = connectPanel.getIP();
        port = Integer.parseInt(connectPanel.getPort());

        Client client = new Client(host, port);
        if (client.getSocket() != null) {
            cardLayout.show(cardPanel, "mainPanel");
            return "success";
        } else {
            cardLayout.show(cardPanel, "connectPanel");
            return "Incorrect IP address or port number.";
        }


    }

    //    public void getClientMsg {
//
//    }
}
