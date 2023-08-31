package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectPanel extends JPanel {

    private JTextField portField;
    private JTextField ipField;
    private JTextArea messageArea;
    private  String message = "hello";

    public ConnectPanel() {

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.decode("#C09F80"));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 1, 10, 1);

        JLabel label = new JLabel("Connect to Server...");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        label.setPreferredSize(new Dimension(300, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 28); // Font name, style, size
        label.setFont(customFont);
        add(label, constraints);


        JLabel ipLabel = new JLabel("IP: ");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        ipLabel.setPreferredSize(new Dimension(80, 50));
        ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        ipLabel.setFont(customFont);
        add(ipLabel, constraints);

        ipField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        ipField.setPreferredSize(new Dimension(80, 50));
        ipField.setText("localhost");
        add(ipField, constraints);


        JLabel portLabel = new JLabel("Port: ");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        portLabel.setPreferredSize(new Dimension(80, 50));
        portLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        portLabel.setFont(customFont);
        add(portLabel, constraints);

        portField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        portField.setPreferredSize(new Dimension(80, 50));
        portField.setText("4444");
        add(portField, constraints);

        // Create a JButton for each button
        JButton connectButton = new JButton("Connect");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 3; // Row 0
        connectButton.setPreferredSize(new Dimension(90, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        connectButton.setFont(customFont);
        connectButton.setBackground((Color.decode("#AB9353")));
        add(connectButton, constraints);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = ClientGUI.refresh();
                setMessage(message);
                System.out.println("Connect button clicked");
            }
        });


        messageArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.messageArea.setVisible(false);
        this.messageArea.setEditable(false);
        this.messageArea.setPreferredSize(new Dimension( 500, 100));
        this.messageArea.setLineWrap(true);
        this.messageArea.setWrapStyleWord(true);
        add(messageArea, constraints);
    }

    public String getPort() {
        return portField.getText();
    }

    public String getIP() {
        return ipField.getText();
    }

    public void setMessage(String message) {
        messageArea.setText("");
        messageArea.setVisible(true);
        messageArea.setEditable(false);
        messageArea.setBackground(Color.decode("#C09F80"));
        Font customFont = new Font("Comic Sans MS", Font.BOLD, 28); // Font name, style, size
        messageArea.setFont(customFont);
        messageArea.append(message);
        revalidate();
        repaint();
    }

}
