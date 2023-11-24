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
import java.util.ArrayList;
import java.util.List;
public class task10 
{
   
    private final JFrame frame;
    private JComboBox<String> Month;
    private JComboBox<Integer> Year;
    private final JButton createEventButton;
    private final JPanel calendarPanel;
    private final List<JButton> day;
    private final JTextArea eventTextArea;
    private int currentMonth;
    private int currentYear;

    public task10()
    {
        frame = new JFrame("Monthly Calendar App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        Month = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        Year = new JComboBox<>();
        createEventButton = new JButton("Create Event");
        calendarPanel = new JPanel(new GridLayout(7, 7));
        day = new ArrayList<>();
        eventTextArea = new JTextArea(10, 30);
        currentMonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int year = currentYear - 10; year <= currentYear + 10; year++)
        {
            Year.addItem(year);
        }
        createEventButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                createEvent();
            }
        });
        Month.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                currentMonth = Month.getSelectedIndex();
                updateCalendar();
            }
        });
        Year.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                currentYear = (Integer) Year.getSelectedItem();
                updateCalendar();
            }
        });
        frame.add(Month, BorderLayout.NORTH);
        frame.add(Year, BorderLayout.NORTH);
        frame.add(calendarPanel, BorderLayout.CENTER);
        frame.add(createEventButton, BorderLayout.SOUTH);
        frame.add(new JScrollPane(eventTextArea), BorderLayout.SOUTH);
        initializeCalendar();
        updateCalendar();
        frame.setVisible(true);
    }

    private void initializeCalendar() 
    {
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek)
        {
            calendarPanel.add(new JLabel(day));
        }
        for (int i = 1; i <= 42; i++) 
        {
            JButton dayButton = new JButton();
            dayButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    showEvent(e.getActionCommand());
                }
            });
            day.add(dayButton);
            calendarPanel.add(dayButton);
        }
    }

    private void updateCalendar() 
    {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(currentYear, currentMonth, 1);

        int firstDayOfMonth = calendar.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int i = 0; i < firstDayOfMonth - 1; i++)
        {
            day.get(i).setText("");
        }

        for (int i = 1; i <= daysInMonth; i++) 
        {
            day.get(firstDayOfMonth + i - 2).setText(String.valueOf(i));
        }

        for (int i = firstDayOfMonth + daysInMonth - 1; i < day.size(); i++)
        {
            day.get(i).setText("");
        }
    }

    private void createEvent() 
    {
        String selectedDate = Month.getSelectedItem() + " " + Year.getSelectedItem();
        String event = JOptionPane.showInputDialog(frame, "Enter an event for " + selectedDate);
        eventTextArea.append(selectedDate + ": " + event + "\n");
    }

    private void showEvent(String date)
    {
        String selectedDate = Month.getSelectedItem() + " " + date + ", " + Year.getSelectedItem();
        String[] events = eventTextArea.getText().split("\n");
        StringBuilder eventText = new StringBuilder();
        for (String event : events)
        {
            if (event.startsWith(selectedDate))
            {
                eventText.append(event + "\n");
            }
        }
        JOptionPane.showMessageDialog(frame, eventText.toString());
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new task10());
    }
}


