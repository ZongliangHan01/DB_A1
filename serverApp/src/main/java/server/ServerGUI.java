/*
Zongliang Han
1166050
 */

package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ServerGUI {

    private JTextField portInput;
    private JTextField fileInput;
//    private TextArea messageArea;
    private  String message = "hello";

    private Server server;
    private int port;
    private File file;

    private boolean running = false;

    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI();
//        Server server = new Server();
//        server.startServer(4444, new File("/Users/zonglianghan/Desktop/DS/DS_A1/serverApp/src/main/java/server/dictionary.json"));

    }


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

        JPanel serverPanel = new JPanel();

        serverPanel.setPreferredSize(new Dimension(700, 700));
        serverPanel.setBackground(Color.decode("#C09F80"));
        serverPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 1, 10, 1);

        JLabel label = new JLabel("E-Dictionary Server");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        label.setPreferredSize(new Dimension(600, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 28); // Font name, style, size
        label.setFont(customFont);
        serverPanel.add(label, constraints);


        JLabel portLabel = new JLabel("Port: ");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        portLabel.setPreferredSize(new Dimension(80, 50));
        portLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        portLabel.setFont(customFont);
        serverPanel.add(portLabel, constraints);

        portInput = new JTextField(30);
        portInput.setText("4444");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        portInput.setPreferredSize(new Dimension(80, 50));
        serverPanel.add(portInput, constraints);


        JLabel fileLabel = new JLabel("File: ");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        fileLabel.setPreferredSize(new Dimension(80, 50));
        fileLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        fileLabel.setFont(customFont);
        serverPanel.add(fileLabel, constraints);

        fileInput = new JTextField(30);
        fileInput.setText("/Users/zonglianghan/Desktop/DS/DS_A1/serverApp/src/main/java/server/dictionary.json");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        fileInput.setPreferredSize(new Dimension(80, 50));
        serverPanel.add(fileInput, constraints);

        JTextArea messageArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        messageArea.setPreferredSize(new Dimension(100, 150));
        messageArea.setVisible(false);
        messageArea.setEditable(false);
        messageArea.setBackground(Color.decode("#C09F80"));
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        messageArea.setFont(customFont);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        serverPanel.add(messageArea, constraints);



        JButton startButton = new JButton("Start");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 3; // Row 0
        startButton.setPreferredSize(new Dimension(90, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        startButton.setFont(customFont);
        startButton.setBackground((Color.decode("#AB9353")));
        serverPanel.add(startButton, constraints);

        JButton stopButton = new JButton("Stop");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 3; // Row 0
        stopButton.setPreferredSize(new Dimension(90, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        stopButton.setFont(customFont);
        stopButton.setBackground((Color.decode("#AB9353")));
        stopButton.setVisible(false);
        serverPanel.add(stopButton, constraints);

        server = new Server();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                startButton.setVisible(false);
                stopButton.setVisible(true);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        port = Integer.parseInt(portInput.getText());
                        file = new File(fileInput.getText());
//                        server = new Server(port, file);
                        server.setPort(port);
                        server.setFile(file);
                        server.setRunning(true);
                        System.out.println(server.getRunning());
                        messageArea.setVisible(true);
                        portLabel.setVisible(false);
                        portInput.setVisible(false);
                        fileLabel.setVisible(false);
                        fileInput.setVisible(false);
                        String message = "Server is running on " + port + "\n\n" + file;
                        messageArea.setText(message);



                        server.startServer();
                        System.out.println("server.Server started");

                    }

                });
                thread.start();
            }
        });



        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stopServer();
                startButton.setEnabled(true);
                startButton.setVisible(true);
                stopButton.setVisible(false);

                messageArea.setVisible(false);
                portLabel.setVisible(true);
                portInput.setVisible(true);
                fileLabel.setVisible(true);
                fileInput.setVisible(true);
                System.out.println("server.Server stopped by button");
            }
        });

        frame.add(serverPanel, BorderLayout.CENTER);
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


}
