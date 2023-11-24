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
public class task9 
{
    private final JFrame frame;
    private JProgressBar progressBar;
    private final JButton start;
    private final JButton restart;
    private Timer timer;
    private int progressValue = 0;
    public task9() 
    {
        frame = new JFrame("Progress Bar ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        start = new JButton("Start");
        restart = new JButton("Reset");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(start);
        buttonPanel.add(restart);
        frame.add(progressBar, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        timer = new Timer(100, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (progressValue < 100)
                {
                    progressValue++;
                    progressBar.setValue(progressValue);
                }
                else 
                {
                    timer.stop();
                }
            }
        });
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                startProgressBar();
            }
        });
        restart.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                resetProgressBar();
            }
        });

        frame.setVisible(true);
    }
    private void resetProgressBar() 
    {
        if (timer.isRunning())
        {
            timer.stop();
        }
        progressValue = 0;
        progressBar.setValue(0);
    }
    private void startProgressBar()
    {
        if (!timer.isRunning()) 
        {
            progressValue = 0;
            progressBar.setValue(0);
            timer.start();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new task9());
    }
}


