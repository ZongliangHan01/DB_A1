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
        setBackground(Color.decode("#C09F80"));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 1, 10, 1);

        JLabel label = new JLabel("Add New Word");
//        this.label = label;
        constraints.gridx = 1; // Column 0
        constraints.gridy = 0; // Row 0
        label.setPreferredSize(new Dimension(300, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 28); // Font name, style, size
        label.setFont(customFont);
        add(label, constraints);

        // Create labels and text fields
//        JLabel wordLabel = new JLabel("search");
        JLabel wordLabel = new JLabel("New Word");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        wordLabel.setPreferredSize(new Dimension(100, 50));
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        wordLabel.setFont(customFont);
        add(wordLabel, constraints);

        JTextField wordField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        wordField.setPreferredSize(new Dimension(100, 50));
        add(wordField, constraints);

        JButton clearBtn = new JButton("Clear");
        constraints.gridx = 3; // Column 0
        constraints.gridy = 1; // Row 0
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


//        textFieldPanel = new JPanel();
//        textFieldPanel.setLayout(new GridBagLayout());
//        JScrollPane scrollPane = new JScrollPane(textFieldPanel);
//        add(textFieldPanel);


        JLabel meanLabel = new JLabel("Meaning");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        meanLabel.setPreferredSize(new Dimension(100, 50));
        meanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        meanLabel.setFont(customFont);
        add(meanLabel, constraints);

        JTextField meaningField = new JTextField(30);
        constraints.gridx = 1; // Column 0
        constraints.gridy = 2; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        meaningField.setPreferredSize(new Dimension(100, 50));
        add(meaningField, constraints);

        JButton plusBtn = new JButton("+");
        constraints.gridx = 3; // Column 0
        constraints.gridy = 2; // Row 0
        plusBtn.setPreferredSize(new Dimension(80, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        plusBtn.setFont(customFont);
        add(plusBtn, constraints);


        this.addBtn = new JButton("Add");
        constraints.gridx = 1; // Column 0
        constraints.gridy = 3; // Row 0
        addBtn.setPreferredSize(new Dimension(90, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        addBtn.setFont(customFont);
        addBtn.setBackground((Color.decode("#AB9353")));
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
                textArea.setEditable(false);
                textArea.setBackground(Color.decode("#C09F80"));
                Font customFont = new Font("Comic Sans MS", Font.BOLD, 28); // Font name, style, size
                textArea.setFont(customFont);
                textArea.append(response);
            }
        });


        this.textArea = new JTextArea();
        constraints.gridx = 1; // Column 0
        constraints.gridy = 4; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.textArea.setVisible(false);
        this.textArea.setEditable(false);
        this.textArea.setPreferredSize(new Dimension( 500, 50));
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        add(textArea, constraints);

    }

    private void addMeanField(GridBagConstraints constraints) {
        numMean++;

        JLabel meanLabel = new JLabel("Meaning");
        constraints.gridx = 0; // Column 0
        constraints.gridy = numMean+1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        meanLabel.setPreferredSize(new Dimension(100, 50));
        meanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 18); // Font name, style, size
        meanLabel.setFont(customFont);
        add(meanLabel, constraints);

        JTextField meaning = new JTextField("");
        constraints.gridx = 1; // Column 0
        constraints.gridy = numMean+1; // Row 0
        constraints.fill = GridBagConstraints.HORIZONTAL;
        meaning.setPreferredSize(new Dimension(100, 50));
        add(meaning, constraints);

        JButton minusBtn = new JButton("-");
        constraints.gridx = 3; // Column 0
        constraints.gridy = numMean+1; // Row 0
        minusBtn.setPreferredSize(new Dimension(80, 50));
        customFont = new Font("Comic Sans MS", Font.PLAIN, 18); // Font name, style, size
        minusBtn.setFont(customFont);
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
//        textArea.setPreferredSize(new Dimension( 500, 50));
//        textArea.setVisible(false);
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
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
