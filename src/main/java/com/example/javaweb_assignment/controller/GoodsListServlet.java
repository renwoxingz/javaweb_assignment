package com.example.javaweb_assignment.controller;

import com.example.javaweb_assignment.pojo.Goods;
import com.example.javaweb_assignment.service.AdminService;
import com.example.javaweb_assignment.service.MerchantService;
import com.example.javaweb_assignment.service.impl.AdminServiceImpl;
import com.example.javaweb_assignment.service.impl.MerchantServiceImpl;
import com.example.javaweb_assignment.utils.StrUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GoodsListServlet", value = "/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MerchantService merchantService = new MerchantServiceImpl();
        AdminService adminService = new AdminServiceImpl();

        req.setAttribute("merchants",adminService.getMerchants());
        String creator = (String) req.getSession().getAttribute("belong");
        req.setAttribute("belong",creator);

        String model =  req.getParameter("model")==null?"init":req.getParameter("model");
        if(model.equals("delete")){
            String id = req.getParameter("id");
            int id_int = StrUtil.strToInt(id);
            if(merchantService.deleteGoodsById(id_int)){
                List<Goods> goodsList = merchantService.getGoodsList();
                req.setAttribute("goodsList", goodsList);
                req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
            }

        }else if(model.equals("add")){
            String id= req.getParameter("id-input");
            String name = req.getParameter("name-input");
            String price = req.getParameter("price-input");
            String info = req.getParameter("info-input");
            float price_float = StrUtil.strToFloat(price);
            int id_int = StrUtil.strToInt(id);
            String belong = creator;

            Goods goods = new Goods(name,belong,price_float,info,null,id_int);

            if(merchantService.insertGoods(goods)){
                List<Goods> goodsList = merchantService.getGoodsList();
                req.setAttribute("goodsList",goodsList);
                req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
            }
        }else if(model.equals("query")){
            String id = req.getParameter("queryById");
            int id_int = StrUtil.strToInt(id);
            List<Goods> goodsList = new ArrayList<>();
            goodsList.add(merchantService.queryGoodsById(id_int));
            req.setAttribute("goodsList", goodsList);
            req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
        }else if(model.equals("modify")){
            String id = req.getParameter("modifyId");
            int id_int = StrUtil.strToInt(id);
            String name = req.getParameter("name-input");
            String price = req.getParameter("price-input");
            float price_float = StrUtil.strToFloat(price);
            String info = req.getParameter("info-input");
            String belong = req.getParameter("belong-option");
            String picture = req.getParameter("picture");
            Goods goods = new Goods(name,belong,price_float,info,picture,id_int);
            if(merchantService.updateGoods(goods)){
                List<Goods> goodsList = merchantService.getGoodsList();
                req.setAttribute("goodsList",goodsList);
                req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
            }
        }
        else if(model.equals("init")){
            List<Goods> goodsList = merchantService.getGoodsList();
            req.setAttribute("goodsList",goodsList);
            req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
        }
    }
}
