package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.FeedBackMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Radion on 19.06.2017.
 */
@Repository
public class FeedBackMessageDaoImpl extends BaseDaoImpl<FeedBackMessage> implements FeedBackMessageDao {

    @Override
    public List<FeedBackMessage> findAllByMark(int mark) {
        List<FeedBackMessage> feedBackMessages = getSessionFactory().getCurrentSession()
                .createQuery("select m from FeedBackMessage m where m.mark=:mark", FeedBackMessage.class)
                .setParameter("mark", mark)
                .getResultList();
        return feedBackMessages.size() > 0 ? feedBackMessages : null;
    }
}
