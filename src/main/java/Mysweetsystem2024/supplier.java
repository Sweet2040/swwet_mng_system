package Mysweetsystem2024;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class supplier extends JFrame {

    private JPanel contentPanel;
    private CardLayout cardLayout;

    public supplier() {
        initializeDashboard();
    }

    private void initializeDashboard() {
        setTitle("Supplier Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout and content panel
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Create and add panels to contentPanel
        contentPanel.add(createInboxPanel(), "Inbox");
        contentPanel.add(createComposeMessagePanel(), "ComposeMessage");
        contentPanel.add(createSentMessagesPanel(), "SentMessages");
        contentPanel.add(createAccountManagementPanel(), "AccountManagement");
        contentPanel.add(createOrderManagementPanel(), "OrderManagement");

        // Main Panel with buttons
        JPanel mainPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton inboxButton = new JButton("View Inbox");
        JButton composeButton = new JButton("Compose Message");
        JButton sentMessagesButton = new JButton("Sent Messages");
        JButton accountManagementButton = new JButton("Account Management");
        JButton orderManagementButton = new JButton("Order Management");

        // Add action listeners to buttons
        inboxButton.addActionListener(e -> showPanel("Inbox"));
        composeButton.addActionListener(e -> showPanel("ComposeMessage"));
        sentMessagesButton.addActionListener(e -> showPanel("SentMessages"));
        accountManagementButton.addActionListener(e -> showPanel("AccountManagement"));
        orderManagementButton.addActionListener(e -> showPanel("OrderManagement"));

        // Add buttons to the mainPanel
        mainPanel.add(inboxButton);
        mainPanel.add(composeButton);
        mainPanel.add(sentMessagesButton);
        mainPanel.add(accountManagementButton);
        mainPanel.add(orderManagementButton);

        // Add mainPanel and contentPanel to frame
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void showPanel(String panelName) {
        cardLayout.show(contentPanel, panelName);
    }

    private JPanel createInboxPanel() {
        // Create and return the Inbox panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Inbox Panel"));
       
        // Add components and logic specific to Inbox
        return panel;
    }

    private JPanel createComposeMessagePanel() {
        // Create and return the Compose Message panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Compose Message Panel"));
        // Add components and logic specific to Compose Message
        return panel;
    }

    private JPanel createSentMessagesPanel() {
        // Create and return the Sent Messages panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Sent Messages Panel"));
        // Add components and logic specific to Sent Messages
        return panel;
    }

    private JPanel createAccountManagementPanel() {
        // Create and return the Account Management panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Account Management Panel"));
        // Add components and logic specific to Account Management
        return panel;
    }

    private JPanel createOrderManagementPanel() {
        // Create and return the Order Management panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Order Management Panel"));
        // Add components and logic specific to Order Management
        return panel;
    }
    

    
}
