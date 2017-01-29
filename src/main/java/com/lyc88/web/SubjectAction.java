package com.lyc88.web;

import com.alibaba.fastjson.JSONObject;
import com.lyc88.beans.Subject;
import com.lyc88.services.SubjectService;
import com.lyc88.utils.TreeBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/1/18.
 */
@Controller
@RequestMapping("/subject")
public class SubjectAction {
    @Resource
    private SubjectService subjectService;
    @ResponseBody
    @RequestMapping("/tree")
    public List<Subject> getTree(){

        return subjectService.getFirstNodes();
    }

    @ResponseBody
    @RequestMapping("/asyntree")
    public List<TreeBean> getasynTree(HttpServletRequest request,String pId){
        if(StringUtils.isNotBlank(pId)){
            return subjectService.getTree(Integer.valueOf(pId));
        }else{ return subjectService.getTree(-1);}
    }

    /**
     * 测试jsonp
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tree1",produces = "text/html;charset=UTF-8")
    public String getTree1(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
       String desc = subjectService.get(22248).getTreeDesc();
        String callback = request.getParameter("callback");//默认值
        //String callback = request.getParameter("jsoncallback");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","hello");
       /* try {
            response.getWriter().write(callback +"("+jsonObject.toString()+")");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return callback +"("+jsonObject.toString()+")";
    }
}
