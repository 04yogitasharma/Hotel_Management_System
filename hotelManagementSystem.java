import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hotelManagementSystem extends JFrame implements ActionListener {

    hotelManagementSystem(){
        setSize(1166,565);
        setLocation(100,100);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        add(image);

        JLabel text=new JLabel("HOTEL  MANAGEMENT  SYSTEM");
        text.setBounds(30,470,800,30);
        text.setForeground(Color.GRAY);
        text.setFont(new Font("serif",Font.PLAIN,40));
        image.add(text);

        JButton next=new JButton("Next");
        next.setBounds(1000,480,100,30);
        next.setBackground(Color.cyan);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,20));
        image.add(next);
        setVisible(true);

        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

//        System.out.println("Hello world!");
        new hotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new login();
    }
}