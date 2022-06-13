package com.example.javaweb_assignment.controller;

import com.example.javaweb_assignment.service.MerchantService;
import com.example.javaweb_assignment.service.impl.MerchantServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MerchantLoginServlet", value = "/merchantLoginServlet")
public class MerchantLoginServlet extends HttpServlet {

    MerchantService merchantService = new MerchantServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("name_Merchant");
        String password = request.getParameter("password_Merchant");

        boolean flag = merchantService.login(id,password);

        if(flag){
            request.getSession().setAttribute("belong",id);
            request.getRequestDispatcher("/GoodsListServlet").forward(request,response);
        }
        else{
            request.setAttribute("msg","登录失败");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
