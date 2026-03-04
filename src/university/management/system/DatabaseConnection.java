
package university.management.system;

import java.sql.*;
public class DatabaseConnection 
{
    String Driver="com.mysql.cj.jdbc.Driver";
    String DBURL="jdbc:mysql:///universitymanagementsystem";
    String DBUSERNAME="root";
    String DBPASSWORD="Upendra@123";
   
    Connection con;
    Statement stm;
    
    DatabaseConnection()
    {
        try
        {
            Class.forName(Driver);
            con =  DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
            stm = con.createStatement();
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
}
