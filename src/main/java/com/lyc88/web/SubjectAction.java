package com.lyc88.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/1/18.
 */
@Controller
@RequestMapping("/subject")
public class SubjectAction {
    @ResponseBody
    @RequestMapping("/desc")
    public String getDesc(){
        return "hello";
    }
}
