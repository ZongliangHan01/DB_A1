package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePanel extends JPanel {
    private JLabel label;
    private JTextArea textArea;
    public UpdatePanel() {

        setPreferredSize(new Dimension(200, 150));
        setBackground(Color.RED);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel label = new JLabel("Update Panel");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        add(label, constraints);
        // Create labels and text fields
//        JLabel wordLabel = new JLabel("search");

        JLabel wordLabel = new JLabel("Word to Update");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(wordLabel, constraints);

        JTextField wordField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(wordField, constraints);

        JLabel meanLabel = new JLabel("Meaning");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 4; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(meanLabel, constraints);


        JTextField meaningField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(meaningField, constraints);

        JButton addBtn = new JButton("Update");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 6; // Row 0
        add(addBtn, constraints);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordField.getText();
                String meaning = meaningField.getText();
                String userInput = "update#"+word+"#"+meaning;
                // Pass the userInput to your client class for processing
                String response = Client.sendRequest(userInput);
                textArea.setVisible(true);
                textArea.setBackground(Color.red);
                textArea.append(response);
            }
        });

        this.textArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 8; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(textArea, constraints);
        textArea.setVisible(false);
    }
}
