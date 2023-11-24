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
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
public class task5 
{

    private final JFrame frame;
    private final JLabel imageLabel;
    private final JButton prevButton;
    private final JButton nextButton;
    private File[] imageFiles;
    private int currentImageIndex = 0;

    public task5()
    {
        frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        imageLabel = new JLabel();
        frame.add(imageLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        prevButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                showPreviousImage();
            }
        });

        nextButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                showNextImage();
            }
        });

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.isDirectory()) 
            {
                imageFiles = selectedFile.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")
                        || name.toLowerCase().endsWith(".jpeg")
                        || name.toLowerCase().endsWith(".png")
                        || name.toLowerCase().endsWith(".gif"));
            } 
            else 
            {
                imageFiles = new File[]{selectedFile};
            }
            displayCurrentImage();
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "No image selected.");
            System.exit(0);
        }

        frame.setVisible(true);
    }

    private void displayCurrentImage() 
    {
        if (imageFiles != null && imageFiles.length > 0)
        {
            if (currentImageIndex < 0)
            {
                currentImageIndex = imageFiles.length - 1;
            }
            if (currentImageIndex >= imageFiles.length)
            {
                currentImageIndex = 0;
            }
            ImageIcon imageIcon = new ImageIcon(imageFiles[currentImageIndex].getAbsolutePath());
            imageLabel.setIcon(imageIcon);
        }
    }

    private void showNextImage() 
    {
        currentImageIndex++;
        displayCurrentImage();
    }

    private void showPreviousImage()
    {
        currentImageIndex--;
        displayCurrentImage();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new task5());
    }
}


