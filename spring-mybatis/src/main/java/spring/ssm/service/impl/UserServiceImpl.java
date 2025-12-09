package spring.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.ssm.dao.UserDao;
import spring.ssm.pojo.User;
import spring.ssm.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.queryUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.queryAllUser();
    }

}
