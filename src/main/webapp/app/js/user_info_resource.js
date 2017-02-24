/**
 * Created by wangwenkai on 2016/10/18.
 */
$(function () {
    // 模块的收起展开button
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
    // 藏书数量中切换"纸质图书/数字资源"的button
    $('.book_classify>div').on('click',function () {
        $(this).addClass('chosed');
        $('.book_classify>div').not($(this)).removeClass('chosed');
    })
    // 初始化日期选框
    $(".time_choise .begging_time").datetimepicker({
        format: 'yyyy-mm',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 3,
        forceParse: false,
        language: 'zh-CN'
    });
    $(".time_choise .ending_time").datetimepicker({
        format: 'yyyy-mm',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 3,
        forceParse: false,
        language: 'zh-CN'
    });
});