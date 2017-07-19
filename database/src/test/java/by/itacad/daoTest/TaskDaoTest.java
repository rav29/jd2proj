package by.itacad.daoTest;

import by.itacad.dao.GroupDao;
import by.itacad.dao.TaskDao;
import by.itacad.dao.TaskDaoImpl;
import by.itacad.dao.UserDao;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radion on 14.06.2017.
 */
public class TaskDaoTest extends BaseDaoTest<Task> {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private BaseDaoImpl<Task> dao = new TaskDaoImpl();


    @Override
    protected BaseDaoImpl<Task> getDao() {
        return dao;
    }

    @Override
    protected Task getModel() {
        return new Task();
    }


    public Long addedGroupId() {
        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");

        User mentorOne = new User();
        mentorOne.setEmail("mail");
        mentorOne.setName("Ментор");
        mentorOne.setPassword("123");
        mentorOne.setRegion(region);
        userDao.save(mentorOne);

        User memberOne = new User();
        memberOne.setEmail("mail1");
        memberOne.setName("Вася");
        memberOne.setPassword("123");
        memberOne.setRegion(region);
        userDao.save(memberOne);

        User memberTwo = new User();
        memberTwo.setEmail("mail2");
        memberTwo.setName("Коля");
        memberTwo.setPassword("123");
        memberTwo.setRegion(region);
        userDao.save(memberTwo);

        Set<User> members = new HashSet<>();
        members.add(memberOne);
        members.add(memberTwo);

        Group group = new Group();
        group.setCurrentTaskNumber(1);
        group.setGroupStatus(GroupStatus.FULL);
        group.setMaxNumberOfMembers(5);
        group.setMembers(members);
        group.setMentor(mentorOne);
        group.setName("Группа№1");
        group.setNumberOfTasks(50);
        Long groupId = groupDao.save(group);

        return groupId;
    }
/*

    @Test
    public void testSaveAndFindByID() {
        Task task = new Task();
        task.setTask("Задание1");
        task.setGroup(groupDao.findById(addedGroupId()));
        Long taskID = taskDao.save(task);
        Assert.assertNotNull("Вернулся NULL",taskDao.findById(taskID));
    }

    @Test
    public void testFindById() {
        Task task = new Task();
        task.setTask("Задание1");
        task.setGroup(groupDao.findById(addedGroupId()));
        Long taskID = taskDao.save(task);
        taskDao.deleteById(taskID);
        Assert.assertNull("Объект не удалён",taskDao.findById(taskID));
    }

    @Test
    public void testFindAll() {
        Long groupId = addedGroupId();
        Task task = new Task();
        task.setTask("Задание1");
        task.setGroup(groupDao.findById(groupId));
        taskDao.save(task);

        Task taskTwo = new Task();
        taskTwo.setTask("Задание2");
        taskTwo.setGroup(groupDao.findById(groupId));
        taskDao.save(taskTwo);

        List<Task> results = taskDao.findAll();
        List<String> tasks
                = results.stream().map(Task::getTask).collect(toList());
        Assert.assertEquals("количество заданий не совпадает", 2, results.size());
        Assert.assertTrue(tasks.contains("Задание1"));
        Assert.assertTrue(tasks.contains("Задание2"));
    }

    @Test
    public void testDeleteById() {
        Task task = new Task();
        task.setTask("Задание1");
        task.setGroup(groupDao.findById(addedGroupId()));
        Long taskId = taskDao.save(task);
        taskDao.deleteById(taskId);
        Assert.assertNull("объект не удалён",taskDao.findById(taskId));
    }
*/

}
