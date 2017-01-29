package com.lyc88.dao.imp;

import com.lyc88.base.BaseImpl;
import com.lyc88.beans.Subject;
import com.lyc88.dao.SubjectDao;
import com.lyc88.utils.Page;
import com.lyc88.utils.TreeBean;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
@Repository("subjectDao")
class SubjectDaoImp extends BaseImpl<Subject> implements SubjectDao {
    public List<Subject> getFirstNodes(){
        Criteria criteria = this.getSession().createCriteria(Subject.class);
        // Expression.eq("patentId",-1) 过时了
        Criterion criterion1 = Restrictions.eq("patentId",-1);
        return criteria.add(criterion1).list();

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final JdbcTemplate subjectDao = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        final RowMapper<Subject> rm = ParameterizedBeanPropertyRowMapper.newInstance(Subject.class);
        for(int i=0;i<100;i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(subjectDao.queryForObject("SELECT * from ztree where tree_id=22248", rm).getTreeDesc());
                }
            }).start();
        }
        //System.out.println(subjectDao.queryForObject("SELECT * from ztree where tree_id=22248",rm).getTreeDesc());

        System.out.println(applicationContext.getBean("dataSource"));

        SubjectDao subjectDao1 = (SubjectDao) applicationContext.getBean("subjectDao");
        System.out.println(subjectDao1.getFirstNodes().size());
        System.out.println("asdsd");

    }

    public List<Subject> getPage(Page page) {
        return null;
    }
}
