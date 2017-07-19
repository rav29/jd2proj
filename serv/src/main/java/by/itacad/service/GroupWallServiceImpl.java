package by.itacad.service;

import by.itacad.dao.GroupWallDao;
import by.itacad.entities.GroupWall;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Radion on 18.07.2017.
 */
@Service
@Transactional
public class GroupWallServiceImpl extends BaseServiceImpl<GroupWall> implements GroupWallService {
    private final GroupWallDao groupWallDao;

    public GroupWallServiceImpl(GroupWallDao groupWallDao) {
        this.groupWallDao = groupWallDao;
    }
}
