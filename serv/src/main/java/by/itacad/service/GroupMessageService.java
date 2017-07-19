package by.itacad.service;

import by.itacad.entities.GroupMessage;
import by.itacad.service.Common.BaseService;

import java.util.List;

/**
 * Created by Radion on 18.07.2017.
 */
public interface GroupMessageService extends BaseService{
    List<GroupMessage> getByGroupName(String groupName);
}
