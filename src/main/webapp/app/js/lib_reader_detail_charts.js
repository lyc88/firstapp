/**
 * Created by wangwenkai on 2016/10/17.
 */
var echarts = require('../../node_modules/echarts/lib/echarts');
require('zrender/lib/vml/vml');
require ('echarts/lib/chart/line');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/title');
require('echarts/lib/component/legend');
// 设置第一个折线图
var libChart = echarts.init(document.getElementById('lib_reader_chart'));
libChart.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '按年到馆读者统计图'
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
    series: [
        {
            name: '人次',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [18,65,141,90,96,70,102,90,142,130]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:false,
        show:true,
        data:['人次'],
        x:'720',
        y:'0',
        label:{
            show:true,
            position:'top'
        }
    }
});