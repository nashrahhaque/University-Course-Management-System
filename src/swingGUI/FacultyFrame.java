package swingGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.*;

import javax.swing.*;

public class FacultyFrame extends JFrame implements ActionListener{
Container container = getContentPane();
    
    
    JLabel bgImage = new JLabel(new ImageIcon("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\MainPageBGImage.jpg"));
    //change the path according to your location
    JLabel appLabel = new JLabel("Faculty");
    JLabel designLabel = new JLabel("------------------------OR--------------------------");
    
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    JButton loginButton = new JButton("Login");
    JButton registrationButton = new JButton("Sign Up");
    JButton backButton = new JButton("Go Back");
    String initial;

    public FacultyFrame() {
    	
    	this.setTitle("MyCourse");
    	this.setBounds(500, 100, 400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    	container.setBackground(Color.YELLOW);
    	
    	//# Labels
    	appLabel.setBounds(92, 82, 192, 56);//set Location and size
    	appLabel.setForeground(new Color(0, 0, 205));//set text color
    	appLabel.setFont(new Font("San Francisco", Font.BOLD, 30));
    	appLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	container.add(appLabel);//add the component to container
    	
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
		
		
        //# Text Fields
        //userTextField.setBounds(150, 150, 150, 30);
        userTextField.setBounds(42, 185, 312, 37);
        userTextField.setToolTipText("Enter Username");
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
				String path = "G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/FacultyInfo.txt";
				//Change the path as per your file location
				
				//Scanner get = new Scanner(new File(path));
				
				FileReader fr = new FileReader(path);
	            BufferedReader br = new BufferedReader(fr);
	            
	            boolean isLoginSuccess = false;
	            int u=0;
	            String line, fuserInitial, fpass;
	            
	            
	            //while ((line = get.nextLine()) != null)
	            while((line = br.readLine()) != null)
	            {	
	            	fpass = line.split(" ")[3];
	            	fuserInitial = line.split(" ")[4];
	                
	                
	                //fuserID = fuserEmail.split("@")[0];
	                //System.out.println(fuserID);
	             
	                
	                
	               if (fuserInitial.equalsIgnoreCase(userText) && fpass.equalsIgnoreCase(passText)) {
	                	isLoginSuccess = true;
	                	this.initial = fuserInitial ;
	                	this.setVisible(false);
		                
	                	FacultyDashboard dashboard = new FacultyDashboard(this.initial);
		                dashboard.setVisible(true);
	    				
		                break;
	                }
	                else if(fuserInitial.equalsIgnoreCase(userText))
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
	            
	            fr.close();
	            //get.close();
				
			}
			
			catch (Exception ep) {
				System.out.println("ERROR 404! File-Not-Found");
	            ep.printStackTrace();
	        }
        }
        
       if (e.getSource() == registrationButton) {
        	this.setVisible(false);
            SignUpFaculty facSignFrame = new SignUpFaculty();
            facSignFrame.setVisible(true);
        }
        if (e.getSource() == showPassword) 
        {
        	//int d = passwordField.getEchoChar();
        	
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