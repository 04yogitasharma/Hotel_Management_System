import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JButton back,submit;
    JCheckBox available;
    JTable table;
    JComboBox cbbed;
    SearchRoom(){
        setLayout(null);

        JLabel lblsearch=new JLabel("Search for Room");
        lblsearch.setBounds(400,30,200,30);
        lblsearch.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblsearch);

        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,30);
        add(lblbed);

        String[] str={"Single Bed","Double Bed"};
        cbbed=new JComboBox(str);
        cbbed.setBounds(150,100,150,30);
        cbbed.setBackground(Color.white);
        add(cbbed);

        available=new JCheckBox("Only Display Available");
        available.setBounds(600,100,200,30);
        available.setBackground(Color.white);
        add(available);

        JLabel lblroomnumber=new JLabel("Room Number");
        lblroomnumber.setBounds(0,180,200,30);
        add(lblroomnumber);

        JLabel lblavailability=new JLabel("Availability");
        lblavailability.setBounds(200,180,200,30);
        add(lblavailability);

        JLabel lblstatus=new JLabel("Status");
        lblstatus.setBounds(400,180,200,30);
        add(lblstatus);

        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(600,180,200,30);
        add(lblprice);

        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setBounds(800,180,200,30);
        add(lblbedtype);

        table=new JTable();
        table.setBounds(0,220,1000,100);
        add(table);

        try{
            Conn c=new Conn();
            String query="Select * from Room";
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

        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            try{
                String query1="select * from room where bed_type = '"+cbbed.getSelectedItem()+"'";
                String query2="select * from room where availability ='Available' AND bed_type = '"+cbbed.getSelectedItem()+"'";

                Conn c=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs=c.s.executeQuery(query2);
                }else{
                    rs=c.s.executeQuery(query1);
                }

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
