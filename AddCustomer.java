import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JButton addcustomer,back;
    JRadioButton rbmale,rbfemale;
    JComboBox cbid;
    JTextField tfname,tfnumber,tfcountry,tfdeposit;
    Choice croom;
    JLabel time;



    AddCustomer(){
        setLayout(null);

        JLabel form=new JLabel("NEW CUSTOMER FORM");
        form.setBounds(120,20,250,30);
        form.setFont(new Font("Tahoma",Font.BOLD,19));
        form.setForeground(Color.BLUE);
        add(form);

        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,70,150,30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblid);

        String[] str={"Passport","Aadhaar Card","Pan Card","Voter-id Card","Ration Card","Driving Licence"};
        cbid=new JComboBox(str);
        cbid.setBounds(200,70,150,30);
        cbid.setBackground(Color.white);
        add(cbid);

        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,120,100,30);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,30);
        add(tfnumber);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,100,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,170,150,30);
        add(tfname);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,220,100,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblgender);


        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,220,70,30);
        add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(280,220,80,30);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,270,100,30);
        lblcountry.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(200,270,150,30);
        add(tfcountry);

        JLabel lblroomnumber=new JLabel("Allocated Room Number");
        lblroomnumber.setBounds(30,320,150,30);
        lblroomnumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblroomnumber);

        croom=new Choice();

        try{
            Conn conn =new Conn();
            String query="Select * from room where availability='Available'";
            ResultSet rs=conn.s.executeQuery(query);
            while ((rs.next())){
                croom.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,320,150,30);
        add(croom);

        JLabel lblcheckintime=new JLabel("Check-in time");
        lblcheckintime.setBounds(30,370,100,30);
        lblcheckintime.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblcheckintime);

        Date date=new Date();

        time=new JLabel(""+date);
        time.setBounds(200,370,150,30);
        time.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(time);


        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(30,420,100,30);
        lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lbldeposit);

        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,420,150,30);
        add(tfdeposit);

        addcustomer=new JButton("Add Customer");
        addcustomer.setBounds(40,470,150,30);
        addcustomer.setFont(new Font("Tahoma",Font.PLAIN,14));
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.addActionListener(this);
        add(addcustomer);

        back=new JButton("Back");
        back.setBounds(220,470,150,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,50,300,400);
        add(image);


        setBounds(350,170,800,550);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addcustomer){
            String id=(String)cbid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="Male";
            }
            else if(rbfemale.isSelected()){
                gender="Female";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String checkintime=time.getText();
            String deposit=tfdeposit.getText();

            try{
                Conn conn=new Conn();
                String query="insert into customer values ('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+checkintime+"', '"+deposit+"')";
                String query2="update room set availability='Occupied' where roomnumber='"+room+"'";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new Reception();

            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else if (e.getSource()==back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }


}
