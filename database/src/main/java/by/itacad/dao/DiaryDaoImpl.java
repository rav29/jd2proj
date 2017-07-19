package by.itacad.dao;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Diary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Radion on 13.06.2017.
 */
@Repository
public class DiaryDaoImpl extends BaseDaoImpl<Diary> implements DiaryDao{
    @Override
    public List<Diary> findByUserName(String userName) {
        List<Diary> diaryList = getSessionFactory().getCurrentSession()
                .createQuery("select d from Diary d where user.name=:userName", Diary.class)
                .setParameter("userName",userName)
                .getResultList();
        return diaryList.size() > 0 ? diaryList : null;
    }

    @Override
    public List<Diary> findByGroupName(String groupName) {
        List<Diary> diaryList = getSessionFactory().getCurrentSession()
                .createQuery("select d from Diary d where group.name=:groupName", Diary.class)
                .setParameter("groupName", groupName)
                .getResultList();
        return diaryList.size() > 0 ? diaryList : null;
    }

    @Override
    public void oneMoreTaskPassed(Diary diary) {
        int numberOfTasksPassed = diary.getTasksPassed() + 1;
        int numberOfTasksLeft = diary.getTasksToFinish() - 1;
        diary.setTasksPassed(numberOfTasksPassed);
        diary.setTasksToFinish(numberOfTasksLeft);
        getSessionFactory().getCurrentSession().update(diary);
    }
}
