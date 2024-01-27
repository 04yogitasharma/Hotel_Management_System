import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends  JFrame implements ActionListener {

    JButton addroom,cancel;
    JTextField tfroom,tfprice;
    JComboBox  cbavailability,cbcleaning,cbbtype;
    AddRooms(){
         setLayout(null);
         JLabel rooms =new JLabel("Add Rooms");
         rooms.setBounds(140,40,100,30);
         rooms.setFont(new Font("Tahoma",Font.BOLD,17));
         add(rooms);

         JLabel lblroom =new JLabel("Room Number");
         lblroom.setBounds(50,90,100,30);
         lblroom.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(lblroom);

         tfroom=new JTextField();
         tfroom.setBounds(170,90,150,30);
         add(tfroom);

        JLabel lblavailable =new JLabel("Available");
        lblavailable.setBounds(50,150,100,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblavailable);

        String[] str={"Available","Not Available"};
        cbavailability=new JComboBox(str);
        cbavailability.setBounds(170,150,150,30);
        cbavailability.setBackground(Color.white);
        add(cbavailability);

        JLabel lblcleainingstatus =new JLabel("Cleaning Status");
        lblcleainingstatus.setBounds(50,200,100,30);
        lblcleainingstatus.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblcleainingstatus);

        String str1[]={"Cleaned","Dirty"};
        cbcleaning=new JComboBox(str1);
        cbcleaning.setBounds(170,200,150,30);
        cbcleaning.setBackground(Color.white);
        add(cbcleaning);

        JLabel lblprice =new JLabel("Price");
        lblprice.setBounds(50,250,100,30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblprice);

        tfprice=new JTextField();
        tfprice.setBounds(170,250,150,30);
        add(tfprice);

        JLabel lblbedtype =new JLabel("Bed Type");
        lblbedtype.setBounds(50,300,100,30);
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblbedtype);

        String str2[]={"Double Bed","Single Bed"};
        cbbtype=new JComboBox(str2);
        cbbtype.setBounds(170,300,150,30);
        cbbtype.setBackground(Color.white);
        add(cbbtype);

        addroom=new JButton("Add Room");
        addroom.setBounds(50,370,120,30);
        addroom.setForeground(Color.white);
        addroom.setBackground(Color.BLACK);
        addroom.addActionListener(this);
        add(addroom);

        cancel=new JButton("Cancel");
        cancel.setBounds(190,370,120,30);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
//        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        JLabel image =new JLabel(i1);
        image.setBounds(350,50,400,300);
        add(image);

         getContentPane().setBackground(Color.white);
         setBounds(350,150,800,500);
         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addroom){
            String roomnumber=tfroom.getText();
            String availability=(String)cbavailability.getSelectedItem();
            String status=(String)cbcleaning.getSelectedItem();
            String price=tfprice.getText();
            String type=(String)cbbtype.getSelectedItem();

            try{
                Conn conn =new Conn();
                String query="insert into room values ('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);

            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }


}
