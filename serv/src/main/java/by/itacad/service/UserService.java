package by.itacad.service;

import by.itacad.entities.Region;
import by.itacad.entities.User;
import by.itacad.service.Common.BaseService;

import java.util.List;

/**
 * Created by Radion on 15.07.2017.
 */
public interface UserService extends BaseService {

    User findByName(String name);

    List<User> findAllByRegion(Region region);

}
