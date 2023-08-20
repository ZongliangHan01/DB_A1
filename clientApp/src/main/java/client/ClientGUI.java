package client;

import javax.swing.*;
import java.awt.*;

public class ClientGUI {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

//    private MainPanel mainPanel;
//
//    public ClientGUI() {
//        this.mainPanel = new MainPanel();
//    }

    public static void main(String[] args) {
//        ClientGUI clientGUI = new ClientGUI();
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {

        Client client = new Client();
        // Create a JFrame
        JFrame frame = new JFrame("Three Button GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

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



    //    public void getClientMsg {
//
//    }
}
