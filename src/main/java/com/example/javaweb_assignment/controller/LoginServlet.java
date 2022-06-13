package com.example.javaweb_assignment.controller;

import com.example.javaweb_assignment.pojo.Admin;
import com.example.javaweb_assignment.service.AdminService;
import com.example.javaweb_assignment.service.impl.AdminServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_Login");
        String password = request.getParameter("password_Login");

        boolean flag = adminService.login(name,password);


        if(flag){
            request.getSession().setAttribute("admin",new Admin(name,password));
            request.setAttribute("kind","登录");
            request.getRequestDispatcher("/merchantManage").forward(request,response);
        }
        else{
            request.setAttribute("msg","用户名或密码不正确");
            request.setAttribute("name",name);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
