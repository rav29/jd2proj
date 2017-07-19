package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Group;
import by.itacad.entities.GroupStatus;
import by.itacad.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Radion on 13.06.2017.
 */
@Repository
public class GroupDaoImpl extends BaseDaoImpl<Group> implements GroupDao{
    @Override
    public List<Group> findByStatus(GroupStatus groupStatus) {
        List<Group> groups = getSessionFactory().getCurrentSession()
                .createQuery("select g from Group g where g.groupStatus=:groupStatus", Group.class)
                .setParameter("groupStatus", groupStatus)
                .getResultList();

        return groups.size() > 0 ? groups : null;
    }

    @Override
    public List<Group> findByMemberName(String memberName) {
        List <Group> groups= getSessionFactory().getCurrentSession()
                .createQuery("select u.groups from User u where u.name=:memberName")
                .setParameter("memberName", memberName)
                .getResultList();

        return groups.size() > 0 ? groups : null;
    }

    @Override
    public List<Group> findByMentorName(String mentorName) {
        List<Group> groups = getSessionFactory().getCurrentSession()
                .createQuery("select g from Group g where g.mentor.name=:mentorName", Group.class)
                .setParameter("mentorName", mentorName)
                .getResultList();

        return groups.size() > 0 ? groups : null;
    }

    @Override
    public Group findByName(String groupName) {
        List<Group> groups = getSessionFactory().getCurrentSession()
                .createQuery("select g from Group g where g.name=:groupName", Group.class)
                .setParameter("groupName", groupName)
                .getResultList();

        return groups.size() > 0 ? groups.get(0) : null;
    }

    @Override
    public void addMember(Group group, User user) {
        group.getMembers().add(user);
        getSessionFactory().getCurrentSession().update(group);
    }

    @Override
    public void excludeMember(Group group, User user) {
        group.getMembers().remove(user);
        getSessionFactory().getCurrentSession().update(group);
    }

    @Override
    public void currentTaskNumberUp(Group group) {
        int newTaskNumber = group.getCurrentTaskNumber() + 1;
        group.setCurrentTaskNumber(newTaskNumber);
        getSessionFactory().getCurrentSession().update(group);

    }

    @Override
    public void changeGroupStatus(Group group, GroupStatus newStatus) {
        group.setGroupStatus(newStatus);
        getSessionFactory().getCurrentSession().update(group);
    }
}
