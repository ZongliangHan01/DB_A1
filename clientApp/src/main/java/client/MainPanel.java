package client;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements sendable {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private  String clientMsg;

    private JPanel updatePanel;
    private ReadPanel readPanel;
    private JPanel addPanel;
    private JPanel deletePanel;
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

        this.updatePanel = new UpdatePanel();
        this.readPanel = new ReadPanel();
        this.addPanel = new AddPanel();
        this.deletePanel = new DeletePanel();

        // Add the panels to the cardPanel with unique names
        cardPanel.add(readPanel, "readPanel");
        cardPanel.add(updatePanel, "updatePanel");
        cardPanel.add(addPanel, "addPanel");
        cardPanel.add(deletePanel, "deletePanel");
    }

    public void setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
    }

    @Override
    public String sendMsg() {
        return readPanel.sendMsg();
    }

//    public static void set(String userInput) {
//        // Process the user input here (e.g., send it to a server)
//        System.out.println("Received input: " + userInput);
//    }
}
