package Mysweetsystem2024;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyApplication {
    private Map<String, User> users;
    private LoginManager loginManager;
    private static final String FILE_PATH = "users.txt";
    
    private static final String DESSERT_CREATIONS_FILE = "dessert_creations.txt";
    private static final String IMAGES_DIR = "images/";
    
    private JTextArea descriptionTextArea;
    private JButton uploadImageButton;
    private File selectedImageFile;
    
    private String currentUser; // Variable to store the current user

    //public MyApplication(String currentUser) {
      //  this.currentUser = currentUser; // Initialize current user
    //}
    
    
    
    

    public MyApplication() {
        users = new HashMap<>();
        loginManager = new LoginManager(users);
        loadUserData();
        showLoginFrame();
    }

    private void initializeUsers() {
        // Add users to the application
        users.put("nuha", new User("nuha", "111111", "nuha@gmail.com", "Nablus", UserRole.REGULAR_USER));
        users.put("shahd", new User("shahd", "222222", "shahd@gmail.com", "Nablus", UserRole.ADMIN));
        users.put("hala", new User("hala", "333333", "hala@gmail.com", "Jenin", UserRole.STORE_OWNER));
        users.put("safaa", new User("safaa", "444444", "safa@gmail.com", "Tulkerem", UserRole.SUPPLIER));
        saveUsers();
    }
//log in
    
    private void showLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(600, 500);
        loginFrame.setLayout(new GridLayout(5, 2)); // Adjust the grid layout to 5 rows, 2 columns
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null); // Center the frame

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        
        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"REGULAR_USER", "ADMIN", "STORE_OWNER", "SUPPLIER"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles); // Create the JComboBox

        JButton loginButton = new JButton("Log In");
        JButton signUpButton = new JButton("Sign Up");

        // Add components to the frame
        loginFrame.add(userLabel);
        loginFrame.add(userText);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordText);
        loginFrame.add(roleLabel);
        loginFrame.add(roleComboBox); // Add the JComboBox to the frame
        loginFrame.add(loginButton);
        loginFrame.add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String selectedRole = (String) roleComboBox.getSelectedItem(); // Get the selected role

                if (loginManager.login(username, password)) {
                	 currentUser= username; 
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
                            	 showStoreOwnerDashboard ();
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

//sign up up up up up up up up up up up 
    private void showSignUpFrame() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(400, 300);
        signUpFrame.setLayout(new GridLayout(6, 2));
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setLocationRelativeTo(null); // Center the frame

        JLabel nameLabel = new JLabel("Username:");
        JTextField nameText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailText = new JTextField();
        JLabel countryLabel = new JLabel("City:");
        JTextField countryText = new JTextField();
        JLabel roleLabel = new JLabel("Role:");
        JComboBox<UserRole> roleComboBox = new JComboBox<>(UserRole.values());
        JButton signUpButton = new JButton("Sign Up");

        signUpFrame.add(nameLabel);
        signUpFrame.add(nameText);
        signUpFrame.add(passwordLabel);
        signUpFrame.add(passwordText);
        signUpFrame.add(emailLabel);
        signUpFrame.add(emailText);
        signUpFrame.add(countryLabel);
        signUpFrame.add(countryText);
        signUpFrame.add(roleLabel);
        signUpFrame.add(roleComboBox);
        signUpFrame.add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameText.getText();
                String password = new String(passwordText.getPassword());
                String email = emailText.getText();
                String City = countryText.getText();
                UserRole role = (UserRole) roleComboBox.getSelectedItem();

                if (!userExists(username)) {
                    signUpUser(username, password, email, City, role);
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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking

        // Panel for user addition
        JPanel addPanel = new JPanel();
        addPanel.setBorder(BorderFactory.createTitledBorder("Add User"));
        addPanel.setLayout(new GridLayout(7, 2)); // Use GridLayout for organized input fields

        JTextField nameField = new JTextField();
        
        JTextField emailField = new JTextField();
        JTextField countryField = new JTextField();
        
        JTextField roleField = new JTextField();
        JPasswordField passwordField = new JPasswordField(); // Added password field

        addPanel.add(new JLabel("Name:"));
        addPanel.add(nameField);
        addPanel.add(new JLabel("Password:")); // Added password label
        addPanel.add(passwordField); // Added password field
       ;
        addPanel.add(new JLabel("Email:"));
        addPanel.add(emailField);
        addPanel.add(new JLabel("City:"));
        addPanel.add(countryField);
        addPanel.add(new JLabel("Role:"));
        addPanel.add(roleField);

        JButton addButton = new JButton("Add User");
        addPanel.add(addButton);

        // Panel for user deletion
        JPanel deletePanel = new JPanel();
        deletePanel.setBorder(BorderFactory.createTitledBorder("Delete User"));
        deletePanel.setLayout(new GridLayout(2, 2));

        JTextField deleteNameField = new JTextField();

        deletePanel.add(new JLabel("Name:"));
        deletePanel.add(deleteNameField);

        JButton deleteButton = new JButton("Delete User");
        deletePanel.add(deleteButton);

        // Panel for user updating
        JPanel updatePanel = new JPanel();
        updatePanel.setBorder(BorderFactory.createTitledBorder("Update User"));
        updatePanel.setLayout(new GridLayout(8, 2)); // Adjust GridLayout to accommodate new fields

        JTextField updateNameField = new JTextField();
       
        JTextField updateEmailField = new JTextField();
        JTextField updateCountryField = new JTextField();
        JTextField updateRoleField = new JTextField();
        JPasswordField updatePasswordField = new JPasswordField(); // Added password field

        updatePanel.add(new JLabel("Name:"));
        updatePanel.add(updateNameField);
        updatePanel.add(new JLabel("Password:")); // Added password label
        updatePanel.add(updatePasswordField); // Added password field
      
        updatePanel.add(new JLabel("Email:"));
        updatePanel.add(updateEmailField);
        updatePanel.add(new JLabel("City:"));
        updatePanel.add(updateCountryField);
        updatePanel.add(new JLabel("Role:"));
        updatePanel.add(updateRoleField);

        JButton updateButton = new JButton("Update User");
        updatePanel.add(updateButton);

        // Add panels to the main panel
        panel.add(addPanel);
        panel.add(deletePanel);
        panel.add(updatePanel);

     // Action listeners for buttons
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String password = new String(passwordField.getPassword()); // Get password from JPasswordField
            String email = emailField.getText();
            String country = countryField.getText();
            String roleString = roleField.getText();

            System.out.println("Name: " + name);
            System.out.println("City: " + country);
            System.out.println("Email: " + email);
            System.out.println("Role: " + roleString);

            // Convert roleString to UserRole
            UserRole role;
            try {
                role = UserRole.fromString(roleString);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid role specified.");
                return;
            }

            User newUser = new User(name, password, email, country, role);
            System.out.println("New User: " + newUser.getUsername() + ", " + newUser.getPassword() + ", " + newUser.getEmail() + ", " + newUser.getCountry() + ", " + newUser.getRole().name());

            users.put(name, newUser);
            saveUsers(); // Save users to file

            JOptionPane.showMessageDialog(panel, "User added successfully."); // Confirmation message
        });

        deleteButton.addActionListener(e -> {
            String name = deleteNameField.getText();
            if (users.containsKey(name)) {
                users.remove(name); // Remove user from in-memory collection
                saveUsers(); // Save users to file
                JOptionPane.showMessageDialog(panel, "User deleted successfully."); // Confirmation message
            } else {
                JOptionPane.showMessageDialog(panel, "User not found."); // Error message
            }
        });

        updateButton.addActionListener(e -> {
            String name = updateNameField.getText();
            String newPassword = new String(updatePasswordField.getPassword()); // Get password from JPasswordField
            String newCountry = updateCountryField.getText();
            String newEmail = updateEmailField.getText();
            String newRoleString = updateRoleField.getText();

            // Convert newRoleString to UserRole
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
                users.put(name, updatedUser); // Update user in the in-memory collection
                saveUsers(); // Save users to file
                JOptionPane.showMessageDialog(panel, "User updated successfully."); // Confirmation message
            } else {
                JOptionPane.showMessageDialog(panel, "User not found."); // Error message
            }
        });

        return panel;

    }

    private JPanel createMonitoringReportingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create title label
        JLabel titleLabel = new JLabel("Monitoring and Reporting", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Main content panel
        JPanel contentPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        // Profits and Financial Reports Section
        JPanel profitsPanel = new JPanel(new BorderLayout());
        profitsPanel.setBorder(BorderFactory.createTitledBorder("Profits and Financial Reports"));

        JTextArea profitsReport = new JTextArea(10, 40);
        profitsReport.setEditable(false);
        profitsReport.setText(generateFinancialReport()); // Replace with actual data
        JScrollPane profitsScrollPane = new JScrollPane(profitsReport);
        profitsPanel.add(profitsScrollPane, BorderLayout.CENTER);

        contentPanel.add(profitsPanel);

        // Best-Selling Products Section
        JPanel bestSellingPanel = new JPanel(new BorderLayout());
        bestSellingPanel.setBorder(BorderFactory.createTitledBorder("Best-Selling Products by Store"));

        JTextArea bestSellingReport = new JTextArea(10, 40);
        bestSellingReport.setEditable(false);
        bestSellingReport.setText(getBestSellingProductsReport()); // Replace with actual data
        JScrollPane bestSellingScrollPane = new JScrollPane(bestSellingReport);
        bestSellingPanel.add(bestSellingScrollPane, BorderLayout.CENTER);

        contentPanel.add(bestSellingPanel);

        // User Statistics by City Section
        JPanel userStatsPanel = new JPanel(new BorderLayout());
        userStatsPanel.setBorder(BorderFactory.createTitledBorder("User Statistics by City"));

        JTextArea userStatsReport = new JTextArea(10, 40);
        userStatsReport.setEditable(false);
        userStatsReport.setText(getUserStatisticsByCity()); // Replace with actual data
        JScrollPane userStatsScrollPane = new JScrollPane(userStatsReport);
        userStatsPanel.add(userStatsScrollPane, BorderLayout.CENTER);

        contentPanel.add(userStatsPanel);

        // Add the content panel to the main panel
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    
    
    private String generateFinancialReport() {
        double totalProfits = 0.0;
        Map<String, Double> storeProfits = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("_Purchases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length < 3) continue;
                
                String productEntry = parts[0];
                double price = Double.parseDouble(parts[2].replace("$", ""));
                
                String storeOwner = "Selen"; // Default if no owner specified///fix it shahd
                if (productEntry.contains(":")) {
                    String[] ownerProduct = productEntry.split(":");
                    storeOwner = ownerProduct[0].trim();
                }
                
                totalProfits += price;
                storeProfits.put(storeOwner, storeProfits.getOrDefault(storeOwner, 0.0) + price);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error generating financial report.";
        }

        StringBuilder report = new StringBuilder();
        report.append("Total Profits: $").append(totalProfits).append("\n\n");
        
        for (Map.Entry<String, Double> entry : storeProfits.entrySet()) {
            report.append("User: ").append(entry.getKey()).append(" - Profits: $").append(entry.getValue()).append("\n");
        }
        
        return report.toString();
    }

    private String getBestSellingProductsReport() {
        Map<String, Integer> productSales = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("_Purchases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length < 2) continue;
                
                String productEntry = parts[0];
                String productName = productEntry.contains(":") ? productEntry.split(":")[1].trim() : productEntry.trim();
                
                productSales.put(productName, productSales.getOrDefault(productName, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error generating best-selling products report.";
        }
        
        StringBuilder report = new StringBuilder();
        productSales.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort by sales descending
            .forEach(entry -> report.append("Product: ").append(entry.getKey())
                    .append(" - Sales: ").append(entry.getValue()).append("\n"));
        
        return report.toString();
    }

    private String getUserStatisticsByCity() {
        Map<String, Integer> cityUserStats = new HashMap<>(); // Maps cities to user counts

        // Load user-city mapping and count REGULAR_USERs per city
        try (BufferedReader userReader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = userReader.readLine()) != null) {
                String[] userParts = line.split(",");
                if (userParts.length < 5) continue; // Ensure there's enough data

                String city = userParts[2].trim();
                String role = userParts[4].trim();

                // Count only REGULAR_USERs
                if (role.equals("REGULAR_USER")) {
                    cityUserStats.put(city, cityUserStats.getOrDefault(city, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading user data.";
        }

        // Generate report
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
            // Implement logic to go back to the previous panel
            // For example, switch back to the admin dashboard
            showAdminDashboard(); // Replace with the actual method to show the admin dashboard
        });

        panel.add(managePostsButton);
        panel.add(manageFeedbackButton);
        panel.add(backButton);

        return panel;
    }
    
    
    private void showManagePostsFrame() {
        JFrame postsFrame = new JFrame("Manage Posts");
        postsFrame.setSize(800, 400);  // زيادة عرض الإطار لاستيعاب الأزرار
        postsFrame.setLocationRelativeTo(null); // Center the frame
        postsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel<JPanel> postListModel = new DefaultListModel<>();
        JList<JPanel> postList = new JList<>(postListModel);
        postList.setCellRenderer(new ListCellRenderer<JPanel>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                return value;
            }
        });

        JScrollPane scrollPane = new JScrollPane(postList);

        try (BufferedReader reader = new BufferedReader(new FileReader("dessert_creations.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the format is "username|path/to/image.jpg|description"
                String[] parts = line.split("\\|", 3);
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String imagePath = parts[1].trim();
                    String description = parts[2].trim();
                    
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    if (imageIcon.getIconWidth() == -1) {
                        System.out.println("Failed to load image: " + imagePath);
                        continue; // Skip if the image can't be loaded
                    }

                    // Create a JPanel to hold the image, description, and buttons
                    JPanel postPanel = new JPanel(new BorderLayout());

                    JLabel imageLabel = new JLabel("<html><b>" + username + ":</b> " + description + "</html>", imageIcon, JLabel.LEFT);
                    postPanel.add(imageLabel, BorderLayout.CENTER);

                    // Create the buttons panel
                    JPanel buttonPanel = new JPanel();
                    JButton editButton = new JButton("Edit");
                    JButton deleteButton = new JButton("Delete");

                    // Action listener for the delete button
                    deleteButton.addActionListener(e -> {
                        postListModel.removeElement(postPanel); // Remove from the list
                        deletePostFromFile(username, imagePath, description); // Custom method to delete the post from the file
                    });

                    // Action listener for the edit button
                    editButton.addActionListener(e -> {
                        editPost(username, imagePath, description); // Custom method to edit the post
                    });

                    buttonPanel.add(editButton);
                    buttonPanel.add(deleteButton);

                    postPanel.add(buttonPanel, BorderLayout.EAST);
                    postListModel.addElement(postPanel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(postsFrame, "Error loading posts.");
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> postsFrame.dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        postsFrame.add(panel);
        postsFrame.setVisible(true);
    }

    // Method to delete the post from the file
    private void deletePostFromFile(String username, String imagePath, String description) {
        // Implement logic to remove the line from the file 'dessert_creations.txt'
        // You may read all lines, remove the specific line, then write back the remaining lines.
    }

    // Method to edit the post
    private void editPost(String username, String imagePath, String description) {
        // Implement logic to allow the user to edit the post details
        // For example, open a dialog with fields pre-filled with the current post details, then save the changes.
    }


    private void showManageFeedbackFrame() {
        JFrame feedbackFrame = new JFrame("Manage Feedback");
        feedbackFrame.setSize(600, 400);
        feedbackFrame.setLocationRelativeTo(null); // Center the frame
        feedbackFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel<String> feedbackListModel = new DefaultListModel<>();
        JList<String> feedbackList = new JList<>(feedbackListModel);
        JScrollPane scrollPane = new JScrollPane(feedbackList);

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                feedbackListModel.addElement(line); // Assuming feedback file contains lines with "username: feedback"
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(feedbackFrame, "Error loading feedback.");
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> feedbackFrame.dispose());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        feedbackFrame.add(panel);
        feedbackFrame.setVisible(true);
    }
///////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    
    
    
    

    
    
    
//////////////////Store ownerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
    private void showStoreOwnerDashboard() {
        JFrame frame = new JFrame("Store Owner Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Product Management", createProductManagementPanel());
        tabbedPane.addTab("Sales & Profits", createSalesProfitsPanel());
        tabbedPane.addTab("Communication & Notifications", createCommunicationNotificationPanel());
        tabbedPane.addTab("Account Management", createAccountManagementPanel());
        tabbedPane.addTab("Order Management", createOrderManagementPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    
    
    
    
    private JPanel createCommunicationNotificationPanel() {
        JPanel panel = new JPanel();
        // Add components for communication and feedback
        return panel;
    }

    private JPanel createOrderManagementPanel() {
        JPanel panel = new JPanel();
        // Add components for communication and feedback
        return panel;
    }

    
    
    
    
    private JPanel createProductManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Top section: Add new product
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
        addProductPanel.add(new JLabel());
        addProductPanel.add(addButton);

        // Center section: Product list
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane productScrollPane = new JScrollPane(productList);
        
        loadProductsFromFile(productListModel);

        // Bottom section: Buttons for update and delete
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Update Product");
        JButton deleteButton = new JButton("Delete Product");
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        panel.add(addProductPanel, BorderLayout.NORTH);
        panel.add(productScrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Action for adding product
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
                    String productString = productName + " - " + productDescription + " - $" + productPrice;
                    productListModel.addElement(productString);
                    
                    saveProductsToFile(productListModel);
                    JOptionPane.showMessageDialog(panel, "Product added successfully.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please fill all fields.");
                }
            }
        });

        // Action for updating product
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String product = productListModel.getElementAt(selectedIndex);
                    String[] parts = product.split(" - ");
                    nameField.setText(parts[0]);
                    descriptionField.setText(parts[1]);
                    priceField.setText(parts[2].substring(1));
                    productListModel.remove(selectedIndex);
                    
                    JOptionPane.showMessageDialog(panel, "Product updated. Please re-add with new details.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a product to update.");
                }
            }
        });

        // Action for deleting product
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    productListModel.remove(selectedIndex);
                    saveProductsToFile(productListModel);
                    JOptionPane.showMessageDialog(panel, "Product deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a product to delete.");
                }
            }
        });

        return panel;
    }

    
    ///hi shahd sha test test 
    
    
    ///////////////////monday 12/8/202444444444444444444444444444444444444444///////////////////
    private JPanel createSalesProfitsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create components for monitoring sales and profits
        JPanel salesProfitsPanel = new JPanel();
        salesProfitsPanel.setLayout(new GridLayout(2, 2)); // Grid layout for sales and profits

        JLabel totalSalesLabel = new JLabel("Total Sales:");
        JLabel totalSalesValue = new JLabel("$0.00"); // Placeholder for total sales value
        JLabel totalProfitsLabel = new JLabel("Total Profits:");
        JLabel totalProfitsValue = new JLabel("$0.00"); // Placeholder for total profits value

        salesProfitsPanel.add(totalSalesLabel);
        salesProfitsPanel.add(totalSalesValue);
        salesProfitsPanel.add(totalProfitsLabel);
        salesProfitsPanel.add(totalProfitsValue);

        // Create components for identifying best-selling products
        JPanel bestSellingPanel = new JPanel();
        bestSellingPanel.setLayout(new BorderLayout());

        JLabel bestSellingLabel = new JLabel("Best-Selling Products:");
        DefaultListModel<String> bestSellingListModel = new DefaultListModel<>();
        JList<String> bestSellingList = new JList<>(bestSellingListModel);
        JScrollPane bestSellingScrollPane = new JScrollPane(bestSellingList);

        bestSellingPanel.add(bestSellingLabel, BorderLayout.NORTH);
        bestSellingPanel.add(bestSellingScrollPane, BorderLayout.CENTER);

        // Create components for dynamic discount features
        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(new GridLayout(3, 2)); // Grid layout for discount controls

        JLabel discountLabel = new JLabel("Apply Discount (%):");
        JTextField discountField = new JTextField();
        JButton applyDiscountButton = new JButton("Apply Discount");

        discountPanel.add(discountLabel);
        discountPanel.add(discountField);
        discountPanel.add(new JLabel()); // Empty label for alignment
        discountPanel.add(applyDiscountButton);

        // Add action listener for the apply discount button
        applyDiscountButton.addActionListener(e -> {
            try {
                double discountPercentage = Double.parseDouble(discountField.getText());
                if (discountPercentage < 0 || discountPercentage > 100) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid discount percentage (0-100).");
                } else {
                    applyDiscount(discountPercentage);
                    JOptionPane.showMessageDialog(panel, "Discount of " + discountPercentage + "% applied successfully.");
                    // Update sales and profits after discount
                    updateSalesAndProfits(totalSalesValue, totalProfitsValue);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please enter a valid number.");
            }
        });

        // Add components to the main panel
        panel.add(salesProfitsPanel, BorderLayout.NORTH);
        panel.add(bestSellingPanel, BorderLayout.CENTER);
        panel.add(discountPanel, BorderLayout.SOUTH);

        // Initial calculation of sales, profits, and best-selling products
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
                    String priceStr = parts[2].replace("$", "");
                    double price = Double.parseDouble(priceStr);

                    // Assuming cost price is available; if not, use a default profit margin.
                    double costPrice = price * 0.7; // Example: 70% of selling price is cost
                    totalSales += price;
                    totalProfits += (price - costPrice);
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

        // Sort products by sales count
        List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<>(productSalesCount.entrySet());
        sortedProducts.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        bestSellingListModel.clear();
        for (Map.Entry<String, Integer> entry : sortedProducts) {
            bestSellingListModel.addElement(entry.getKey() + " - " + entry.getValue() + " sales");
        }
    }

    private void applyDiscount(double discountPercentage) {
        List<String> discountedProducts = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("_Purchases.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("_Purchases_tmp.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length >= 3) {
                    String productName = parts[0];
                    String description = parts[1];
                    double price = Double.parseDouble(parts[2].replace("$", ""));

                    double discountedPrice = price * (1 - discountPercentage / 100);
                    String discountedProductLine = productName + " - " + description + " - $" + String.format("%.2f", discountedPrice);
                    discountedProducts.add(discountedProductLine);
                    
                    writer.write(discountedProductLine + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Replace the original file with the updated file
        new File("_Purchases.txt").delete();
        new File("_Purchases_tmp.txt").renameTo(new File("_Purchases.txt"));

        // Show the discounted products in a new frame
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
    
    
    
    private void saveProductsToFile(DefaultListModel<String> productListModel) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Product.txt"))) {
            for (int i = 0; i < productListModel.size(); i++) {
                String productString = productListModel.get(i);
                writer.write(productString);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProductsFromFile(DefaultListModel<String> productListModel) {
        File file = new File("Product.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    productListModel.addElement(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

  
    
    ///////////////////////////////end Store Owner
    
//////////USER USER  USER USER USER USER
    private void showBeneficiaryUserDashboard() {
        // Implementation specific to the Beneficiary User Dashboard
        // You can use the `showMainFrame` method if it meets the needs of this dashboard
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

        // Create a tabbed pane for account management features
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel for managing account details
        JPanel accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridLayout(6, 2, 10, 10));
        
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        
        JLabel countryLabel = new JLabel("Country:");
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
        accountDetailsPanel.add(new JLabel()); // Empty cell
        accountDetailsPanel.add(updateButton);

        // Action for the update button
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
                    saveUsers();  // Ensure this method correctly saves the updated user details
                    JOptionPane.showMessageDialog(panel, "Details updated successfully.");
                } else {
                    System.out.println("User not found.");
                    JOptionPane.showMessageDialog(panel, "User not found.");
                }
            }
        });

        
        
    
        JPanel postDessertPanel = createPostDessertPanel();

        // Add tabs to the JTabbedPane
        tabbedPane.addTab("Account Details", accountDetailsPanel);
       // tabbedPane.addTab("View My Posts", viewMyPostsPanel);
        tabbedPane.addTab("Post Dessert", postDessertPanel);

        panel.add(tabbedPane, BorderLayout.CENTER);

        return panel;
    }
        
    
    private String getCurrentUsername() {
        // Implement logic to retrieve the currently logged-in username
        // Placeholder implementation:
        return currentUser; // Replace with actual logic
    }
    
    
    
    
    
    
    
    private String loadUserPosts(String username) {
        StringBuilder posts = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(DESSERT_CREATIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(username + ":")) {
                    // Assuming the format is username:imagePath:description
                    String[] parts = line.split(":");
                    if (parts.length >= 3) {
                        String imagePath = parts[1];
                        String description = parts[2];
                        posts.append("Description: ").append(description).append("\n");
                        posts.append("Image: ").append(imagePath).append("\n\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts.toString();
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
        panel.removeAll(); // Clear existing content

        try (BufferedReader reader = new BufferedReader(new FileReader(DESSERT_CREATIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) { // Ensure the line has the correct format
                    String postUsername = parts[0];
                    String imagePath = parts[1];
                    String description = parts[2];

                    if (postUsername.equals(username)) {
                        JPanel contentItemPanel = new JPanel();
                        contentItemPanel.setLayout(new BoxLayout(contentItemPanel, BoxLayout.Y_AXIS));
                        contentItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around each item

                        JLabel descriptionLabel = new JLabel("Description: " + description);
                        contentItemPanel.add(descriptionLabel);

                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        Image image = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                        JLabel imageLabel = new JLabel(new ImageIcon(image));
                        contentItemPanel.add(imageLabel);

                        panel.add(contentItemPanel);
                        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Space between items
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions
        }

        panel.revalidate(); // Refresh the panel to show new content
        panel.repaint();
    }

    
    
    
    
    
    
    
    
    
    
    //post and share
    
    private JPanel createPostDessertPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // Adjusted GridLayout for the additional button

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionTextArea = new JTextArea(4, 30);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

        uploadImageButton = new JButton("Upload Image");
        JButton postButton = new JButton("Post Dessert");
        JButton viewPostsButton = new JButton("View My Posts"); // Added button to view posts

        panel.add(descriptionLabel);
        panel.add(scrollPane);
        panel.add(uploadImageButton);
        panel.add(postButton);
        panel.add(viewPostsButton); // Added button to panel

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
                showAllUserPosts(); // Call the method to show user posts
            }
        });

        return panel;
    }


    
    
    
    
    
   
    private void saveDessertCreation(String description, File imageFile) {
        String currentUsername = getCurrentUsername();
        String imagePath = imageFile.getAbsolutePath(); // Store the full path of the image

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

        // Create components for browsing and searching products
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton purchaseFromStoreOwnerButton = new JButton("Purchase from Store Owner");

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Products:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(purchaseFromStoreOwnerButton);

        // Create a list to display the search results (products)
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane productScrollPane = new JScrollPane(productList);

        // Create components for filtering based on dietary needs or food allergies
        JCheckBox glutenFreeCheckbox = new JCheckBox("Gluten-Free");
        JCheckBox veganCheckbox = new JCheckBox("Vegan");
        JCheckBox nutFreeCheckbox = new JCheckBox("Nut-Free");
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter by:"));
        filterPanel.add(glutenFreeCheckbox);
        filterPanel.add(veganCheckbox);
        filterPanel.add(nutFreeCheckbox);

        // Create a button to show available products for purchase
        JButton purchaseButton = new JButton("Purchase Selected Product");

        // Load all products from the file initially
        List<String> allProducts = loadProductsFromFile("Product.txt");
        allProducts.forEach(productListModel::addElement);

        // Add action listener for the search button
        searchButton.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            boolean glutenFree = glutenFreeCheckbox.isSelected();
            boolean vegan = veganCheckbox.isSelected();
            boolean nutFree = nutFreeCheckbox.isSelected();

            // Filter products based on search query and selected filters
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

            // Update the list model with filtered products
            productListModel.clear();
            filteredProducts.forEach(productListModel::addElement);
        });

        // Add action listener for the purchase button
        purchaseButton.addActionListener(e -> {
            String selectedProduct = productList.getSelectedValue();
            if (selectedProduct != null) {
                int confirm = JOptionPane.showConfirmDialog(panel,
                        "Are you sure you want to purchase: " + selectedProduct + "?",
                        "Confirm Purchase",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Simulate purchase logic (e.g., update inventory, deduct balance)
                    savePurchaseToFile(selectedProduct);
                    JOptionPane.showMessageDialog(panel, "Purchase successful! You bought: " + selectedProduct);
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Please select a product to purchase.");
            }
        });

        // Add action listener for the direct purchase button
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
        panel.add(purchaseButton, BorderLayout.SOUTH);

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
                    storeOwners.add(parts[0].trim()); // Add the username (first part)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storeOwners;
    }
    //done
    

    private List<String> loadProductsForStoreOwner(String storeOwner) {
        List<String> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Product.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(storeOwner + ":")) {
                    products.add(line.substring(storeOwner.length() + 2)); // Remove owner name and colon
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

//done
    //new frame
    private void showProductsFrame(String storeOwner) {
        JFrame productsFrame = new JFrame("Products of " + storeOwner);
        productsFrame.setSize(500, 400);
        productsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productsFrame.setLayout(new BorderLayout());

        
        
        List<String> products =  loadProductsFromFile("Product.txt");
       // List<String> products = loadProductsForStoreOwner(storeOwner);
        DefaultListModel<String> productListModel = new DefaultListModel<>();
        for (String product : products) {
            productListModel.addElement(product);
        }

        JList<String> productList = new JList<>(productListModel);
        JScrollPane scrollPane = new JScrollPane(productList);
        productsFrame.add(scrollPane, BorderLayout.CENTER);

        JButton purchaseButton = new JButton("Purchase Selected Product");
        productsFrame.add(purchaseButton, BorderLayout.SOUTH);

        purchaseButton.addActionListener(e -> {
            String selectedProduct = productList.getSelectedValue();
            if (selectedProduct != null) {
                // Save the selected product to _purchases file
                savePurchaseToFile(selectedProduct);
                JOptionPane.showMessageDialog(productsFrame, "Product purchased successfully.");
            } else {
                JOptionPane.showMessageDialog(productsFrame, "Please select a product to purchase.");
            }
        });

        productsFrame.setVisible(true);
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

    private List<String> loadProductsForStoreOwner(String fileName, String storeOwner) {
        List<String> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming that each line contains the store owner's name followed by a product
                if (line.startsWith(storeOwner + ":")) {
                    products.add(line.substring(storeOwner.length() + 1).trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void savePurchaseToFile(String product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("_purchases.txt", true))) {
            String purchaseEntry = String.format("%s: %s", loginManager.getCurrentUser(), product);
            writer.write(purchaseEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ////monday
    
    
    private JPanel createCommunicationFeedbackPanel() {
        JPanel panel = new JPanel();
        // Add components for communication and feedback
        return panel;
    }

    public void signUpUser(String username, String password, String email, String country, UserRole role) {
        if (!userExists(username)) {
            users.put(username, new User(username, password, email, country, role));
            saveUsers(); // This will save the updated users map to the file
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    
 

    public User getUser(String username) {
        return users.get(username);
    }
    public void addUser(User user) {
        users.put(user.getUsername(), user);
        saveUsers();
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
    ///hi test to push push push
}


