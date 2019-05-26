<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
    <meta charset="UTF-8">
    <title>销售机会管理</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="./js/form.js"></script>
     <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts-en.common.js"></script>
</head>
<body>
    <div class="list">
        <span class="layui-breadcrumb">
  <a href="">首页</a>
  <a href="">列表页</a>
  <a href="">客户构成分析</a>
 
</span>
    </div>
    <div class="listOne">
        
    </div>
    <div class="inp">
        <form class="layui-form" action="">
 
  
  <div class="layui-form-item">
   
    <div class="layui-input-block" style="margin-left:20px">
      <select name="city">
        <option value="">请选择地域</option>
        <option value="0">华东</option>
        <option value="1">华北</option>
        <option value="2">华南</option>
        <option value="2">华中</option>
        
        
      </select>
    </div>
  </div>
   <div class="layui-form-item">
    
    <div class="layui-input-block" style="margin-left: 230px;margin-top:-52px;">
      <select name="city">
        <option value="">请选择访问途径</option>
        <option value="0">直接访问</option>
        <option value="1">邮件营销</option>
        <option value="2">联盟广告</option>
        <option value="2">视屏广告</option>
        <option value="2">搜索引擎</option>
       
        
      </select>
    </div>
  </div>
  
  
</form>
<div class="layui-form-item">
    <div class="layui-input-block" style="margin-left:450px;margin-top:-54px">
      <button id="fun" class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
      <button type="reset" class="resrt">重置</button>
    </div>
  </div>

<div class="listOne">
        


   </div>
   <div id="main" style="width:48%;height:270px; box-shadow: #666 0px 0px 10px;margin-top:10px"></div>
   <div id="maix" style="width:50%;height:270px;
                                         box-shadow: #666 0px 0px 10px; "></div>
  <div id="test1" style="margin-left:400px"></div>
<script>
   layui.use('laypage', function(){
  var laypage = layui.laypage;
  
  //执行一个laypage实例
  laypage.render({
    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
    ,count: 50 //数据总数，从服务端得到
  });
});
    var myChart = echarts.init(document.getElementById('main'));
     var youChart = echarts.init(document.getElementById('maix'));
    var option = {
            title: {
                text: '地域分析'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["华中","华北","华南","华东"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, ]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

            var option = {
           title : {
        text: '访问途径',
        
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
}

        // 使用刚指定的配置项和数据显示图表。
        youChart.setOption(option);


        $('#fun').click(function(){
      alert('查询');

    });
</script> 
    </div>

<script src="./layui/layui.all.js"></script>


</body>
</html>
<style>
  
  #maix{
    position: absolute;
    right:0;
    top:200px;
  }
</style>
