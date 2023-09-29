package programming.ue.UE9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.BorderFactory;
import java.awt.geom.Ellipse2D;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GUI extends JPanel implements ActionListener, ChangeListener
{
    /*BUTTONS AND LABELS*/
    private JButton graph, help;
    private JTextField equation;
    private JLabel equationLabel;
    private JLabel scale;
    private JLabel detail;
    private JSlider scaleSlider;
    private JSlider detailSlider;
    /*OBJECTS*/
    private Window gWin;
    private Graph graphingUtil;
    
    public static void main(String[] args)
    {
        new GUI();
    }
    
    public GUI()
    {
        /*INITIALIZE WINDOW (JFRAME)*/
        JFrame window = new JFrame("Graphing Interface");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Graphing Interface");
        window.setSize(500,600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        /*INITIALIZE GRAPHING UTILITY OBJECT*/
        graphingUtil=new Graph();

        
        /*INITIALIZE JPANELS*/
        JPanel userInterface = new JPanel();
        userInterface.setLayout(new BorderLayout(20,10));
        
        /*VIEWING PANEL*/
        JPanel graphDisplay = new JPanel();
        graphDisplay.setLayout(new GridLayout(1,1));
        gWin = new Window(graphingUtil.getTable());
        gWin.setPreferredSize(new Dimension(500, 500));
        graphDisplay.add(gWin);
        
        /*BOTTOM BAR*/
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new BorderLayout(20,10));
        JPanel sliderBar = new JPanel();
        bottomBar.add(sliderBar, BorderLayout.SOUTH);
        JPanel equationBar = new JPanel();
        equationLabel = new JLabel("Polynomial Equation:");
        equationBar.add(equationLabel);
        equation = new JTextField(10); //equation textfield
        equation.setText("x^2+2x");
        equationBar.add(equation);
        graph = new JButton("Plot"); //graph button
        graph.addActionListener(this);
        graph.doClick();
        equationBar.add(graph);
        help = new JButton("help");
        help.addActionListener(this);
        equationBar.add(help);
        bottomBar.add(equationBar, BorderLayout.CENTER);
        
        userInterface.add(graphDisplay, BorderLayout.CENTER);
        userInterface.add(bottomBar, BorderLayout.SOUTH);
        
        /*SET WINDOW VISIBLE*/
        window.add(userInterface);
        window.pack();
        window.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        /*GRAPH BUTTON LISTENING*/
        if(e.getSource()==graph)
        {
            graphingUtil.setExpression(equation.getText()); //create new equation
            gWin.setPoints(graphingUtil.getTable()); //update points used by the graph window
            gWin.repaint(); //repaint the window
        }
        
        if(e.getSource()==help)
        {
            String message = "How to use this GraphPlotter";
            message += "\n\t Ex.1: 2x";
            message += "\n\t Ex.2: 2x+3";
            message += "\n\t Ex.3: 3x^2+4x-6";
            message += "\n\t Ex.4: netter Versuch selber lernen ;)";
            JOptionPane.showMessageDialog(null, message, "Help Window", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void stateChanged(ChangeEvent e)
    {
        /*SLIDERS*/
        JSlider source = (JSlider)e.getSource();
        if(!source.getValueIsAdjusting())
        {
            if(source.getName().equals("scaleSlider")) //Changes the zoom of the graph window
            {
                gWin.setScale((int)source.getValue());
                gWin.repaint();
            }
            
            if(source.getName().equals("detailSlider")) //Changes the amount of points plotted between each x value
            {
                graphingUtil.setPointDensity(source.getValue()/4.0);
                gWin.setPoints(graphingUtil.getTable());
                gWin.repaint();
            }
        }
    }
}
