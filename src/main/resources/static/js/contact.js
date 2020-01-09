

$(function(){
    initTabTitle();
    layui.use(['element', 'carousel'], function(){
        var element = layui.element;

        //一些事件监听
        element.on('tab(demo)', function(data){
            // console.log(data.index);
           var active = $(data.elem).find(".layui-this");
            getDetail(active.attr("lay-id"),data.index);
        });

    });
})



var utab=$("#tabs-title");
var cont=$("#contents");
//初始化选项卡标题
function initTabTitle(){
    $.ajax({
        url:'/employInfo/allList',
        type: 'post',
        dataType: 'JSON',
        success:function(result){
            var str = "";
            var sdt="";
           for(var i=0;i<result.length;i++){
               str+="<li  lay-id='"+result[i].pid+"'>"+result[i].pname+"</li>";
               sdt+="<div class='layui-tab-item' id="+i+">"+i+"</div>";
           }
            utab.html(str);
            cont.html(sdt);
            cont.children("#0").addClass("layui-show");
            getDetail(result[0].pid,0);
        }
    })
}

//获取部门招聘详情信息
function getDetail(id,index){
    initEmployInfo(id,index);
}


//初始化部门招聘详情
function initEmployInfo(pid,index){
    $.ajax({
        url:'/employInfo/detail',
        type: 'post',
        dataType: 'JSON',
        data:{
            pid:pid
        },
        success:function(result){
            var str = "";
            for(var i=0;i<result.length;i++){
                //组装数据
                getEmployData(result[i]);
                str+=$(".items").html();
            }
            cont.children("#"+index).html(str);
        }
    })
}

//组装招聘信息item数据
function getEmployData(res){
    $(".items .hniois-data").each(function () {
        //清空数值
        $(this).html("");
        //赋值
        $(this).html(res[$(this).attr("name")]);
    })
}