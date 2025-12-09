package spring.ssh.service;

import spring.ssh.pojo.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getAllUser();

}
