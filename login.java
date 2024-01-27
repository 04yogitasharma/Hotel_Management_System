import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {   

    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    login(){
        setBounds(500,200,500,300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user=new JLabel("Username");
        user.setBounds(20,20,100,30);
        add(user);

        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(20,70,100,30);
        add(pass);

        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);

        login=new JButton("Login");
        login.setBounds(40,130,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(170,130,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(280,8,200,200);
        add(image);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            String user=username.getText();
            String pass=password.getText();
            try{
                Conn c=new Conn();
                String query="select * from login where username = '"+user +"' and password = '"+ pass+"'";
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            }catch(Exception ae){
                ae.printStackTrace();
            }

        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new login();
    }


}