package com.lyc88.base;

import com.lyc88.utils.Page;

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

    public List<T> getPage(Page page);

    public long getTotal();
}
