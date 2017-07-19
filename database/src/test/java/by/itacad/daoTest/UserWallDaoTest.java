package by.itacad.daoTest;

import by.itacad.dao.UserWallDaoImpl;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.UserWall;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Radion on 14.06.2017.
 */
public class UserWallDaoTest extends BaseDaoTest<UserWall>{
    @Autowired
    private BaseDaoImpl<UserWall> dao = new UserWallDaoImpl();

    @Override
    protected BaseDaoImpl<UserWall> getDao() {
        return dao;
    }

    @Override
    protected UserWall getModel() {
        return new UserWall();
    }
}
