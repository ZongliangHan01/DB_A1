package client;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public MainPanel() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new ButtonPanel();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        add(buttonPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        initCardLayout();
    }

    private void initCardLayout() {

        JPanel updatePanel = new UpdatePanel();
        JPanel readPanel = new ReadPanel();
        JPanel addPanel = new AddPanel();
        JPanel deletePanel = new DeletePanel();

        // Add the panels to the cardPanel with unique names
        cardPanel.add(readPanel, "readPanel");
        cardPanel.add(updatePanel, "updatePanel");
        cardPanel.add(addPanel, "addPanel");
        cardPanel.add(deletePanel, "deletePanel");
    }
}
