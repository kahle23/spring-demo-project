package spring.ssh.dao;

import spring.ssh.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据id查询用户信息
     */
    User queryUserById(Long id);

    List<User> queryAllUser();

}
