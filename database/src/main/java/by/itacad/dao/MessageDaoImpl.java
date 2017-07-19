package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Message;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Radion on 13.06.2017.
 */
@Repository
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

    @Override
    public List<Message> findAllByDate(LocalDate localDate) {
        List<Message> messages = getSessionFactory().getCurrentSession()
                .createQuery("select m from Message m where m.date=:dateOfMessage", Message.class)
                .setParameter("dateOfMessage", localDate)
                .getResultList();

        return messages.size() > 0 ? messages : null;
    }

    @Override
    public List<Message> findAllByUserName(String userName) {
        List<Message> messages = getSessionFactory().getCurrentSession()
                .createQuery("select m from Message m where m.sender.name=:userName", Message.class)
                .setParameter("userName", userName)
                .getResultList();

        return messages.size() > 0 ? messages : null;
    }
    //:TODO по примеру BaseDaoImpl общие методы через модельки

}
