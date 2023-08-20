package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPanel extends JPanel implements sendable{
//    private JLabel label;
    private String readMsg;
    private JTextArea textArea;
    public ReadPanel() {

        setPreferredSize(new Dimension(200, 150));
        setBackground(Color.RED);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel label = new JLabel("read Panel");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        add(label, constraints);
        // Create labels and text fields
//        JLabel wordLabel = new JLabel("search");

        JTextField searchField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
//        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(searchField, constraints);


        JButton readBtn = new JButton("Look Up");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        add(readBtn, constraints);

        readBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = searchField.getText();
                // Pass the userInput to your client class for processing
                String response = Client.sendRequest("read#"+userInput);
                textArea.setVisible(true);
                textArea.setBackground(Color.red);
                textArea.append(response);
            }
        });


        this.textArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 6; // Row 0
//        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(textArea, constraints);
        textArea.setVisible(false);

    }

    public void setReadMsg(String readMsg) {
        this.readMsg = readMsg;
    }

    public String getReadMsg() {
        return this.readMsg;
    }

    @Override
    public String sendMsg() {
        return this.readMsg;
    }
}
