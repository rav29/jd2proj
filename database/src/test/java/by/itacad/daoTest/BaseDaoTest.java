package by.itacad.daoTest;

import by.itacad.config.DaoTestConfig;
import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.BaseEntity;
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
@ContextConfiguration(classes = DaoTestConfig.class)
@Transactional
public abstract class BaseDaoTest<T extends BaseEntity> {

    protected abstract BaseDaoImpl<T> getDao();

    protected abstract T getModel();

    @Test
    public void testFindById() {
        T model = getModel();
        Long id = getDao().save(model);

        T entity = getDao().findById(id);
        assertNotNull(entity);

        clearH2();
    }

    @Test
    public void testDelete() {
        T model = getModel();
        Long id = getDao().save(model);

        getDao().delete(model);

        T entity = getDao().findById(id);
        assertNull(entity);

        clearH2();
    }

    @Test
    public void testDeleteById() {
        T model = getModel();
        Long id = getDao().save(model);

        getDao().deleteById(id);

        T entity = getDao().findById(id);
        assertNull(entity);

        clearH2();
    }

    @Test
    public void testFindAll() {
        T modelOne = getModel();
        T modelTwo = getModel();

        getDao().save(modelOne);
        getDao().save(modelTwo);

        List<T> modelsList = getDao().findAll();
        Assert.assertTrue(modelsList.contains(modelOne));
        Assert.assertTrue(modelsList.contains(modelTwo));

        clearH2();
    }

    @Test
    public void testSave() {
        T model = getModel();
        Long id = getDao().save(model);

        assertNotNull(getDao().findById(id));

        getDao().delete(model);
        clearH2();
    }

    @Test
    public void testUpdate() {
        //:TODO update BaseDao method

    }

    protected void clearH2() {
        List<T> modelsList = getDao().findAll();
        for (T t : modelsList) {
            getDao().delete(t);
        }
    }
}
