import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JButton back;
    Department(){
        setLayout(null);

        JLabel lbldepartment=new JLabel("Department");
        lbldepartment.setBounds(0,20,350,30);
        lbldepartment.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbldepartment);

        JLabel lblbudget=new JLabel("Budget");
        lblbudget.setBounds(350,20,350,30);
        lblbudget.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblbudget);

        JTable table=new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try{
            Conn c=new Conn();
            String query="select * from department";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(450,400,150,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setBounds(400,200,700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
}
