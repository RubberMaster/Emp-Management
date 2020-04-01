/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmnt.dao;

import empmgmnt.dbutil.DBConnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pravesh
 */
public class EmployeeDAO {
    public static boolean addEmployee(Employee e)throws SQLException
    { 
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?)");
        ps.setInt(1,e.getEmpNo());
        ps.setString(2,e.getEname());
        ps.setDouble(3,e.getSal());
        int ans=ps.executeUpdate();
        if(ans==1)
            return true;
        else
            return false;
    }

    public static Employee findEmployeeById(int eno)throws SQLException
{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employee where emp=?");//two possibilities record milega yaa nahi milega
        ps.setInt(1,eno);
        ResultSet rs=ps.executeQuery();//hamesha banega
        Employee e=null;//reference
        if(rs.next())
        { 
         e=new Employee();   
         e.setEmpNo(rs.getInt(1));
         e.setEname(rs.getString(2));
         e.setSal(rs.getDouble(3));
        }
        return e;
        
        }
    public static ArrayList<Employee> getAllEmployee()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employee");
        ResultSet rs=ps.executeQuery();
        ArrayList<Employee>empList=new ArrayList<Employee>();
        while(rs.next())
        {
         Employee e=new Employee();
         e.setEmpNo(rs.getInt(1));
         e.setEname(rs.getString(2));
         e.setSal(rs.getDouble(3));
         empList.add(e);
         
        
    }
    return empList;
}
}