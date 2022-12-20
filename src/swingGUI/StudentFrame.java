package swingGUI;

import java.util.*;
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StudentFrame extends JFrame implements ActionListener {
	
    Container container = getContentPane();
    
    JLabel bgImage = new JLabel(new ImageIcon("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\MainPageBGImage.jpg"));
    JLabel appLabel = new JLabel("Student");
    JLabel designLabel = new JLabel("------------------------OR------------------------");
    String fn, ln, email;
    String id;
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    JButton loginButton = new JButton("Login");
    JButton registrationButton = new JButton("Sign Up");
    JButton backButton = new JButton("Go Back");

    public StudentFrame() {
    	//#Notes
    // setBounds(int Xaxis, int Yaxis, int width, int height)
    	
    	this.setTitle("MyCourse");
    	this.setBounds(500, 100, 400, 600);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        //Set App Icon here
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\ProjectIcon.jpg"));
    	
    	Initialize();
        addActionEvent();
        
    }
    
    public void Initialize()
    {
    	
    	//#Notes
    	// setBounds(int Xaxis, int Yaxis, int width, int height)
    	
    	//# Container
    	//set default layout to null (no components)
    	container.setLayout(null);
    	container.setBackground(Color.BLACK);
    	
    	//# Labels
    	appLabel.setBounds(92, 82, 192, 56);//set Location and size
    	appLabel.setForeground(new Color(0, 0, 205));//set text color
    	appLabel.setFont(new Font("San Francisco", Font.BOLD, 30));
    	appLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	container.add(appLabel);
    	
    	backButton.setBounds(20, 20, 90, 26);
    	backButton.setHorizontalTextPosition(SwingConstants.LEFT);
    	backButton.setVerticalTextPosition(SwingConstants.CENTER);
    	backButton.setBackground(new Color(255, 255, 255));
    	backButton.setFont(new Font("San Francisco", Font.BOLD, 12));
        container.add(backButton);
    	
    	
    	designLabel.setFont(new Font("San Francisco", Font.BOLD, 16));
    	designLabel.setBounds(15, 455, 364, 29);
    	designLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	designLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(designLabel);
		
		
        
        userTextField.setBounds(42, 185, 312, 37);
        userTextField.setToolTipText("Enter Student ID");
        userTextField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        container.add(userTextField);
        
        //passwordField.setBounds(150, 220, 150, 30);
        passwordField.setToolTipText("Enter Password");
        passwordField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        passwordField.setBounds(40, 258, 314, 37);
        container.add(passwordField);
        
        //# Check Boxes
        showPassword.setBounds(360, 267, 20, 20);
        showPassword.setBackground(new Color(135, 206, 250));
        showPassword.setToolTipText("Show Password");
        container.add(showPassword);
        
        //# Buttons
        loginButton.setBounds(145, 354, 97, 26);
        loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
        loginButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginButton.setBackground(new Color(60, 179, 113));
        loginButton.setFont(new Font("San Francisco", Font.BOLD, 17));
        container.add(loginButton);
        
        registrationButton.setBounds(135, 493, 115, 29);
        registrationButton.setBackground(new Color(90, 252, 3));
        registrationButton.setFont(new Font("San Francisco", Font.BOLD, 17));
        container.add(registrationButton);
		
        bgImage.setBounds(0, 0, 400, 600);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		container.add(bgImage);
    }
    

    public void addActionEvent() {
        loginButton.addActionListener(this);
        registrationButton.addActionListener(this);
        showPassword.addActionListener(this);
        backButton.addActionListener(this);
    }
    
    public void reset()
    {
    	userTextField.setText("");
    	passwordField.setText("");
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            
        	String userText;
            String passText;
            
            userText = userTextField.getText();
            passText = passwordField.getText();
            
			try {
				String path = ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/StudentInfo.txt");
				//Change the path as per your file loaction
				
				//Scanner get = new Scanner(new File(path));
				
				FileReader fr = new FileReader(path);
	            BufferedReader br = new BufferedReader(fr);
	            
	            boolean isLoginSuccess = false;
	           
	            int u=0;
	            String line, fuserEmail, fpass, fuserID, firstname, lastname;
	            
	            
	            //while ((line = get.nextLine()) != null)
	            while((line = br.readLine()) != null)
	            {	
	            	firstname = line.split(" ")[0];
	            	lastname = line.split(" ")[1];
	            	fuserEmail = line.split(" ")[2];
	            	fuserID = line.split(" ")[3];
	            	fpass = line.split(" ")[4];
	           
	              if ((fuserID.equalsIgnoreCase(userText) || fuserEmail.equalsIgnoreCase(userText)) && fpass.equalsIgnoreCase(passText)) {
	                	isLoginSuccess = true;
	                	this.fn = firstname;
	                	this.ln = lastname;
	                	this.email = fuserEmail;
	                	this.id = fuserID;
	                	this.setVisible(false);
		    
	                	StudentDashboard s = new StudentDashboard(this.fn,this.ln,this.id,this.email);
		                s.setVisible(true);
	    				
		                break;
	                }
	                else if(fuserID.equalsIgnoreCase(userText) || fuserEmail.equalsIgnoreCase(userText))
	                {
	                	u++;
	                }    
	            }
	            if(!isLoginSuccess)
	            {
	            	if(u>0)
	            	{
	            		JOptionPane.showMessageDialog(null, "Invalid Password!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null, "Invalid User!", "WARNING!!", JOptionPane.WARNING_MESSAGE);
	            	}
	            }
	            
	            br.close();
	          
				
			}
				
			catch (Exception ep) {
				System.out.println("ERROR 404! File-Not-Found");
	            ep.printStackTrace();
	        }
        }

   
        if (e.getSource() == registrationButton) {
        	this.setVisible(false);
            SignUpStudent stuSignFrame = new SignUpStudent();
            stuSignFrame.setVisible(true);
        }
        if (e.getSource() == showPassword) 
        {
            if (showPassword.isSelected()) 
            {
                passwordField.setEchoChar((char) 0);
            }
            else 
            {
                passwordField.setEchoChar((char) 8226);
            }
        }
        if(e.getSource() == backButton) {
        	this.setVisible(false);
        	MainPage main = new MainPage();
        	main.setVisible(true);
        }
    }
}
    




