/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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

public class task1 
{
    private static int count = 0;
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Click Count");
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Click Count: 0");
        JButton button = new JButton("Click Me");
        frame.add(label);
        frame.add(button);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               
                count++;
                label.setText("Click Count: " + count);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}

