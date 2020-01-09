var page_count=0;//分页总数
//分页查询数据
var hr="/news/detail?id=";
var page;

if(!page){
    page=1;
}
//初始化函数
$(function(){
    findPage(page,5);
})


function findPage(page,limit){
    $.ajax({
        url:'/news/pageList',
        type: 'post',
        dataType: 'JSON',
        data:{
            "page":page,
            "limit":limit,
        },
        success:function(result){
            page_count=result.count;//分页查询总数
            var newsList=result.data;
            if(page_count>0){
                //清空之前的值
                $("#itemList").html("");
                $(".items .item").attr("href","");
                //说明查询的有新闻资讯
                for(var i=0;i<newsList.length;i++){
                    var id=newsList[i].id;
                    $(".items .item a").attr("href",hr+id);
                    if(newsList[i].cover){
                        //如果有封面图片,则将封面图片展示
                        var url=newsList[i].cover;
                        $(".items .img").attr("src",url);
                        getMyData(newsList[i]);
                        $("#itemList").append($(".items").html());
                    }else{
                        getMyData(newsList[i]);
                        $("#itmeList").append($(".items").html());
                    }

                }
            }else{
                //没有查询出结果
                $("#itemList").html("<span class='pText'>没有找到符合条件的结果！</span>");
            }
                //分页控件
              // if(page==1){
              //     findListPageFoot();
              // }
            if(page){
                findListPageFoot();
            }



        }


    })
}


//组装新闻资讯item数据
function getMyData(res){
    $(".items .hniois-data").each(function () {
        //清空数值
        $(this).html("");
        //赋值
        $(this).html(res[$(this).attr("name")]);
    })
}

//分页控制插件函数
function findListPageFoot(){
    var laypage=layui.laypage;
    //执行一个laypage实例
    laypage.render({
        elem: 'pageFoot' //注意，这里的 pageFoot 是 ID，不用加 # 号
        ,count: page_count //数据总数，从服务端得到
        ,limit:5   //每页显示条数
        ,curr:page
        ,layout: ['prev', 'page', 'next']
        ,jump: function(obj, first){
            //obj包含了当前分页的所有参数，比如：
            console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
            console.log(obj.limit); //得到每页显示的条数
            page=obj.curr;
            //首次不执行
            if(!first){
                //do something
                findPage(obj.curr,obj.limit);
            }
        }
    });
}


//去除换行
function ClearBr(key) {
    key = key.replace(/<\/?.+?>/g,"");
    key = key.replace(/[\r\n]/g, "");
    return key;
}

//去掉字符串两端的空格
function trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}


//去除字符串中间空格
function CTim(str) {
    return str.replace(/\s/g,'');
}


//去除左侧空格
function LTrim(str) {
    return str.replace(/^\s*/g,"");
}

//去右空格
function RTrim(str) {
    return str.replace(/\s*$/g,"");
}

