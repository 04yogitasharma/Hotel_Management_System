import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    JButton back;
    CustomerInfo(){

        JLabel lblname=new JLabel("Document");
        lblname.setBounds(0,10,150,30);
        add(lblname);

        JLabel lblage=new JLabel("Number");
        lblage.setBounds(130,10,150,30);
        add(lblage);

        JLabel lblgender=new JLabel("Name");
        lblgender.setBounds(250,10,150,30);
        add(lblgender);

        JLabel lbljob=new JLabel("Gender");
        lbljob.setBounds(380,10,150,30);
        add(lbljob);

        JLabel lblsalary=new JLabel("Country");
        lblsalary.setBounds(500,10,150,30);
        add(lblsalary);

        JLabel lblphone=new JLabel("Room Number");
        lblphone.setBounds(630,10,150,30);
        add(lblphone);

        JLabel lblemail=new JLabel("Check-in-time");
        lblemail.setBounds(750,10,150,30);
        add(lblemail);

        JLabel lblaadhar=new JLabel("Deposit");
        lblaadhar.setBounds(880,10,150,30);
        add(lblaadhar);

        setLayout(null);
        JTable table=new JTable();
        table.setBounds(0,40,1000,300);
        add(table);

        try{
            Conn c=new Conn();
            String query="select * from customer";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(500,400,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setBounds(300,200,1000,500);
        setVisible(true);
    }
    public  static void main(String[] args){
        new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
}
