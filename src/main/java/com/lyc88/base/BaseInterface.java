package com.lyc88.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface BaseInterface<T> {
    public void save(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> getAll();

    public T get(Serializable uuid);
}
