/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tele.iti.Serv;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tele.iti.dao.RegisterDao;
import tele.iti.data.User;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Speed
 */
//@WebServlet("iti")
public class RegisterServ extends HttpServlet {
//    private static final long serialVersionUID = 1L;
   
     public static final String ACCOUNT_SID = "AC29f41bcc219243b234ebf024cc8c3961";
        public static final String AUTH_TOKEN = "fe7f87d98707586eab73fb8544ca6abc";

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");  
        HttpSession session = request.getSession();
          
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");

            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification = Verification.creator(
                "VA5ec79f629e8a76bae5b9115e05d990df", 
                phone,
                "sms").create();
         System.out.println(verification.getStatus());
          User user= new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                user.setPhone(phone);
                user.setBirthday(birthday);
                
                session.setAttribute("user", user);
               
         response.sendRedirect("verify.jsp");
        

         
            
        
       

    }
}