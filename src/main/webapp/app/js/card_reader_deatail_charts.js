/**
 * Created by wangwenkai on 2016/10/14.
 */
var echarts = require('../../node_modules/echarts/lib/echarts');
require('zrender/lib/vml/vml');
require ('echarts/lib/chart/line');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/title');
require('echarts/lib/component/legend');
// 设置第一个折线图
var cardreader = echarts.init(document.getElementById('history_card_reader_chart'));
cardreader.setOption({
    title: {
        x:'center',
        textAlign:'left',
        text: '按月读者类型统计图'
    },
    tooltip: {
        trigger: 'axis'
    },
    color:['#f83052','#689ef9','#ff7007','#07dfff'],
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
        data: ["2015年7月","2015年8月","2015年9月","2015年10月","2015年11月","2015年12月","2016年1月","2016年2月","2016年3月","2016年4月","2016年5月","2016年6月"]
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
            name: '读者类型一',
            type: 'line',
            axisTick:{
            show:true
            },
            data: [18,65,141,90,96,70,102,90,142,130,137,91]
        },
        {
            name: '读者类型二',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [90,96,70,102,90,142,130,137,91,70,39,40]
        },
        {
            name: '读者类型三',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [61,61,87,187,15,161,66,192,39,93,184,23]
        },
        {
            name: '读者类型四',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [51,51,72,141,173,137,173,137,37,51,83,52]
        }
        ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        show:true,
        data:['读者类型一','读者类型二','读者类型三','读者类型四'],
        x:'680',
        y:'5',
        label:{
            show:true,
            position:'top'
        }
    }
});
