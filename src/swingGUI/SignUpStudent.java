package swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpStudent extends JFrame implements ActionListener
{
	String path = ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/StudentInfo.txt");
	//change the path as per your file location
    
	Container sContainer = getContentPane();
	
	JLabel bgImage = new JLabel(new ImageIcon("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\SignUpBackground.jpg"));
	JLabel appLabel = new JLabel("Student - Sign Up");
	JLabel accLabel = new JLabel("Already have an Account? ");
	JTextField fnTextField = new JTextField();
	JTextField lnTextField = new JTextField();
	JTextField emailTextField = new JTextField();
	JTextField stdIDTextField = new JTextField();
	
	JLabel fnlabel= new JLabel("First Name");
	JLabel lnlabel= new JLabel("Last Name");
    JLabel emaillabel= new JLabel("Email");
    JLabel IDLabel= new JLabel("Student ID");
    JLabel passlabel= new JLabel("Password");
	
	JPasswordField passwordField = new JPasswordField();
	
    JCheckBox showPassword = new JCheckBox();
    
    JButton regButton = new JButton("Create Account");
    JButton loginButton = new JButton("Log in");

	public SignUpStudent()
	{
		this.setTitle("MyCourse");
        this.setBounds(300, 80, 800, 531);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\ProjectIcon.jpg"));
	
		Initialize();
        addActionEvent();
	}
	
	public void Initialize()
	{
		sContainer.setLayout(null);
		
		appLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		appLabel.setBounds(230, 5, 300, 150);
		appLabel.setForeground(Color.black);//set text color
    	appLabel.setFont(new Font("San Francisco", Font.BOLD, 30));
    	appLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(appLabel);
		
		fnlabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fnlabel.setBounds(180, 125, 80, 30);//250, 130, 270, 28
		fnlabel.setForeground(Color.black);//set text color
        fnlabel.setFont(new Font("San Francisco", Font.BOLD, 10));
        fnlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(fnlabel);
                
        lnlabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lnlabel.setBounds(180, 175, 80, 30);
		lnlabel.setForeground(Color.black);//set text color
        lnlabel.setFont(new Font("San Francisco", Font.BOLD, 10));
        lnlabel.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(lnlabel);
                
        emaillabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		emaillabel.setBounds(180, 225, 80, 30);//
		emaillabel.setForeground(Color.black);//set text color
        emaillabel.setFont(new Font("San Francisco", Font.BOLD, 10));
        emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(emaillabel);
		
		IDLabel.setBounds(180, 275, 80, 30);//
		IDLabel.setForeground(Color.black);//set text color
		IDLabel.setFont(new Font("San Francisco", Font.BOLD, 10));
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(IDLabel);
        
		passlabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passlabel.setBounds(180, 325, 80, 30);//
	    passlabel.setForeground(Color.black);//set text color
	    passlabel.setFont(new Font("San Francisco", Font.BOLD, 10));
	    passlabel.setHorizontalAlignment(SwingConstants.CENTER);
	    sContainer.add(passlabel);
	                
		fnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fnTextField.setBounds(250, 130, 270, 28);
        fnTextField.setToolTipText("First name");
        fnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(fnTextField);
        
        lnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lnTextField.setBounds(250, 180, 270, 28);
        lnTextField.setToolTipText("Last name");
        lnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(lnTextField);
        
        emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        emailTextField.setBounds(250, 230, 270, 28);
        emailTextField.setToolTipText("Email address");
        emailTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(emailTextField);
        
        stdIDTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        stdIDTextField.setBounds(250, 280, 270, 28);
        stdIDTextField.setToolTipText("Student ID");
        stdIDTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(stdIDTextField);
        
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passwordField.setBounds(250, 330, 270, 28);
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(passwordField);
        
        showPassword.setBounds(530, 335, 20, 20);
        showPassword.setToolTipText("Show Password");
        showPassword.setBackground(Color.gray);
        sContainer.add(showPassword);
        
        regButton.setBounds(250, 380, 268, 37);
        regButton.setBorderPainted(false);
        regButton.setBackground(new Color(59,89,155));
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("San Francisco", Font.BOLD, 15));
        sContainer.add(regButton);
        
        accLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        accLabel.setBounds(150, 410, 300, 80);
	    accLabel.setForeground(Color.RED);//set text color
	    accLabel.setFont(new Font("San Francisco", Font.BOLD, 15));
    	accLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    sContainer.add(accLabel);
        
        loginButton.setBounds(430, 435, 78, 30);
        loginButton.setBorderPainted(false);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(59,89,155));
        loginButton.setFont(new Font("San Francisco", Font.BOLD, 14));
        sContainer.add(loginButton);
        
        bgImage.setBounds(0, 0, 800, 531);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		sContainer.add(bgImage);
        
	}
	
	public void addActionEvent()
	{
		loginButton.addActionListener(this);
        regButton.addActionListener(this);
        showPassword.addActionListener(this);
	}
	
	public boolean check(String stdID)
	{
		String line;
		try {
			FileReader fr = new FileReader(path);
	        BufferedReader br = new BufferedReader(fr);
	        
	        while ((line = br.readLine()) != null)
	        {
	        	if(stdID.equalsIgnoreCase(line.split(" ")[3]))
	        	{
	        		return true;
	        	}
	        }
		}
		catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");
            //ep.printStackTrace();
        }
		return false;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == loginButton) 
		{
			this.setVisible(false);
			StudentFrame stuFrame = new StudentFrame();
			stuFrame.setVisible(true);
		}
		if (e.getSource() == regButton) 
		{
			try
			{
			      if(!check(stdIDTextField.getText())) //PLEASE REVISIT THIS LINE AFTER TAKING ID INPUT IN FILE
			      {
			    	  
			    	  FileWriter myWriter = new FileWriter(path,true);
			    	  myWriter.write(fnTextField.getText()+" "+lnTextField.getText()+" "+emailTextField.getText()+" "+stdIDTextField.getText()+" "+passwordField.getText()+"\n");
				      myWriter.close();
				      JOptionPane.showMessageDialog(null, "Successfully Registered! Please Login to continue...","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "Username already in use!","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			 }
			catch (IOException ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			    }
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
	}
}