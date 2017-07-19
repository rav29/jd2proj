package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Region;
import by.itacad.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Radion on 11.06.2017.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByName(String name) {
        List<User> userList = getSessionFactory().getCurrentSession().createQuery(
                "select u from User u where u.name=:name", User.class)
                .setParameter("name", name)
                .getResultList();
        return userList.get(0);
    }

    @Override
    public List<User> findAllByRegion(Region region) {
        List<User> userList = getSessionFactory().getCurrentSession().createQuery("select u from User u where u.region=:region", User.class)
                .setParameter("region", region)
                .getResultList();
        return userList.size() > 0 ? userList : null;
    }

}
