package com.lyc88.dao.imp;

import com.lyc88.base.BaseImpl;
import com.lyc88.beans.Subject;
import com.lyc88.dao.SubjectDao;
import com.lyc88.dao.TreeBeanDao;
import com.lyc88.utils.TreeBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/25.
 */
@Repository("treeBeanDao")
public class TreeBeanDaoImp  implements TreeBeanDao{
    private  Log log = LogFactory.getLog(this.getClass());
    @Resource
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        TreeBeanDao treeBeanDao = (TreeBeanDao) applicationContext.getBean("treeBeanDao");
        List<TreeBean> list=  treeBeanDao.getList(-1);
        System.out.println(list);

    }

    public List<TreeBean> getList(Integer id) {
        //String sql = "select tree_id,parent_id,tree_desc from ztree where parent_id = ?";
        //String sql = "select tree_id,parent_id,tree_desc from ztree where parent_id = ?";
        String sql = "SELECT z1.tree_id,z1.parent_id,z1.tree_desc,CASE (SELECT count(1) FROM ztree z2 WHERE z1.tree_id = z2.parent_id)WHEN 0 THEN 0 ELSE 1 end isparent FROM ztree z1 where z1.parent_id=?";

        Object[] params = new Object[] {id};

        List<TreeBean> list = jdbcTemplate.query(sql, new RowMapper<TreeBean>() {
            public TreeBean mapRow(ResultSet resultSet, int i) throws SQLException {
                TreeBean tree = new TreeBean();
                tree.setId(resultSet.getInt("tree_id"));
                tree.setpId(resultSet.getInt("parent_id"));
                tree.setName(resultSet.getString("tree_desc"));
                if(resultSet.getInt("isparent")==0){
                    tree.setIsParent(false);
                }else{
                    tree.setIsParent(true);

                }
                return tree;
            }
        },params);
        if(log.isDebugEnabled())
        log.debug(list.size()+"------");
        return list;
    }
}
