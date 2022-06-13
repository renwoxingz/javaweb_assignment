package com.example.javaweb_assignment.controller;

import com.example.javaweb_assignment.pojo.Merchant;
import com.example.javaweb_assignment.service.AdminService;
import com.example.javaweb_assignment.service.impl.AdminServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MerchantListServlet", urlPatterns = {"/merchantManage"})
public class MerchantListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();

        String model =  req.getParameter("model")==null?"init":req.getParameter("model");
        if(model.equals("delete")){
            String id = req.getParameter("id");
            if(adminService.deleteMerById(id)){
            List<Merchant> merchants = adminService.getMerchants();
            req.setAttribute("merchantList", merchants);
            req.getRequestDispatcher("/merchantManage.jsp").forward(req, resp);
            }

        }else if(model.equals("add")){
            String id= req.getParameter("id-input");
            String name = req.getParameter("name-input");
            String password = req.getParameter("password-input");
            String info = req.getParameter("info-input");
            Merchant merchant = new Merchant(name,id,password,info);
            if(adminService.insertMer(merchant)){
                List<Merchant> merchants = adminService.getMerchants();
                req.setAttribute("merchantList", merchants);
                req.getRequestDispatcher("/merchantManage.jsp").forward(req, resp);
            }
        }else if(model.equals("query")){
            String id = req.getParameter("queryById");
            List<Merchant> merchants = new ArrayList<>();
            merchants.add(adminService.queryMerById(id));
            req.setAttribute("merchantList", merchants);
            req.getRequestDispatcher("/merchantManage.jsp").forward(req, resp);
        }else if(model.equals("modify")){
            String id = req.getParameter("modifyId");
            String name = req.getParameter("name-input");
            String password = req.getParameter("password-input");
            String info = req.getParameter("info-input");
            Merchant merchant = new Merchant(name,id,password,info);
            if(adminService.updateMer(merchant)){
                List<Merchant> merchants = adminService.getMerchants();
                req.setAttribute("merchantList", merchants);
                req.getRequestDispatcher("/merchantManage.jsp").forward(req, resp);
            }
        }
        else if(model.equals("init")){
            List<Merchant> merchants = adminService.getMerchants();
            req.setAttribute("merchantList", merchants);
            req.getRequestDispatcher("/merchantManage.jsp").forward(req, resp);
        }
    }
}
