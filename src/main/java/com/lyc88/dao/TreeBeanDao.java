package com.lyc88.dao;

import com.lyc88.base.BaseInterface;
import com.lyc88.beans.Subject;
import com.lyc88.utils.TreeBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/25.
 */
public interface TreeBeanDao{
   public List<TreeBean> getList(Integer id);
}
