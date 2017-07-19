package by.itacad.service;

import by.itacad.dao.AchievementDao;
import by.itacad.entities.Achievement;
import by.itacad.entities.User;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
@Service
@Transactional
public class AchievementServiceImpl extends BaseServiceImpl<Achievement> implements AchievementService {
    @Autowired
    private AchievementDao achievementDao;


    @Override
    public List<Achievement> findByUserName(String userName) {
        return achievementDao.findByUserName(userName);
    }

    @Override
    public List<User> findUsersByAchievementName(String achievementName) {
        return achievementDao.findUsersByAchievementName(achievementName);

    }

    public void save(Achievement achievement) {
        achievementDao.save(achievement);
    }


}
