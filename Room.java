import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Room extends JFrame implements ActionListener {
    JButton back;
    Room(){
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,20,450,400);
        add(image);

        JLabel lblroomnumber=new JLabel("Room Number");
        lblroomnumber.setBounds(0,10,100,30);
        add(lblroomnumber);

        JLabel lblavailability=new JLabel("Availability");
        lblavailability.setBounds(100,10,100,30);
        add(lblavailability);

        JLabel lblstatus=new JLabel("Status");
        lblstatus.setBounds(200,10,100,30);
        add(lblstatus);

        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(300,10,100,30);
        add(lblprice);

        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setBounds(400,10,100,30);
        add(lblbedtype);

        JTable table=new JTable();
        table.setBounds(0,40,500,300);
        add(table);

        try{
            Conn c=new Conn();
            String query="Select * from Room";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(300,400,150,30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setBounds(300,150,900,550);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
}
