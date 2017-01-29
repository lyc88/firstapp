package com.lyc88.dao;

import com.lyc88.base.BaseInterface;
import com.lyc88.beans.Subject;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface SubjectDao extends BaseInterface<Subject> {
    public List<Subject> getFirstNodes();
}
