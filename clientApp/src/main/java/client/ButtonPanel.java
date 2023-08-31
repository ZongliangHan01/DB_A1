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

    private JButton refreshBtn;

    public ButtonPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(20, 10, 20, 10);
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        setBackground(Color.decode("#E9C893"));

        readBtn = new JButton("Look Up");
        addBtn = new JButton("Add");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        refreshBtn = new JButton("Refresh");

//        this.readBtn = readBtn;
//        this.addBtn = addBtn;
//        this.updateBtn = updateBtn;
//        this.deleteBtn = deleteBtn;
//        this.refreshBtn = refreshBtn;

        this.readBtn.setPreferredSize(new Dimension(80, 50));
        this.addBtn.setPreferredSize(new Dimension(80, 50));
        this.updateBtn.setPreferredSize(new Dimension(80, 50));
        this.deleteBtn.setPreferredSize(new Dimension(80, 50));
        this.refreshBtn.setPreferredSize(new Dimension(80, 50));

        System.out.println(this.addBtn.getBackground());

        add(this.readBtn, constraints);
        add(this.addBtn, constraints);
        add(this.updateBtn, constraints);
        add(this.deleteBtn, constraints);
        add(this.refreshBtn, constraints);

        readBtn.setBackground(Color.decode("#AB9353"));
        addBtn.setBackground(Color.decode("#AB9353"));
        updateBtn.setBackground(Color.decode("#AB9353"));
        deleteBtn.setBackground(Color.decode("#AB9353"));
        refreshBtn.setBackground(Color.decode("#FF3B3F"));

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

        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ClientGUI clientGUI = new ClientGUI();
                ClientGUI.refresh();
                MainPanel cardPanel = (MainPanel) getParent();
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
                        ((JTextArea) comp).setVisible(false);
                    }
                    if (comp instanceof JTextField) {
                        ((JTextField) comp).setText("");
                    }
                }
            }
        }
    }


}

