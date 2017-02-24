/**
 * Created by wangwenkai on 2016/10/9.
 */
$(function () {
    // 日期控件
    $(".form_datetime").datetimepicker({
        startView: 'decade',
        minView: 'decade',
        format: "yyyy ",
        autoclose: true
    });

    // 事件for隐藏和显示button
    $('.classify_detail_title>button').addClass('showmore');
    $('.classify_detail_title>button').on('click',function () {
        var name = $(this).prop("className");
        name = name.split(' ');
        $('.'+name[0]).toggle();
        $(this).toggleClass('showmore').toggleClass('hidemore');
    });

    // title选中对应的字选框效果
    $('#getall').on('click',function () {
        $('.classify_detail :checkbox').prop('checked',true);
    });
    $('#rmall').on('click',function () {
        $('.classify_detail :checkbox').prop('checked',false);
    });
    $('.classify_detail_title>input').on('click',function(){
        var name = $(this).prop("className");
        if($(this).prop("checked")===true){
            name = name.split(' ');
            $('.classify_detail_content.' + name).children('input').prop('checked',true);
        }
        if($(this).prop("checked")===false){
            name = name.split(' ');
            console.log(name);
            $('.classify_detail_content.' + name).children('input').prop('checked',false);
        }
    });

    // 把下拉框里的文字返回到button
    $('.dropdown-menu>li>a').on('click',function () {
        var v = $(this).html();
        console.log(v);
        $(this).parent().parent().siblings("button").html(v+'<span class="caret"></span>');
    });
    // dialog中的下拉框特殊返回方法
    $('.dialog_main').on('click','.dropdown-menu>li>a',function () {
        var v = $(this).html();
        console.log(v);
        $(this).parent().parent().siblings("button").html(v+'<span class="caret"></span>');
    });

    // dialog里的添加删除逻辑
    var dialog_dropdown_newid = 7;
    var dialog_tmp = $('.dialog_search').html();
    // 修正添加框的样式问题
    var dt_width= function () {
        $(".dialog_search .dropdown:even .dropdown-toggle").css({"width":"106px"});
        $(".dialog_search .dropdown:odd .dropdown-toggle").css({"width":"150px"});
    };
    dt_width();
    // 绑定移除事件
    $('.dialog_main').on('click','.dialog_rm',function () {
        $(this).parent().remove();
    });
    // 绑定添加事件
    $('.dialog_add').on('click',function () {
        dialog_dropdown_newid ++;
        // 插入新选框
        $(this).parent().siblings('button').before("<div class='dialog_search'>"+dialog_tmp+"</div>");
        // 给下拉框动态赋值id
        $(this).parent().siblings('.dialog_search:last').children('.dropdown:first').children('.dropdown-toggle').attr("id","dialog_dropdownMenu"+ dialog_dropdown_newid);
        dialog_dropdown_newid ++;
        $(this).parent().siblings('.dialog_search:last').children('.dropdown:last').children('.dropdown-toggle').attr("id","dialog_dropdownMenu"+ dialog_dropdown_newid);
        dt_width();
    });
    $('#rm_timeline').on('click',function () {
        console.log(123);
        $('.form_datetime input').val(' ');
    });
    // 在结果中搜索的checkbox的逻辑
    $("#research").on('click',function () {
        if($(this).is(':checked')){
            $("#result_search").attr('checked',false);
            $("#result_add").attr('checked',false);
            $("#result_del").attr('checked',false);
        }
    });
    $("#result_search").on('click',function () {
        if($(this).is(':checked')){
            $("#research").attr('checked',false);
        }
    });
    $("#result_add").on('click',function () {
        if($(this).is(':checked')){
            $("#research").attr('checked',false);
            $("#result_del").attr('checked',false);
        }
    });
    $("#result_del").on('click',function () {
        if($(this).is(':checked')){
            $("#research").attr('checked',false);
            $("#result_add").attr('checked',false);
        }
    });
});