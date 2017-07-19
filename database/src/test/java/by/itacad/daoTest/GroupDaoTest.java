package by.itacad.daoTest;

import by.itacad.dao.GroupDao;
import by.itacad.dao.GroupDaoImpl;
import by.itacad.dao.UserDao;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Group;
import by.itacad.entities.GroupStatus;
import by.itacad.entities.Region;
import by.itacad.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Radion on 14.06.2017.
 */
public class GroupDaoTest extends BaseDaoTest<Group> {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BaseDaoImpl<Group> dao = new GroupDaoImpl();


    @Override
    protected BaseDaoImpl<Group> getDao() {
        return dao;
    }

    @Override
    protected Group getModel() {
        return new Group();
    }


    private void addGroupToDB() {

        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");

        User mentor = new User();
        mentor.setEmail("mail12");
        mentor.setName("Ментор");
        mentor.setPassword("123");
        mentor.setRegion(region);
        userDao.save(mentor);

        User mentorTwo = new User();
        mentorTwo.setEmail("Ментор2@mail12");
        mentorTwo.setName("Ментор2");
        mentorTwo.setPassword("123");
        mentorTwo.setRegion(region);
        userDao.save(mentorTwo);

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

        User memberThree = new User();
        memberThree.setEmail("Миша@mail");
        memberThree.setName("Миша");
        memberThree.setPassword("123");
        memberThree.setRegion(region);
        userDao.save(memberThree);

        Set<User> membersOne = new HashSet<>();
        membersOne.add(memberOne);
        membersOne.add(memberTwo);

        Set<User> membersTwo = new HashSet<>();
        membersTwo.add(memberThree);
        membersTwo.add(memberTwo);

        Group group = new Group();
        group.setCurrentTaskNumber(1);
        group.setGroupStatus(GroupStatus.FULL);
        group.setMaxNumberOfMembers(5);
        group.setMembers(membersOne);
        group.setMentor(mentor);
        group.setName("Группа№1");
        group.setNumberOfTasks(50);
        groupDao.save(group);

        Group groupTwo = new Group();
        groupTwo.setCurrentTaskNumber(1);
        groupTwo.setGroupStatus(GroupStatus.HAS_VACANCY);
        groupTwo.setMaxNumberOfMembers(5);
        groupTwo.setMembers(membersTwo);
        groupTwo.setMentor(mentorTwo);
        groupTwo.setName("Группа№2");
        groupTwo.setNumberOfTasks(50);
        groupDao.save(groupTwo);

    }

    @Test
    public void testFindByName() {
        addGroupToDB();
        Assert.assertNotNull(groupDao.findByName("Группа№2"));

        clearH2();
    }

    @Test
    public void testFindByStatus() {
        addGroupToDB();
        Assert.assertTrue(groupDao.findByStatus(GroupStatus.HAS_VACANCY).get(0).getName().equals("Группа№2"));

        clearH2();
    }

    @Test
    public void testFindByMemberName() {
        addGroupToDB();
        List<Group> groups = groupDao.findByMemberName("Миша");
        Assert.assertTrue(groups.get(0).getName().equals("Группа№2"));
        Assert.assertTrue(groups.size() == 1);

        clearH2();
    }

    @Test
    public void testFindByMentorName() {
        addGroupToDB();

        List<Group> groups = groupDao.findByMentorName("Ментор");
        Assert.assertTrue(groups.get(0).getName().equals("Группа№1"));
        Assert.assertTrue(groups.size() == 1);

        clearH2();
    }

    @Test
    public void testAddMember() {
        addGroupToDB();
        Group group = groupDao.findByName("Группа№2");

        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");

        User memberOne = new User();
        memberOne.setEmail("Гриша@mail1");
        memberOne.setName("Гриша");
        memberOne.setPassword("123");
        memberOne.setRegion(region);
        userDao.save(memberOne);

        groupDao.addMember(group, memberOne);

        Assert.assertTrue(groupDao.findByName("Группа№2").getMembers().contains(memberOne));

        clearH2();
    }

    @Test
    public void testExcludeMember() {
        addGroupToDB();

        Group group = groupDao.findByName("Группа№2");
        groupDao.excludeMember(group, userDao.findByName("Миша"));

        Assert.assertFalse(groupDao.findByName("Группа№2").getMembers().contains(userDao.findByName("Миша")));

        clearH2();
    }

    @Test
    public void testCurrentTaskNumberUp() {
        addGroupToDB();

        groupDao.currentTaskNumberUp(groupDao.findByName("Группа№2"));
        Assert.assertTrue(groupDao.findByName("Группа№2").getCurrentTaskNumber() == 2);

        clearH2();
    }

    @Test
    public void testChangeGroupStatus() {
        addGroupToDB();

        Group group = groupDao.findByName("Группа№2");
        groupDao.changeGroupStatus(group, GroupStatus.FULL);

        Assert.assertTrue(groupDao.findByName("Группа№2").getGroupStatus().equals(GroupStatus.FULL));

        clearH2();
    }

}
