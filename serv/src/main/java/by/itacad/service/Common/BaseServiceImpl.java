package by.itacad.service.Common;


import by.itacad.dao.common.BaseDaoImpl;
import by.itacad.entities.BaseEntity;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Service;


/**
 * Created by Radion on 18.07.2017.
 */
@Service
public abstract class BaseServiceImpl <T extends BaseEntity> extends BaseDaoImpl implements BaseService {

}
