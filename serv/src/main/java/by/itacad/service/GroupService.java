package by.itacad.service;

import by.itacad.entities.Group;
import by.itacad.entities.GroupStatus;
import by.itacad.entities.User;
import by.itacad.service.Common.BaseService;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
public interface GroupService extends BaseService{
    Group findByName(String groupName);

    List<Group> findByStatus(GroupStatus groupStatus);

    List<Group> findByMemberName(String memberName);

    List<Group> findByMentorName(String mentorName);

    void addMember(Group group, User user);

    void excludeMember(Group group,User user);

    void currentTaskNumberUp(Group group);

    void changeGroupStatus(Group group, GroupStatus newStatus);
}
