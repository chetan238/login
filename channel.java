
package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Class.forName;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




public class channel extends HttpServlet 
{

    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("welcome");
        // System.out.println("class loaded");
       // JOptionPane.showMessageDialog(null,"Registered successful");
        String name=req.getParameter("user_name");
        String pass=req.getParameter("user_pass");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("class loaded");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(channel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/servlet","root","");
                PreparedStatement ps=cn.prepareStatement("insert into user_Data (`User_name`, `User`) values(?,?)");
         //        System.out.println("prepare loaded");      
                ps.setString(1,name);
                ps.setString(2,pass);
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null,"Registered successful");
            }
            
         catch (SQLException ex) {
            Logger.getLogger(channel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
