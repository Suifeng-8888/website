<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>招聘信息列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,minimum-scale=1, user-scalable=no">
    <link href="/static/js/layui/css/layui.css" rel="stylesheet" />
</head>
<body>
<div class="hniois-table">
    <form action="/employInfo/list" method="post" class="layui-form hniois-search-form" id="hniois-search-form">
        <div class="hniois-table-header">
            <div class="hniois-search-btns">
                <a id="hniois-add" onclick="toEdit('')" class="layui-btn layui-btn-sm layui-btn-normal" href="javascript:;">
                    <i class="fa fa-plus fa-lg" aria-hidden="true"></i> 新增</a>

            </div>
        </div>
    </form>
</div>

<table class="layui-hide" id="table" lay-filter="lay_table">

</table>


<script type="text/html" id="editBar">
    <a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>

</body>
<script src="/static/js/layui/layui.all.js"></script>
<script src="/static/js/jquery-1.7.2.js"></script>
<script>
    //初始化函数 order-1
    var data_table ;//数据表格
    $(document).ready(function() {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        data_table = table.render({
            elem: '#table',
            url:'/employInfo/list',
            // limit:5
            limits:[5,10,15],
            cols: [
                [
                    {type:'checkbox'},
                    {field:'pname', title:'发布部门',width:120, align:'center'},
                    {field:'station', title:'岗位名称',width:120, align:'center',edit:'text'},
                    {field:'number', title:'岗位数量',width:120, align:'center',edit:'text'},
                    {field:'depict', title:'岗位描述',width:300, align:'center'},
                    {field:'time', title:'发布时间',width:150, align:'center'},
                    {fixed: 'right',align:'center', toolbar: '#editBar'}
                ]
            ],
            height: 'full-150', cellMinWidth: 60,page: true
        });



        //监听工具条
        table.on('tool(lay_table)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                look(data.id)
            } else if(layEvent === 'edit'){
                toEdit(data.id)
            }else if(layEvent === 'del'){
                layer.confirm('确认删除么', function(index){
                    layer.close(index);
                    obj.del(); //删除对应行（tr）的DOM结构
                    //向服务端发送删除指令
                    doDelete(data.id);
                });
            }
        });

        //监听单元格编辑
        table.on('edit(lay_table)', function(obj){
            var field = obj.field , //得到字段
                value = obj.value ,//得到修改后的值
                data = obj.data ;//得到所在行所有键值
            var obj = new Object();
            obj.id = data.id;
            obj[field] = value;
            //修改数据
            doEdit(obj);

        });



    });

   function look(id){
       var layer = layui.layer ;
       window.location.href="/employInfo/find?id="+id;
   }



    function toEdit(id){
        var layer = layui.layer ;
        window.location.href="/employInfo/toEdit?id="+id;
    }

    //表格编辑 修改数据
    function doEdit(obj){
        $.ajax({
            url: "/employInfo/update",
            data: obj,
            type: "post",
            dataType:'json',
            success: function(data){
                // layui.layer.msg(data.msg);
            }
        });
    }

    //单个删除
    function doDelete(id){
        $.ajax({
            url: '/employInfo/delete',
            data: {
                id:id
            },
            type: "post",
            dataType:'json',
            success: function(data){
                // layui.layer.msg(data.msg);
            }
        });
    }




</script>
</html>