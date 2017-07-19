package by.itacad.service;

import by.itacad.dao.GroupMessageDao;
import by.itacad.entities.GroupMessage;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
@Service
@Transactional
public class GroupMessageServiceImpl extends BaseServiceImpl<GroupMessage> implements GroupMessageService{


    private final GroupMessageDao groupMessageDao;
    @Autowired
    public GroupMessageServiceImpl(GroupMessageDao groupMessageDao) {
        this.groupMessageDao = groupMessageDao;
    }

    @Override
    public List<GroupMessage> getByGroupName(String groupName) {
        return groupMessageDao.getByGroupName(groupName);
    }
}
