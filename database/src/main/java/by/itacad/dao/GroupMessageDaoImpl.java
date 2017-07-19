package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.GroupMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Radion on 19.06.2017.
 */
@Repository
public class GroupMessageDaoImpl extends BaseDaoImpl<GroupMessage> implements GroupMessageDao {

    @Override
    public List<GroupMessage> getByGroupName(String groupName) {
        List<GroupMessage> groupMessages = getSessionFactory().getCurrentSession()
                .createQuery("select m from GroupMessage m where m.group.name=:groupName", GroupMessage.class)
                .setParameter("groupName", groupName)
                .getResultList();

        return groupMessages.size() > 0 ? groupMessages : null;
    }
}
