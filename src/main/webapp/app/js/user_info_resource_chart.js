/**
 * Created by wangwenkai on 2016/10/18.
 */
var echarts = require('../../node_modules/echarts/lib/echarts');
require('zrender/lib/vml/vml');
require ('echarts/lib/chart/line');
require ('echarts/lib/chart/pie');
require('echarts/lib/component/tooltip');
require('echarts/lib/component/title');
require('echarts/lib/component/legend');
// 设置第一个饼图
var libresourceproportionChart = echarts.init(document.getElementById('lib_resource_proportion_chart'));
libresourceproportionChart.setOption({
    title: {
        x:'650',
        y:'80',
        textAlign:'left',
        text: '馆藏资源比例'
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
            radius:'140',
            center:['35%','60%'],
            data:[
                {value:335, name:'纸质图书'},
                {value:635, name:'电子图书'},
                {value:735, name:'数字文献'},
                {value:310, name:'视频图像'}
            ]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        orient : 'vertical',
        show:true,
        data:['纸质图书','电子图书','数字文献','视频图像'],
        x:'660',
        y:'130',
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
var classifycountChart = echarts.init(document.getElementById('classify_count_chart'));
classifycountChart.setOption({
    title: {
        x:'650',
        y:'50',
        textAlign:'left',
        text: '分类量饼状图'
    },
    color:['#c23531','#2f4554','#61a0a8','#91c7ae','#d48265'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    // 数据
    series: [
        {
            name:'利用类型',
            type:'pie',
            radius:'99',
            center:['35%','50%'],
            data:[
                {value:335, name:'马克思主义'},
                {value:635, name:'哲学'},
                {value:735, name:'社会科学总论'},
                {value:1421, name:'政治法律'},
                {value:310, name:'经济'}
            ]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        orient : 'vertical',
        show:true,
        data:['马克思主义','哲学','社会科学总论','政治法律','经济'],
        x:'650',
        y:'100',
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
// 设置第三个饼图
var libbooknumChart = echarts.init(document.getElementById('lib_book_num_chart'));
libbooknumChart.setOption({
    title: {
        x:'650',
        y:'20',
        textAlign:'left',
        text: '分类量饼状图'
    },
    color:['#cdd9f1','#1a9bff','#fc7e9a','#89b2fd','#fd4673','#aa86fc','#1a9bff','#5c53e4','#07a6a3','#ff6687'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    // 数据
    series: [
        {
            name:'利用类型',
            type:'pie',
            radius:'99',
            center:['35%','50%'],
            data:[
                {value:335, name:'军事阅览室'},
                {value:635, name:'图书典藏室'},
                {value:735, name:'新书展厅'},
                {value:1421, name:'综合阅览室'},
                {value:310, name:'社科阅览室'},
                {value:335, name:'密级文献阅览室'},
                {value:635, name:'教员阅览室'},
                {value:735, name:'基本书库'},
                {value:1421, name:'原生文献阅览室'},
                {value:310, name:'过期报刊阅览室'}
            ]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        orient : 'vertical',
        show:true,
        data:['军事阅览室','图书典藏室','新书展厅','综合阅览室','社科阅览室','密级文献阅览室','教员阅览室','基本书库','原生文献阅览室','过期报刊阅览室'],
        x:'650',
        y:'50',
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
var liballChart = echarts.init(document.getElementById('lib_all_chart'));
liballChart.setOption({
    tooltip: {
        trigger: 'axis'
    },
    color:['#f83052','#07a6a2'],
    xAxis: {
        name:'时间（年）',
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
        data: ["2001","2002","2003","2004","2005","2006","2007","2007","2009","2010","2011","2012","2013","2014","2015"]
    },
    yAxis: {
        name:'藏书数量（本）',
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
            itemStyle:{
                normal:
                {
                    label : {show: true},
                    textStyle:{
                        color:'#1c1c1c'
                    }
                }
            },
            name: '总增量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [18,65,141,90,96,70,11,151,34,10,51,62,73,52,72]
        },
        {
            itemStyle:{
                normal:
                {
                    label : {show: true},
                    textStyle:{
                        color:'#1c1c1c'
                    }
                }
            },
            name: '总册数',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [13,24,71,63,52,52,62,41,155,14,43,64,31,51,51]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:true,
        show:true,
        data:['总增量','总册数'],
        x:'680',
        y:'0',
        label:{
            show:true,
            position:'top'
        }
    }
});
// 设置第二个折线图
var chineseincrementChart = echarts.init(document.getElementById('chinese_increment_chart'));
chineseincrementChart.setOption({
    tooltip: {
        trigger: 'axis'
    },
    color:['#f89330','#1a9bff'],
    xAxis: {
        name:'时间（年）',
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
        data: ["2001","2002","2003","2004","2005","2006","2007","2007","2009","2010","2011","2012","2013","2014","2015"]
    },
    yAxis: {
        name:'藏书数量（本）',
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
            itemStyle:{
                normal:
                {
                    label : {show: true},
                    textStyle:{
                        color:'#1c1c1c'
                    }
                }
            },
            name: '总增量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [18,65,141,90,96,70,11,151,34,10,51,62,73,52,72]
        },
        {
            itemStyle:{
                normal:
                {
                    label : {show: true},
                    textStyle:{
                        color:'#1c1c1c'
                    }
                }
            },
            name: '总册数',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [13,24,71,63,52,52,62,41,155,14,43,64,31,51,51]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:true,
        show:true,
        data:['总增量','总册数'],
        x:'680',
        y:'0',
        label:{
            show:true,
            position:'top'
        }
    }
});
// 设置第三个折线图
var libroomincrementChart = echarts.init(document.getElementById('lib_room_increment_chart'));
libroomincrementChart.setOption({
    tooltip: {
        trigger: 'axis'
    },
    color:['#ff426e'],
    xAxis: {
        name:'分布',
        nameTextStyle:{
            fontFamily: 'Microsoft YaHei',
            color: '#5793f3'
        },
        boundaryGap : false,
        axisLabel:{
            rotate:'30',
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
        data:['军事阅览室','图书典藏室','新书展厅','综合阅览室','社科阅览室','密级文献阅览室','教员阅览室','基本书库','原生文献阅览室','过期报刊阅览室'],
    },
    yAxis: {
        name:'藏书数量（本）',
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
            itemStyle:{
                normal:
                {label : {show: true}}
            },
            name: '总增量',
            type: 'line',
            axisTick:{
                show:true
            },
            data: [70,11,151,34,10,51,62,73,52,72]
        }
    ],
    // 提示框,里面的data对应数据里面的name
    legend:{
        selectedMode:true,
        show:true,
        data:['总增量','总册数'],
        x:'680',
        y:'0',
        label:{
            show:true,
            position:'top'
        }
    }
});