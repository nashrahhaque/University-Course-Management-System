package swingGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class YourStudents extends JFrame {
            
            Container container = getContentPane();
            JLabel mainLabel = new JLabel("Student Information");
            JFrame f = new JFrame();
            
            JTable table;
            
            String initial;

 String addedcoursespath="G://NSU//Summer 20//CSE 215L//Course Management System//src//swingGUI/showaddedcourses.txt";
 
 
public YourStudents(String initial) {
            
             this.initial = initial;
             this.setTitle("MyCourse");
             this.setBounds(300, 80, 800, 531);
                this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                this.setResizable(false);
                
                
            // Frame Title
            //f.setTitle("Student information");
            
                    String[]  fname = new String[30];
                    String [] lname =  new String[30];
                    String [] email = new String[30];
                    String  []id =  new String[30];
                    String []  concated =  new String[30];
            
                    String[] columnNames = { "Name", "ID","Email"};
            
             try { 
            	 
            	 
    	 FileReader fr = new FileReader(addedcoursespath);
         BufferedReader br = new BufferedReader(fr);
         
         Object [] lines = br.lines().toArray();
    	 for(int i =0; i<lines.length;i++) {
    		
    		if(this.initial.equalsIgnoreCase(lines[i].toString().split(" ")[5])){
                fname[i]=lines[i].toString().split(" ")[0];
                lname[i]=lines[i].toString().split(" ")[1];
                id[i]=lines[i].toString().split(" ")[2];
                email[i]=lines[i].toString().split(" ")[3];
                concated[i]=fname[i]+" "+lname[i];  
               String data[][]= {{concated[i],id[i],email[i]}};
              
               table = new JTable(data, columnNames);
        }
    		
    		
         }
    	 
         
        fr.close();
             }
           
             catch(Exception e){
            	 System.out.println("File Not found");
            	 }
             

         JScrollPane sp = new JScrollPane(table);
         f.add(sp);
         
        
       
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\NSU\\Summer 20\\CSE 215L\\Project\\Demo Project\\SwingGUI\\icon.png"));
          Initialize();
          
        
}

        public void Initialize() {
            	
            container.setLayout(null);
            mainLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            mainLabel.setBounds(200, 3, 300, 150);
            mainLabel.setForeground(Color.black);//set text color
            mainLabel.setFont(new Font("San Francisco ", Font.BOLD, 30));
            mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
            container.add(mainLabel);
            
            
            table.setBounds(10, 200, 700, 400);
            table.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            
            container.add(table);
            
            


}
}