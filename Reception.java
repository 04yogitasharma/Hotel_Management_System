import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton customerForm,rooms,employee,department,customer,manager,searchroom,updateroom,updateroomstatus,pickup,logout,checkout;
    Reception(){
        setLayout(null);

        customerForm =new JButton("New Customer Form");
        customerForm.setBounds(10,20,200,30);
        customerForm.setBackground(Color.black);
        customerForm.setForeground(Color.white);
        customerForm.setFont(new Font("Tahoma",Font.PLAIN,14));
        customerForm.addActionListener(this);
        add(customerForm);

        rooms =new JButton("Rooms");
        rooms.setBounds(10,60,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.setFont(new Font("Tahoma",Font.PLAIN,14));
        rooms.addActionListener(this);
        add(rooms);

        department =new JButton("Department Info");
        department.setBounds(10,100,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.setFont(new Font("Tahoma",Font.PLAIN,14));
        department.addActionListener(this);
        add(department);

        employee =new JButton("All Employees");
        employee.setBounds(10,140,200,30);
        employee.setBackground(Color.black);
        employee.setForeground(Color.white);
        employee.setFont(new Font("Tahoma",Font.PLAIN,14));
        employee.addActionListener(this);
        add(employee);

        customer =new JButton("Customer info");
        customer.setBounds(10,180,200,30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.setFont(new Font("Tahoma",Font.PLAIN,14));
        customer.addActionListener(this);
        add(customer);

        manager =new JButton("Manager info");
        manager.setBounds(10,220,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.setFont(new Font("Tahoma",Font.PLAIN,14));
        manager.addActionListener(this);
        add(manager);

        checkout =new JButton("Checkout");
        checkout.setBounds(10,260,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,14));
        checkout.addActionListener(this);
        add(checkout);

        updateroom =new JButton("Update Rooms");
        updateroom.setBounds(10,300,200,30);
        updateroom.setBackground(Color.black);
        updateroom.setForeground(Color.white);
        updateroom.setFont(new Font("Tahoma",Font.PLAIN,14));
        updateroom.addActionListener(this);
        add(updateroom);

        updateroomstatus=new JButton("Update Room Status");
        updateroomstatus.setBounds(10,340,200,30);
        updateroomstatus.setBackground(Color.black);
        updateroomstatus.setForeground(Color.white);
        updateroomstatus.setFont(new Font("Tahoma",Font.PLAIN,14));
        updateroomstatus.addActionListener(this);
        add(updateroomstatus);

        pickup =new JButton("Pickup Service");
        pickup.setBounds(10,380,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.setFont(new Font("Tahoma",Font.PLAIN,14));
        pickup.addActionListener(this);
        add(pickup);

        searchroom =new JButton("Search Room");
        searchroom.setBounds(10,420,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.setFont(new Font("Tahoma",Font.PLAIN,14));
        searchroom.addActionListener(this);
        add(searchroom);

        logout =new JButton("Logout");
        logout.setBounds(10,460,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Tahoma",Font.PLAIN,14));
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(160,20,620,470);
        add(image);


        setBounds(350,150,800,550);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==customerForm){
            setVisible(false);
            new AddCustomer();
        }
        else if(e.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(e.getSource()==department){
            setVisible(false);
            new Department();
        }
        else if(e.getSource()==employee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(e.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        }
        else if(e.getSource()==customer){
            setVisible(false);
            new CustomerInfo();
        }
        else if(e.getSource()==searchroom){
            setVisible(false);
            new SearchRoom();
        }
        else if(e.getSource()==updateroom){
            setVisible(false);
            new UpdateCheck();
        } else if (e.getSource()==updateroomstatus) {
            setVisible(false);
            new UpdateRoom();
        }
        else if(e.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }
        else if(e.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        else if(e.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
}
