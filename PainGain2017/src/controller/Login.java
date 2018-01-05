/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.*;
import model.*;

/**
 *
 * @author dangt
 */
public class Login extends HttpServlet {


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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
    	Date dNow = new Date( );
    	SimpleDateFormat hourft = new SimpleDateFormat ("HH");
        int curhour =  Integer.parseInt(hourft.format(dNow));
    	
     // chi co tk Admin hoat dong 24/24, tk nhan vien chi hoat dong tu 8h-21h
        
       
    	   String username = request.getParameter("username");
           String password = request.getParameter("password");
           AccountDAO nvacess = new AccountDAO();
           Account nv;
           // tinh thoi gian bat dau cham cong
           
           SimpleDateFormat curtimefm = new SimpleDateFormat ("HH:mm:ss");
           String curtime =  curtimefm.format(dNow);
           
            try {
                nv = nvacess.getAccountByName(username);
                if(nv == null){
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                 }else{
                   if (nv.getPass().equals(password))
                   {
                	   if (nv.getUserName().equals("admin"))
                	   {
                		   HttpSession session = request.getSession();
                           session.setAttribute("login", nv);
                           session.setAttribute("curtime", curtime);
                           response.sendRedirect("home.jsp");
                	   }
                	   else
                	   {
                		   if(nv.getTrangThai()==1)
                		   {
                			   if(curhour < 8 || curhour > 21)
                    	       {
                    	    	   response.sendRedirect("login.jsp");
                    	       }
                    	       else 
                    	       {
                    	    	   HttpSession session = request.getSession();
                                   session.setAttribute("login", nv);
                                   session.setAttribute("curtime", curtime);
                                   response.sendRedirect("home.jsp");
                    	       }
                		   }
                		   else
                		   {
                			   response.sendRedirect("login.jsp");
                		   }
                	       
                	   }
                   }
                   else 
                   {
                	   request.getRequestDispatcher("login.jsp").forward(request, response);
                   }
                }
            } catch (Exception ex) {
                //request.getRequestDispatcher("login.jsp").forward(request, response);
                response.getWriter().print(ex.getMessage());
            }
       
       
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
