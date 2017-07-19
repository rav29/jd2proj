package by.itacad.service;

import by.itacad.entities.FeedBackMessage;
import by.itacad.service.Common.BaseService;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
public interface FeedBackMessageService extends BaseService{
    List<FeedBackMessage> findAllByMark(int mark);
}
