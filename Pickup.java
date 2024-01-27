import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pickup extends JFrame implements ActionListener {
        JButton back,submit;
        JCheckBox available;
        JTable table;
        Choice typeofcar;
        Pickup(){
        setLayout(null);

        JLabel lblsearch=new JLabel("Pickup Service");
        lblsearch.setBounds(400,30,200,30);
        lblsearch.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblsearch);

        JLabel lblbed=new JLabel("Type of car");
        lblbed.setBounds(50,100,100,30);
        add(lblbed);

        typeofcar =new Choice();
        typeofcar.setBounds(150,100,200,30);
        add(typeofcar);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while (rs.next()){
                typeofcar.add(rs.getString("Model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }



        JLabel lblroomnumber=new JLabel("Name");
        lblroomnumber.setBounds(0,180,142,30);
        add(lblroomnumber);

        JLabel lblavailability=new JLabel("Age");
        lblavailability.setBounds(142,180,142,30);
        add(lblavailability);

        JLabel lblstatus=new JLabel("Gender");
        lblstatus.setBounds(284,180,142,30);
        add(lblstatus);

        JLabel lblprice=new JLabel("Company");
        lblprice.setBounds(426,180,142,30);
        add(lblprice);

        JLabel lblbedtype=new JLabel("Brand");
        lblbedtype.setBounds(568,180,142,30);
        add(lblbedtype);

        JLabel lblavailable=new JLabel("Available");
        lblavailable.setBounds(710,180,142,30);
        add(lblavailable);

        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(852,180,142,30);
        add(lbllocation);

        table=new JTable();
        table.setBounds(0,220,1000,100);
        add(table);

        try{
        Conn c=new Conn();
        String query="Select * from driver";
        ResultSet rs=c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        e.printStackTrace();
        }

        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(300,400,150,30);
        submit.addActionListener(this);
        add(submit);

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(500,400,150,30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setBounds(250,150,1000,550);
        setVisible(true);
        }
        public static void main(String[] args) {

            new Pickup();
        }

@Override
public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
        try{
        String query1="select * from driver where model = '"+typeofcar.getSelectedItem()+"'";

        Conn c=new Conn();
        ResultSet rs;
        rs=c.s.executeQuery(query1);

        table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ea){
        ea.printStackTrace();
        }
        }
        else if(e.getSource()==back){
        setVisible(false);
        new Reception();
        }
        }
        }
