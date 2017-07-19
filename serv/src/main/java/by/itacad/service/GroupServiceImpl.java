package by.itacad.service;

import by.itacad.dao.GroupDao;
import by.itacad.entities.Group;
import by.itacad.entities.GroupStatus;
import by.itacad.entities.User;
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
public class GroupServiceImpl extends BaseServiceImpl<Group> implements GroupService {


    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public Group findByName(String groupName) {
        return groupDao.findByName(groupName);
    }

    @Override
    public List<Group> findByStatus(GroupStatus groupStatus) {
        return groupDao.findByStatus(groupStatus);
    }

    @Override
    public List<Group> findByMemberName(String memberName) {
        return groupDao.findByMemberName(memberName);
    }

    @Override
    public List<Group> findByMentorName(String mentorName) {
        return groupDao.findByMentorName(mentorName);
    }

    @Override
    public void addMember(Group group, User user) {
        groupDao.addMember(group,user);
    }

    @Override
    public void excludeMember(Group group, User user) {
        groupDao.excludeMember(group,user);
    }

    @Override
    public void currentTaskNumberUp(Group group) {
        groupDao.currentTaskNumberUp(group);
    }

    @Override
    public void changeGroupStatus(Group group, GroupStatus newStatus) {
        groupDao.changeGroupStatus(group, newStatus);
    }
}
