package by.itacad.daoTest;

import by.itacad.dao.GroupDao;
import by.itacad.dao.GroupMessageDao;
import by.itacad.dao.GroupMessageDaoImpl;
import by.itacad.dao.UserDao;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radion on 19.06.2017.
 */
public class GroupMessageDaoTest extends BaseDaoTest<GroupMessage> {
    @Autowired
    private GroupMessageDao gmDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private BaseDaoImpl<GroupMessage> dao = new GroupMessageDaoImpl();


    @Override
    protected BaseDaoImpl<GroupMessage> getDao() {
        return dao;
    }

    @Override
    protected GroupMessage getModel() {
        return new GroupMessage();
    }

    private Long savedGroupId() {
        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");

        User mentorOne = new User();
        mentorOne.setEmail("mail5");
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
        return groupDao.save(group);
    }

    private Long savedUserId() {
        User user = new User();
        user.setEmail("mail");
        user.setName("Витя");
        user.setPassword("123");
        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");
        user.setRegion(region);
        return userDao.save(user);
    }


    private void addMessages() {
        Long groupId = savedGroupId();
        Long userId = savedUserId();

        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroup(groupDao.findById(groupId));
        groupMessage.setSender(userDao.findById(userId));
        groupMessage.setMessage("message");
        groupMessage.setDate(LocalDateTime.now());
        gmDao.save(groupMessage);

        GroupMessage groupMessageTwo = new GroupMessage();
        groupMessageTwo.setGroup(groupDao.findById(groupId));
        groupMessageTwo.setSender(userDao.findById(userId));
        groupMessageTwo.setMessage("message");
        groupMessageTwo.setDate(LocalDateTime.now());
        gmDao.save(groupMessageTwo);


    }

    @Test
    public void testGetByGroupName() {
        addMessages();

        Assert.assertTrue(gmDao.getByGroupName("Группа№1").size() == 2);

        clearH2();
    }

}
