package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.Achievement;
import by.itacad.entities.User;

import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface AchievementDao extends BaseDao<Achievement> {
    List<Achievement> findByUserName(String userName);

    List<User> findUsersByAchievementName(String achievementName);

}
