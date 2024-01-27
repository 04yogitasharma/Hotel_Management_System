import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame implements ActionListener {

    JButton back;
    EmployeeInfo(){

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(0,10,150,30);
        add(lblname);

        JLabel lblage=new JLabel("Age");
        lblage.setBounds(130,10,150,30);
        add(lblage);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(250,10,150,30);
        add(lblgender);

        JLabel lbljob=new JLabel("Job");
        lbljob.setBounds(380,10,150,30);
        add(lbljob);

        JLabel lblsalary=new JLabel("Salary");
        lblsalary.setBounds(500,10,150,30);
        add(lblsalary);

        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(630,10,150,30);
        add(lblphone);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(750,10,150,30);
        add(lblemail);

        JLabel lblaadhar=new JLabel("Aadhar");
        lblaadhar.setBounds(880,10,150,30);
        add(lblaadhar);

        setLayout(null);
        JTable table=new JTable();
        table.setBounds(0,40,1000,300);
        add(table);

        try{
            Conn c=new Conn();
            String query="select * from employee";
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
        new EmployeeInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
}
