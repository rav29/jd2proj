package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.Message;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface MessageDao extends BaseDao<Message> {
    List<Message> findAllByDate (LocalDate localDate);

    List<Message> findAllByUserName(String userName);
}
