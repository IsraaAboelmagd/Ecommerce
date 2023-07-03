/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tele.iti.Serv;

import com.twilio.rest.verify.v2.service.VerificationCheck;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tele.iti.dao.RegisterDao;
import tele.iti.data.User;

/**
 *
 * @author Admin
 */
public class VerfiyServ extends HttpServlet {
 private RegisterDao registerDao;
 @Override
    public void init() {
        registerDao = new RegisterDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String code = request.getParameter("code");
          User user = (User) request.getSession().getAttribute("user");
         String phoneNumber = user.getPhone();
            PrintWriter out = response.getWriter(); 
         try {

            VerificationCheck verificationCheck = VerificationCheck.creator(
                            "VA5ec79f629e8a76bae5b9115e05d990df")
                    .setTo(phoneNumber) /// change with register phone number
                    .setCode(code) ///change with code sent to the number make a jsp page to enterd code
                    .create();

//            System.out.println(verificationCheck.getStatus());
            if (verificationCheck.getStatus().equals("approved"))
            {
                ///save user info to database
                ///appear message said register is successed
                try {
                   int i = registerDao.registerUser(user);
                    if(i>0)  
                       response.sendRedirect("login.jsp"); 
                    else 
                        out.print("failed register");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
                System.out.println("wrong code");
        }
    }
    
  
}
