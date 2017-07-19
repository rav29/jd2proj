package by.itacad.service;

import by.itacad.dao.FeedBackMessageDao;
import by.itacad.entities.FeedBackMessage;
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
public class FeedBackMessageServiceImpl extends BaseServiceImpl<FeedBackMessage> implements FeedBackMessageService {


    private final FeedBackMessageDao fbMessageDao;
    @Autowired
    public FeedBackMessageServiceImpl(FeedBackMessageDao fbMessageDao) {
        this.fbMessageDao = fbMessageDao;
    }

    @Override
    public List<FeedBackMessage> findAllByMark(int mark) {
        return fbMessageDao.findAllByMark(mark);
    }
}
