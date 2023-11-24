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
public class task6 
{
  
    private final JFrame frame;
    private JPanel Panel;
    private final JButton[] Button;

    public task6()
  
    {
        frame = new JFrame("Color Palette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        Panel = new JPanel();
        frame.add(Panel, BorderLayout.CENTER);

        JPanel palettePanel = new JPanel();
        palettePanel.setLayout(new FlowLayout());

        String[] colorNames = {"Green", "Red", "Blue", "Yellow", "Orange"};
        Button = new JButton[colorNames.length];

        for (int i = 0; i < colorNames.length; i++)
        {
            Button[i] = new JButton(colorNames[i]);
            palettePanel.add(Button[i]);

            final Color color = getColorForName(colorNames[i]);
            Button[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                {
                    Panel.setBackground(color);
                }
            });
        }

        frame.add(palettePanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new task6());
    }

    private Color getColorForName(String colorName)
    {
        switch (colorName.toLowerCase())
        {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            case "blue":
                return Color.BLUE;
            case "yellow":
                return Color.YELLOW;
            case "orange":
                return Color.ORANGE;
            default:
                return Color.BLACK;
        }
    }
}

