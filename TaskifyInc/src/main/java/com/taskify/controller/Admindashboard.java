package com.taskify.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.taskify.service.AdminDashboardService;
import com.taskify.service.taskifyLoginService;

;


/**
 * Servlet implementation class Job
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admindashboard" })
public class Admindashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AdminDashboardService DashboardService=new AdminDashboardService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admindashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           
            
            // Forward to jobpage.jsp where the jobs will be displayed
        	int usercount = DashboardService.getUserCount();
        	int jobcount = DashboardService.getJobCount();
        	int pendingjobcount = DashboardService.getPendingJobApprovals();
        	int totaladmincount = DashboardService.getTotalAdmin();
    		request.setAttribute("userCount",usercount);
    		request.setAttribute("jobCount",jobcount);
    		request.setAttribute("PendingJobCount", pendingjobcount);
    		request.setAttribute("TotalAdminCount", totaladmincount);
    		request.getRequestDispatcher("/WEB-INF/pages/admindashboard.jsp").forward(request, response);
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
