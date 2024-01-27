import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///hotelManagement","root","root");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
//
    }
}

//Register the Driver
//Establish a connection
//Create a statement
//Execute a query
//Close the connection
