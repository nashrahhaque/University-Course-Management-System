package swingGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class FacultyDashboard extends JFrame implements ActionListener{
    
    
        String addmarkpath=("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/marks.txt");
        JComboBox jComboBox1 = new JComboBox();
        String selected;
        String selectedID;
	Container container = getContentPane();
	JLabel mainLabel = new JLabel("Faculty Dashboard");
	String showPath =  ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/showaddedcourses.txt");
        String initial;
	JLabel welcomeLabel;
        JTextField namefield= new JTextField();
        JTextField markfield= new JTextField();
      //  JLabel bgImage = new JLabel(new ImageIcon("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/SignUpBackground.jpg"));
        JLabel appLabel;
	
	JButton addMarks = new JButton("Add Grade");
	JButton logOut = new JButton("Log Out");
        JLabel yourstu= new JLabel("<- Your Students");
        JLabel studentID= new JLabel("<- Student ID");
	

	
	public FacultyDashboard(String initial) {
	this.initial = initial;
	welcomeLabel = new JLabel("Welcome "+this.initial);
    	this.setTitle("MyCourse");
    	this.setBounds(300, 80, 800, 531);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\ProjectIcon.jpg"));
        String fname;
                    String lname;
                    String email;
                    String  id;
                    String  concated="";
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Project\\Demo Project\\SwingGUI\\icon.png"));
        
        
        try { 
    	 FileReader fr = new FileReader(showPath);
         BufferedReader br = new BufferedReader(fr);
         Object [] lines = br.lines().toArray();
    	 for(int i =0; i<lines.length;i++) {
    		if(this.initial.equalsIgnoreCase(lines[i].toString().split(" ")[5])){
                 fname=lines[i].toString().split(" ")[0];
                 lname=lines[i].toString().split(" ")[1];
                 id=lines[i].toString().split(" ")[2];
                 email=lines[i].toString().split(" ")[3];
                 concated=fname+" "+lname+" "+id+" "+email;
                 jComboBox1.addItem(concated);
                 
        
            }
          }br.close();
        }
     
     catch(Exception ex) {
    	 
    	System.out.println("File Cannot be Found!");
   
     }
        
      
     jComboBox1.addActionListener(this);
        
    	Initialize();
        addActionEvent();
	}
	public void Initialize() {
		container.setLayout(null);
                container.setBackground(new Color(65, 105, 225));
                
                
		
		mainLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		mainLabel.setBounds(210, 3, 400, 150);
		mainLabel.setForeground(new Color(139, 0, 139));//set text color
		mainLabel.setFont(new Font("COPPERPLATE GOTHIC BOLD", Font.BOLD, 30));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(mainLabel);
		
		welcomeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		welcomeLabel.setBounds(240, 80, 300, 100);
		welcomeLabel.setForeground(new Color(216, 191, 216));//set text color
		welcomeLabel.setFont(new Font("Forte", Font.BOLD, 25));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(welcomeLabel);
                
        yourstu.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		yourstu.setBounds(510, 170, 200, 100);
		yourstu.setForeground(Color.black);//set text color
		yourstu.setFont(new Font("San Francisco", Font.BOLD, 16));
		yourstu.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(yourstu);
		
		
		
		addMarks.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		addMarks.setBounds(560, 350, 100, 40);
		addMarks.setForeground(Color.black);//set text color
		addMarks.setFont(new Font("San Francisco", Font.BOLD, 17));
		addMarks.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(addMarks);
                
        namefield.setToolTipText("Student selected");
        namefield.setFont(new Font("San Francisco", Font.PLAIN, 16));
        namefield.setBounds(240, 280, 300, 35);
        container.add(namefield);
        
        studentID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        studentID.setBounds(500, 245, 200, 100);
        studentID.setForeground(Color.black);//set text color
        studentID.setFont(new Font("San Francisco", Font.BOLD, 16));
        studentID.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(studentID);
        
        markfield.setToolTipText("This Student's grade");
        markfield.setFont(new Font("San Francisco", Font.PLAIN, 16));
        markfield.setBounds(240, 350, 300, 35);
        
        container.add(markfield);
        markfield.setVisible(false);
		
		logOut.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		logOut.setBounds(280, 420, 150, 30);
		logOut.setForeground(Color.black);//set text color
		logOut.setFont(new Font("San Francisco", Font.BOLD, 17));
		logOut.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(logOut);
		
		/*bgImage.setBounds(0, 0, 800, 531);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		container.add(bgImage);*/
                
                
                
                jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	jComboBox1.setBounds(240, 200, 300, 40);
	jComboBox1.setForeground(Color.black);//set text color
	jComboBox1.setFont(new Font("San Francisco", Font.BOLD, 15));
        jComboBox1.setBackground(Color.white);
	
	container.add(jComboBox1);
                
                
	}
	 public void addActionEvent() {
	        
	        addMarks.addActionListener(this);
	        logOut.addActionListener(this);
	        
	    }
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()== jComboBox1){
                     markfield.setVisible(true);
                    JComboBox jb=(JComboBox)e.getSource();
                    
                    selected=jb.getSelectedItem().toString();
                    selectedID = selected.split(" ")[2];
                    namefield.setText(selectedID);
                }
	        
	       if (e.getSource() == addMarks) {
                   
               
                  String info=namefield.getText()+" "+markfield.getText();
                  try{
                  
                  FileWriter myWriter = new FileWriter(addmarkpath,true);
                  myWriter.write(info+" "+this.initial+"\n");
                  myWriter.close();
                  JOptionPane.showMessageDialog(null, "Grade Added Successfully!","Confirmation", JOptionPane.INFORMATION_MESSAGE);
                  
			     
			 
               }catch (IOException ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			      
			    }
		
                   
         }
          if (e.getSource() == logOut) 
          {
          	this.setVisible(false);
                  MainPage main= new MainPage();
                  main.setVisible(true);
          }
      } 
         
}