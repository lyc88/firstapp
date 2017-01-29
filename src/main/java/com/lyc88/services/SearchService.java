package com.lyc88.services;

import com.lyc88.beans.QueryBean;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/27.
 */
public interface SearchService {
    public void addIndex();
    /**多线程添加索引 **/
    public void mulAddIndex();
    public Map query(QueryBean queryBean);
}
