import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;


public class Players implements ActionListener  {
	
	JFrame f;
	JLabel l1, l2;
	JButton b1,b2,b3,b4;
	
	Players(){
		f=new JFrame("Players");
        f.setBackground(Color.black);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,800,500);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icons/players.jpg"));
        l1.setIcon(img);
        f.add(l1);
        
        l2 = new JLabel("PLAYERS");
        l2.setBounds(310,20,250,40);
        l2.setFont(new Font("serif",Font.BOLD,40));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        b1=new JButton("Player1");
        b1.setBounds(355,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("Player2");
        b2.setBounds(355,140,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Player3");
        b3.setBounds(355,200,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);
        
        b4=new JButton("Cancel");
        b4.setBounds(355,270,100,30);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);
        
        

        f.setVisible(true);
        f.setSize(600,500);
        f.setLocation(450,200);

	}
	 public void actionPerformed(ActionEvent ae){
		 
		 
	        if(ae.getSource()==b1){
	            f.setVisible(true);
	            new Chart();
	            }
	        
	        if(ae.getSource()==b2){
	            f.setVisible(true);
	            new Chart1();
	            }
	        
	        if(ae.getSource()==b3){
	            f.setVisible(true);
	            new Chart2();
	            }
	        
	        
	        if(ae.getSource()==b4){
	            f.setVisible(false);
	            new details();
	            }
	
	
	 }



public static void main(String[ ] arg){
    new Players();
   }
}
