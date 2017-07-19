package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.Region;
import by.itacad.entities.User;

import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface UserDao extends BaseDao<User> {
    User findByName(String name);

    List<User> findAllByRegion(Region region);
}
