package com.dj.user.controller;

import com.dj.config.Constant;
import com.dj.user.config.ServiceException;
import com.dj.user.model.User;
import com.dj.user.service.UserService;
import com.dj.util.JwtUtil;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dj.util.ResponseUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by dajiechen on 2017/7/25.
 */

@RestController
@RequestMapping("/users")
public class LoginRigisterController {

    @Autowired
    private UserService userService;

//    @Value("${jwt.secret}")
//    private String secret;

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public Object test() {

        return ResponseUtil.success("test sucess");
    }

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Map<String, Object> login(String username, String password) {

        return null;
    }



    /**
     *
     * @param username
     * @param password
     * @return
     * @throws TooManyResultsException
     */

    @RequestMapping(method = RequestMethod.POST, value = "/findBy")
    public Object findBy(String username, String password) throws TooManyResultsException {
        try {
            User userFind = new User();
//            userFind.setUserName(username);
            User user = userService.find(userFind);
            return user;
        } catch (Exception e) {
            throw new TooManyResultsException();
//            throw new ServiceException(e.getMessage(), e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findBy1")
    public Object findBy1(String username, String password) {

            User userFind = new User();
//            userFind.setUserName(username);
            User user = userService.find(userFind);
            return user;

    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public Object register(String username, String password) {

        if (username == null || username.length() == 0) {
            return ResponseUtil.exception("用戶名不能为空!");
        } else if (password == null || password.length() == 0) {
            return ResponseUtil.exception("密码不能为空");
        }
        User userFind = new User();
        userFind.setUserName(username);
        User user = userService.find(userFind);
        if(user != null){
            return ResponseUtil.exception("用户已存在");
        }

        user = new User();
        user.setUserName(username);
        user.setPassword(password);

        userService.save(user);

        Integer userId = user.getId();

        String token = null;
        if (userId != null) {
//            token = JwtUtil.generateToken(secret, userId.toString());
            token = JwtUtil.generateToken(Constant.JWT_SECRET, userId.toString());
        }

        return ResponseUtil.success(token);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(User user) {
        ModelMap result = new ModelMap();
        String msg = user.getId() == null ? "新增成功!" : "更新成功!";
        userService.save(user);
        result.put("content", user);
        result.put("msg", msg);
        return result;
    }
}
