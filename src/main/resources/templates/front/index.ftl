<! DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>和聚网络官网</title>

    <link  rel="stylesheet" href="/static/js/layui/css/layui.css"  media="all">
    <link  rel="stylesheet" href="/static/js/layui/css/main.css"  media="all">
    <link  rel="stylesheet" href="/static/mine/mine.css"  media="all">
</head>
<body>
<div class="container" >
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
        <div class="first">
            <img src="/static/imgs/index/5G.jpg" id="fg">
            <img src="/static/imgs/index/mouse.png" id="fm">
        </div>
        <div class="second">

            <div class="layui-row"  >
                <span class="layui-col-lg4">
                    <div class="sline" ></div>
                    <div id="tongxin">
                        <div  id="t1"></div>
                        <div  id="t2"></div>
                    </div>
                </span>
                <span class="layui-col-lg4" id="sa" >业务介绍</span>
                <span class="layui-col-lg4">
                    <div class="sline"></div>
                    <div id="tgx">
                        <div  id="t3"></div>
                        <div  id="t4"></div>
                    </div>
                </span>
            </div>

            <div class="layui-row">
                <span class="layui-col-lg2" id="spay" >
                    <a hover><img src="/static/imgs/index/4.png" style="width: 60px;height: 85px"></a>
                    <h3 style="color: #f0f0f0">聚合支付</h3>
                    <p style="color: #f0f0f0">
                        致力于为互联网企业提供全方位的支付接口接入服务、刷脸支付接入服务、支付技术接入服务、
                        支付产品内容丰富,涵盖各个行业,一站式支付解决方案提供商
                    </p>
                </span>
                <span class="layui-col-lg2" id="ss">
                    <img src="/static/imgs/index/shop.png" style="width: 50px;height: 55px;margin-bottom: 20px">
                    <p>
                        新零售
                    </p>
                </span>
                <span class="layui-col-lg2" id="st">
                    <img src="/static/imgs/index/qingshenghuo.png">
                    <p>
                        氢生活 生态圈
                    </p>
                </span>
                <span class="layui-col-lg2" id="sf">
                    <img src="/static/imgs/index/xinmeiti.png">
                    <p>
                        新媒体
                    </p>
                </span>
            </div>
        </div>

        <div class="three">
            <img src="/static/imgs/index/jianjie.jpg" style="height: 150px;width: 1138px;">
            <div id="tm" >
                <hr style="width: 44px">
                <h4 >公司简介</h4>
                <p>许昌和聚网络科技有限公司成立于2019年,是集互联网运营,聚合支付,新媒体,新零售为一体的科技零售服务公司。</p>
                <p>公司聚焦"互联网+",在5G技术支持下,构建以社区为中心的新零售互联网产业的新经济体。广泛布局线下众多实体门店、媒体、
                    互联网生活、互联网金融、互联网前沿科技等众多领域,争取打造一个社区管家式新零售服务闭环....</p>
                <a href="/front/aboutUs" class="layui-btn layui-btn-primary">查看更多</a>
            </div>
        </div>


        <div class="four" style="height: 300px;width: 1134px;border: 1px orangered solid">
            <div class="layui-row">
                <span class="layui-col-lg5">
                    <hr>
                </span>
                <span class="layui-col-lg2">最新新闻</span>
                <span class="layui-col-lg5">
                <hr>
                </span>
            </div>
            <div class="layui-row">
                <span class="layui-col-lg4">
                    <img src="/static/imgs/index/chain.png" style="width: 180px;height: 180px">
                    <div>
                        <div>和聚网络产业链整合说明</div>
                        <div>2020-04-24</div>
                    </div>
                </span>
                <span class="layui-col-lg4">
                    <h3>和聚网络新品展示</h3>
                    <p>
                        新品展示新品展示新品展示新品展示新品展示
                        新品展示新品展示新品展示新品展示新品展示
                    </p>
                    <a href="#" class="layui-btn layui-btn-primary">查看更多</a>
                </span>
                <span class="layui-col-lg4">
                     <img src="/static/imgs/index/spread.png" style="width: 180px;height: 180px">
                     <div>
                        <div>新媒体推广运营</div>
                        <div>2020-04-24</div>
                     </div>
                </span>
            </div>
            <div class="layui-row">
                <span class="layui-col-lg5"></span>
                <a href="/front/news" class="layui-btn layui-btn-danger layui-col-lg2">查看更多</a>
                <span class="layui-col-lg5"></span>
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

</div>
<script src="/static/js/jquery-1.7.2.js"></script>
<#--<script src="/static/js/layui/layui.js" ></script>-->
<script src="/static/js/layui/layui.all.js" ></script>
<script>


</script>

</body>
</html>
