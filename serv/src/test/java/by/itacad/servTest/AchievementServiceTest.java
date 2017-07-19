package by.itacad.servTest;

import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.Achievement;
import by.itacad.service.AchievementServiceImpl;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Radion on 19.07.2017.
 */
public class AchievementServiceTest extends BaseServiceTest<Achievement> {

    @Autowired
    private BaseServiceImpl<Achievement> baseService = new AchievementServiceImpl();


    
    @Override
    protected BaseServiceImpl<Achievement> getService() {
        return baseService;
    }

    @Override
    protected Achievement getModel() {
        return new Achievement();
    }
}
