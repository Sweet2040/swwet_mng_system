package Mysweetsystem2024;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;
    private static final String FILE_PATH = "users.txt";
    
    
    
    
    /////may edit 
    private static final String POSTS_FILE = "dessert_creations.txt";
    
    
    ////
    private static final String DESSERT_CREATIONS_FILE = "dessert_creations.txt";
    private static final String IMAGES_DIR = "images/";
    
    private JTextArea descriptionTextArea;
    private JButton uploadImageButton;
    private File selectedImageFile;
    
    private String currentUser; 

    
    
    
    
    

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
       // loadUserData();
       // showLoginFrame();
    }
/*
    private void initializeUsers() {
        
        users.put("nuha", new User("nuha", "111111", "nuha@gmail.com", "Nablus", UserRole.REGULAR_USER));
        users.put("shahd", new User("shahd", "222222", "shahd@gmail.com", "Nablus", UserRole.ADMIN));
        users.put("hala", new User("hala", "333333", "hala@gmail.com", "Jenin", UserRole.STORE_OWNER));
        users.put("safaa", new User("safaa", "444444", "safa@gmail.com", "Tulkerem", UserRole.SUPPLIER));
        saveUsers();
    }
/////////////////////////////////////log in///////////////////////////////////////////////////////////////////
 
    private void showLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 350); 
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null); // 

        // 
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(208, 185, 101));
        JLabel welcomeLabel = new JLabel("Welcome!Sweet management system");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(60, 63, 65));
        welcomePanel.add(welcomeLabel);

        // 
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(208, 185, 101));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        // 
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(userLabel, gbc);

        gbc.gridx = 1;
        JTextField userText = new JTextField(15);
        formPanel.add(userText, gbc);

        // 
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordText = new JPasswordField(15);
        formPanel.add(passwordText, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        roleLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(roleLabel, gbc);

        gbc.gridx = 1;
        String[] roles = {"REGULAR_USER", "ADMIN", "STORE_OWNER", "SUPPLIER"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        formPanel.add(roleComboBox, gbc);

        // 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(208, 185, 101));

        JButton loginButton = new JButton("Log In");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.setBackground(new Color(60, 63, 65));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(loginButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setPreferredSize(new Dimension(100, 30));
        signUpButton.setBackground(new Color(60, 63, 65));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(signUpButton);

        
        loginFrame.add(welcomePanel, BorderLayout.NORTH);
        loginFrame.add(formPanel, BorderLayout.CENTER);
        loginFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners remain unchanged
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String selectedRole = (String) roleComboBox.getSelectedItem();

                if (loginManager.login(username, password)) {
                    currentUser = username;
                    loginFrame.dispose();
                    User user = users.get(username);
                    if (user != null && user.getRole().toString().equals(selectedRole)) {
                        switch (user.getRole()) {
                            case REGULAR_USER:
                                showBeneficiaryUserDashboard();
                                break;
                            case ADMIN:
                                showAdminDashboard();
                                break;
                            case STORE_OWNER:
                                showStoreOwnerDashboard();
                             
                                break;
                            case SUPPLIER:
                                showSupplierDashboard();
                         
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, "Role does not match. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid credentials. Please try again.");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpFrame();
            }
        });

        loginFrame.setVisible(true);
    }


 /////////////////////nuha 
    
    
    
    
    private void showSupplierDashboard() {
        JFrame frame = new JFrame("Supplier Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inbox", createInboxPanel());
        tabbedPane.addTab("Compose messages", createComposeMessagesPanel());
        tabbedPane.addTab("Sent messages", createSentMessagesPanel());

       
        tabbedPane.setSelectedIndex(1); 

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    
    
    private JPanel createInboxPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea inboxArea = new JTextArea();
        inboxArea.setEditable(false);

       
        try (BufferedReader reader = new BufferedReader(new FileReader(currentUser + "_messages.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inboxArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        
        }

        JScrollPane scrollPane = new JScrollPane(inboxArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
    
    
    
    
    
    private JPanel createComposeMessagesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        
        JPanel recipientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        recipientPanel.add(new JLabel("To:"));
        JTextField recipientField = new JTextField(20);
        recipientPanel.add(recipientField);
        panel.add(recipientPanel, BorderLayout.NORTH);
        
        
        JTextArea messageArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> {
            String recipient = recipientField.getText();
            String message = messageArea.getText();
            sendMessage(recipient, message);
        });
        buttonPanel.add(sendButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    
    private void sendMessage(String recipient, String message) {
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(recipient + "_messages.txt", true))) {
            writer.write("From: " + currentUser + " - Message: " + message);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Message sent.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error sending message.");
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentUser + "_sent_messages.txt", true))) {
            writer.write("To: " + recipient + " - Message: " + message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving sent message.");
        }
    }
    
    
    
    
    private JPanel createSentMessagesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea sentMessagesArea = new JTextArea();
        sentMessagesArea.setEditable(false);

        try (BufferedReader reader = new BufferedReader(new FileReader(currentUser + "_sent_messages.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sentMessagesArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading sent messages.");
        }

        JScrollPane scrollPane = new JScrollPane(sentMessagesArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    
    ////end supplier dashboard
   
//sign up up up up up up up up up up up 
    private void showSignUpFrame() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(600, 500); // Increased size to accommodate the new design
        signUpFrame.setLayout(new BorderLayout());
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null); // Center the frame

        // Panel for the welcome message
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(208, 185, 101));
        JLabel welcomeLabel = new JLabel("Create a New Account in Sweet Management System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(60, 63, 65));
        welcomePanel.add(welcomeLabel);

        // Panel for the form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(208, 185, 101));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        // Username field
        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        JTextField nameText = new JTextField(15);
        formPanel.add(nameText, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordText = new JPasswordField(15);
        formPanel.add(passwordText, gbc);

        // Email field
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        JTextField emailText = new JTextField(15);
        formPanel.add(emailText, gbc);

        // City field
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel countryLabel = new JLabel("City:");
        countryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        countryLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(countryLabel, gbc);

        gbc.gridx = 1;
        JTextField countryText = new JTextField(15);
        formPanel.add(countryText, gbc);

        // Role dropdown
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        roleLabel.setForeground(new Color(60, 63, 65));
        formPanel.add(roleLabel, gbc);

        gbc.gridx = 1;
        JComboBox<UserRole> roleComboBox = new JComboBox<>(UserRole.values());
        formPanel.add(roleComboBox, gbc);

        // Panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(208, 185, 101));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setPreferredSize(new Dimension(120, 30));
        signUpButton.setBackground(new Color(60, 63, 65));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(signUpButton);

        // Adding panels to the frame
        signUpFrame.add(welcomePanel, BorderLayout.NORTH);
        signUpFrame.add(formPanel, BorderLayout.CENTER);
        signUpFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners remain unchanged
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameText.getText();
                String password = new String(passwordText.getPassword());
                String email = emailText.getText();
                String city = countryText.getText();
                UserRole role = (UserRole) roleComboBox.getSelectedItem();

                if (!userExists(username)) {
                    signUpUser(username, password, email, city, role);
                    JOptionPane.showMessageDialog(signUpFrame, "Account created successfully.");
                    signUpFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(signUpFrame, "User already exists.");
                }
            }
        });

        signUpFrame.setVisible(true);
    }

//Admin Admin Admin  Admin
    private void showAdminDashboard() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("User Management", createUserManagementPanel());
        tabbedPane.addTab("Monitoring & Reporting", createMonitoringReportingPanel());
        tabbedPane.addTab("Content Management", createContentManagementPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    
    
    
    
    
    
    
    
    
    private JPanel createUserManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

        
        JPanel addPanel = new JPanel();
        addPanel.setBorder(BorderFactory.createTitledBorder("Add User"));
        addPanel.setLayout(new GridLayout(7, 2)); 

        JTextField nameField = new JTextField();
        
        JTextField emailField = new JTextField();
        JTextField countryField = new JTextField();
        
        JTextField roleField = new JTextField();
        JPasswordField passwordField = new JPasswordField(); 

        addPanel.add(new JLabel("Name:"));
        addPanel.add(nameField);
        addPanel.add(new JLabel("Password:")); 
        addPanel.add(passwordField); 
       ;
        addPanel.add(new JLabel("Email:"));
        addPanel.add(emailField);
        addPanel.add(new JLabel("City:"));
        addPanel.add(countryField);
        addPanel.add(new JLabel("Role:"));
        addPanel.add(roleField);

        JButton addButton = new JButton("Add User");
        addPanel.add(addButton);

        
        JPanel deletePanel = new JPanel();
        deletePanel.setBorder(BorderFactory.createTitledBorder("Delete User"));
        deletePanel.setLayout(new GridLayout(2, 2));

        JTextField deleteNameField = new JTextField();

        deletePanel.add(new JLabel("Name:"));
        deletePanel.add(deleteNameField);

        JButton deleteButton = new JButton("Delete User");
        deletePanel.add(deleteButton);

        JPanel updatePanel = new JPanel();
        updatePanel.setBorder(BorderFactory.createTitledBorder("Update User"));
        updatePanel.setLayout(new GridLayout(8, 2)); 

        JTextField updateNameField = new JTextField();
       
        JTextField updateEmailField = new JTextField();
        JTextField updateCountryField = new JTextField();
        JTextField updateRoleField = new JTextField();
        JPasswordField updatePasswordField = new JPasswordField(); 

        updatePanel.add(new JLabel("Name:"));
        updatePanel.add(updateNameField);
        updatePanel.add(new JLabel("Password:")); 
        updatePanel.add(updatePasswordField); 
      
        updatePanel.add(new JLabel("Email:"));
        updatePanel.add(updateEmailField);
        updatePanel.add(new JLabel("City:"));
        updatePanel.add(updateCountryField);
        updatePanel.add(new JLabel("Role:"));
        updatePanel.add(updateRoleField);

        JButton updateButton = new JButton("Update User");
        updatePanel.add(updateButton);

      
        panel.add(addPanel);
        panel.add(deletePanel);
        panel.add(updatePanel);

    
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String email = emailField.getText().trim();
            String city = countryField.getText().trim(); // Consider renaming this field to cityField for clarity
            String roleString = roleField.getText().trim();

            // Validate input fields
            if (name.isEmpty() || password.isEmpty() || email.isEmpty() || city.isEmpty() || roleString.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "All fields must be filled out.");
                return;
            }

            UserRole role;
            try {
                role = UserRole.fromString(roleString);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid role specified.");
                return;
            }

            // Create new user with the provided details
            User newUser = new User(name, password, email, city, role);
            System.out.println("New User: " + newUser.getUsername() + ", " + newUser.getPassword() + ", " + newUser.getEmail() + ", " + newUser.getCountry() + ", " + newUser.getRole().name());

            // Add the new user to the collection and save it to the file
            users.put(name, newUser);
            saveUsers(); // Save users to file

            // Confirm success
            JOptionPane.showMessageDialog(panel, "User added successfully."); 

            // Clear input fields after adding user
            nameField.setText("");
            passwordField.setText("");
            emailField.setText("");
            countryField.setText("");
            roleField.setText("");
        });

        deleteButton.addActionListener(e -> {
            String name = deleteNameField.getText();
            if (users.containsKey(name)) {
                users.remove(name); 
                saveUsers();
                JOptionPane.showMessageDialog(panel, "User deleted successfully."); 
            } else {
                JOptionPane.showMessageDialog(panel, "User not found."); 
            }
        });

        updateButton.addActionListener(e -> {
            String name = updateNameField.getText();
            String newPassword = new String(updatePasswordField.getPassword()); 
         
            String newEmail = updateEmailField.getText();
            String newCountry = updateCountryField.getText();
            String newRoleString = updateRoleField.getText();

          
            UserRole newRole;
            try {
                newRole = UserRole.fromString(newRoleString);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid role specified.");
                return;
            }

            User existingUser = users.get(name);
            if (existingUser != null) {
                User updatedUser = new User(name, newPassword, newEmail, newCountry, newRole);
                users.put(name, updatedUser); 
                saveUsers(); 
                JOptionPane.showMessageDialog(panel, "User updated successfully."); 
            } else {
                JOptionPane.showMessageDialog(panel, "User not found."); 
            }
        });

        return panel;

    }

    private JPanel createMonitoringReportingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Monitoring and Reporting", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JPanel profitsPanel = new JPanel(new BorderLayout());
        profitsPanel.setBorder(BorderFactory.createTitledBorder("Profits and Financial Reports"));

        JTextArea profitsReport = new JTextArea(10, 40);
        profitsReport.setEditable(false);
        JScrollPane profitsScrollPane = new JScrollPane(profitsReport);
        profitsPanel.add(profitsScrollPane, BorderLayout.CENTER);

        JButton refreshProfitsButton = new JButton("Refresh Profits");
        refreshProfitsButton.addActionListener(e -> profitsReport.setText(generateFinancialReport()));
        profitsPanel.add(refreshProfitsButton, BorderLayout.SOUTH);

        contentPanel.add(profitsPanel);

        JPanel bestSellingPanel = new JPanel(new BorderLayout());
        bestSellingPanel.setBorder(BorderFactory.createTitledBorder("Best-Selling Products by Store"));

        JTextArea bestSellingReport = new JTextArea(10, 40);
        bestSellingReport.setEditable(false);
        JScrollPane bestSellingScrollPane = new JScrollPane(bestSellingReport);
        bestSellingPanel.add(bestSellingScrollPane, BorderLayout.CENTER);

        JButton refreshBestSellingButton = new JButton("Refresh Best-Selling Products");
        refreshBestSellingButton.addActionListener(e -> bestSellingReport.setText(getBestSellingProductsReport()));
        bestSellingPanel.add(refreshBestSellingButton, BorderLayout.SOUTH);

        contentPanel.add(bestSellingPanel);

        JPanel userStatsPanel = new JPanel(new BorderLayout());
        userStatsPanel.setBorder(BorderFactory.createTitledBorder("User Statistics by City"));

        JTextArea userStatsReport = new JTextArea(10, 40);
        userStatsReport.setEditable(false);
        JScrollPane userStatsScrollPane = new JScrollPane(userStatsReport);
        userStatsPanel.add(userStatsScrollPane, BorderLayout.CENTER);

        JButton refreshUserStatsButton = new JButton("Refresh User Statistics");
        refreshUserStatsButton.addActionListener(e -> userStatsReport.setText(getUserStatisticsByCity()));
        userStatsPanel.add(refreshUserStatsButton, BorderLayout.SOUTH);

        contentPanel.add(userStatsPanel);

        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }


    private String generateFinancialReport() {
        double totalProfits = 0.0;
        Map<String, Double> storeProfits = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("_Purchases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by '|'
                String[] parts = line.split("\\|");
                
                if (parts.length < 2) continue; // Skip lines that do not have the correct format

                // Extract store owner and product details
                String storeOwner = parts[0].trim();
                String productDetails = parts[1].trim();

                // Find the Price section
                String[] detailsParts = productDetails.split(" - ");
                String priceStr = "";

                for (String part : detailsParts) {
                    if (part.trim().startsWith("Price:")) {
                        priceStr = part.trim().replace("Price: $", "").trim();
                        break;
                    }
                }

                // Convert price to double
                try {
                    double price = Double.parseDouble(priceStr.replace(",", ""));
                    
                    // Accumulate total profits
                    totalProfits += price;

                    // Update store profits
                    storeProfits.put(storeOwner, storeProfits.getOrDefault(storeOwner, 0.0) + price);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid price format: " + priceStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error generating financial report.";
        }

        // Build report
        StringBuilder report = new StringBuilder();
        report.append("Total Profits: $").append(String.format("%.2f", totalProfits)).append("\n\n");

        for (Map.Entry<String, Double> entry : storeProfits.entrySet()) {
            report.append("Store Owner: ").append(entry.getKey()).append(" - Profits: $").append(String.format("%.2f", entry.getValue())).append("\n");
        }

        return report.toString();
    } 

    private String getBestSellingProductsReport() {
        Map<String, Map<String, Integer>> salesData = loadSalesDataFromFile("_Purchases.txt"); // Replace with your actual file path

        StringBuilder reportBuilder = new StringBuilder();

        for (Map.Entry<String, Map<String, Integer>> storeEntry : salesData.entrySet()) {
            String storeOwner = storeEntry.getKey();
            Map<String, Integer> productSales = storeEntry.getValue();

            // Identify the best-selling product(s)
            String bestSellingProduct = null;
            int maxSales = 0;
            for (Map.Entry<String, Integer> productEntry : productSales.entrySet()) {
                String productName = productEntry.getKey();
                int salesCount = productEntry.getValue();

                if (salesCount > maxSales) {
                    maxSales = salesCount;
                    bestSellingProduct = productName;
                }
            }

            reportBuilder.append("Store Owner: ").append(storeOwner).append("\n");
            if (bestSellingProduct != null) {
                reportBuilder.append("Best-Selling Product: ").append(bestSellingProduct)
                              .append(" (").append(maxSales).append(" sales)\n");
            } else {
                reportBuilder.append("No sales data available.\n");
            }
            reportBuilder.append("\n");
        }

        return reportBuilder.toString();
    }

    private Map<String, Map<String, Integer>> loadSalesDataFromFile(String fileName) {
        Map<String, Map<String, Integer>> salesData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Example line: ahmad | tasneem: Product: White chocolate pops - Description: every one can have a lice. - Price: $63.00
                String[] parts = line.split("Product: ");
                if (parts.length < 2) {
                    // Log or print a warning, and skip this line as it's not in the expected format
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                String storeInfo = parts[0].trim();
                String productInfo = parts[1].trim();

                // Extract store owner and product name
                String[] storeParts = storeInfo.split("\\|");
                if (storeParts.length < 2) {
                    // Log or print a warning, and skip this line as it's not in the expected format
                    System.err.println("Skipping malformed store info: " + storeInfo);
                    continue;
                }
                String storeOwner = storeParts[0].trim();
                String productName = productInfo.split(" - ")[0].trim();

                // Update sales data
                salesData.putIfAbsent(storeOwner, new HashMap<>());
                Map<String, Integer> productSales = salesData.get(storeOwner);
                productSales.put(productName, productSales.getOrDefault(productName, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salesData;
    }

 










    
    
    
    
    

    private String getUserStatisticsByCity() {
        Map<String, Integer> cityUserStats = new HashMap<>(); 

        
        try (BufferedReader userReader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = userReader.readLine()) != null) {
                String[] userParts = line.split(",");
                if (userParts.length < 5) continue; 

                String city = userParts[3].trim();
                String role = userParts[4].trim();

                
                if (role.equals("REGULAR_USER")) {
                    cityUserStats.put(city, cityUserStats.getOrDefault(city, 0) +1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading user data.";
        }

        
        StringBuilder report = new StringBuilder();
        cityUserStats.forEach((city, count) -> 
            report.append("City: ").append(city).append(" - REGULAR_USERs: ").append(count).append("\n")
        );

        return report.toString();
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private JPanel createContentManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton managePostsButton = new JButton("Manage Posts");
        JButton manageFeedbackButton = new JButton("Manage Feedback");
        JButton backButton = new JButton("Back");

        managePostsButton.addActionListener(e -> showManagePostsFrame());
        manageFeedbackButton.addActionListener(e -> showManageFeedbackFrame());
        backButton.addActionListener(e -> {
           
            showAdminDashboard(); 
        });

        panel.add(managePostsButton);
        panel.add(manageFeedbackButton);
        panel.add(backButton);

        return panel;
    }
    
    /////////////////////////////////////////////
    ////////////////////////////////////////////
    ///////////////////////////////////////////////
    //////////////////////////////////////////////
    public void showManagePostsFrame() {
        JFrame postsFrame = new JFrame("Manage Posts");
        postsFrame.setSize(800, 400);  
        postsFrame.setLocationRelativeTo(null); 
        postsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        try (BufferedReader reader = new BufferedReader(new FileReader("dessert_creations.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
               
                String[] parts = line.split("\\|", 3);
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String imagePath = parts[1].trim();
                    String description = parts[2].trim();

                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    if (imageIcon.getIconWidth() == -1) {
                        System.out.println("Failed to load image: " + imagePath);
                        continue; 
                    }

                   
                    JPanel postPanel = new JPanel(new BorderLayout());

                    JLabel imageLabel = new JLabel("<html><b>" + username + ":</b> " + description + "</html>", imageIcon, JLabel.LEFT);
                    postPanel.add(imageLabel, BorderLayout.CENTER);

                    
                    JPanel buttonPanel = new JPanel();
                    JButton editButton = new JButton("Edit");
                    JButton deleteButton = new JButton("Delete");

                   
                    deleteButton.addActionListener(e -> {
                        mainPanel.remove(postPanel); 
                        mainPanel.revalidate();
                        mainPanel.repaint();
                        deletePostFromFile(username, imagePath, description); 
                    });

                    
                    editButton.addActionListener(e -> {
                        editPost(username, imagePath, description, postPanel, imageLabel); 
                    });

                    buttonPanel.add(editButton);
                    buttonPanel.add(deleteButton);

                    postPanel.add(buttonPanel, BorderLayout.SOUTH); 

                    mainPanel.add(postPanel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(postsFrame, "Error loading posts.");
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> postsFrame.dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        postsFrame.add(panel);
        postsFrame.setVisible(true);
    }


    private void deletePostFromFile(String username, String imagePath, String description) {
        File inputFile = new File("dessert_creations.txt");
        File tempFile = new File("temp_dessert_creations.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            String postToRemove = username + "|" + imagePath + "|" + description;
            while ((line = reader.readLine()) != null) {
                
                if (!line.trim().equals(postToRemove.trim())) {
                    writer.write(line + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        } else {
            System.out.println("Could not delete file");
        }
    }

 
    private void editPost(String username, String imagePath, String description, JPanel postPanel, JLabel imageLabel) {
        JTextField newDescriptionField = new JTextField(description, 20);
        JButton chooseImageButton = new JButton("Choose New Image");
        JFileChooser fileChooser = new JFileChooser();
        final String[] newImagePath = {imagePath};

        chooseImageButton.addActionListener((ActionEvent e) -> {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                newImagePath[0] = selectedFile.getAbsolutePath();
            }
        });

        Object[] message = {
            "New Description:", newDescriptionField,
            "New Image:", chooseImageButton
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Edit Post", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String newDescription = newDescriptionField.getText().trim();
            updatePostInFile(username, imagePath, description, newImagePath[0], newDescription);
            imageLabel.setText("<html><b>" + username + ":</b> " + newDescription + "</html>");
            imageLabel.setIcon(new ImageIcon(newImagePath[0]));
        }
    }

    
    private void updatePostInFile(String username, String oldImagePath, String oldDescription, String newImagePath, String newDescription) {
        File inputFile = new File("dessert_creations.txt");
        File tempFile = new File("temp_dessert_creations.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            String oldPost = username + "|" + oldImagePath + "|" + oldDescription;
            String newPost = username + "|" + newImagePath + "|" + newDescription;

            while ((line = reader.readLine()) != null) {
          
            	
  ///////new ewkmklk
            	
            	
            	
                if (line.trim().equals(oldPost.trim())) {
                    writer.write(newPost + System.getProperty("line.separator"));
                } else {
                    writer.write(line + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        } else {
            System.out.println("Could not delete file");
        }
    }

/////////////////////////////////////////////////
    ////////////////////////////////////////////////
    //////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //////////////////////////////////////////////////////

    private void showManageFeedbackFrame() {
        JFrame feedbackFrame = new JFrame("Manage Feedback");
        feedbackFrame.setSize(600, 400);
        feedbackFrame.setLocationRelativeTo(null);
        feedbackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel<String> feedbackListModel = new DefaultListModel<>();
        JList<String> feedbackList = new JList<>(feedbackListModel);
        JScrollPane scrollPane = new JScrollPane(feedbackList);

        
        loadFeedbackFromFile(feedbackListModel, "feedback.txt", false);
      
        System.out.println("____________________________________________________________________--");
        loadFeedbackFromFile(feedbackListModel, "postsfeedback.txt", true);

       
        JButton deleteButton = new JButton("Delete Feedback");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = feedbackList.getSelectedIndex();
                if (selectedIndex != -1) {
                    int confirm = JOptionPane.showConfirmDialog(feedbackFrame, "Are you sure you want to delete this feedback?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                       
                        feedbackListModel.remove(selectedIndex);

                      
                        saveFeedbackToFile(feedbackListModel, "feedback.txt", false);
                        saveFeedbackToFile(feedbackListModel, "postsfeedback.txt", true);
                    }
                } else {
                    JOptionPane.showMessageDialog(feedbackFrame, "No feedback selected.");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> feedbackFrame.dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        feedbackFrame.add(panel);
        feedbackFrame.setVisible(true);
    }

    private void loadFeedbackFromFile(DefaultListModel<String> feedbackListModel, String fileName, boolean isPostFeedback) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isPostFeedback) {
                    // Process post feedback lines
                    String[] parts = line.split(" gave feedback on post by ");
                    if (parts.length == 2) {
                        String username = parts[0].trim();
                        String[] feedbackParts = parts[1].split(" - \"");
                        if (feedbackParts.length == 2) {
                            String postDescription = feedbackParts[0].trim();
                            String feedback = feedbackParts[1].replace("\"", "").trim();
                            feedbackListModel.addElement("User: " + username + " | Post: " + postDescription + " | Feedback: " + feedback);
                        }
                    }
                } else {
                    
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        String username = parts[0].trim();
                        String productName = parts[1].trim();
                        String feedback = parts[2].trim();
                        feedbackListModel.addElement("User: " + username + " | Product: " + productName + " | Feedback: " + feedback);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading feedback from " + fileName + ".");
        }
    }

    private void saveFeedbackToFile(DefaultListModel<String> feedbackListModel, String fileName, boolean isPostFeedback) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < feedbackListModel.getSize(); i++) {
                String item = feedbackListModel.getElementAt(i);
                String[] parts = item.split("\\|");
                if (isPostFeedback) {
                    
                    String username = parts[0].replace("User: ", "").trim();
                    String postDescription = parts[1].replace("Post: ", "").trim();
                    String feedback = parts[2].replace("Feedback: ", "").trim();
                    writer.write(username + " gave feedback on post by " + postDescription + " - \"" + feedback + "\"");
                } else {
                  
                    String username = parts[0].replace("User: ", "").trim();
                    String productName = parts[1].replace("Product: ", "").trim();
                    String feedback = parts[2].replace("Feedback: ", "").trim();
                    writer.write(username + "|" + productName + "|" + feedback);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating feedback file " + fileName + ".");
        }
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////14/8/2024
   

  
    
    
    
//14/8/2024 shahd
///////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    
    
    
    

    
    
    
//////////////////Store ownerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
    private void showStoreOwnerDashboard() {
        JFrame frame = new JFrame("Store Owner Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Product Management", createProductManagementPanel(currentUser));
        tabbedPane.addTab("Sales & Profits", createSalesProfitsPanel());
        tabbedPane.addTab("Communication & Notifications", createCommunicationNotificationPanel());
        tabbedPane.addTab("Account Management",createOwnerAccountManagementPanel());
        tabbedPane.addTab("Order Management", createOrderManagementPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    private JPanel createCommunicationNotificationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a label for the title
        JLabel titleLabel = new JLabel("Communication and Notification", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for communication options
        JPanel communicationPanel = new JPanel();
        communicationPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Create buttons for sending messages and viewing received messages
        JButton sendMessageButton = new JButton("Send Message");
        JButton viewMessagesButton = new JButton("View Received Messages");

        communicationPanel.add(sendMessageButton);
        communicationPanel.add(viewMessagesButton);

        panel.add(communicationPanel, BorderLayout.CENTER);

        // Action Listener to send messages
        sendMessageButton.addActionListener(e -> {
            JTextField recipientField = new JTextField();
            JTextArea messageArea = new JTextArea(5, 20);

            JPanel sendMessagePanel = new JPanel(new BorderLayout(5, 5));
            sendMessagePanel.add(new JLabel("Recipient:"), BorderLayout.NORTH);
            sendMessagePanel.add(recipientField, BorderLayout.CENTER);
            sendMessagePanel.add(new JLabel("Message:"), BorderLayout.WEST);
            sendMessagePanel.add(new JScrollPane(messageArea), BorderLayout.SOUTH);

            int result = JOptionPane.showConfirmDialog(panel, sendMessagePanel, 
                    "Send Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String recipient = recipientField.getText().trim();
                String message = messageArea.getText().trim();
                if (!recipient.isEmpty() && !message.isEmpty()) {
                    saveNotification(currentUser, recipient, message); // Store the message
                    JOptionPane.showMessageDialog(panel, "Message sent to " + recipient + "!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Recipient and message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewMessagesButton.addActionListener(e -> showReceivedMessages1(currentUser)); // Show received messages

        return panel;
    }


    private void saveNotification(String sender, String recipient, String message) {
        String filename = recipient + "_messages.txt";
        String notification = "Store owner " + sender + " sent a message to " + recipient + ":\n" + message + "\n\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(notification);
            writer.flush(); // Ensure the data is written to the file
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to save the message.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

   


    public JPanel createOrderManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Order Management", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

       
        String[] columnNames = {"Order ID", "Product Name", "Quantity", "Customer", "Status", "Store Owner"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable orderTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        loadOrdersFromFile(model);

        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 5, 5));

      
        JTextField orderIdField = new JTextField();
        JTextField productNameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField customerField = new JTextField();

        formPanel.add(new JLabel("Order ID:"));
        formPanel.add(orderIdField);
        formPanel.add(new JLabel("Product Name:"));
        formPanel.add(productNameField);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(quantityField);
        formPanel.add(new JLabel("Customer:"));
        formPanel.add(customerField);

        panel.add(formPanel, BorderLayout.NORTH);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addButton = new JButton("Add Order");
        JButton startProcessingButton = new JButton("Start Processing");
        JButton updateStatusButton = new JButton("Update Status");
        JButton completeOrderButton = new JButton("Complete Order");
        JButton deleteOrderButton = new JButton("Delete Order");

        buttonPanel.add(addButton);
        buttonPanel.add(startProcessingButton);
        buttonPanel.add(updateStatusButton);
        buttonPanel.add(completeOrderButton);
        buttonPanel.add(deleteOrderButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);


        addButton.addActionListener(e -> {
            String orderId = orderIdField.getText();
            String productName = productNameField.getText();
            String quantity = quantityField.getText();
            String customer = customerField.getText();
            String storeOwner = currentUser; 

            
            Order order = new Order(orderId, "New", productName, quantity, customer, storeOwner);
            
            model.addRow(new Object[]{order.getOrderId(), productName, quantity, customer, order.getStatus(), order.getStoreOwnerName()});

            
            saveOrderToFile(order);

           
            orderIdField.setText("");
            productNameField.setText("");
            quantityField.setText("");
            customerField.setText("");
        });

      
        startProcessingButton.addActionListener(e -> {
            int selectedRow = orderTable.getSelectedRow();
            if (selectedRow >= 0) {
                model.setValueAt("Processing", selectedRow, 4); 
                updateOrderStatusInFile(model, selectedRow, "Processing");
            } else {
                JOptionPane.showMessageDialog(panel, "Please select an order to start processing.");
            }
        });

        updateStatusButton.addActionListener(e -> {
            int selectedRow = orderTable.getSelectedRow();
            if (selectedRow >= 0) {
                String newStatus = JOptionPane.showInputDialog(panel, "Enter new status:");
                if (newStatus != null && !newStatus.trim().isEmpty()) {
                    model.setValueAt(newStatus, selectedRow, 4); // Update the status
                    updateOrderStatusInFile(model, selectedRow, newStatus);
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Please select an order to update the status.");
            }
        });

        completeOrderButton.addActionListener(e -> {
            int selectedRow = orderTable.getSelectedRow();
            if (selectedRow >= 0) {
                model.setValueAt("Completed", selectedRow, 4); 
                updateOrderStatusInFile(model, selectedRow, "Completed");
            } else {
                JOptionPane.showMessageDialog(panel, "Please select an order to complete.");
            }
        });

       
        deleteOrderButton.addActionListener(e -> {
            int selectedRow = orderTable.getSelectedRow();
            if (selectedRow >= 0) {
                String orderId = (String) model.getValueAt(selectedRow, 0);
                String storeOwner = (String) model.getValueAt(selectedRow, 5);
                model.removeRow(selectedRow); 
                deleteOrderFromFile(orderId, storeOwner); 
            } else {
                JOptionPane.showMessageDialog(panel, "Please select an order to delete.");
            }
        });

        return panel;
    }

    private void saveOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt", true))) {
           
            String orderLine = String.format("%s:%s|Product: %s, Quantity: %s, Customer: %s|%s",
                    order.getStoreOwnerName(), order.getOrderId(), order.getProductName(), order.getQuantity(), order.getCustomerName(), order.getStatus());

            writer.write(orderLine);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateOrderStatusInFile(DefaultTableModel model, int row, String newStatus) {
        String orderId = (String) model.getValueAt(row, 0);
        String storeOwner = (String) model.getValueAt(row, 5);
        String productName = (String) model.getValueAt(row, 1);
        String quantity = (String) model.getValueAt(row, 2);
        String customer = (String) model.getValueAt(row, 3);

        List<String> updatedOrders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("order.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(storeOwner + ":" + orderId)) {
             
                    String updatedLine = String.format("%s:%s|Product: %s, Quantity: %s, Customer: %s|%s",
                            storeOwner, orderId, productName, quantity, customer, newStatus);
                    updatedOrders.add(updatedLine);
                } else {
                    updatedOrders.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt"))) {
            for (String updatedOrder : updatedOrders) {
                writer.write(updatedOrder);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteOrderFromFile(String orderId, String storeOwner) {
        List<String> remainingOrders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("order.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(storeOwner + ":" + orderId)) {
                    remainingOrders.add(line); // Keep orders that do not match the deleted one
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt"))) {
            for (String order : remainingOrders) {
                writer.write(order);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


///////////////////////////////// tuesday


private void loadOrdersFromFile(DefaultTableModel model) {
    try (BufferedReader reader = new BufferedReader(new FileReader("order.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                // Split the first part to extract store owner and order ID
                String[] storeOwnerAndOrderId = parts[0].split(":");
                String storeOwner = storeOwnerAndOrderId[0];
                String orderId = storeOwnerAndOrderId[1];

                // Split the details part to extract product name, quantity, and customer
                String details = parts[1];
                String productName = details.split(",")[0].split(":")[1].trim();
                String quantity = details.split(",")[1].split(":")[1].trim();
                String customer = details.split(",")[2].split(":")[1].trim();

                String status = parts[2];

                // Add to the table model
                model.addRow(new Object[]{orderId, productName, quantity, customer, status, storeOwner});
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
    
private JPanel createProductManagementPanel(String storeOwnerName) { // Add storeOwnerName as a parameter
    JPanel panel = new JPanel(new BorderLayout());
    String newStoreOwnerName = currentUser;
    // Create the add product panel
    JPanel addProductPanel = new JPanel(new GridLayout(4, 2));
    JLabel nameLabel = new JLabel("Product Name:");
    JTextField nameField = new JTextField();
    JLabel descriptionLabel = new JLabel("Product Description:");
    JTextField descriptionField = new JTextField();
    JLabel priceLabel = new JLabel("Price:");
    JTextField priceField = new JTextField();
    JButton addButton = new JButton("Add Product");

    addProductPanel.add(nameLabel);
    addProductPanel.add(nameField);
    addProductPanel.add(descriptionLabel);
    addProductPanel.add(descriptionField);
    addProductPanel.add(priceLabel);
    addProductPanel.add(priceField);
    addProductPanel.add(new JLabel()); // Empty space
    addProductPanel.add(addButton);

    
    DefaultListModel<String> productListModel = new DefaultListModel<>();
    JList<String> productList = new JList<>(productListModel);
    JScrollPane productScrollPane = new JScrollPane(productList);
    
    loadProductsFromFile1(productListModel);

  
    JPanel buttonPanel = new JPanel();
    JButton updateButton = new JButton("Update Product");
    JButton deleteButton = new JButton("Delete Product");
    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);

    
    panel.add(addProductPanel, BorderLayout.NORTH);
    panel.add(productScrollPane, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.SOUTH);

 
   

    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String productName = nameField.getText().trim();
            String productDescription = descriptionField.getText().trim();
            double productPrice;
            try {
                productPrice = Double.parseDouble(priceField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid price.");
                return;
            }

            if (!productName.isEmpty() && !productDescription.isEmpty()) {
                String productString = storeOwnerName + "| Product: " + productName + " - Description: " + productDescription + " - Price: $" + productPrice;
                productListModel.addElement(productString);
                
          
                appendProductToFile(productString);
                
                JOptionPane.showMessageDialog(panel, "Product added successfully.");
            } else {
                JOptionPane.showMessageDialog(panel, "Please fill all fields.");
            }
        }
    });


    
    updateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedProduct = productListModel.getElementAt(selectedIndex);
                
            
                String newProductName = JOptionPane.showInputDialog("Enter new product name:", extractProductName(selectedProduct));
                String newDescription = JOptionPane.showInputDialog("Enter new product description:", extractProductDescription(selectedProduct));
                String newPriceStr = JOptionPane.showInputDialog("Enter new product price:", extractProductPrice(selectedProduct));

                if (newProductName != null && newDescription != null && newPriceStr != null) {
                    double newPrice;
                    try {
                        newPrice = Double.parseDouble(newPriceStr.trim());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Invalid price format.");
                        return;
                    }
                    
                    
                    String updatedProduct = newStoreOwnerName + "| Product: " + newProductName + " - Description: " + newDescription + " - Price: $" + String.format("%.2f", newPrice);
                    
          
                    updateProductInFile(selectedProduct, updatedProduct);
                    
        
                    productListModel.setElementAt(updatedProduct, selectedIndex);
                    
                    JOptionPane.showMessageDialog(panel, "Product updated successfully.");
                }
            }
        }
    });

   
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                
                String selectedProduct = productListModel.getElementAt(selectedIndex);

               
                productListModel.remove(selectedIndex);

              
                String productName = extractProductName(selectedProduct);

                saveProductToFile1(productName);

                JOptionPane.showMessageDialog(panel, "Product deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(panel, "Please select a product to delete.");
            }
        }
    });


    return panel;
}






////
private String extractProductDescription(String productLine) {
    String[] parts = productLine.split(" - ");
    if (parts.length >= 2) {
        return parts[1].replace("Description: ", "").trim();
    }
    return "";
}

private String extractProductPrice(String productLine) {
    String[] parts = productLine.split(" - ");
    if (parts.length >= 3) {
        return parts[2].replace("Price: $", "").trim();
    }
    return "";
}

private void updateProductInFile(String originalProduct, String updatedProduct) {
    File inputFile = new File("products.txt");
    File tempFile = new File("products_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
          
            if (!currentLine.trim().equalsIgnoreCase(originalProduct.trim())) {
               
                writer.println(currentLine);
            }
        }
        
       
        writer.println(updatedProduct);

    } catch (IOException e) {
        e.printStackTrace();
    }

   
    if (inputFile.delete()) {
        tempFile.renameTo(inputFile);
    }
}
////
private String extractProductName(String productString) {
   
    String[] parts = productString.split(" - ");
    
   
    String[] nameParts = parts[0].split(": ");
    
  
    return nameParts[1].trim();
}


private void appendProductToFile(String productString) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("products.txt", true))) {  
        writer.println(productString);
    } catch (IOException e) {
        e.printStackTrace();
    }
}




private void saveProductToFile1(String productName) {
    File inputFile = new File("products.txt");
    File tempFile = new File("products_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] parts = currentLine.split(" - ");
            if (parts.length > 0) {
                String currentProductName = parts[0].split(":")[1].trim(); 
                if (!currentProductName.equals(productName)) {
                    writer.println(currentLine);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    
    if (inputFile.delete()) {
        if (!tempFile.renameTo(inputFile)) {
            System.err.println("Failed to rename the temporary file.");
        }
    } else {
        System.err.println("Failed to delete the original file.");
    }
}



private void loadProductsFromFile1(DefaultListModel<String> productListModel) {
    try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            productListModel.addElement(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    
    //////////hbhdbhjdbhj
    
    
    ///////////////////monday 12/8/202444444444444444444444444444444444444444///////////////////
    private JPanel createSalesProfitsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        
        JPanel salesProfitsPanel = new JPanel();
        salesProfitsPanel.setLayout(new GridLayout(2, 2)); 

        JLabel totalSalesLabel = new JLabel("Total Sales:");
        JLabel totalSalesValue = new JLabel("$0.00"); 
        JLabel totalProfitsLabel = new JLabel("Total Profits:");
        JLabel totalProfitsValue = new JLabel("$0.00"); 
        
        salesProfitsPanel.add(totalSalesLabel);
        salesProfitsPanel.add(totalSalesValue);
        salesProfitsPanel.add(totalProfitsLabel);
        salesProfitsPanel.add(totalProfitsValue);

        
        JPanel bestSellingPanel = new JPanel();
        bestSellingPanel.setLayout(new BorderLayout());

        JLabel bestSellingLabel = new JLabel("Best-Selling Products:");
        DefaultListModel<String> bestSellingListModel = new DefaultListModel<>();
        JList<String> bestSellingList = new JList<>(bestSellingListModel);
        JScrollPane bestSellingScrollPane = new JScrollPane(bestSellingList);

        bestSellingPanel.add(bestSellingLabel, BorderLayout.NORTH);
        bestSellingPanel.add(bestSellingScrollPane, BorderLayout.CENTER);

       
        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(new GridLayout(3, 2)); 
        
        JLabel discountLabel = new JLabel("Apply Discount (%):");
        JTextField discountField = new JTextField();
        JButton applyDiscountButton = new JButton("Apply Discount");

        discountPanel.add(discountLabel);
        discountPanel.add(discountField);
        discountPanel.add(new JLabel());
        discountPanel.add(applyDiscountButton);

        
        applyDiscountButton.addActionListener(e -> {
            try {
                double discountPercentage = Double.parseDouble(discountField.getText());
                if (discountPercentage < 0 || discountPercentage > 100) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid discount percentage (0-100).");
                } else {
                    applyDiscount(discountPercentage);
                    JOptionPane.showMessageDialog(panel, "Discount of " + discountPercentage + "% applied successfully.");
                  
                    updateSalesAndProfits(totalSalesValue, totalProfitsValue);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please enter a valid number.");
            }
        });

        panel.add(salesProfitsPanel, BorderLayout.NORTH);
        panel.add(bestSellingPanel, BorderLayout.CENTER);
        panel.add(discountPanel, BorderLayout.SOUTH);

      
        updateSalesAndProfits(totalSalesValue, totalProfitsValue);
        updateBestSellingProducts(bestSellingListModel);

        return panel;
    }

    private void updateSalesAndProfits(JLabel totalSalesValue, JLabel totalProfitsValue) {
        double totalSales = 0.0;
        double totalProfits = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader("_Purchases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length >= 3) {
                  
                    String priceStr = parts[2].trim();
                    if (priceStr.startsWith("Price:")) {
                       
                        priceStr = priceStr.split(":")[1].trim();
                    }
                    
                    priceStr = priceStr.replace("$", "");
                    try {
                        double price = Double.parseDouble(priceStr);

                       
                        double costPrice = price * 0.7;
                        totalSales += price;
                        totalProfits += (price - costPrice);
                    } catch (NumberFormatException e) {
                        System.err.println("Failed to parse price: " + priceStr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        totalSalesValue.setText(String.format("$%.2f", totalSales));
        totalProfitsValue.setText(String.format("$%.2f", totalProfits));
    }

    private void updateBestSellingProducts(DefaultListModel<String> bestSellingListModel) {
        Map<String, Integer> productSalesCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("_Purchases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length >= 3) {
                    String productName = parts[0];
                    productSalesCount.put(productName, productSalesCount.getOrDefault(productName, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

     
        List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<>(productSalesCount.entrySet());
        sortedProducts.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        bestSellingListModel.clear();
        for (Map.Entry<String, Integer> entry : sortedProducts) {
            bestSellingListModel.addElement(entry.getKey() + " - " + entry.getValue() + " sales");
        }
    }

    private void applyDiscount(double discountPercentage) {
        List<String> discountedProducts = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("products_tmp.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length >= 3) {
                    
                    String storeOwnerAndProductName = parts[0];

                    
                    String description = parts[1];

                    
                    String priceStr = parts[2].replace("Price: $", "");
                    double price = Double.parseDouble(priceStr);

                    
                    double discountedPrice = price * (1 - discountPercentage / 100);

                    
                    String discountedProductLine = storeOwnerAndProductName + " - " + description + " - Price: $" + String.format("%.2f", discountedPrice);
                    discountedProducts.add(discountedProductLine);
                    
                    writer.write(discountedProductLine + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        new File("products.txt").delete();
        new File("products_tmp.txt").renameTo(new File("products.txt"));

        
        showDiscountedProductsFrame(discountedProducts);
    }

    private void showDiscountedProductsFrame(List<String> discountedProducts) {
        JFrame frame = new JFrame("Discounted Products");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String product : discountedProducts) {
            model.addElement(product);
        }
        
        JList<String> productList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(productList);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

///////////////////////////////////////////////////////////////////////////////////////////
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private JPanel createOwnerAccountManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridLayout(5, 2, 10, 10));
        
        JLabel usernameLabel = new JLabel("Store Owner Name:");
        JTextField usernameField = new JTextField(15);
        
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        
        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField(15);
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        
        JButton updateButton = new JButton("Update Account");

        accountDetailsPanel.add(usernameLabel);
        accountDetailsPanel.add(usernameField);
        accountDetailsPanel.add(emailLabel);
        accountDetailsPanel.add(emailField);
        accountDetailsPanel.add(cityLabel);
        accountDetailsPanel.add(cityField);
        accountDetailsPanel.add(passwordLabel);
        accountDetailsPanel.add(passwordField);
        accountDetailsPanel.add(new JLabel()); 
        accountDetailsPanel.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String email = emailField.getText().trim();
                String city = cityField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (username.isEmpty() || email.isEmpty() || city.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "All fields are required.");
                    return;
                }

                String currentUsername = getCurrentUsername(); // Fetch the current store owner's username
                User user = users.get(currentUsername);
                if (user != null) {
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setCountry(city);
                    user.setPassword(password);
                    saveUsers();  
                    JOptionPane.showMessageDialog(panel, "Account details updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Store owner not found.");
                }
            }
        });

        panel.add(accountDetailsPanel, BorderLayout.CENTER);

        return panel;
    }

  
    
    ///////////////////////////////end Store Owner
    
//////////USER USER  USER USER USER USER
    private void showBeneficiaryUserDashboard() {
        showMainFrame();
    }

    private void showMainFrame() {
        JFrame frame = new JFrame("Beneficiary User Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Account Management", createAccountManagementPanel());
        tabbedPane.addTab("Explore & Purchase", createExplorePurchasePanel());
        tabbedPane.addTab("Communication & Feedback", createCommunicationFeedbackPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    
    
    private JPanel createAccountManagementPanel() {
    	JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

       
        JTabbedPane tabbedPane = new JTabbedPane();

  
        JPanel accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridLayout(6, 2, 10, 10));
        
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        
        JLabel countryLabel = new JLabel("City:");
        JTextField countryField = new JTextField(15);
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        
        JButton updateButton = new JButton("Update Details");
        
        accountDetailsPanel.add(usernameLabel);
        accountDetailsPanel.add(usernameField);
        accountDetailsPanel.add(emailLabel);
        accountDetailsPanel.add(emailField);
        accountDetailsPanel.add(countryLabel);
        accountDetailsPanel.add(countryField);
        accountDetailsPanel.add(passwordLabel);
        accountDetailsPanel.add(passwordField);
        accountDetailsPanel.add(new JLabel()); 
        accountDetailsPanel.add(updateButton);

       
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String email = emailField.getText().trim();
                String country = countryField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (username.isEmpty() || email.isEmpty() || country.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "All fields are required.");
                    return;
                }

                String currentUsername = getCurrentUsername();
                System.out.println("Current username: " + currentUsername);

                User user = users.get(currentUsername);
                if (user != null) {
                    System.out.println("User found: " + user.getUsername());
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setCountry(country);
                    user.setPassword(password);
                    saveUsers();  
                    JOptionPane.showMessageDialog(panel, "Details updated successfully.");
                } else {
                    System.out.println("User not found.");
                    JOptionPane.showMessageDialog(panel, "User not found.");
                }
            }
        });

        
        
    
        JPanel postDessertPanel = createPostDessertPanel();

        
        tabbedPane.addTab("Account Details", accountDetailsPanel);
       
        tabbedPane.addTab("Post Dessert", postDessertPanel);

        panel.add(tabbedPane, BorderLayout.CENTER);

        return panel;
    }

        
    
    private String getCurrentUsername() {
        
        return currentUser; 
    }
    
    
    
    
 

    
  
    
    
    
    
    
    
    
    
    //post and share
    
    private void showAllUserPosts() {
        JFrame postsFrame = new JFrame("My Dessert Creations");
        postsFrame.setSize(800, 600);
        postsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        postsFrame.setLayout(new BorderLayout());

        JPanel postsPanel = new JPanel();
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(postsPanel);
        postsFrame.add(scrollPane, BorderLayout.CENTER);

        String currentUsername = getCurrentUsername();
        loadUserPosts(postsPanel, currentUsername);

        postsFrame.setVisible(true);
    }

    private void loadUserPosts(JPanel panel, String username) {
        panel.removeAll(); 

        try (BufferedReader reader = new BufferedReader(new FileReader(DESSERT_CREATIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) { 
                    String postUsername = parts[0];
                    String imagePath = parts[1];
                    String description = parts[2];

                    if (postUsername.equals(username)) {
                        JPanel contentItemPanel = new JPanel();
                        contentItemPanel.setLayout(new BoxLayout(contentItemPanel, BoxLayout.Y_AXIS));
                        contentItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

                        JLabel descriptionLabel = new JLabel("Description: " + description);
                        contentItemPanel.add(descriptionLabel);

                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                        JLabel imageLabel = new JLabel(new ImageIcon(image));
                        contentItemPanel.add(imageLabel);

                        panel.add(contentItemPanel);
                        panel.add(Box.createRigidArea(new Dimension(0, 20))); 
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        panel.revalidate(); 
        panel.repaint();
    }

    
    
    
    
    
    
    
    
    
    
    //post and share
    
    private JPanel createPostDessertPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); 

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionTextArea = new JTextArea(4, 30);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

        uploadImageButton = new JButton("Upload Image");
        JButton postButton = new JButton("Post Dessert");
        JButton viewPostsButton = new JButton("View My Posts"); 

        panel.add(descriptionLabel);
        panel.add(scrollPane);
        panel.add(uploadImageButton);
        panel.add(postButton);
        panel.add(viewPostsButton); 

        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(null, "Image selected: " + selectedImageFile.getName());
                }
            }
        });

        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionTextArea.getText().trim();
                if (description.isEmpty() || selectedImageFile == null) {
                    JOptionPane.showMessageDialog(null, "Please provide a description and select an image.");
                    return;
                }

                saveDessertCreation(description, selectedImageFile);
                JOptionPane.showMessageDialog(null, "Dessert creation posted!");
            }
        });

        viewPostsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllUserPosts(); 
            }
        });

        return panel;
    }


    
    
    
    
    
   
    private void saveDessertCreation(String description, File imageFile) {
        String currentUsername = getCurrentUsername();
        String imagePath = imageFile.getAbsolutePath(); 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DESSERT_CREATIONS_FILE, true))) {
            // Format: username|imagePath|description
            writer.write(currentUsername + "|" + imagePath + "|" + description);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save dessert creation.");
        }
    }

    //post and share endddddddddddddddd
    
    
    
    public JPanel createExplorePurchasePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton purchaseFromStoreOwnerButton = new JButton("Purchase from Store Owner");

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Products:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(purchaseFromStoreOwnerButton);

        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane productScrollPane = new JScrollPane(productList);

        JCheckBox glutenFreeCheckbox = new JCheckBox("Gluten-Free");
        JCheckBox veganCheckbox = new JCheckBox("Vegan");
        JCheckBox nutFreeCheckbox = new JCheckBox("Nut-Free");
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter by:"));
        filterPanel.add(glutenFreeCheckbox);
        filterPanel.add(veganCheckbox);
        filterPanel.add(nutFreeCheckbox);

        //JButton purchaseButton = new JButton("Purchase Selected Product");

        // Load all products from file
        List<String> allProducts = loadProductsFromFile("products.txt");
        allProducts.forEach(productListModel::addElement);

        searchButton.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            boolean glutenFree = glutenFreeCheckbox.isSelected();
            boolean vegan = veganCheckbox.isSelected();
            boolean nutFree = nutFreeCheckbox.isSelected();

            List<String> filteredProducts = allProducts.stream()
                .filter(product -> product.toLowerCase().contains(query))
                .filter(product -> {
                    boolean matchesFilter = true;
                    if (glutenFree) {
                        matchesFilter = matchesFilter && product.toLowerCase().contains("gluten-free");
                    }
                    if (vegan) {
                        matchesFilter = matchesFilter && product.toLowerCase().contains("vegan");
                    }
                    if (nutFree) {
                        matchesFilter = matchesFilter && product.toLowerCase().contains("nut-free");
                    }
                    return matchesFilter;
                })
                .collect(Collectors.toList());

            productListModel.clear();
            filteredProducts.forEach(productListModel::addElement);
        });

       



        purchaseFromStoreOwnerButton.addActionListener(e -> {
            List<String> storeOwners = loadStoreOwnersFromFile("users.txt");
            String selectedStoreOwner = (String) JOptionPane.showInputDialog(
                    panel,
                    "Select a store owner to purchase from:",
                    "Select Store Owner",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    storeOwners.toArray(new String[0]),
                    storeOwners.get(0));

            if (selectedStoreOwner != null) {
                showProductsFrame(selectedStoreOwner);
            }
        });

        // Add components to the panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(productScrollPane, BorderLayout.CENTER);
        panel.add(filterPanel, BorderLayout.WEST);
      

        return panel;
    }

    

///from here
    private List<String> loadStoreOwnersFromFile(String fileName) {
        List<String> storeOwners = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5 && "STORE_OWNER".equalsIgnoreCase(parts[4].trim())) {
                    storeOwners.add(parts[0].trim()); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storeOwners;
    }
    //done
   

//done
 
    private void showProductsFrame(String storeOwnerName) {
        JFrame frame = new JFrame("Products from " + storeOwnerName);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane scrollPane = new JScrollPane(productList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load and filter products
        loadAndDisplayProducts(storeOwnerName, productListModel);

        // Panel for the purchase button
        JPanel buttonPanel = new JPanel();
        JButton purchaseButton = new JButton("Purchase");
        buttonPanel.add(purchaseButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        purchaseButton.addActionListener(e -> {
            String selectedProduct = productList.getSelectedValue();
            if (selectedProduct != null) {
                int confirm = JOptionPane.showConfirmDialog(panel,
                        "Are you sure you want to purchase: " + selectedProduct + "?",
                        "Confirm Purchase",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Save the purchase
                    savePurchaseToFile(selectedProduct, storeOwnerName);
                    JOptionPane.showMessageDialog(panel, "Purchase successful! You bought: " + selectedProduct);

                    // Assuming currentUser is a String containing the username
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Please select a product to purchase.");
            }
        });


        frame.add(panel);
        frame.setVisible(true);
    }

    private void savePurchaseToFile(String product, String storeOwnerName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("_purchases.txt", true))) {
            // Split the product string to separate the product details
            String[] productDetails = product.split(" - ");
            
            if (productDetails.length >= 3) {
                // Format: storeOwnerName | PurchaserName: Product: productName - Description: productDescription - Price: $price
                String purchaseEntry = String.format(
                    "%s | %s: Product: %s - Description: %s - Price: %s",
                    storeOwnerName,
                    currentUser,
                    productDetails[0].replace("Product: ", "").trim(),
                    productDetails[1].replace("Description: ", "").trim(),
                    productDetails[2].replace("Price: ", "").trim()
                );
                writer.write(purchaseEntry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    
    
    

    private void loadAndDisplayProducts(String storeOwnerName, DefaultListModel<String> productListModel) {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the format is "storeOwnerName| Product: ... - Description: ... - Price: $..."
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    String ownerName = parts[0].trim();
                    String productInfo = parts[1].trim();

                    if (ownerName.equals(storeOwnerName)) {
                        productListModel.addElement(productInfo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    

    private List<String> loadProductsFromFile(String fileName) {
        List<String> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                products.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    

    
    

   


    ////monday
    
    ////////////////////////////////////
    //////////////////////////////
    ///////////////////////////////////////
    //////////////////////////////////
    private JPanel createCommunicationFeedbackPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10)); 

        JButton communicationButton = new JButton("Communication");
        communicationButton.addActionListener(e -> {
            try {
                showCommunicationOptions();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error opening communication options: " + ex.getMessage(), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

      
        JButton feedbackButton = new JButton("Feedback");
        feedbackButton.addActionListener(e -> {
            try {
                showFeedbackOptionsFrame();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error opening feedback options: " + ex.getMessage(), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

     
        JButton receivedMessagesButton = new JButton("Show Received Messages");
        receivedMessagesButton.addActionListener(e -> {
            try {
                showReceivedMessages1(currentUser); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error showing received messages: " + ex.getMessage(), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        
        panel.add(communicationButton);
        panel.add(feedbackButton);
        panel.add(receivedMessagesButton); 

        return panel;
    }

    private void showReceivedMessages1(String username) {

        String filename = username + "_messages.txt";
        
        File file = new File(filename);
        
        
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "No messages found for " + username + ".", 
                                          "Messages", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        StringBuilder messages = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messages.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading messages: " + e.getMessage(), 
                                          "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
      
        JTextArea textArea = new JTextArea(messages.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        JOptionPane.showMessageDialog(null, scrollPane, "Received Messages", JOptionPane.INFORMATION_MESSAGE);
    }


    
    private void showFeedbackOptionsFrame() {
        JFrame feedbackOptionsFrame = new JFrame("Feedback Options");
        feedbackOptionsFrame.setSize(300, 150);
        feedbackOptionsFrame.setLocationRelativeTo(null);
        feedbackOptionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));

   
        JButton feedbackOnPurchasesButton = new JButton("Feedback on My Purchases");
        feedbackOnPurchasesButton.addActionListener(e -> {
            feedbackOptionsFrame.dispose(); 
            showFeedbackFrame();
        });

        JButton feedbackOnPostsButton = new JButton("Feedback on Posts");
        feedbackOnPostsButton.addActionListener(e -> {
            feedbackOptionsFrame.dispose(); 
            showFeedbackFrameForPosts ();
        });

        panel.add(feedbackOnPurchasesButton);
        panel.add(feedbackOnPostsButton);

        feedbackOptionsFrame.add(panel);
        feedbackOptionsFrame.setVisible(true);
    }
    
    /////////////////////////////////////////////////////////////////////////////////
    
//////wednesday
    private void showFeedbackFrameForPosts() {
        JFrame feedbackFrame = new JFrame("Provide Feedback on Shared Posts");
        feedbackFrame.setSize(600, 800);
        feedbackFrame.setLocationRelativeTo(null);
        feedbackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<Post> sharedPosts = loadSharedPosts();

        if (sharedPosts.isEmpty()) {
            JOptionPane.showMessageDialog(feedbackFrame, "No shared posts found.");
            feedbackFrame.dispose();
            return;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Post post : sharedPosts) {
            JPanel singlePostPanel = new JPanel(new BorderLayout());
            JLabel postLabel = new JLabel(post.getUsername() + ": " + post.getDescription());

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(post.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            JLabel imageLabel = new JLabel(imageIcon);

            
            JTextArea feedbackArea = new JTextArea(3, 20);
            feedbackArea.setWrapStyleWord(true);
            feedbackArea.setLineWrap(true);
            JScrollPane feedbackScrollPane = new JScrollPane(feedbackArea);
            feedbackScrollPane.setPreferredSize(new Dimension(550, 50));

            JButton saveFeedbackButton = new JButton("Save Feedback");

            saveFeedbackButton.addActionListener(e -> {
                String feedback = feedbackArea.getText().trim();
                if (!feedback.isEmpty()) {
                    saveFeedbackpostToFile(currentUser, post.getDescription(), feedback);
                    JOptionPane.showMessageDialog(feedbackFrame, "Thank you for your feedback on " + post.getUsername() + "'s post!");
                    feedbackArea.setText(""); 
                } else {
                    JOptionPane.showMessageDialog(feedbackFrame, "Feedback cannot be empty.");
                }
            });

           
            singlePostPanel.add(imageLabel, BorderLayout.WEST);
            singlePostPanel.add(postLabel, BorderLayout.CENTER);
            singlePostPanel.add(feedbackScrollPane, BorderLayout.SOUTH);
            singlePostPanel.add(saveFeedbackButton, BorderLayout.EAST);

            panel.add(singlePostPanel);
            panel.add(Box.createVerticalStrut(10)); 
        }

        JScrollPane panelScrollPane = new JScrollPane(panel);
        panelScrollPane.setPreferredSize(new Dimension(580, 750));

        feedbackFrame.add(panelScrollPane);
        feedbackFrame.setVisible(true);
    }




    private List<Post> loadSharedPosts() {
        List<Post> sharedPosts = new ArrayList<>();
        String filePath = "dessert_creations.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
              
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String imagePath = parts[1].trim();
                    String postText = parts[2].trim();
                    sharedPosts.add(new Post(username, imagePath, postText));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading shared posts data.");
        }

        return sharedPosts;
    }

    private void saveFeedbackpostToFile(String feedbackGiver, String originalPostText, String feedbackContent) {
        try (FileWriter writer = new FileWriter("postsfeedback.txt", true)) {
            String[] postDetails = originalPostText.split(":", 2);
            String feedbackReceiver = postDetails[0]; 

            
            String feedbackEntry = String.format("%s: gave feedback on post by %s - \"%s\"%n", feedbackGiver, feedbackReceiver, feedbackContent);

            writer.write(feedbackEntry);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while saving feedback.");
        }
    }


    
    ///////
    //////end feedback
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 

    private void showCommunicationOptions() {
    	String currentUserName = currentUser; 
        JFrame communicationFrame = new JFrame("Communication Options");
        communicationFrame.setSize(600, 400);
        communicationFrame.setLocationRelativeTo(null);
        communicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      
        JLabel titleLabel = new JLabel("Choose an Option to Communicate", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        
        List<String> storeOwners = new ArrayList<>();
        List<String> suppliers = new ArrayList<>();
        loadUsers(storeOwners, suppliers);

       
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        
        JList<String> ownersList = new JList<>(storeOwners.toArray(new String[0]));
        ownersList.setBorder(BorderFactory.createTitledBorder("Store Owners"));
        JScrollPane ownersScrollPane = new JScrollPane(ownersList);

        JList<String> suppliersList = new JList<>(suppliers.toArray(new String[0]));
        suppliersList.setBorder(BorderFactory.createTitledBorder("Suppliers"));
        JScrollPane suppliersScrollPane = new JScrollPane(suppliersList);

       
        JTextArea messageArea = new JTextArea(5, 20);
        messageArea.setBorder(BorderFactory.createTitledBorder("Write your message here"));
        messageArea.setWrapStyleWord(true);
        messageArea.setLineWrap(true);

        
        JPanel southPanel = new JPanel(new BorderLayout(10, 10));
        southPanel.add(new JScrollPane(messageArea), BorderLayout.CENTER);

        JButton communicateWithOwnerButton = new JButton("Communicate with Store Owner");
        communicateWithOwnerButton.addActionListener(e -> communicateWithSelectedUser(ownersList, messageArea, currentUserName));

        JButton communicateWithSupplierButton = new JButton("Communicate with Supplier");
        communicateWithSupplierButton.addActionListener(e -> communicateWithSelectedUser(suppliersList, messageArea, currentUserName));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(communicateWithOwnerButton);
        buttonPanel.add(communicateWithSupplierButton);

    
        southPanel.add(buttonPanel, BorderLayout.SOUTH);

        
        centerPanel.add(ownersScrollPane);
        centerPanel.add(suppliersScrollPane);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

      
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> communicationFrame.dispose());
        closePanel.add(closeButton);
        mainPanel.add(closePanel, BorderLayout.NORTH);

        communicationFrame.add(mainPanel);
        communicationFrame.setVisible(true);
    }


    
    private void communicateWithSelectedUser(JList<String> userList, JTextArea messageArea, String sender) {
        String selectedUser = userList.getSelectedValue();
        String message = messageArea.getText();

        if (selectedUser != null && !message.isEmpty()) {
            saveMessageToFile(selectedUser, sender, message);
            messageArea.setText("");
            JOptionPane.showMessageDialog(null, "Message sent to " + selectedUser + ":\n" + message);
        } else if (selectedUser == null) {
            JOptionPane.showMessageDialog(null, "Please select a user to communicate with.");
        } else if (message.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please write a message before sending.");
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    //friday
    private void saveMessageToFile(String recipient, String sender, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(recipient + "_messages.txt", true))) {
            writer.write("From: " + sender + " - Message: " + message);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Message saved to " + recipient + "_messages.txt");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving message to file.");
        }
    }
//friday
   



// Method to load users from the file and filter them into store owners and suppliers
private void loadUsers(List<String> storeOwners, List<String> suppliers) {
    try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userDetails = line.split(",");
            
            // Ensure that the array has at least 5 elements before accessing them
            if (userDetails.length >= 5) {
                String username = userDetails[0];
                String role = userDetails[4].trim();

                if ("STORE_OWNER".equals(role)) {
                    storeOwners.add(username);
                } else if ("SUPPLIER".equals(role)) {
                    suppliers.add(username);
                }
            } else {
                System.out.println("Skipping improperly formatted line: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading users from file.");
    }
}




    // Method to show the feedback frame
    private void showFeedbackFrame() {
        JFrame feedbackFrame = new JFrame("Provide Feedback");
        feedbackFrame.setSize(400, 300);
        feedbackFrame.setLocationRelativeTo(null);
        feedbackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<String> purchasedProducts = loadPurchasedProducts(currentUser);

        if (purchasedProducts.isEmpty()) {
            JOptionPane.showMessageDialog(feedbackFrame, "No purchased products found.");
            feedbackFrame.dispose();
            return;
        }

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JComboBox<String> productComboBox = new JComboBox<>(purchasedProducts.toArray(new String[0]));
        JTextArea feedbackArea = new JTextArea(5, 20);
        feedbackArea.setWrapStyleWord(true);
        feedbackArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        JButton submitFeedbackButton = new JButton("Submit Feedback");

        submitFeedbackButton.addActionListener(e -> {
            String selectedProduct = (String) productComboBox.getSelectedItem();
            String feedback = feedbackArea.getText().trim();
            if (!feedback.isEmpty()) {
            	saveFeedbackToFile(currentUser, selectedProduct, feedback);
                JOptionPane.showMessageDialog(feedbackFrame, "Thank you for your feedback!");
                feedbackFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(feedbackFrame, "Feedback cannot be empty.");
            }
        });

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Select a product:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(productComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(scrollPane, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitFeedbackButton, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        feedbackFrame.add(panel);
        feedbackFrame.setVisible(true);
    }

    // Placeholder methods for feedback functionality
    private List<String> loadPurchasedProducts(String username) {
        List<String> purchasedProducts = new ArrayList<>();
        String filePath = "_Purchases.txt"; // File where purchase data is stored

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(username + ":")) {  // Check if the line starts with the given username
                    String product = line.substring(line.indexOf(":") + 1).trim(); // Extract the product details
                    purchasedProducts.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading purchase data.");
        }

        return purchasedProducts;
    }

    private void saveFeedbackToFile(String username, String productName, String feedback) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            writer.write(username +"|" + productName +"|" + feedback);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    ////////////////feedback on shared post 
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    public void signUpUser(String username, String password, String email, String country, UserRole role) {
        if (!userExists(username)) {
            users.put(username, new User(username, password, email, country, role));
            saveUsers(); 
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    
 

    public User getUser(String username) {
        return users.get(username);
    }
    public boolean addUser(User user) {
        if (userExists(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    
       // saveUsers();
        
        
    }
// read  users from file
    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String username = parts[0];
                    String password = parts[1];
                    String email = parts[2];
                    String country = parts[3];
                    UserRole role = UserRole.valueOf(parts[4]);
                    users.put(username, new User(username, password, email, country, role));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getCountry() + "," + user.getRole());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyApplication());
       
    }
    */
    public void signUpUser(String username, String password, String email, String country, UserRole role) {
        if (!userExists(username)) {
            users.put(username, new User(username, password, email, country, role));
            //saveUsers(); 
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    
 

    public User getUser(String username) {
        return users.get(username);
    }
    public boolean addUser(User user) {
        if (userExists(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    
       // saveUsers();
        
        
    }
    
}
