package swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpFaculty extends JFrame implements ActionListener
{
	String path = "G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/FacultyInfo.txt";
	String coursePath =  "G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/CoursesAvailable.txt";
    //change the path as per your file location
	
	Container sContainer = getContentPane();
	
	JLabel bgImage = new JLabel(new ImageIcon("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\SignUpBackground.jpg"));
	//Change the path of bgImage as per your file location
	JLabel appLabel = new JLabel("Faculty - Sign Up");
	JLabel accLabel = new JLabel("Already have an Account? ");
	JTextField fnTextField = new JTextField();
	JTextField lnTextField = new JTextField();
	JTextField emailTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
        
    JTextField FacInitialTextField = new JTextField();
    JTextField CourseTextField = new JTextField();
    JTextField TimingTextField= new JTextField();
        
        
        
        
    JCheckBox showPassword = new JCheckBox();
    
    JButton regButton = new JButton("Create Account");
    JButton loginButton = new JButton("Log in");

	public SignUpFaculty()
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
		appLabel.setBounds(200, 5, 300, 150);
		appLabel.setForeground(Color.black);//set text color
                appLabel.setFont(new Font("San Francisco", Font.BOLD, 30));
                appLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sContainer.add(appLabel);
        
		fnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		fnTextField.setBounds(150, 130, 200, 28);
                fnTextField.setToolTipText("First name");
                fnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
                sContainer.add(fnTextField);
        
        lnTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	lnTextField.setBounds(150, 180, 200, 28);
        lnTextField.setToolTipText("Last name");
        lnTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(lnTextField);
        
        emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        emailTextField.setBounds(150, 230, 200, 28);
        emailTextField.setToolTipText("Email address");
        emailTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(emailTextField);
        
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        passwordField.setBounds(150, 280, 200, 28);
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(passwordField);
        
        showPassword.setBounds(370, 290, 20, 20);
        showPassword.setBackground(Color.WHITE);
        showPassword.setToolTipText("Show Password");
        sContainer.add(showPassword);
        
        FacInitialTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        FacInitialTextField.setBounds(400, 130, 200, 28);
        FacInitialTextField.setToolTipText("Faculty Initial");
        FacInitialTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(FacInitialTextField);
        
        CourseTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        CourseTextField.setBounds(400, 180, 200, 28);
        CourseTextField.setToolTipText("Course name");
        CourseTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(CourseTextField);
        
        TimingTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        TimingTextField.setBounds(400, 230, 200, 28);
        TimingTextField.setToolTipText("Class Time");
        TimingTextField.setFont(new Font("San Francisco", Font.PLAIN, 15));
        sContainer.add(TimingTextField);
        
        
        regButton.setBounds(250, 380, 268, 37);
        regButton.setBorderPainted(false);
        regButton.setBackground(new Color(59,89,155));
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("San Francisco", Font.BOLD, 15));
        sContainer.add(regButton);
        
        accLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        accLabel.setBounds(150, 430, 300, 80);
	accLabel.setForeground(Color.RED);//set text color
	accLabel.setFont(new Font("San Francisco", Font.BOLD, 15));
    	accLabel.setHorizontalAlignment(SwingConstants.CENTER);
	sContainer.add(accLabel);
        
        loginButton.setBounds(430, 455, 78, 30);
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
	
	public boolean check(String initial)
	{
		String line;
		try {
			FileReader fr = new FileReader(path);
	        BufferedReader br = new BufferedReader(fr);
	        
	        while ((line = br.readLine()) != null)
	        {
	        	if(initial.equalsIgnoreCase(line.split(" ")[4]))// look here for index
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
			FacultyFrame facFrame = new FacultyFrame();
			facFrame.setVisible(true);
		}
		if (e.getSource() == regButton) 
		{
			try
			{
			      if(!check(FacInitialTextField.getText())) //PLEASE REVISIT THIS LINE AFTER TAKING INITIAL INPUT IN FILE
			      {
			    	  
			    	  FileWriter myWriter = new FileWriter(path,true);
			    	  myWriter.write(fnTextField.getText()+" "+lnTextField.getText()+" "+emailTextField.getText()+" "+passwordField.getText()+" "+FacInitialTextField.getText()+" "+CourseTextField.getText()+" "+TimingTextField.getText()+"\n");
				      myWriter.close();
				     
				      FileWriter courseWriter = new FileWriter(coursePath,true);
				      courseWriter.write(CourseTextField.getText()+" "+FacInitialTextField.getText()+" "+TimingTextField.getText()+"\n");
				      courseWriter.close();
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