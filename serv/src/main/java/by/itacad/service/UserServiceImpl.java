package by.itacad.service;


import by.itacad.dao.UserDao;
import by.itacad.entities.Region;
import by.itacad.entities.User;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Radion on 12.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> findAllByRegion(Region region) {
        return userDao.findAllByRegion(region);
    }
}
