package com.example.javaweb_assignment.service.impl;




import com.example.javaweb_assignment.mapper.AdminMapper;
import com.example.javaweb_assignment.mapper.MerchantMapper;
import com.example.javaweb_assignment.pojo.Admin;
import com.example.javaweb_assignment.pojo.Merchant;
import com.example.javaweb_assignment.service.AdminService;
import com.example.javaweb_assignment.utils.GetSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();

    /**
     * 登录
     * @param name 输入的姓名
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String name ,String password){
        boolean flag;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.queryAdminByName(name);
        flag = admin.getPassword().equals(password);
        sqlSession.close();
        return flag;
    }

    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    public boolean register(String name,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        try{
            boolean flag;
            Admin admin = new Admin(name,password);
            flag = adminMapper.insertAdmin(admin);
            return flag;
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return false;
    }

    /**
     * 添加商家
     * @param merchant 要插入的对象
     * @return 是否插入成功
     */
    public boolean insertMer(Merchant merchant){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);
        boolean flag = merchantMapper.insertMer(merchant);
        sqlSession.close();
        return flag;
    }

    /**
     * 根据Id删除商家
     * @param id 要删除商家的Id
     * @return 是否删除成功
     */
    public boolean deleteMerById(String id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);
        boolean flag = merchantMapper.deleteMerById(id);
        sqlSession.close();
        return flag;
    }

    /**
     * 更新商家信息
     * @param merchant 更新数据
     * @return 是否更新成功
     */
    public boolean updateMer(Merchant merchant){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);
        boolean flag = merchantMapper.updateMer(merchant);
        sqlSession.close();
        return flag;
    }

    /**
     * 根据ID查询商家
     * @param id 查询商家的ID
     * @return 返回查询到的对象
     */
    public Merchant queryMerById(String id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);
        Merchant flag = merchantMapper.queryMerById(id);
        sqlSession.close();
        return flag;
    }

    /**
     * 获取所有商家信息
     * @return 商家列表
     */
    public List<Merchant> getMerchants(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);
        List<Merchant> flag = merchantMapper.getMerchants();
        sqlSession.close();
        return flag;
    }
}
