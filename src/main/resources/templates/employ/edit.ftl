<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>招聘管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1,minimum-scale=1, user-scalable=no">
    <link href="/static/js/layui/css/layui.css" rel="stylesheet"/>

</head>
<body>
<form class="layui-form layui-form-pane" action="" id="form">
    <input type="hidden" name="id" id="key" value="${employ.id}">
    <input type="hidden" name="pid" id="pid" value="${employ.pid}">
    <div class="layui-form-item">
        <label class="layui-form-label">发布部门<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="pname" class="layui-input" type="text" autocomplete="off"
                   readonly="readonly"   lay-verify="required" value="${employ.pname}">
        </div>
        <label class="layui-form-label">发布日期</label>
        <div class="layui-input-block">
            <input type="text" name="time" autocomplete="off" class="layui-input"
                   id="test2" placeholder="yyyy-MM-dd" value="${employ.time}"  >
        </div>
        <label class="layui-form-label">岗位名称<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="station" class="layui-input" type="text" autocomplete="off"
                   lay-verify="required" value="${employ.station}">
        </div>
        <label class="layui-form-label">岗位数量<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="number" class="layui-input" type="text" autocomplete="off"
                   lay-verify="required" value="${employ.number}">
        </div>
        <label class="layui-form-label">岗位描述<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <textarea name="depict"  autocomplete="off" lay-verify="required"
                 cols="100" rows="10">${employ.depict!''}</textarea>
        </div>
        <label class="layui-form-label">招聘要求<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <textarea name="demand"  autocomplete="off" lay-verify="required"
                 cols="100" rows="20" >${employ.demand!''}</textarea>
        </div>

    </div>
    <div class="layui-form-item" style="text-align: center;">
        <button class="layui-btn" lay-filter="formSave" lay-submit>保存</button>
        <button class="layui-btn layui-btn-warm" onclick="closeWin()">关闭</button>
    </div>
</form>

</body>

<script src="/static/js/layui/layui.all.js"></script>
<script src="/static/js/jquery-1.7.2.js"></script>
<script>
    //初始化函数 order-1
    $(document).ready(function () {
        // init();
    });
    //layui模块加载 order-2
    layui.use(['layer','laydate', 'form'], function () {
        var layer = layui.layer,
            form = layui.form,
         laydate=layui.laydate;

        laydate.render({
            elem:'#test2'
        });
        //监听提交
        form.on('submit(formSave)', function(data){
            var url = "/employInfo/update";
            $.ajax({
                url: url,
                data: data.field,
                type: "post",
                dataType:'json',
                success: function(data){
                    if(data.state=="ok"){
                        parent.layer.msg(data.msg);
                        closeWin();
                    }else{
                        layer.msg(data.msg);
                    }
                }
            });
            return false;
        });


    });

    function closeWin() {
        parent.layer.close(index);
    }




</script>
</html>