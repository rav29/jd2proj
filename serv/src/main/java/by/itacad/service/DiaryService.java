package by.itacad.service;

import by.itacad.entities.Diary;
import by.itacad.service.Common.BaseService;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
public interface DiaryService extends BaseService{
    List<Diary> findByUserName(String userName);

    List<Diary> findByGroupName(String groupName);

    void oneMoreTaskPassed(Diary diary);
}
