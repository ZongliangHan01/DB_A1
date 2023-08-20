package client;

// ThreeButtonPanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private JButton readBtn;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;

    public ButtonPanel() {
        JButton readBtn = new JButton("Look Up");
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        this.readBtn = readBtn;
        this.addBtn = addBtn;
        this.updateBtn = updateBtn;
        this.deleteBtn = deleteBtn;

        add(readBtn);
        add(addBtn);
        add(updateBtn);
        add(deleteBtn);

        readBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "readPanel");
                clearText(cardPanel.getCardPanel());
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "updatePanel");
                clearText(cardPanel.getCardPanel());
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "addPanel");
                clearText(cardPanel.getCardPanel());
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "deletePanel");
                clearText(cardPanel.getCardPanel());
            }
        });
    }

    private void clearText(JPanel cardPanel) {
        Component[] panels = cardPanel.getComponents();
        for (Component panel : panels) {
            // Check if the component is a panel
            if (panel instanceof JPanel) {
//                JPanel panel = (JPanel) panel;
                Component[] comps = ((JPanel) panel).getComponents();
                for (Component comp: comps ) {
                    if (comp instanceof JTextArea) {
                        ((JTextArea) comp).setText("");
                    }
                    if (comp instanceof JTextField) {
                        ((JTextField) comp).setText("");
                    }
                }
            }
        }
    }


}

