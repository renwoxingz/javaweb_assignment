package com.example.javaweb_assignment.mapper;


import com.example.javaweb_assignment.pojo.Admin;

/**
 * admin接口
 */
public interface AdminMapper {
    /**
     * 插入Admin
     * @param admin 输入的admin对象
     * @return 是否插入成功
     */
    public boolean insertAdmin(Admin admin);

    /**
     * 根据id删除Admin
     * @param id 要删除的姓名
     * @return 是否删除成功
     */
    public boolean deleteAdminById(String id);

    /**
     * 根据名字查询对象
     * @param name 要查询的对象名字
     * @return 返回对象
     */
    public Admin queryAdminByName(String name);

    /**
     * 更新admin
     * @param admin 更新信息
     * @return 是否成功
     */
    public boolean updateAdmin(Admin admin);
}
