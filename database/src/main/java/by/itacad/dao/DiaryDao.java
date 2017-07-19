package by.itacad.dao;

import by.itacad.dao.common.BaseDao;
import by.itacad.entities.Diary;

import java.util.List;

/**
 * Created by Radion on 21.06.2017.
 */
public interface DiaryDao extends BaseDao<Diary>{

    List<Diary> findByUserName(String userName);

    List<Diary> findByGroupName(String groupName);

    void oneMoreTaskPassed(Diary diary);

}
