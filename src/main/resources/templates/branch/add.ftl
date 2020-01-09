<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>部门管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1,minimum-scale=1, user-scalable=no">
    <link href="/static/js/layui/css/layui.css" rel="stylesheet"/>
</head>
<body>
<form class="layui-form layui-form-pane" action="" id="form" >
    <input type="hidden" name="id" >
    <input type="hidden" name="code" >
    <div class="layui-form-item">
        <label class="layui-form-label">部门名称<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="name" class="layui-input" type="text" autocomplete="off"
                   lay-verify="required" >
        </div>
        <label class="layui-form-label">负责人<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="leader" class="layui-input" type="text" autocomplete="off"
                   lay-verify="required" >
        </div>
        <label class="layui-form-label">备注信息</label>
        <div class="layui-input-block">
            <input name="remark" class="layui-input" type="text" autocomplete="off">
        </div>


    </div>
    <div class="layui-form-item" style="text-align: center;">
        <button class="layui-btn" lay-filter="formSave" lay-submit>保存</button>
        <#--        <button class="layui-btn" onclick="saveForm()" >保存</button>-->
        <button class="layui-btn layui-btn-warm" onclick="closeWin()">关闭</button>
    </div>
</form>

</body>

<script src="/static/js/layui/layui.all.js"></script>
<script src="/static/js/jquery-1.7.2.js"></script>
<script>

    $(function () {
        alert(layui.v);
    })
    //layui模块加载 order-2
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            form = layui.form;

        //监听提交
        form.on('submit(formSave)', function(data){
            var url = "/branch/add";
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



    })

    //提交表单
    // function saveForm(){
    //     var content=tinymce.activeEditor.getContent();
    //     $("#cnt").val(content);
    //      $("#form").submit();
    // }

    function closeWin() {
        window.opener=null;
        window.close();
    }




</script>
</html>