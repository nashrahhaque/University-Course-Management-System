package swingGUI;

	import java.util.*;
	import javax.swing.*;

	import java.awt.*;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;

	public class MainPage extends JFrame implements ActionListener {
	   
	    Container container = getContentPane();
	    JLabel bgImage = new JLabel(new ImageIcon("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\MainPageBGImage.jpg"));
	    
	    JLabel appLabel = new JLabel("Welcome to MyCourse");
	    JLabel designLabel = new JLabel("Choose Your Category");
	    JLabel creditlabel= new JLabel("Designed by: Erfan, Naved and Nashrah ");
	    
	    
	    JButton FacultyButton = new JButton("Faculty");
	    JButton StudentButton = new JButton("Student");

	    MainPage() {
	    	//#Notes
	        // setBounds(int Xaxis, int Yaxis, int width, int height)
	    	
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
	        // container.setBackground(Color.gray);
	    	//# Labels
	    	appLabel.setBounds(10, 82, 380, 56);//set Location and size
	    	appLabel.setForeground(new Color( 0, 0, 139));//set text color to 
	    	appLabel.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 30));
	    	appLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    	container.add(appLabel);//add the component to container
	    	
	    	
	    	designLabel.setFont(new Font("San Francisco", Font.BOLD, 20));
	        designLabel.setForeground(Color.blue);
	    	designLabel.setBounds(18, 170, 350,29);
	    	designLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    	designLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		    container.add(designLabel);
			
	                creditlabel.setFont(new Font("Candara Light", Font.BOLD, 20));
	                creditlabel.setForeground(Color.black);
	                creditlabel.setBounds(16,500,350,35);
	                creditlabel.setHorizontalAlignment(SwingConstants.CENTER);
	                creditlabel.setHorizontalTextPosition(SwingConstants.CENTER);
	                container.add(creditlabel);
	        
	        bgImage.setBounds(0, 0, 400, 600);
			bgImage.setHorizontalAlignment(SwingConstants.CENTER);
			bgImage.setOpaque(true);
			container.add(bgImage);
			
	        
	        //# Buttons
	        FacultyButton.setBounds(130, 236, 100, 35);//x, y , width, height
	        FacultyButton.setBackground(new Color(135, 206, 250));
	        FacultyButton.setFont(new Font("Calibri Light", Font.BOLD, 17));
	        container.add(FacultyButton);
	    
	        StudentButton.setBounds(130,284,100, 35);
	        StudentButton.setBackground(new Color(135,206, 250));
	        StudentButton.setFont(new Font("Calibri Light", Font.BOLD, 17));
	        container.add(StudentButton);
			
	    }

	    public void addActionEvent() {
	        FacultyButton.addActionListener(this);
	        StudentButton.addActionListener(this);
	        
	    }
	    
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == FacultyButton) {
	            this.setVisible(false);
	            FacultyFrame facFrame = new FacultyFrame();
	            facFrame.setVisible(true);
	            
	        }
	            
	        if (e.getSource() == StudentButton) {
	        	 this.setVisible(false);
	            StudentFrame stuFrame = new StudentFrame();
	            stuFrame.setVisible(true);
	        }
	        
	    }
	}





