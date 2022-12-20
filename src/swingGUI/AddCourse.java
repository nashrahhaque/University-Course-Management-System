package swingGUI;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddCourse extends JFrame implements ActionListener{
    
    String fn,ln,email,id;
    String selected;     
    Container container = getContentPane();
    String showPath =  ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/showaddedcourses.txt");
    String coursePath =  ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/CoursesAvailable.txt");
   // String courseRead = ("G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/CoursesAvailable.txt");
    
    
        
        JButton add = new JButton("Add");
        
        
        JTextField c1= new JTextField();
	JComboBox jComboBox1 = new JComboBox();
        
	JLabel addCourse = new JLabel("Add Course");
	
        JButton back = new JButton("<-- Back");
       //JLabel bgImage = new JLabel(new ImageIcon("C:\\Users\\Naved\\Documents\\NetBeansProjects\\Swing GUI\\src\\swing\\gui\\SignUpBackground.jpg"));
        
        public AddCourse(String fname, String lname, String id, String email) {
    this.fn=fname;
    this.ln=lname;
    this.id=id;
    this.email=email;
    
	this.setTitle("MyCourse");
	 this.setBounds(500, 100, 400, 500);
	
     this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     
     this.setResizable(false);
     this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Course Management System\\src\\swingGUI\\ProjectIcon.jpg"));
     
     
     
     try { 
    	 FileReader fr = new FileReader(coursePath);
         BufferedReader br = new BufferedReader(fr);
         Object [] lines = br.lines().toArray();
    	 for(int i =0; i<lines.length;i++) {
    		 String line = lines[i].toString();
    		 jComboBox1.addItem(line);
                
    	 }
         
        
     }
     
     catch(Exception ex) {
    	 
    	System.out.println("File Cannot be Found!");
   
     }
     jComboBox1.setSelectedIndex(0);
     jComboBox1.addActionListener(this);
    
     
     Initialize();
     addActionEvent();	
}
public void Initialize(){
	container.setLayout(null);
	 container.setBackground(new Color(106, 90, 205));
        
	addCourse.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	addCourse.setBounds(60, 50, 250, 40);
	addCourse.setForeground(Color.black);//set text color
	addCourse.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
	addCourse.setHorizontalAlignment(SwingConstants.CENTER);
	container.add(addCourse);
        
	
	jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	jComboBox1.setBounds(50, 100, 250, 40);
	jComboBox1.setForeground(Color.black);//set text color
	jComboBox1.setFont(new Font("San Francisco", Font.BOLD, 15));
	//jComboBox1.setHorizontalAlignment(SwingConstants.CENTER);
	container.add(jComboBox1);
        
        
      
        
        
        add.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		add.setBounds(310, 200, 40, 40);
		add.setForeground(Color.black);//set text color
		add.setFont(new Font("San Francisco", Font.BOLD, 15));
		add.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(add);
                
        c1.setToolTipText("Selected course");
        c1.setFont(new Font("San Francisco", Font.PLAIN, 16));
        c1.setBounds(50, 200, 250, 35);
        
        container.add(c1);
        
        
        
                
                back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		back.setBounds(160, 300, 80, 50);
		back.setForeground(Color.black);//set text color
		back.setFont(new Font("San Francisco", Font.BOLD, 15));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(back);
                
                /*bgImage.setBounds(0, 0, 400, 500);
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setOpaque(true);
		container.add(bgImage);*/
                
                
                }
            public void addActionEvent() {
	        add.addActionListener(this);
	        back.addActionListener(this);
	        
	    }
	 public void actionPerformed(ActionEvent e) {
             
                
                
                if(e.getSource()== jComboBox1){
                    JComboBox jb=(JComboBox)e.getSource();
                    
                    selected=jb.getSelectedItem().toString();
                    c1.setText(selected);
                }
		 if (e.getSource() == add) {
			 String line, course, initial, timing="", concated="";
	            try{
	            	FileReader fr = new FileReader(showPath);
		            BufferedReader br = new BufferedReader(fr);
		            
		            while((line = br.readLine()) != null) {
                       if(this.id.equalsIgnoreCase(line.split(" ")[2])){
                    	   course = line.split(" ")[4];
   		                initial = line.split(" ")[5];
   		            	timing = line.split(" ")[6];
   		            	concated = course+" "+initial+" "+timing;
   		            	if(selected.equalsIgnoreCase(concated)) {
   		            		JOptionPane.showMessageDialog(null, "You already have this course!","Warning", JOptionPane.WARNING_MESSAGE);		            				            		
   		            	break;
   		            	}
		            	}
		            }
		          	fr.close();
		            }
	           
		           
	            
		            	catch(Exception x){
	                        System.out.println("File cannot be found");
	                    }
		            	
		            
		            
		 try {
		            if(!selected.equalsIgnoreCase(concated)) {
		            	FileWriter mywriter= new FileWriter(showPath,true);
	                       mywriter.write(this.fn+" "+this.ln+" "+this.id+" "+this.email+" "+selected+"\n");
	                       
	                        mywriter.close();
	                        JOptionPane.showMessageDialog(null, "Successfully Added Course","Confirmation", JOptionPane.INFORMATION_MESSAGE);
		            	
		            }
	            }
                      
                    catch(Exception x){
                        System.out.println("Cannot write to file");
                    }
                     
                     
	        }
	        if(e.getSource()== back){
                    this.setVisible(false);
                    StudentDashboard s= new StudentDashboard(this.fn,this.ln,this.id,this.email);
                    s.setVisible(true);
                    
                }
         }
}
        