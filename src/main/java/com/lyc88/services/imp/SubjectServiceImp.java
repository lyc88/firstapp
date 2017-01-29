package com.lyc88.services.imp;

import com.lyc88.beans.Subject;
import com.lyc88.dao.SubjectDao;
import com.lyc88.dao.TreeBeanDao;
import com.lyc88.services.SubjectService;
import com.lyc88.utils.TreeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
@Service("subjectService")
public class SubjectServiceImp implements SubjectService {
    @Resource
    private SubjectDao subjectDao;
    @Resource
    private TreeBeanDao treeBeanDao;
    public void save(Subject subject) {

    }

    public void update(Subject subject) {

    }

    public void delete(Subject subject) {

    }

    public List<Subject> getAll() {
        return null;
    }

    public Subject get(Serializable uuid) {
        return subjectDao.get(uuid);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SubjectService subjectDao = (SubjectService) applicationContext.getBean("subjectService");
        System.out.println(subjectDao.get(22248).getTreeDesc());
        //System.out.println(applicationContext.getBean("dataSource"));

    }

    public List<Subject> getFirstNodes() {

        return subjectDao.getFirstNodes();
    }

    public List<TreeBean> getTree(Integer pId) {
        return treeBeanDao.getList(pId);
    }
}
