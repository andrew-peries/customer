/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import cusServices.cusServices;
import customer.customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "Logservlet", urlPatterns = {"/Logservlet"})
public class Logservlet extends HttpServlet {

    
    cusServices cus = new cusServices();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Logservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Logservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
              String userid=request.getParameter("userid");
        String password=request.getParameter("password");
       HttpSession session=request.getSession();
        
       int i = cus.checkcustomer(userid, password);
       if(i==1){
        session.setAttribute("userid",userid);
        
           //response.sendRedirect("reg.jsp");
          RequestDispatcher dispatcher = request.getRequestDispatcher("registration/../shop.jsp");
          dispatcher.forward(request, response);
       }
       else{
          response.sendRedirect("registration/login.jsp");
        //  RequestDispatcher dispatcher = request.getRequestDispatcher("registration/reg.jsp");
          //dispatcher.forward(request, response);
         
       }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String userid=request.getParameter("userid");
        String password=request.getParameter("password");
       
        
        cus.checkcustomer(userid, password);
        
      
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
   /*     String userid=request.getParameter("userid");
        String password=request.getParameter("password");
       
        
       int i = cus.checkcustomer(userid, password);
       if(i==1){
        
           //response.sendRedirect("reg.jsp");
          RequestDispatcher dispatcher = request.getRequestDispatcher("../shop.jsp");
          dispatcher.forward(request, response);
       }
       else{
         //  response.sendRedirect("registration/login.jsp");
          RequestDispatcher dispatcher = request.getRequestDispatcher("registration/login.jsp");
          dispatcher.forward(request, response);
         
       } */
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
