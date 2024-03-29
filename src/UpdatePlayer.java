import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdatePlayer extends AddPlayer implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String id_ply;

    UpdatePlayer(String idaa){
        super(0);
        f=new JFrame("update Player details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_ply=idaa;
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icons/update.jpg"));
        img.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        id15.setIcon(img);

        id8 = new JLabel("Update Player Detail:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.BOLD,40));
        id8.setForeground(Color.white);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("Name:");  
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.white);
        id15.add(id1);


        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Father's Name:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id2.setForeground(Color.white);
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("Address:");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id3.setForeground(Color.white);
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);

        id4= new JLabel("Mobile No:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id4.setForeground(Color.white);
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        id5= new JLabel("Email Id:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id5.setForeground(Color.white);
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id6= new JLabel("Education:");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id6.setForeground(Color.white);
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

  
        id9= new JLabel("player id:");
        id9.setBounds(50,250,100,30);  
        id9.setFont(new Font("serif",Font.BOLD,20));
        id9.setForeground(Color.white);
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(200,250,150,30);
        id15.add(t8);

        id10= new JLabel("CNIC N0:");
        id10.setBounds(400,250,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id10.setForeground(Color.white);
        id15.add(id10);
        f.setVisible(false);
        t9=new JTextField();
        t9.setBounds(600,250,150,30);
        id15.add(t9);

        b=new JButton("update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);

        showData(idaa);
    }

    int i=0;
    String age,dat;

    void showData(String s){
        try{
            Conn con = new Conn();
            String str = "select * from player where ply_id = '"+s+"'" ;
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));
                t6.setText(rs.getString(8));
                t8.setText(rs.getString(9));
                t9.setText(rs.getString(10));

                age=rs.getString(3);
                dat=rs.getString(4);
            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Id not found");
            new SearchPlayer();
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                Conn con = new Conn();
                String id_ply = this.id_ply;
                String str = "update player set name='"+t1.getText()+"',fname='"+t2.getText()+"',age='"+age+
                        "',dob='"+dat+"',address='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',education='"+t6.getText()+
                        "',PLY_ID='"+t8.getText()+"',CNIC='"+t9.getText()+
                        "' where ply_id='"+id_ply+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new SearchPlayer();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            new details();
        }
    }

    public static void main(String[] arg){
        new UpdatePlayer("Update Player");
    }
}