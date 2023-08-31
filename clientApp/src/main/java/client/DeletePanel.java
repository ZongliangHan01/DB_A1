/*
Zongliang Han
1166050
 */

package client;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel extends JPanel {
    private String readMsg;
    private JTextArea textArea;
    public DeletePanel() {

        setPreferredSize(new Dimension(200, 150));
        setBackground(Color.decode("#C09F80"));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 5, 10, 5);

        JLabel label = new JLabel("Delete");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        label.setPreferredSize(new Dimension(200, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 28); // Font name, style, size
        label.setFont(customFont);
        add(label, constraints);
        // Create labels and text fields
//        JLabel wordLabel = new JLabel("search");

        JTextField deleteField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
//        constraints.fill = GridBagConstraints.HORIZONTAL;
        deleteField.setPreferredSize(new Dimension(100, 50));
        add(deleteField, constraints);


        JButton deleteBtn = new JButton("Delete");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        deleteBtn.setPreferredSize(new Dimension(90, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        deleteBtn.setFont(customFont);
        add(deleteBtn, constraints);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = "";
                String userInput = "delete#";
                String text = deleteField.getText().trim();
                if (!text.isEmpty()) {
                    userInput = userInput + text;
                    response = Client.sendRequest(userInput);
                } else {
                    response = "Error: Please enter the word to delete.";
                }
                // Pass the userInput to your client class for processing
                textArea.setText("");
                Font customFont = new Font("Comic Sans MS", Font.BOLD, 28); // Font name, style, size
                textArea.setFont(customFont);
                textArea.setVisible(true);
                textArea.setEditable(false);
                textArea.setBackground(Color.decode("#C09F80"));
                textArea.append(response);
            }
        });

        this.textArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 6; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.textArea.setPreferredSize(new Dimension(500, 100));
        add(textArea, constraints);
        this.textArea.setVisible(false);
        this.textArea.setEditable(false);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);

        JButton clearBtn = new JButton("Clear");
        constraints.gridx = 3; // Column 0
        constraints.gridy = 2; // Row 0
        clearBtn.setPreferredSize(new Dimension(80, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        clearBtn.setFont(customFont);
        add(clearBtn, constraints);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

    }

    private void clear() {
        Component[] components = getComponents();
        for (Component component: components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
            if (component instanceof JTextArea) {
                ((JTextArea) component).setText("");
                ((JTextArea) component).setVisible(false);
            }
        }
    }
}
