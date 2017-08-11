package com.dj.user.service;

import com.dj.user.dao.UserDao;
import com.dj.user.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dajiechen on 2017/8/3.
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAll(User user) {
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        return userDao.selectAll();
    }

    public User find(User user){

        User userResult = userDao.selectOne(user);
        return userResult;
    }

    public void save(User user) {
        if (user.getId() != null) {
            userDao.updateByPrimaryKey(user);
        } else {
            userDao.insert(user);
        }
    }
}
