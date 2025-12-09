package spring.boot.hibernate.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.boot.hibernate.pojo.User;
import spring.boot.hibernate.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> allUsers() {
        List<User> users = userService.findAllUser();
        if(users != null){
            log.info("users size is " + users.size() + ".");
        }
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if(user != null){
            log.info("user is " + user + ".");
        }
        return user;
    }

}
