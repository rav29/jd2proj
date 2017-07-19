package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Achievement;
import by.itacad.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Radion on 13.06.2017.
 */
@Repository
public class AchievementDaoImpl extends BaseDaoImpl<Achievement> implements AchievementDao {

    @Override
    public List<Achievement> findByUserName(String userName) {
        List<Achievement> achievements = getSessionFactory().getCurrentSession()
                .createQuery("select a from Achievement a where a.user.name =:userName", Achievement.class)
                .setParameter("userName", userName)
                .getResultList();

        return achievements.size() > 0 ? achievements : null;
    }

    @Override
    public List<User> findUsersByAchievementName(String achievementName) {
        List<User> users = getSessionFactory().getCurrentSession()
                .createQuery("select a.user from Achievement a where a.name=:aName", User.class)
                .setParameter("aName", achievementName)
                .getResultList();

        return users.size() > 0 ? users : null;
    }
}
