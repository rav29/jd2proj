package by.itacad.daoTest;

import by.itacad.dao.FeedBackMessageDao;
import by.itacad.dao.FeedBackMessageDaoImpl;
import by.itacad.dao.UserDao;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.FeedBackMessage;
import by.itacad.entities.Region;
import by.itacad.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Created by Radion on 19.06.2017.
 */
public class FeedBackMessageDaoTest extends BaseDaoTest<FeedBackMessage> {
    @Autowired
    private FeedBackMessageDao fbMessageDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BaseDaoImpl<FeedBackMessage> dao = new FeedBackMessageDaoImpl();

    @Override
    protected BaseDaoImpl<FeedBackMessage> getDao() {
        return dao;
    }

    @Override
    protected FeedBackMessage getModel() {
        return new FeedBackMessage();
    }

    private Long savedUserId() {
        User user = new User();
        user.setEmail("mail");
        user.setName("Вася");
        user.setPassword("123");
        Region region = new Region();
        region.setCity("Минск");
        region.setCountry("Рб");
        user.setRegion(region);
        return userDao.save(user);
    }

    private void addMessage() {
        Long userId = savedUserId();
        FeedBackMessage fbMessageOne = new FeedBackMessage();
        fbMessageOne.setMark(5);
        fbMessageOne.setSender(userDao.findById(userId));
        fbMessageOne.setMessage("message");
        fbMessageOne.setDate(LocalDateTime.now());
        fbMessageDao.save(fbMessageOne);

        FeedBackMessage fbMessageTwo = new FeedBackMessage();
        fbMessageTwo.setMark(5);
        fbMessageTwo.setSender(userDao.findById(userId));
        fbMessageTwo.setMessage("message");
        fbMessageTwo.setDate(LocalDateTime.now());
        fbMessageDao.save(fbMessageTwo);

        FeedBackMessage fbMessageThree = new FeedBackMessage();
        fbMessageThree.setMark(4);
        fbMessageThree.setSender(userDao.findById(userId));
        fbMessageThree.setMessage("message");
        fbMessageThree.setDate(LocalDateTime.now());
        fbMessageDao.save(fbMessageThree);
    }

    @Test
    public void testFindAllByMark(){
        addMessage();
        Assert.assertTrue(fbMessageDao.findAllByMark(5).size() == 2);

        clearH2();
    }
}
