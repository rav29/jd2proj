package by.itacad.daoTest;

import by.itacad.dao.UserDao;
import by.itacad.dao.UserDaoImpl;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Region;
import by.itacad.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Radion on 14.06.2017.
 */

public class UserDaoTest extends BaseDaoTest<User> {
    @Autowired
    private BaseDaoImpl<User> dao = new UserDaoImpl();

    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDaoImpl<User> getDao() {
        return dao;
    }

    @Override
    protected User getModel() {
        return new User();
    }

    private void addUsersToDB() {
        Region regionOne = new Region();
        regionOne.setCity("Минск");
        regionOne.setCountry("Рб");

        Region regionTwo = new Region();
        regionTwo.setCity("Москва");
        regionTwo.setCountry("Рф");

        User user = new User();
        user.setEmail("mail");
        user.setName("Вася");
        user.setPassword("123");
        user.setRegion(regionOne);
        userDao.save(user);

        User userTwo = new User();
        userTwo.setEmail("mail1");
        userTwo.setName("Петя");
        userTwo.setPassword("123");
        userTwo.setRegion(regionOne);
        userDao.save(userTwo);

        User userThree = new User();
        userThree.setEmail("mail2");
        userThree.setName("Коля");
        userThree.setPassword("123");
        userThree.setRegion(regionTwo);
        userDao.save(userThree);

    }

    @Test
    public void testGetUsersByRegion() {
        addUsersToDB();

        Region regionOne = new Region();
        regionOne.setCity("Минск");
        regionOne.setCountry("Рб");

        Assert.assertTrue(userDao.findAllByRegion(regionOne).size()==2);

        clearH2();
    }

    @Test
    public void testFindByName(){
        addUsersToDB();
        Assert.assertTrue(userDao.findByName("Вася").getName().equals("Вася"));

        clearH2();
    }

}
