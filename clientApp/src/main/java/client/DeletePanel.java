package client;

import javax.swing.*;

public class DeletePanel extends JPanel {
    private JLabel label;
    public DeletePanel() {
        JLabel label = new JLabel("Delete Panel");
        this.label = label;
        add(label);
    }
}
