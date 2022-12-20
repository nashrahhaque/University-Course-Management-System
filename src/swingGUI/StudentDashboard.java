package swingGUI;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
//this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naved\\Documents\\NetBeansProjects\\Swing GUI\\src\\icon.png"));


public class StudentDashboard extends JFrame implements ActionListener {
    Container container = getContentPane();
    String selected;
    String addmarkpath=("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/marks.txt");
    String showPath =  ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/showaddedcourses.txt");
    //Change path according to your path location
    JComboBox jComboBox1 = new JComboBox();
   JLabel bgImage = new JLabel(new ImageIcon("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/SignUpBackground.jpg"));
    JLabel appLabel;
    JLabel yourcourse= new JLabel("Your Courses");
    String firstName,lastname,id,email;
    JTextField coursefield= new JTextField();
    JTextField yourmark = new JTextField();
    JLabel CourseName= new JLabel("<- Selected Course");
    JLabel mainLabel = new JLabel("Student Dashboard");
    JButton showmark= new JButton("<- Show Grade");
    JButton addcourses = new JButton("Add Course");
    JButton logout = new JButton("Log Out");
    
    public StudentDashboard(String fname, String lname, String id, String email) {
    	this.firstName = fname;
    	this.lastname = lname;
    	this.email = email;
    	this.id = id;
    	this.setTitle("MyCourse");
    	appLabel =  new JLabel("Welcome "+this.firstName);
       this.setBounds(300, 80, 800, 531);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\ProjectIcon.jpg"));
        //Set App Icon here
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naved\\Documents\\NetBeansProjects\\Swing GUI\\src\\icon.png"));
        
        
       String initial,course,timing,concated="";
        
        try { 
    	 FileReader fr = new FileReader(showPath);
         BufferedReader br = new BufferedReader(fr);
         
         Object [] lines = br.lines().toArray();
    	 for(int i =0; i<lines.length;i++) {
    		if(this.id.equalsIgnoreCase(lines[i].toString().split(" ")[2])){
                 course=lines[i].toString().split(" ")[4];
                 initial=lines[i].toString().split(" ")[5];
                 timing=lines[i].toString().split(" ")[6];
                   concated=course+" "+initial+" "+timing; 
                   String line = concated;
    		 jComboBox1.addItem(line);
                }
                      
    	 }
         
        
     }
     
     catch(Exception ex) {
    	 
    	System.out.println("File Cannot be Found!");
   
     }
      
     jComboBox1.addActionListener(this);
     
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
        container.setBackground(Color.red);
    	
    	//# Labels
        mainLabel.setBounds(200,20,350,40);//set Location and size
        mainLabel.setForeground(Color.blue);//set text color
        mainLabel.setFont(new Font("COPPERPLATE GOTHIC BOLD", Font.PLAIN, 30));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	container.add( mainLabel);//add the component to container
    	
    	appLabel.setBounds(250,70,250,40);//set Location and size
    	appLabel.setForeground(new Color(216, 191, 216));//set text color
    	appLabel.setFont(new Font("Forte", Font.PLAIN, 25));
    	appLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	container.add(appLabel);//add the component to container
        
        yourmark.setBounds(65,350,250,40);//set Location and size
    	yourmark.setFont(new Font("San Francisco", Font.PLAIN, 16));
    	yourmark.setHorizontalAlignment(SwingConstants.CENTER);
    	yourmark.setToolTipText("Your Grade");
    	container.add(yourmark);//add the component to container
    	yourmark.setVisible(false);
    	
        
        yourcourse.setBounds(80,120,150,30);//set Location and size
    	yourcourse.setForeground(Color.black);//set text color
    	yourcourse.setFont(new Font("San Francisco", Font.PLAIN, 18));
    	yourcourse.setHorizontalAlignment(SwingConstants.CENTER);
    	container.add(yourcourse);//add the component to container
    	
        coursefield.setToolTipText("Selected Course");
        coursefield.setFont(new Font("San Francisco", Font.PLAIN, 16));
        coursefield.setBounds(65, 250, 300, 35);
        container.add(coursefield);
        
        CourseName.setBounds(350,255,250, 20);//set Location and size
        CourseName.setForeground(Color.BLACK);//set text color
        CourseName.setBackground(Color.white);
        CourseName.setFont(new Font("San Francisco", Font.PLAIN, 18));
        CourseName.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(CourseName);//add the component to contain
        
		
        
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	jComboBox1.setBounds(65, 150, 300, 36);
	jComboBox1.setForeground(Color.black);//set text color
	jComboBox1.setFont(new Font("San Francisco", Font.BOLD, 15));
	//jComboBox1.setHorizontalAlignment(SwingConstants.CENTER);
	container.add(jComboBox1);
		
		
       
        
        //# Buttons
        
        showmark.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        showmark.setBounds(350, 355, 150, 20);
        showmark.setForeground(Color.black);//set text color
        showmark.setFont(new Font("San Francisco", Font.BOLD, 17));
        showmark.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(showmark);
                
                
        addcourses.setBounds(400,160,150,20);
        addcourses.setHorizontalTextPosition(SwingConstants.CENTER);
        addcourses.setVerticalTextPosition(SwingConstants.CENTER);
        //addcourses.setBackground(new Color(60, 179, 113));
        addcourses.setFont(new Font("San Francisco", Font.BOLD, 17));
        container.add(addcourses);
        
        
        logout.setBounds(650,50,100,30);
        logout.setHorizontalTextPosition(SwingConstants.CENTER);
        logout.setVerticalTextPosition(SwingConstants.CENTER);
        //logout.setBackground(new Color(60, 179, 113));
        logout.setFont(new Font("San Francisco", Font.BOLD, 17));
        container.add(logout);
        
        bgImage.setBounds(0, 0, 800, 531);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		container.add(bgImage);
		
    }
    public void addActionEvent() {
        showmark.addActionListener(this);
        addcourses.addActionListener(this);
        logout.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jComboBox1){
            
                     yourmark.setVisible(true);
                    JComboBox jb=(JComboBox)e.getSource();
                    
                    selected=jb.getSelectedItem().toString();
                    String selectedCourse= selected.split(" ")[0];
                    coursefield.setText(selectedCourse);
                    
                    
                }
                if (e.getSource() == showmark) {
                    String check=selected.split(" ")[1];
                    String info,line;
                  try{
                  
                  FileReader fr = new FileReader(addmarkpath);
	          BufferedReader br = new BufferedReader(fr);
	          
	          while((line = br.readLine()) != null){
                      if(this.id.equalsIgnoreCase(line.split(" ")[2])){
                          if(check.equalsIgnoreCase(line.split(" ")[5])){
                              String grade=line.split(" ")[4];
                              //yourmark.setVisible(true);
                              yourmark.setText(grade);
                          }
                         
                          }
                     
                      }
              
  	 
               }catch (Exception ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			      
			    }
	   
         }
                    
        
        
       if (e.getSource() == addcourses) {
           this.setVisible(false);
            AddCourse c = new AddCourse(this.firstName,this.lastname,this.id, this.email);
            c.setVisible(true);
        }
        if (e.getSource() == logout) 
        {
        	this.setVisible(false);
                MainPage mp= new MainPage();
                mp.setVisible(true);
        }
    }  
}