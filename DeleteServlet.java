package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.repository.DeleteUser;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	DeleteUser dd=new DeleteUser();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user=request.getParameter("user");
		
		
		String result="";
		try {
			result = dd.deleteValues(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("Deleted Successfully")){
			out.println("Deleted Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");
			rd.include(request, response);
			
		}else{
			out.println("Failed");
			RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
			rd.include(request,response);
		}
	}

}
