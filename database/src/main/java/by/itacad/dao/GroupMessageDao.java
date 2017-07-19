package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.GroupMessage;

import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface GroupMessageDao extends BaseDao<GroupMessage> {
    List<GroupMessage> getByGroupName(String groupName);
}
