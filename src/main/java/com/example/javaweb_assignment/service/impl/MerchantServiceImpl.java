package com.example.javaweb_assignment.service.impl;




import com.example.javaweb_assignment.mapper.GoodsMapper;
import com.example.javaweb_assignment.mapper.MerchantMapper;
import com.example.javaweb_assignment.pojo.Goods;
import com.example.javaweb_assignment.pojo.Merchant;
import com.example.javaweb_assignment.service.MerchantService;
import com.example.javaweb_assignment.utils.GetSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class MerchantServiceImpl implements MerchantService {
    SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();

    /**
     * 登录
     * @param id 输入的ID
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String id ,String password){
        boolean flag;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = sqlSession.getMapper(MerchantMapper.class);
        Merchant merchant = merchantMapper.queryMerById(id);
        sqlSession.close();
        if(merchant==null){
            return false;
        }
        flag = merchant.getPassword().equals(password);
        return flag;
    }

    /**
     * 添加商品
     * @param goods 要添加的商品对象
     * @return 是都插入成功
     */
    public boolean insertGoods(Goods goods){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        boolean flag = goodsMapper.insertGoods(goods);
        sqlSession.close();
        return flag;
    }

    /**
     * 根据ID删除商品
     * @param id 要删除商品的ID
     * @return 是否成功删除
     */
    public boolean deleteGoodsById(int id ){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        boolean flag = goodsMapper.deleteGoodsById(id);
        sqlSession.close();
        return flag;
    }

    /**
     * 更新商品
     * @param goods 要更新的商品
     * @return 是否更新成功
     */
    public boolean updateGoods(Goods goods){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        boolean flag = goodsMapper.updateGoods(goods);
        sqlSession.close();
        return flag;
    }

    /**
     * 根据Id查询对象
     * @param id 要查询商品的id
     * @return 返回对象
     */
    public Goods queryGoodsById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods flag = goodsMapper.queryGoodsById(id);
        sqlSession.close();
        return flag;
    }

    /**
     * 获取Goods列表
     * @return
     */
    public List<Goods> getGoodsList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> flag = goodsMapper.getGoodsList();
        sqlSession.close();
        return flag;
    }
}
