import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroom,lblcheckintime,lblcheckouttime;
    JButton checkout,back;

    Checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lblid=new JLabel("Customer id");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,30);
        add(ccustomer);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);

        JLabel lblroomnumber=new JLabel("Room Number");
        lblroomnumber.setBounds(30,130,100,30);
        add(lblroomnumber);

        lblroom=new JLabel();
        lblroom.setBounds(150,130,100,30);
        add(lblroom);

        JLabel lblcheckin=new JLabel("Check-in-time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(150,180,150,30);
        add(lblcheckintime);

        JLabel lblcheckout=new JLabel("Check-out-time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);

        Date date=new Date();
        lblcheckouttime=new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);

        checkout=new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(350,50,400,250);
        add(image1);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroom.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setBounds(300,200,800,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Checkout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkout){
            String query1="delete from customer where number ='"+ccustomer.getSelectedItem()+"'";
            String query2="update room set availability ='Available' where roomnumber ='"+lblroom.getText()+"'";

            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout done");
                setVisible(false);
                new Reception();
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
}
