/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmnt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pravesh
 */
public class DBConnection {
    private static Connection conn;
    static
    {
     try
        {

      Class.forName("oracle.jdbc.OracleDriver");
      System.out.println("class loaded successfully");
      conn=DriverManager.getConnection("jdbc:oracle:thin:@//RubberMaster:1521/xe","project","java");
      JOptionPane.showMessageDialog(null,"Connected to the database","Sucess!",JOptionPane.INFORMATION_MESSAGE);
         }
      catch(Exception ex)
      {
      JOptionPane.showMessageDialog(null,"Error "+ex,"Failed!",JOptionPane.ERROR_MESSAGE);
      System.out.println("Exception is"+ex);
      }
       }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        if(conn!=null)
    {
    try
  {
   conn.close();
   JOptionPane.showMessageDialog(null,"Successfully disconnected from the Database","Success!",JOptionPane.INFORMATION_MESSAGE);
   }
   catch(SQLException sq)
  {
  JOptionPane.showMessageDialog(null,"Error "+sq,"Failed!",JOptionPane.ERROR_MESSAGE);
  }
  }
  }
  }

        
