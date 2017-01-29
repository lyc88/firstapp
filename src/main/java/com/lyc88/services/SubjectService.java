package com.lyc88.services;

import com.lyc88.base.BaseService;
import com.lyc88.beans.Subject;
import com.lyc88.utils.TreeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface SubjectService extends BaseService<Subject>{
    public List<Subject> getFirstNodes();
    public List<TreeBean> getTree(Integer pId);
}
