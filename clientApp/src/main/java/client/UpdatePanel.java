package client;

import javax.swing.*;

public class UpdatePanel extends JPanel {
    private JLabel label;
    public UpdatePanel() {
        JLabel label = new JLabel("Update Panel");
        this.label = label;
        add(label);
    }
}
