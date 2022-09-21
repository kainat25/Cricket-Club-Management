import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;


class FrontPage implements ActionListener {
	JFrame f;
	JLabel id,l1;
    JButton b;

    FrontPage(){
 
        f=new JFrame("Cricket Club Management");
        f.setLayout(null);

        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        
        l1.setBounds(30, 130, 1300, 530);
        f.add(l1);

        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(550,580,190,50);
        
        b.addActionListener(this);
       
        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
  
        JLabel lid=new JLabel("CRICKET CLUB MANAGEMENT");
        lid.setBounds(180,25,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.BLUE);
        
        id.add(lid);
        id.add(b);
        f.add(id);
        
        f.getContentPane().setBackground(Color.BLACK);

        f.setVisible(true);
        f.setSize(1360,750);
        f.setLocation(200,100);
        
        
        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }
            catch(Exception e){} 
            
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new Login();    
        }
    }
        
    public static void main(String[] arg){
         new FrontPage();
    }
}
	
