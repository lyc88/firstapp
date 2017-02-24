/**
 * Created by wangwenkai on 2016/10/13.
 */
var echarts = require('../../node_modules/echarts/lib/echarts');
require('zrender/lib/vml/vml');
require ('echarts/lib/chart/line');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/title');
require('echarts/lib/component/legend');
// 设置第一个折线图
var readreporterChart = echarts.init(document.getElementById('today_lib_chart'));
readreporterChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '今日到馆人数'
    },
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
        data: ["8点","9点","10点","11点","12点","1点","2点","3点","4点","5点","6点","7点","8点","9点","10点"]
    },
    yAxis: {
        name:'人次',
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
    series: [{
        name: '人数',
        type: 'line',
        axisTick:{
            show:true
        },
        data: [18,65,141,90,96,70,102,90,142,130,137,91,70,39,40]
    }],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:false,
        show:true,
        data:['人数'],
        x:'700',
        y:'10',
        label:{
            show:true,
            position:'top'
        }
    }
});

// 设置第二个折线图
var webChart = echarts.init(document.getElementById('today_web_chart'));
webChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '今日到馆人数'
    },
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
        data: ["8点","9点","10点","11点","12点","1点","2点","3点","4点","5点","6点","7点","8点","9点","10点","11点","12点"]
    },
    yAxis: {
        ne:'人次',
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
    series: [{
        name: '人数',
        type: 'line',
        axisTick:{
            show:true
        },
        data: [18,65,201,90,96,70,102,90,142,130,137,91,70,39,40,200,202]
    }],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:false,
        show:true,
        data:['人数'],
        x:'700',
        y:'10'
    }
});