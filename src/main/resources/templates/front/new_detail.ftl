<! DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>和聚网络官网</title>

    <link rel="stylesheet" href="/static/js/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/js/layui/css/main.css" media="all">
</head>
<body>
<div class="container">
    <div class="layui-header header" style="background-color: #f4f4f4">
        <div class="layui-main" >
            <ul class="layui-nav">
                <li class="layui-nav-item layui-this">
                    <img src="/static/imgs/index/logo.png" alt="公司logo" style="width: 40px;height: 30px">
                    <span style="color: red">和聚网络</span>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="/front/index">首页</a>
                </li>
                <li class="layui-nav-item ">
                    <a href="/front/aboutUs">关于我们</a>
                </li>


                <li class="layui-nav-item layui-hide-xs">
                    <a href="/front/product" >产品介绍</a>
                </li>

                <li class="layui-nav-item layui-hide-xs">
                    <a href="/front/news" >新闻</a>
                </li>

                <li class="layui-nav-item layui-hide-xs">
                    <a href="/front/join" >加盟</a>
                </li>

                <li class="layui-nav-item layui-hide-xs" >
                    <a href="/front/contact" >联系我们 </a>
                </li>
            </ul>
        </div>
    </div>


    <!--详情展示-->
    <div class="newsDetail">
        <div class="layui-container">

            <h2>${news.title}</h2>
            <div class="note">
            <span>
                <label>新闻摘要:</label>
                <span >${news.summary}</span>
            </span>
                <span>
                <label>日期:</label>
                <span >${news.time}</span>
            </span>
            </div>
            <hr>
            <div class="content">
                <div>${news.content}</div>
            </div>

            <div class="layui-row">
                <span class="layui-col-lg9">
                    <div>
                        上一篇:<span onclick="change($(this))" data-id="${news.preid!0}">
                                ${news.prename!"已经是第一篇"}
                        </span>
                    </div>
                    <div>
                        下一篇:<span onclick="change($(this))" data-id="${news.nextid!0}">
                                ${news.nextname!"已经是最后一篇"}
                        </span>
                    </div>
                </span>
                <span class="layui-col-lg3">
                    <button class="layui-btn layui-btn-warm" onclick="goBack()">返回列表</button>
                </span>
            </div>

        </div>

    </div>
    <div class="layui-container">
        <!--底部内容-->
        <div class="layui-footer " style="background-color:#01AAED">
            <div class="layui-row" >
            <span class="layui-col-lg9">
                <p>资讯电话 0374-8303110</p>
                <p>公司地址 河南省许昌市天宝路与许州路交汇处航空大酒店裙楼1楼</p>
            </span>
                <span class="layui-col-lg3">
               <div class="layui-row">
                   <span layui-col-lg6>关注微信公众号:</span>
                   <span layui-col-lg6>
                       <img src="/static/imgs/index/rcode.jpg" style="width: 50px;height: 50px">
                   </span>
               </div>
            </span>
            </div>
            <hr style="width: 1000px">
            <div class="layui-row">
                <span>&copy; ICP备案 豫ICP备19025971号-1 互联网备案号4110232000254</span>
            </div>
        </div>
    </div>

</div>
<script src="/static/js/jquery-1.7.2.js"></script>
<#--<script src="/static/js/layui/layui.js" ></script>-->
<script src="/static/js/layui/layui.all.js" ></script>
<script>

    var preId=$("#pre").html();
    var nextId=$("#net").html();
    //返回列表
     function goBack(){
         window.location.href="/front/news";
     }

    //点击更换文章信息
    function change(res){
        var st= res.attr("data-id");
        if(st!=="0"){
            window.location.href="/news/detail?id="+st;
        }

    }

</script>

</body>
</html>
