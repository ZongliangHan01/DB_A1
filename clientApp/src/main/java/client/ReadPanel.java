package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPanel extends JPanel{
    private JLabel label;

    public ReadPanel() {

        setPreferredSize(new Dimension(200, 150));
        setBackground(Color.RED);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel label = new JLabel("read Panel");
        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        add(label, constraints);
        // Create labels and text fields
//        JLabel wordLabel = new JLabel("search");

        JTextField searchField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
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
                Client.processInput(userInput);
            }
        });
    }
}
