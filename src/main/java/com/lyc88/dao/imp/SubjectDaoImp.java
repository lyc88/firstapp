package com.lyc88.dao.imp;

import com.lyc88.base.BaseImpl;
import com.lyc88.beans.Subject;
import com.lyc88.dao.SubjectDao;
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
        System.out.println(subjectDao1.get(22248).getTreeDesc()+"sjdfbdfsl");
        System.out.println("asdsd");
    }

}
