package by.itacad.daoTest;

import by.itacad.dao.AchievementDao;
import by.itacad.dao.AchievementDaoImpl;
import by.itacad.dao.GroupDao;
import by.itacad.dao.UserDao;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radion on 14.06.2017.
 */
public class AchievementDaoTest extends BaseDaoTest<Achievement> {
    @Autowired
    private BaseDaoImpl<Achievement> dao = new AchievementDaoImpl();
    @Autowired
    private AchievementDao achievementDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;


    @Override
    protected BaseDaoImpl<Achievement> getDao() {
        return dao;
    }

    @Override
    protected Achievement getModel() {
        return new Achievement();
    }

    private void addAchievements() {
        Task task = new Task();
        task.setTask("Задание1");

        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");

        User mentor = new User();
        mentor.setEmail("mail12");
        mentor.setName("Ментор");
        mentor.setPassword("123");
        mentor.setRegion(region);
        userDao.save(mentor);

        User memberOne = new User();
        memberOne.setEmail("mail1");
        memberOne.setName("Вася");
        memberOne.setPassword("123");
        memberOne.setRegion(region);
        userDao.save(memberOne);

        User memberTwo = new User();
        memberTwo.setEmail("mail");
        memberTwo.setName("Коля");
        memberTwo.setPassword("123");
        memberTwo.setRegion(region);
        userDao.save(memberTwo);

        Set<User> membersOne = new HashSet<>();
        membersOne.add(memberOne);
        membersOne.add(memberTwo);

        Group group = new Group();
        group.setCurrentTaskNumber(1);
        group.setGroupStatus(GroupStatus.FULL);
        group.setMaxNumberOfMembers(5);
        group.setMembers(membersOne);
        group.setMentor(mentor);
        group.setName("Группа№1");
        group.setNumberOfTasks(50);
        groupDao.save(group);

        Achievement achievementOne = new Achievement();
        achievementOne.setGroup(group);
        achievementOne.setMentor(mentor);
        achievementOne.setUser(memberOne);
        achievementOne.setName("АчивкаОдин");
        achievementDao.save(achievementOne);

        Achievement achievementTwo = new Achievement();
        achievementTwo.setGroup(group);
        achievementTwo.setMentor(mentor);
        achievementTwo.setUser(memberTwo);
        achievementTwo.setName("АчивкаОдин");
        achievementDao.save(achievementTwo);
    }

    @Test
    public void testFindByUserName() {
        addAchievements();
        Assert.assertNotNull(achievementDao.findByUserName("Вася"));

        clearH2();
    }

    @Test
    public void testFindUsersByAchievementName() {
        addAchievements();
        Assert.assertTrue(achievementDao.findUsersByAchievementName("АчивкаОдин").size() == 2);

        clearH2();
    }
}
