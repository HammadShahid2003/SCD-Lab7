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
public class task3 
{
   
    private final JFrame frame;
    private final JList<String> ListofTask;
    private final DefaultListModel<String> listModel;
    private final JTextField InputofTask;

    public task3() 
    {
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        ListofTask = new JList<>(listModel);
        frame.add(new JScrollPane(ListofTask), BorderLayout.CENTER);
        InputofTask = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark as Completed");
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(InputofTask, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(new AddButton());
        deleteButton.addActionListener(new DeleteButton());
        completeButton.addActionListener(new CompleteButton());
        frame.setVisible(true);
    }

    private class AddButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String task = InputofTask.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                InputofTask.setText("");
            }
        }
    }

    private class DeleteButton implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int selectedIndex = ListofTask.getSelectedIndex();
            if (selectedIndex != -1) 
            {
                listModel.remove(selectedIndex);
            }
        }
    }

    private class CompleteButton implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int selectedIndex = ListofTask.getSelectedIndex();
            if (selectedIndex != -1) 
            {
                String task = listModel.getElementAt(selectedIndex);
                if (!task.endsWith(" (Completed)"))
                {
                    listModel.setElementAt(task + " (Completed)", selectedIndex);
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new task3());
    }

 
}
