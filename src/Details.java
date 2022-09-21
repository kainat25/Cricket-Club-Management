import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class details  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3, b4,b5;

    details(){
        f=new JFrame("Player Detail");
        f.setBackground(Color.black);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 1300, 530);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/details.jpg"));
        i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("PLAYER DETAILS");
        l2.setBounds(200,20,250,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(200,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(320,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(200,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4 =new JButton("Update");
        b4.setBounds(320,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        b5 =new JButton("Performance Graph");
        b5.setBounds(200,200,180,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);





        f.setVisible(true);
        f.setSize(600,500);
        f.setLocation(450,200);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new AddPlayer();
            }
        
        if(ae.getSource()==b2){
            f.setVisible(false);
            new ViewPlayer();
            }
        
        if(ae.getSource()==b3){
            f.setVisible(false);
            new RemovePlayer();
            }
        
        if(ae.getSource()== b4){
            f.setVisible(false);
            new SearchPlayer();
            }

        if(ae.getSource()== b5){
          f.setVisible(false);
            new Players();
            }
        }

    public static void main(String[ ] arg){
     new details();
    }
}