/**
 * Created by wangwenkai on 2016/10/17.
 */
$(function () {
    // 初始化第一部分日期选框
    $(".info_proportion_content .time_choise .begging_time").datetimepicker({
        format: 'yyyy-mm',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 3,
        forceParse: false,
        language: 'zh-CN'
    });
    $(".info_proportion_content .time_choise .ending_time").datetimepicker({
        format: 'yyyy-mm',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 3,
        forceParse: false,
        language: 'zh-CN'
    });

    // 初始化可以选择范围的日期选框
    // 选择年为单位时的控件
    $(".time_line_year .begging_time").datetimepicker({
        format: 'yyyy',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 4,
        forceParse: false,
        language: 'zh-CN'
    });
    $(".time_line_year .ending_time").datetimepicker({
        format: 'yyyy',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 4,
        forceParse: false,
        language: 'zh-CN'
    });
    // 选择月为单位时的控件
    $(".time_line_mouth .begging_time").datetimepicker({
        format: 'yyyy-mm',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 3,
        forceParse: false,
        language: 'zh-CN'
    });
    $(".time_line_mouth .ending_time").datetimepicker({
        format: 'yyyy-mm',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 3,
        forceParse: false,
        language: 'zh-CN'
    });
    // 选择日为单位时的控件
    $(".time_line_day .begging_time").datetimepicker({
        format: 'yyyy-mm-dd',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 2,
        forceParse: false,
        language: 'zh-CN'
    });
    $(".time_line_day .ending_time").datetimepicker({
        format: 'yyyy-mm-dd',
        weekStart: 1,
        autoclose: true,
        startView: 4,
        minView: 2,
        forceParse: false,
        language: 'zh-CN'
    });

    // 年月日 选择控件
    $(".year_mouth_day").on('change',function () {
        var time_classify = $(this).children("option:selected").attr('value');
        console.log(time_classify);
        if(time_classify==='year'){
            $(this).parent('.time_choise').children('.time_line_year').show();
            $(this).parent('.time_choise').children('.time_line_mouth').hide();
            $(this).parent('.time_choise').children('.time_line_day').hide();
            $(this).parent('.time_choise').siblings('.year_list').show();
            $(this).parent('.time_choise').siblings('.month_list').hide();
            $(this).parent('.time_choise').siblings('.day_list').hide();
        }
        if(time_classify==='mouth'){
            $(this).parent('.time_choise').children('.time_line_year').hide();
            $(this).parent('.time_choise').children('.time_line_mouth').show();
            $(this).parent('.time_choise').children('.time_line_day').hide();
            $(this).parent('.time_choise').siblings('.year_list').hide();
            $(this).parent('.time_choise').siblings('.month_list').show();
            $(this).parent('.time_choise').siblings('.day_list').hide();
        }
        if(time_classify==='day'){
            $(this).parent('.time_choise').children('.time_line_year').hide();
            $(this).parent('.time_choise').children('.time_line_mouth').hide();
            $(this).parent('.time_choise').children('.time_line_day').show();
            $(this).parent('.time_choise').siblings('.year_list').hide();
            $(this).parent('.time_choise').siblings('.month_list').hide();
            $(this).parent('.time_choise').siblings('.day_list').show();
        }
    });

    // 单位总计数据统计图的切换button
    $(".switch_button button").on("click",function () {
        $(this ).children('span').removeClass('hide_it').addClass('show_it');
        $(".switch_button button span").not($(this).children('span')).removeClass('show_it').addClass('hide_it');

    });

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
});