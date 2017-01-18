package com.lyc88.base;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
@Component
public abstract class BaseImpl<T> implements BaseInterface<T>{
    private SessionFactory sf;
    @Resource(name="sessionFactory")
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
    private Class<T> entityClass ;
    //将entityClass初始化
    public BaseImpl(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass =  (Class)params[0];
    }

    public void save(T t) {
        this.sf.getCurrentSession().save(t);
    }

    public void update(T t) {
        this.sf.getCurrentSession().update(t);
    }

    public void delete(T t) {
        this.sf.getCurrentSession().delete(t);
    }

    public T get(Serializable uuid) {
        return (T) sf.getCurrentSession().get(entityClass,uuid);
    }

    public List<T> getAll() {
        return (List<T>) this.sf.getCurrentSession().createCriteria(entityClass).list();
    }
}
