package by.itacad.servTest;

import by.itacad.config.ServTestConfig;
import by.itacad.entities.BaseEntity;
import by.itacad.service.Common.BaseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Radion on 24.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServTestConfig.class)
@Transactional
public abstract class BaseServiceTest<T extends BaseEntity> {

    protected abstract BaseServiceImpl<T> getService();

    protected abstract T getModel();


    @Test
    public void testFindById() {
        T model = getModel();
        Long id = getService().save(model);

        T entity = (T) getService().findById(id);
        assertNotNull(entity);

        clearH2();
    }

    @Test
    public void testDelete() {
        T model = getModel();
        Long id = getService().save(model);

        getService().delete(model);

        T entity = (T) getService().findById(id);
        assertNull(entity);

        clearH2();
    }

    @Test
    public void testDeleteById() {
        T model = getModel();
        Long id = getService().save(model);

        getService().deleteById(id);

        T entity = (T) getService().findById(id);
        assertNull(entity);

        clearH2();
    }

    @Test
    public void testFindAll() {
        T modelOne = getModel();
        T modelTwo = getModel();

        getService().save(modelOne);
        getService().save(modelTwo);

        List<T> modelsList = getService().findAll();
        Assert.assertTrue(modelsList.contains(modelOne));
        Assert.assertTrue(modelsList.contains(modelTwo));

        clearH2();
    }

    @Test
    public void testSave() {
        T model = getModel();
        Long id = getService().save(model);

        assertNotNull(getService().findById(id));

        getService().delete(model);
        clearH2();
    }

    @Test
    public void testUpdate() {
        //:TODO update BaseDao method

    }

    protected void clearH2() {
        List<T> modelsList = getService().findAll();
        for (T t : modelsList) {
            getService().delete(t);
        }
    }
}
