
package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class StudentDetails extends JFrame implements ActionListener
{
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    public StudentDetails()
    {
        
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        try
        {
           DatabaseConnection db = new DatabaseConnection();
           ResultSet rs = db.stm.executeQuery("select * from student");
           while(rs.next())
           {
               crollno.add(rs.getString("rollno"));
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        table = new JTable();
            
        try
        {
            DatabaseConnection db = new DatabaseConnection();
            ResultSet rs = db.stm.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
       
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == search)
        {
            String query ="select * from student where rollno ='"+crollno.getSelectedItem()+"'";
            try
            {
               DatabaseConnection db = new DatabaseConnection();
               ResultSet rs = db.stm.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == print)
        {
            try
            {
               table.print(); 
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }  
        else if(ae.getSource() == add)
        {
            setVisible(false);
            new AddStudent();
        }
        else if(ae.getSource() == update)
        {
            //new Updatestudent();
        }
        else
        {
            setVisible(false);
        }
    }  
    public static void main(String[] args) 
    {
        new StudentDetails();
    }
}
