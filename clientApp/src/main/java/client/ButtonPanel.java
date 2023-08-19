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
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "updatePanel");
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "addPanel");
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel cardPanel = (MainPanel) getParent();
                cardPanel.getCardLayout().show(cardPanel.getCardPanel(), "deletePanel");
            }
        });
    }

    public void addListener(JPanel panel) {
        readBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, panel.getName());
            }
        });
    }
}

