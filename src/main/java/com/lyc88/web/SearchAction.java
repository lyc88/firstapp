package com.lyc88.web;

import com.lyc88.beans.DiskFilesSolrBean;
import com.lyc88.beans.QueryBean;
import com.lyc88.services.SearchService;
import com.lyc88.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/28.
 */
@Controller
@RequestMapping("search")
public class SearchAction {
    @Resource
    private SearchService searchService;

    @RequestMapping("toSearch")
    public String toSearch(Model model){
        QueryBean queryBean = new QueryBean();
        Page page = new Page();
        queryBean.setPage(page);
        Map map = searchService.query(queryBean);
        model.addAttribute("page",page);
        model.addAttribute("map",map);
        return "search";
    }

    /**
     * 搜索
     * @return
     */
    @RequestMapping("searchAll/{currentPage}")
    @ResponseBody
    public Map search(@PathVariable String currentPage,String q){
        QueryBean queryBean = new QueryBean();
        if(StringUtils.isNotBlank(q)){
            queryBean.setQ("all:"+q);
        }
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage).intValue());
        queryBean.setPage(page);
        return searchService.query(queryBean);
    }
}
