import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JButton cancel,adddriver;
    JComboBox cbavailable,cbgender;

    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    AddDriver(){

        setLayout(null);

        JLabel AddDriver =new JLabel("Add Drivers");
        AddDriver.setBounds(150,30,100,30);
        AddDriver.setFont(new Font("Tahoma",Font.BOLD,17));
        add(AddDriver);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,80,100,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(180,80,150,30);
        add(tfname);

        JLabel lblage=new JLabel("Age");
        lblage.setBounds(50,130,100,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(180,130,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(50,180,100,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblgender);

        String str[]={"Male","Female"};
        cbgender=new JComboBox(str);
        cbgender.setBounds(180,180,150,30);
        cbgender.setBackground(Color.white);
        add(cbgender);

        JLabel lblcarcompany=new JLabel("Car Company");
        lblcarcompany.setBounds(50,230,100,30);
        lblcarcompany.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblcarcompany);

        tfcompany=new JTextField();
        tfcompany.setBounds(180,230,150,30);
        add(tfcompany);

        JLabel lblcarmodel=new JLabel("Car Model");
        lblcarmodel.setBounds(50,280,100,30);
        lblcarmodel.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblcarmodel);

        tfmodel=new JTextField();
        tfmodel.setBounds(180,280,150,30);
        add(tfmodel);

        JLabel lblavailable=new JLabel("Available");
        lblavailable.setBounds(50,330,100,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lblavailable);

        String str1[]={"Available","Not Available"};
        cbavailable=new JComboBox(str1);
        cbavailable.setBounds(180,330,150,30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);

        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(50,380,100,30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(180,380,150,30);
        add(tflocation);

        adddriver=new JButton("Add Driver");
        adddriver.setBounds(50,430,150,30);
        adddriver.setBackground(Color.BLACK);
        adddriver.setForeground(Color.white);
        adddriver.setFont(new Font("Tahoma",Font.PLAIN,14));
        adddriver.addActionListener(this);
        add(adddriver);

        cancel=new JButton("Cancel");
        cancel.setBounds(230,430,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma",Font.PLAIN,14));
        cancel.addActionListener(this);
        add(cancel);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,330,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,70,350,330);
        add(image);

        setBounds(350,150,800,530);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==adddriver){
            String name=tfname.getText();
            String age=tfage.getText();
            String company=tfcompany.getText();
            String model=tfmodel.getText();
            String location =tflocation.getText();
            String gender=(String)cbgender.getSelectedItem();
            String available=(String)cbavailable.getSelectedItem();

            try{
                Conn conn=new Conn();

                String query="insert into driver values ('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+available+"', '"+location+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Driver Added Succesfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String arr[]){

        new AddDriver();
    }

}
