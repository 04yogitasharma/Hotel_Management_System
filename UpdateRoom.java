import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom  extends JFrame implements ActionListener {
    JButton check,update,back;
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfamount,tfpending;
    UpdateRoom(){
        setLayout(null);

        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);

        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblroom =new JLabel("Room Number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);

        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lblname =new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);

        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lblchecktime =new JLabel("Cleaning Status");
        lblchecktime.setBounds(30,230,100,20);
        add(lblchecktime);

        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);

        check=new JButton("Check");
        check.setBounds(20,300,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(140,300,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(260,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,280,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,50,450,300);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,900,450);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where number = '"+id+"'";
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }

                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber= '"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailable.getText();
            String status=tfstatus.getText();

            try{
                Conn c=new Conn();
                c.s.executeUpdate("Update room set availability ='"+available+"', cleaning_status ='"+status+"' where roomnumber ='"+room+"'");
                JOptionPane.showMessageDialog(null,"Data updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==back) {
            setVisible(false);
            new Reception();
        }
    }
}