import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname,tfage,tfsalary,tfphone,tfaadhar,tfemail;
    JButton submit;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjob;

    AddEmployee(){
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(50,30,100,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel age = new JLabel("AGE");
        age.setBounds(50,80,100,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);

        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lblgender= new JLabel("GENDER");
        lblgender.setBounds(50,130,100,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);

        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(290,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob =new JLabel("JOB");
        lbljob.setBounds(50,180,100,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);

        String[] str={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);


        JLabel salary = new JLabel("SALARY");
        salary.setBounds(50,230,100,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);

        tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(50,280,100,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);

        tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(50,330,100,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);

        tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(50,380,100,30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(aadhar);

        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

        submit =new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(200,460,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,80,350,300);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,150,750,560);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name= tfname.getText();
        String age= tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String aadhar=tfaadhar.getText();
        String email=tfemail.getText();

        String gender=null;

        if(rbmale.isSelected()){
            gender="Male";
        } else if (rbfemale.isSelected()) {
            gender="Female";
        }

        String job=(String)cbjob.getSelectedItem();

        try{
            Conn conn=new Conn();

            String query="insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            setVisible(false);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new AddEmployee();
    }


}
