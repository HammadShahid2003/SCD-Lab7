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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class task7 
{

    private JFrame frame;
    private Canvas c;
    private ShapeType currentShapeType;

    public task7() 
    {
        frame = new JFrame("Drawing Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        c = new Canvas();
        frame.add(c);
        JPanel control = new JPanel();
        frame.add(control, BorderLayout.NORTH);
        JButton lineButton = new JButton("Line");
        JButton rectangleButton = new JButton("Rectangle");
        JButton ellipseButton = new JButton("Ellipse");
        control.add(lineButton);
        control.add(rectangleButton);
        control.add(ellipseButton);
        lineButton.addActionListener(e -> setCurrentShapeType(ShapeType.LINE));
        rectangleButton.addActionListener(e -> setCurrentShapeType(ShapeType.RECTANGLE));
        ellipseButton.addActionListener(e -> setCurrentShapeType(ShapeType.ELLIPSE));
        frame.setVisible(true);
    }
    private void setCurrentShapeType(ShapeType shapeType)
    {
        currentShapeType = shapeType;
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new task7());
    }
    private class Canvas extends JPanel 
    {
        private Point startPoint;
        private Point endPoint;

        public Canvas()
        {
            setBackground(Color.WHITE);
            addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mousePressed(MouseEvent e)
                {
                    startPoint = e.getPoint();
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {
                    endPoint = e.getPoint();
                    repaint();
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            if (startPoint != null && endPoint != null) 
            {
                switch (currentShapeType)
                {
                    case LINE:
                        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                        break;
                    case RECTANGLE:
                        int x = Math.min(startPoint.x, endPoint.x);
                        int y = Math.min(startPoint.y, endPoint.y);
                        int width = Math.abs(startPoint.x - endPoint.x);
                        int height = Math.abs(startPoint.y - endPoint.y);
                        g.drawRect(x, y, width, height);
                        break;
                    case ELLIPSE:
                        x = Math.min(startPoint.x, endPoint.x);
                        y = Math.min(startPoint.y, endPoint.y);
                        width = Math.abs(startPoint.x - endPoint.x);
                        height = Math.abs(startPoint.y - endPoint.y);
                        g.drawOval(x, y, width, height);
                        break;
                }
            }
        }
    }

    private enum ShapeType 
    {
        LINE, RECTANGLE, ELLIPSE
    }
}


