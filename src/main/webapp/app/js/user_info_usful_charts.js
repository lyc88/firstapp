/**
 * Created by wangwenkai on 2016/10/17.
 */
var echarts = require('../../node_modules/echarts/lib/echarts');
require('zrender/lib/vml/vml');
require ('echarts/lib/chart/line');
require ('echarts/lib/chart/pie');
require ('echarts/lib/chart/bar');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/title');
require('echarts/lib/component/legend');
// 设置第一个饼图
var accessnumChart = echarts.init(document.getElementById('access_num_chart'));
accessnumChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '访问量'
    },
    color:['#f3d999','#a4d8c2'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    // 数据
    series: [
        {
            name:'利用类型',
            type:'pie',
            radius:'60%',
            center:['50%','60%'],
            data:[
                {value:335, name:'纸质图书借书人数'},
                {value:310, name:'数字资源访问人数'}
            ]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        orient : 'vertical',
        show:true,
        data:['纸质图书借书人数','数字资源访问人数'],
        x:'right',
        y:'0px',
        label:{
            show:true,
            position:'left'
        },
        textStyle:{
            fontFamily:'font-family: Microsoft YaHei',
            fontSize:'12px'
        }
    }
});
// 设置第二个饼图
var infopercentageChart = echarts.init(document.getElementById('info_percentage_chart'));
infopercentageChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '信息资源利用综合比例'
    },
    color:['#fe8463','#9bca63','#fad860','#f3a43b'],

    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    // 数据
    series: [
        {
            name:'利用类型',
            type:'pie',
            radius:'60%',
            center:['40%','60%'],
            data:[
                {value:335, name:'纸质图书借出率'},
                {value:310, name:'数字资源浏览量'},
                {value:234, name:'数字资源收藏量'},
                {value:135, name:'数字资源下载量'}
            ]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        orient : 'vertical',
        show:true,
        data:['纸质图书借出率','数字资源浏览量','数字资源收藏量','数字资源下载量'],
        x:'right',
        y:'0px',
        label:{
            show:true,
            position:'left'
        },
        textStyle:{
            fontFamily:'font-family: Microsoft YaHei',
            fontSize:'12px'
        }
    }
});
// 设置第一个折线图
var returnbookCharts = echarts.init(document.getElementById('return_book_charts'));
returnbookCharts.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '按月借还图书统计图'
    },
    color:['#f83052','#f8c230'],
    tooltip: {
        trigger: 'axis'
    },
    xAxis: {
        name:'时间',
        nameTextStyle:{
            fontFamily: 'Microsoft YaHei',
            color: '#5793f3'
        },
        boundaryGap : false,
        axisLabel:{
            rotate:'50',
            interval:0,
            textStyle:{
                fontFamily: 'Microsoft YaHei',
                color: '#5793f3'
            }
        },
        axisLine:{
            lineStyle:{
                color:'#5793f3'
            }
        },
        data: ["2007年","2008年","2009年","2010年","2011年","2012年","2013年","2014年","2015年","2016年"]
    },
    yAxis: {
        name:'册数',
        axisLabel:{
            textStyle:{
                fontFamily: 'Microsoft YaHei',
                color: '#5793f3'
            }
        },
        axisLine:{
            lineStyle:{
                color:'#5793f3'
            }
        }
    },
    // 数据
    series: [
        {
            name: '借书',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [18,65,141,90,96,70,102,90,142,130]
        },
        {
            name: '还书',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [123,32,141,23,51,144,51,151,61,24]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:true,
        show:true,
        data:['借书','还书'],
        x:'750',
        y:'0',
        label:{
            show:true,
            position:'top'
        }
    }
});
// 设置第二个折线图
var resourceapplyChart = echarts.init(document.getElementById('resource_apply_chart'));
resourceapplyChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '按月借还图书统计图'
    },
    tooltip: {
        trigger: 'axis'
    },
    color:['#f68094','#5ad8b0','#f4de87','#c1bcf4'],
    xAxis: {
        name:'时间',
        nameTextStyle:{
            fontFamily: 'Microsoft YaHei',
            color: '#5793f3'
        },
        boundaryGap : false,
        axisLabel:{
            rotate:'50',
            interval:0,
            textStyle:{
                fontFamily: 'Microsoft YaHei',
                color: '#5793f3'
            }
        },
        axisLine:{
            lineStyle:{
                color:'#5793f3'
            }
        },
        data: ["2007年10月","2007年11月","2007年12月","2008年1月","2008年2月","2008年3月"]
    },
    yAxis: {
        name:'册数',
        axisLabel:{
            textStyle:{
                fontFamily: 'Microsoft YaHei',
                color: '#5793f3'
            }
        },
        axisLine:{
            lineStyle:{
                color:'#5793f3'
            }
        }
    },
    // 数据
    series: [
        {
            name: '浏览量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [18,65,141,90,96,70]
        },
        {
            name: '下载量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [123,32,141,23,51,144]
        },
        {
            name: '收藏量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [11,32,23,41,41,51]
        },
        {
            name: '总量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [51,31,131,25,31,61]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:true,
        show:true,
        data:['浏览量','下载量','收藏量','总量'],
        x:'680',
        y:'0',
        label:{
            show:true,
            position:'top'
        }
    }
});
// 设置第一个柱状图
var grouptotalChart = echarts.init(document.getElementById('group_total_chart'));
grouptotalChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '按月借还图书统计图'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer:{
            type:'shadow'
        }
    },
    color:['#00c5e9','#5e83c0'],
    xAxis: {
        name:'时间',
        nameTextStyle:{
            fontFamily: 'Microsoft YaHei',
            color: '#5793f3'
        },
        axisLabel:{
            rotate:'50',
            interval:'0',
            textStyle:{
                fontFamily: 'Microsoft YaHei',
                color: '#5793f3'
            }
        },
        axisLine:{
            lineStyle:{
                color:'#5793f3'
            }
        },
        data: ["单位一","单位二","单位三","单位四","单位五","院外读者"]
    },
    yAxis: {
        name:'册数',
        axisLabel:{
            textStyle:{
                fontFamily: 'Microsoft YaHei',
                color: '#5793f3'
            }
        },
        axisLine:{
            lineStyle:{
                color:'#5793f3'
            }
        }
    },
    // 数据
    series: [
        {
            name: '人均量',
            type: 'bar',
            barWidth:'30',
            axisTick:{
                show:true
            },
            data: [18,65,141,90,96,70]
        },
        {
            name: '总量',
            type: 'bar',
            barWidth:'30',
            axisTick:{
                show:true
            },
            data: [123,32,141,23,51,144]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:true,
        show:true,
        data:['人均量','总量'],
        x:'680',
        y:'5',
        label:{
            show:true,
            position:'top'
        }
    }
});
