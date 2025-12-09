package spring.boot.hibernate.service;

import spring.boot.hibernate.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(Long id);

}
