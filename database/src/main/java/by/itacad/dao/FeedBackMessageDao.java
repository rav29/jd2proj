package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.FeedBackMessage;

import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface FeedBackMessageDao extends BaseDao<FeedBackMessage>  {

    List<FeedBackMessage> findAllByMark(int mark);
}
