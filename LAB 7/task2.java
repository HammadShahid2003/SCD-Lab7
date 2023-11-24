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

public class task2 
{
    private final JFrame frame;
    private final JTextField display;
    private double n1, n2;
    private char operator;

    public task2() 
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttonLabels = 
        {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String label : buttonLabels)
        {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();

            if (Character.isDigit(command.charAt(0)))
            {
                display.setText(display.getText() + command);
            } 
            else if (command.equals("C")) 
            {
                display.setText("");
                n1 = 0;
                n2 = 0;
                operator = ' ';
            }
            else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                n1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            } 
            else if (command.equals("="))
            {
                n2 = Double.parseDouble(display.getText());
                double result = calculate(n1, n2, operator);
                display.setText(Double.toString(result));
            }
        }
    }

    private double calculate(double num1, double num2, char operator) 
    {
        switch (operator) 
        {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return num2;
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new task2());
    }
}


