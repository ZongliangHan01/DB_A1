package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI {

    private JTextField portInput;
    private JTextField fileInput;
    private TextArea messageArea;
    private  String message = "hello";
    public ServerGUI() {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        // Create a JFrame
        JFrame frame = new JFrame("E-Dictionary Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        // Create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel();

        // Create a JButton for each button
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        // Add the buttons to the buttonPanel
        buttonPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ;
            }
        });



        buttonPanel.add(stopButton);

        // Create a JPanel to hold the text area
        JPanel textPanel = new JPanel();

        JLabel portLabel = new JLabel("Please enter the port number: ");

        // Create a JTextArea to display messages
        portInput = new JTextField(35);
        portInput.setText("-1");

        JLabel fileLabel = new JLabel("Please enter the file address: ");

        // Create a JTextField to enter text
        fileInput = new JTextField(35);

        messageArea = new TextArea(10, 50);
        messageArea.setEditable(false);
        messageArea.setText(message);

        // Add the text area to the text panel
        textPanel.add(portLabel);
        textPanel.add(portInput);
        textPanel.add(fileLabel);
        textPanel.add(fileInput);
        textPanel.add(messageArea);

        // Add the button panel to the JFrame
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Add the text panel to the JFrame
        frame.add(textPanel, BorderLayout.CENTER);

        // Center the JFrame on the screen
        frame.setLocationRelativeTo(null);

        // Make the JFrame visible
        frame.setVisible(true);
    }

    public String getPort() {
        return portInput.getText();
    }

    public String getFile() {
        return fileInput.getText();
    }

    public void setMessage(String message) {
        this.message = message + "\n";
        messageArea.setText(message);
        messageArea.repaint();
    }

}
