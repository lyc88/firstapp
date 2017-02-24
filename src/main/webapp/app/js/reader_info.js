/**
 * Created by wangwenkai on 2016/10/14.
 */
$(function () {
    // 日期控件
    $(".begging_time").datetimepicker({
        format: 'yyyy-mm-dd',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 2,
        forceParse: false,
        language: 'zh-CN'
    });
    $(".ending_time").datetimepicker({
        format: 'yyyy-mm-dd',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 2,
        forceParse: false,
        language: 'zh-CN'
    });

    // 初始化排名列表样式
    $(".group_rank").addClass('group_rank_chosing');
    $(".group_ranking_list").show();
    $(".person_ranking_list").hide();
    // 列表切换button的方法
    $(".group_rank").on("click",function () {
        $(this).addClass('group_rank_chosing');
        $(".person_rank").removeClass('person_rank_chosing');
        $(".group_ranking_list").show();
        $(".person_ranking_list").hide();
    });
    $(".person_rank").on("click",function () {
        $(this).addClass('person_rank_chosing');
        $(".group_rank").removeClass('group_rank_chosing');
        $(".person_ranking_list").show();
        $(".group_ranking_list").hide();
    });

    // 收起展开模块
    $(".up_down").on('click',function () {
        $(this).parent().next().toggle();
        $(this).children('span').toggleClass('classify_down').toggleClass('classify_up');
        var up_down = $(this).html();
        up_down = up_down.split('n>');
        console.log($.trim(up_down[1]));
        if($.trim(up_down[1])==='收起'){
            $(this).html(up_down[0]+'n>展开');
            return;
        }
        if($.trim(up_down[1])==='展开'){
            $(this).html(up_down[0]+'n>收起');
            return;
        }
    });
});