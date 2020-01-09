<! DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>和聚网络官网</title>

    <link  rel="stylesheet" href="/static/js/layui/css/layui.css"  media="all">
    <link  rel="stylesheet" href="/static/js/layui/css/main.css"  media="all">
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

    <!--中间内容  栅格系统布局-->
    <div class="layui-container" >

<#--        <img src="/static/imgs/contact/first.png" style="height: 300px;width: 1134px">-->

        <div class="layui-row" style="height: 500px;width: 1134px;border: 1px red solid;padding: 10px 20px">
            <div class="layui-tab" lay-filter="demo">
                <ul class="layui-tab-title "  id="tabs-title">

                </ul>

                <div class="layui-tab-content " id="contents">
<#--                    <div class="layui-tab-item layui-show" >-->
<#--                    </div>-->
                </div>
            </div>

        </div>

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

    <!--每一条招聘信息对象-->
    <div class="items" style="display: none">
        <div class="item">
            <div class="layui-row">
                <div>
                    <span class="hniois-data" name="station"></span>&nbsp;&nbsp;<span class="hniois-data" name="number"></span>
                </div>
                <div>
                    职位描述:
                    <p><span class="hniois-data" name="depict"></p>
                </div>
                <div>
                    招聘要求:
                    <p><span class="hniois-data" name="demand"></p>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="/static/js/jquery-1.7.2.js"></script>
<#--<script src="/static/js/layui/layui.js" ></script>-->
<script src="/static/js/layui/layui.all.js" ></script>
<script src="/static/js/contact.js" ></script>


</body>
</html>
