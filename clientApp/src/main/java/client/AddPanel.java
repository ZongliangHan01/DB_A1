package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel {
    private JTextArea textArea;
    private JButton addBtn;
//    private JTextField wordField;
//    private JPanel textFieldPanel;
    private int numMean = 1;

    public AddPanel() {

        setPreferredSize(new Dimension(200, 150));
        setBackground(Color.RED);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel label = new JLabel("Add Panel");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        add(label, constraints);
        // Create labels and text fields
//        JLabel wordLabel = new JLabel("search");
        JLabel wordLabel = new JLabel("New Word");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(wordLabel, constraints);

        JTextField wordField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(wordField, constraints);

        JButton clearBtn = new JButton("Clear");
        constraints.gridx = 3; // Column 0
        constraints.gridy = 1; // Row 0
        add(clearBtn, constraints);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });


//        textFieldPanel = new JPanel();
//        textFieldPanel.setLayout(new GridBagLayout());
//        JScrollPane scrollPane = new JScrollPane(textFieldPanel);
//        add(textFieldPanel);


        JLabel meanLabel = new JLabel("Meaning");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(meanLabel, constraints);

        JTextField meaningField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(meaningField, constraints);

        JButton plusBtn = new JButton("+");
        constraints.gridx = 3; // Column 0
        constraints.gridy = 2; // Row 0
        add(plusBtn, constraints);


        this.addBtn = new JButton("Add");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 3; // Row 0
        add(addBtn, constraints);


        plusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMeanField(constraints);
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEmptyField = false;
                String userInput = "add";
                Component[] components = getComponents();
                for (Component component: components) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        String text = textField.getText().trim(); // Remove leading and trailing spaces

                        // Check if the text is empty
                        if (!text.isEmpty()) {
                            userInput = userInput + "#" + text;
                        } else {
                            isEmptyField = true; // Set the flag to true if an empty field is found
                        }
                    }
                }
                String response = "";
                if (!isEmptyField) {
                    response = Client.sendRequest(userInput);
                } else {
                    response = "Error: Please fill all the text field.";
                }

                // Pass the userInput to your client class for processing
//                String response = Client.sendRequest(userInput);
                textArea.setText("");
                textArea.setVisible(true);
                textArea.setBackground(Color.red);
                textArea.append(response);
            }
        });


        this.textArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(textArea, constraints);
        textArea.setVisible(false);


    }

    private void addMeanField(GridBagConstraints constraints) {
        numMean++;

        JLabel meanLabel = new JLabel("Meaning");
        constraints.gridx = 0; // Column 0
        constraints.gridy = numMean+1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(meanLabel, constraints);

        JTextField meaning = new JTextField("");
        constraints.gridx = 1; // Column 0
        constraints.gridy = numMean+1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(meaning, constraints);

        JButton minusBtn = new JButton("-");
        constraints.gridx = 3; // Column 0
        constraints.gridy = numMean+1; // Row 0
        add(minusBtn, constraints);

        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMeanField(constraints, e);
            }
        });

        constraints.gridx = 1;
        constraints.gridy = numMean+2;
        GridBagLayout layout = (GridBagLayout) getLayout();
        layout.setConstraints(addBtn, constraints);
        System.out.println("add new meaning field");

        constraints.gridx = 1; // Column 0
        constraints.gridy = numMean+3; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(textArea, constraints);

        revalidate();
        repaint();
    }

    private void deleteMeanField(GridBagConstraints constraints, ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        Component[] components = getComponents();
        for (int i = components.length - 1; i >= 0; i--) {
            Component component = components[i];
            if (component instanceof JButton) {
                JButton btn = (JButton) component;
                if (btn == clickedButton) {
                    JLabel label = (JLabel) components[i-2];
                    JTextField textField = (JTextField) components[i-1];
                    remove(label);
                    remove(textField);
                    remove(btn);
                    break;
                }
            }
        }

        revalidate();
        repaint();
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
