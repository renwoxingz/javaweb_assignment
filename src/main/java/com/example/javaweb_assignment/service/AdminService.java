package com.example.javaweb_assignment.service;

import com.example.javaweb_assignment.pojo.Admin;
import com.example.javaweb_assignment.pojo.Merchant;

import java.util.List;

public interface AdminService {
    /**
     * 登录
     * @param name 输入的姓名
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String name ,String password);

    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    public boolean register(String name,String password);

    /**
     * 添加商家
     * @param merchant 要插入的对象
     * @return 是否插入成功
     */
    public boolean insertMer(Merchant merchant);

    /**
     * 根据Id删除商家
     * @param id 要删除商家的Id
     * @return 是否删除成功
     */
    public boolean deleteMerById(String id);

    /**
     * 更新商家信息
     * @param merchant 更新数据
     * @return 是否更新成功
     */
    public boolean updateMer(Merchant merchant);

    /**
     * 根据ID查询商家
     * @param id 查询商家的ID
     * @return 返回查询到的对象
     */
    public Merchant queryMerById(String id);

    /**
     * 获取所有商家信息
     * @return 商家列表
     */
    public List<Merchant> getMerchants();
}
