package by.itacad.daoTest;

import by.itacad.dao.*;
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
public class DiaryDaoTest extends BaseDaoTest<Diary> {

    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private DiaryDao diaryDao;

    @Autowired
    private BaseDaoImpl<Diary> dao = new DiaryDaoImpl();


    @Override
    protected BaseDaoImpl<Diary> getDao() {
        return dao;
    }

    @Override
    protected Diary getModel() {
        return new Diary();
    }


    private void addDiary() {
        Task taskOne = new Task();
        taskOne.setTask("Задание1");
        taskDao.save(taskOne);

        Task taskTwo = new Task();
        taskOne.setTask("Задание2");
        taskDao.save(taskTwo);

        Set<Task> tasks = new HashSet<>();
        tasks.add(taskOne);
        tasks.add(taskTwo);

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

        Diary diaryOne = new Diary();
        diaryOne.setFinishedTasks(tasks);
        diaryOne.setGroup(group);
        diaryOne.setTasksPassed(2);
        diaryOne.setTasksToFinish(10);
        diaryOne.setUser(memberOne);
        diaryDao.save(diaryOne);

        Diary diaryTwo = new Diary();
        diaryTwo.setFinishedTasks(tasks);
        diaryTwo.setGroup(group);
        diaryTwo.setTasksPassed(2);
        diaryTwo.setTasksToFinish(9);
        diaryTwo.setUser(memberTwo);
        diaryDao.save(diaryTwo);

    }

    @Test
    public void testFindByUserName() {
        addDiary();
        Assert.assertNotNull(diaryDao.findByUserName("Вася"));
        clearH2();
    }

    @Test
    public void testFindByGroupName() {
        addDiary();

        Assert.assertTrue(diaryDao.findByGroupName("Группа№1").size() == 2);

        clearH2();
    }

    @Test
    public void testOneMoreTaskPassed() {
        addDiary();
        diaryDao.oneMoreTaskPassed(diaryDao.findByUserName("Вася").get(0));
        Assert.assertTrue(diaryDao.findByUserName("Вася").get(0).getTasksPassed() == 3);
        Assert.assertTrue(diaryDao.findByUserName("Вася").size() == 1);

        clearH2();
    }
}
