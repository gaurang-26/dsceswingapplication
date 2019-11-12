package dscewebpage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.*;


public class Form implements ActionListener {
    JFrame frame3;
    JButton registerButton=new JButton("Login");
    JButton resetButton=new JButton("Register");
    JLabel content = new JLabel("<html>"+"To impart quality technical education with a focus on Research and Innovation emphasising on Development of Sustainable and Inclusive Technology for the benefit of society."+"</html>");
    JLabel lab1 = new JLabel("DAYANANDA SAGAR COLLEGE OF ENGINEERING,BANGALORE",SwingConstants.CENTER);
    JLabel lab2 = new JLabel("WELCOME TO CSE,DSCE..",SwingConstants.CENTER);

    ImageIcon ii = new ImageIcon("C:\\Users\\GAURA\\Desktop\\dscewebpage\\src\\images.jpg");
    JLabel lable = new JLabel(ii,SwingConstants.CENTER);
    Form()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame3=new JFrame();
        frame3.setTitle(" Welcome Form");
        frame3.setBounds(40,40,400,600);
        frame3.getContentPane().setBackground(Color.cyan);
        frame3.getContentPane().setLayout(null);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setResizable(false);
    }
    public void setLocationAndSize()
    {
        lab1.setBounds(40,180,300,70);
        lab2.setBounds(40,200,300,70);
        content.setBounds(60,240,300,140);
        lable.setBounds(130,20,100,150);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }  

public void addComponentsToFrame()
{
    frame3.add(lab1);
    frame3.add(lab2);
    frame3.add(content);
    frame3.add(lable);

    frame3.add(registerButton);
    frame3.add(resetButton);
}

public void actionEvent()
{
	resetButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			frame3.dispose();
			new LoginForm();
		}
	});
	registerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			frame3.dispose();
			new RegistrationForm();
		}
	});
}
public static void main(String[] args) {
    new Form(); 
   
}


   
}