package spring.ssm.service;

import spring.ssm.pojo.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getAllUser();

}
