package by.itacad.dao.common;

import by.itacad.entities.BaseEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

/**
 * Created by Radion on 20.06.2017.
 */
public abstract class BaseDaoImpl <T extends BaseEntity> implements BaseDao<T>{


    @Autowired
    private SessionFactory sessionFactory;
    private final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }


    @Override
    public Long save(T entity) {
        Long id = (Long) sessionFactory.getCurrentSession().save(entity);;
        return id;
    }

    @Override
    public T findById(Long id) {
        List<T> modelsList =  sessionFactory.getCurrentSession()
                .createQuery("from " + modelClass.getSimpleName() + " m where m.id=:modelId", modelClass)
                .setParameter("modelId", id)
                .getResultList();
        return modelsList.size() > 0 ? modelsList.get(0) : null;
    }

    @Override
    public void deleteById(Long id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<T> findAll() {

        return sessionFactory.getCurrentSession().createQuery("from " + modelClass.getSimpleName(), modelClass)
                .getResultList();

    }

    @Override
    public Long update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity.getId();


        //:TODO update метод(блокировка + в тест)
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
