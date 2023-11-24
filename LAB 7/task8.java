/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labb7;

/**
 *
 * @author mashalbutt
 */
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class task8 
{
 
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    public task8() 
    {
        frame = new JFrame("Login System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); 
        loginPanel.add(loginButton);
        frame.add(loginPanel, BorderLayout.CENTER);
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                if (authenticate(username, new String(password)))
                {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(frame, "Login failed. Please check your credentials.");
                }
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        frame.setVisible(true);
    }

    private boolean authenticate(String username, String password) 
    {
        
        return username.equals("Hamza") && password.equals("Hamza123");
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new task8());
    }
}


