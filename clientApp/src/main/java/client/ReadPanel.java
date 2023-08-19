package client;

import javax.swing.*;

public class ReadPanel extends JPanel{
    private JLabel label;
    public ReadPanel() {
        JLabel label = new JLabel("read Panel");
        this.label = label;
        add(label);
    }
}
