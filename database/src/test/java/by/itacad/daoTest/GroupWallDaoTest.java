package by.itacad.daoTest;

import by.itacad.dao.GroupWallDaoImpl;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.GroupWall;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Radion on 14.06.2017.
 */
public class GroupWallDaoTest extends BaseDaoTest<GroupWall> {
    @Autowired
    private BaseDaoImpl<GroupWall> dao = new GroupWallDaoImpl();


    @Override
    protected BaseDaoImpl<GroupWall> getDao() {
        return dao;
    }

    @Override
    protected GroupWall getModel() {
        return new GroupWall();
    }
}
