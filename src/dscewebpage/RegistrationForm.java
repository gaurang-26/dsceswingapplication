package dscewebpage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
//    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
//    JLabel genderLabel=new JLabel("GENDER");
//    JLabel fatherNameLabel=new JLabel("FATHER NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
//    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
//    JLabel cityLabel=new JLabel("CITY");
//    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
//    JComboBox genderComboBox=new JComboBox(gender);
//    JTextField fatherTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
//    JPasswordField confirmPasswordField=new JPasswordField();
//    JTextField cityTextField=new JTextField();
//    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
//    JButton reg= new JButton("register");
   JFrame frame1;

    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Login  Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame1=new JFrame();
        frame1.setTitle("welcome");
//        frame1.setBounds(40,40,380,600);
        frame1.getContentPane().setBackground(Color.cyan);
        frame1.getContentPane().setLayout(null);
//        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);

    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
//        genderLabel.setBounds(20,70,80,70);
//        fatherNameLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
//        confirmPasswordLabel.setBounds(20,220,140,70);
//        cityLabel.setBounds(20,270,100,70);
//        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
//        genderComboBox.setBounds(180,93,165,23);
//        fatherTextField.setBounds(180,143,165,23);
        passwordField.setBounds(180,193,165,23);
//        confirmPasswordField.setBounds(180,243,165,23);
//        cityTextField.setBounds(180,293,165,23);
//        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
//        frame.add(genderLabel);
//        frame.add(fatherNameLabel);
        frame.add(passwordLabel);
//        frame.add(confirmPasswordLabel);
//        frame.add(cityLabel);
//        frame.add(emailLabel);
        frame.add(nameTextField);
//        frame.add(genderComboBox);
//        frame.add(fatherTextField);
        frame.add(passwordField);
//        frame.add(confirmPasswordField);
//        frame.add(cityTextField);
//        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
            	
                //Creating Connection Object
            	
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase?useSSL=false","root","Current-Root-Password");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("select * from student where username=? and passwrd=?;");
                //Specifying the values of it's parameter
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,passwordField.getText());
//                Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
//                Pstatement.setString(3,fatherTextField.getText());
                 
                 ResultSet x =Pstatement.executeQuery();
                 //                Pstatement.setString(5,confirmPasswordField.getText());
//                Pstatement.setString(6,cityTextField.getText());
//                Pstatement.setString(7,emailTextField.getText());
                //Checking for the Password match
                if(x.next()!=false)
                {
                    //Executing query
                    
                    JOptionPane.showMessageDialog(null,"login successfull");
                    frame.setVisible(false);
                    frame1.setSize(400,400);
                    frame1.setVisible(true);
                    JLabel lab2 = new JLabel("WELCOME" +"      "+ nameTextField.getText().toUpperCase(),SwingConstants.CENTER);
                    lab2.setSize(200,200);
                    frame1.add(lab2);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password/username not found in the database. ");
                    
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            


        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            nameTextField.setText("");
//            genderComboBox.setSelectedItem("Male");
//            fatherTextField.setText("");
            passwordField.setText("");
//            confirmPasswordField.setText("");
//            cityTextField.setText("");
//            emailTextField.setText("");
      }

    }
    
    
        public static void main(String[] args)
        {
            new RegistrationForm();
            
        }
    
}