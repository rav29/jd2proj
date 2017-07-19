package by.itacad.service;

import by.itacad.entities.Achievement;
import by.itacad.entities.User;
import by.itacad.service.Common.BaseService;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
public interface AchievementService extends BaseService{
    List<Achievement> findByUserName(String userName);

    List<User> findUsersByAchievementName(String achievementName);
}
