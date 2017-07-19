package by.itacad.service;

import by.itacad.dao.UserWallDao;
import by.itacad.entities.UserWall;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Radion on 18.07.2017.
 */
@Service
@Transactional
public class UserWallServiceImpl extends BaseServiceImpl<UserWall> implements UserWallService{

    private UserWallDao userWallDao;

    @Autowired
    public UserWallServiceImpl(UserWallDao userWallDao) {
        this.userWallDao = userWallDao;
    }

}
