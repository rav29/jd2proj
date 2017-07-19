package by.itacad.service;

import by.itacad.dao.DiaryDao;
import by.itacad.entities.Diary;
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
public class DiaryServiceImpl extends BaseServiceImpl<Diary> implements DiaryService{

    private final DiaryDao diaryDao;

    @Autowired
    public DiaryServiceImpl(DiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }

    @Override
    public List<Diary> findByUserName(String userName) {
        return diaryDao.findByUserName(userName);
    }

    @Override
    public List<Diary> findByGroupName(String groupName) {
        return diaryDao.findByGroupName(groupName);
    }

    @Override
    public void oneMoreTaskPassed(Diary diary) {
        diaryDao.oneMoreTaskPassed(diary);
    }
}
