import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard  extends JFrame implements ActionListener {
    JMenuItem reception,AddEmployee,AddRooms,AddDrivers;
    Dashboard(){
        setBounds(0,0,1450,800);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1400,800);
        add(image);

        JLabel text=new JLabel("THE  TAJ  GROUP  WELCOMES  YOU");
        text.setBounds(400,50,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,40));
        text.setForeground(Color.white);
        image.add(text);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1400,30);
        mb.setBackground(Color.white);
        image.add(mb);

        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        reception =new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin=new JMenu("Admin");
        admin.setForeground(Color.blue);
        mb.add(admin);

        AddEmployee =new JMenuItem("Add Employee");
        AddEmployee.addActionListener(this);
        admin.add(AddEmployee);

        AddRooms =new JMenuItem("Add Rooms");
        AddRooms.addActionListener(this);
        admin.add(AddRooms);

        AddDrivers =new JMenuItem("Add Drivers");
        AddDrivers.addActionListener(this);
        admin.add(AddDrivers);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals(("Reception"))){
            new Reception();
        }
    }
    public static void main(String[] args) {

        new Dashboard();
    }
}
