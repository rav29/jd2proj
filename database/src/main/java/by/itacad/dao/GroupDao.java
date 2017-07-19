package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.Group;
import by.itacad.entities.GroupStatus;
import by.itacad.entities.User;

import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface GroupDao extends BaseDao<Group> {

    Group findByName(String groupName);

    List<Group> findByStatus(GroupStatus groupStatus);

    List<Group> findByMemberName(String memberName);

    List<Group> findByMentorName(String mentorName);

    void addMember(Group group, User user);

    void excludeMember(Group group,User user);

    void currentTaskNumberUp(Group group);

    void changeGroupStatus(Group group, GroupStatus newStatus);



}
