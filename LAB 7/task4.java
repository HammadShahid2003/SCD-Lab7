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
public class task4 
{
     private final JFrame frame;
    private final JTextField input;
    private final JLabel result;
    private final JComboBox<String> source;
    private final JComboBox<String> target;
    private final JButton convert;

    public task4()
    {
        frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        input = new JTextField(10);
        inputPanel.add(input);
        source = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        inputPanel.add(source);
        target = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        inputPanel.add(target);
        convert = new JButton("Convert");
        inputPanel.add(convert);
        frame.add(inputPanel, BorderLayout.NORTH);
        result = new JLabel("Result: ");
        frame.add(result, BorderLayout.CENTER);
        convert.addActionListener(new ConvertButtonListener());
        frame.setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                double inputValue = Double.parseDouble(input.getText());
                String source = task4.this.source.getSelectedItem().toString();
                String target = task4.this.target.getSelectedItem().toString();
                double result = 0;

                if (source.equals("Celsius") && target.equals("Fahrenheit"))
                {
                    result = (inputValue * 9 / 5) + 32;
                } 
                else if (source.equals("Fahrenheit") && target.equals("Celsius"))
                {
                    result = (inputValue - 32) * 5 / 9;
                } 
                else
                {
                    result = inputValue;
                }

               task4.this.result.setText("Result: " + result + " " + target);
            } 
            catch (NumberFormatException ex)
            {
                result.setText("Invalid input");
            }
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new task4());
    }
    

}
