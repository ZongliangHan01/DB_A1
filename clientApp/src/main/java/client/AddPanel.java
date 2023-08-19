package client;

import javax.swing.*;

public class AddPanel extends JPanel {
    private JLabel label;
    public AddPanel() {
        JLabel label = new JLabel("Add Panel");
        this.label = label;
        add(label);
    }
}
