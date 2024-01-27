import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck  extends JFrame implements ActionListener {
    JButton check,update,back;
    Choice ccustomer;
    JTextField tfroom,tfname,tfchecktime,tfamount,tfpending;
    UpdateCheck(){
        setLayout(null);

        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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

        JLabel lblname =new JLabel("Name");
        lblname.setBounds(30,180,100,20);
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,180,150,25);
        add(tfname);

        JLabel lblchecktime =new JLabel("Check-in-time");
        lblchecktime.setBounds(30,230,100,20);
        add(lblchecktime);

        tfchecktime=new JTextField();
        tfchecktime.setBounds(200,230,150,25);
        add(tfchecktime);

        JLabel lblamount =new JLabel("Amount Paid");
        lblamount.setBounds(30,280,100,20);
        add(lblamount);

        tfamount=new JTextField();
        tfamount.setBounds(200,280,150,25);
        add(tfamount);

        JLabel lblpending =new JLabel("Pending Amount");
        lblpending.setBounds(30,330,100,20);
        add(lblpending);

        tfpending=new JTextField();
        tfpending.setBounds(200,330,150,25);
        add(tfpending);

        check=new JButton("Check");
        check.setBounds(20,380,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(140,380,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(260,380,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(380,50,450,300);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,900,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateCheck();
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
                    tfamount.setText(rs.getString("deposit"));
                    tfchecktime.setText(rs.getString("checkintime"));
//                    tfpending.setText(rs.getString("deposit"));
                    tfname.setText(rs.getString("name"));
                }

                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber= '"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfamount.getText());
                    tfpending.setText(""+amountPaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfchecktime.getText();
            String deposite=tfamount.getText();

            try{
                Conn c=new Conn();
                c.s.executeUpdate("Update customer set room ='"+room+"', name ='"+name+"', checkintime ='"+checkin+"', deposit ='"+deposite+"' where number ='"+number+"'");
                JOptionPane.showMessageDialog(null,"Data updated successfully");
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
