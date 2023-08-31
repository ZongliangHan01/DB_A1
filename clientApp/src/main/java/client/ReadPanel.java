package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPanel extends JPanel {
//    private JLabel label;
    private String readMsg;
    private JTextArea textArea;
    JTextField searchField;
    public ReadPanel() {

        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.decode("#C09F80"));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 5, 10, 5);

        JLabel label = new JLabel("Search");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        label.setPreferredSize(new Dimension(200, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 28); // Font name, style, size
        label.setFont(customFont);
        add(label, constraints);

        // Create labels and text fields
        this.searchField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
//        constraints.fill = GridBagConstraints.HORIZONTAL;
        searchField.setPreferredSize(new Dimension(100, 50));
        add(this.searchField, constraints);


        JButton readBtn = new JButton("Look Up");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        readBtn.setPreferredSize(new Dimension(90, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        readBtn.setFont(customFont);
        add(readBtn, constraints);

        readBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String userInput = searchField.getText();
//                // Pass the userInput to your client class for processing
//                String response = format(Client.sendRequest("read#"+userInput));
//                textArea.setText("");
//                textArea.setVisible(true);
//                textArea.setBackground(Color.red);
//                textArea.append(response);


                String response = "";
                String userInput = "read#";
                String text = searchField.getText().trim();
                if (!text.isEmpty()) {
                    userInput = userInput + text;
                    response = format(Client.sendRequest(userInput));
                } else {
                    response = "Error: Please enter the word to search.";
                }
                // Pass the userInput to your client class for processing
                textArea.setText("");
                textArea.setVisible(true);
                textArea.setEditable(false);
                textArea.setBackground(Color.decode("#C09F80"));
                Font customFont = new Font("Comic Sans MS", Font.BOLD, 28); // Font name, style, size
                textArea.setFont(customFont);
                textArea.append(response);
            }
        });


        this.textArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 6; // Row 0

        constraints.fill = GridBagConstraints.HORIZONTAL;
        textArea.setPreferredSize(new Dimension( 500, 200));
        add(textArea, constraints);
        textArea.setVisible(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

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

    private String format(String response) {
        String format = "";
        String[] split = response.split("#");
        for (String string: split) {
            switch (string) {
                case "Word does not find":
                    format = "Error: Word does not find.";
                    break;
                case "no encode":
                    format = "Error: Cannot decode the content. Please enter another word.";
                    break;
                case "no connection":
                    format = "Error: Bad Connection. Please refresh.";
                    break;
                default:
                    format = format + "• " + string + "\n";
            }


//            if (string.equals("Word does not find")) {
//                format = "Error: Word does not find.";
//                break;
//            }
//
//            format = format + "• " + string + "\n";
        }
        return format;
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

    public void setReadMsg(String readMsg) {
        this.readMsg = readMsg;
    }

    public String getReadMsg() {
        return this.readMsg;
    }

}
