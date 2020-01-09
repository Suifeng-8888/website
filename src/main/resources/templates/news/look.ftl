<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>新闻管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1,minimum-scale=1, user-scalable=no">
    <link href="/static/js/layui/css/layui.css" rel="stylesheet"/>
    <!-- tinyMCE -->
    <#-- 从云服务直接引用   <script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>-->
    <script src="/static/tinymce/tinymce.min.js"></script>
    <script src="/static/tinymce/langs/zh_CN.js"></script>
    <script>
        tinymce.init({
            selector: '#tinydemo',
            language:'zh_CN',
            height: 300,
            plugins: 'image',
            toolbar: 'image',
            images_upload_url: '/file/upload',
            // images_upload_base_path: '/file',
            setup: function (editor) {
                editor.on('init', function (e) {
                    tinymce.activeEditor.setContent(content);
                });
            }
        });
    </script>
    <!-- /tinyMCE -->
</head>
<body>
<form class="layui-form layui-form-pane" action="" id="form">
    <input type="hidden" name="id" id="key" value="${news.id}">
    <input type="hidden" name="nimg" id="img" value="${news.nimg}">
    <input type="hidden" name="content" id="cnt" value='${news.content}'>
    <div class="layui-form-item">
        <label class="layui-form-label">新闻标题<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="title" class="layui-input" type="text" autocomplete="off"
                   lay-verify="required" value="${news.title}">
        </div>
        <label class="layui-form-label">封面</label>
        <div class="layui-input-block">
            <img src="" id="mg" style="height: 50px;width: 300px">
            <button type="button" class="layui-btn" id="test3">
                上传图片
            </button>
        </div>
        <label class="layui-form-label">日期</label>
        <div class="layui-input-block">
            <input type="text" name="ntime" autocomplete="off"
                   id="test2" placeholder="yyyy-MM-dd"  class="layui-input" value="${news.ntime}">
        </div>
        <label class="layui-form-label">作者<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <input name="author" class="layui-input" type="text" autocomplete="off"
                   lay-verify="required" value="${news.author}">
        </div>
        <label class="layui-form-label">摘要</label>
        <div class="layui-input-block">
            <textarea name="summary"  autocomplete="off"
                      cols="100" rows="10" >${news.summary}</textarea>
        </div>
        <label class="layui-form-label">新闻内容<span style="color: #FF5722">*</span></label>
        <div class="layui-input-block">
            <#--            <#include "tinymce.ftl" encoding="utf8">-->
            <#--            <div id="tinydemo"></div>-->
            <textarea id="tinydemo" name="content"></textarea>
        </div>

    </div>
    <div class="layui-form-item" style="text-align: center;">
        <#--        <button class="layui-btn" lay-filter="formSave" lay-submit>保存</button>-->
        <button class="layui-btn layui-btn-warm" onclick="closeWin()">关闭</button>
    </div>
</form>

</body>

<script src="/static/js/layui/layui.all.js"></script>
<script src="/static/login/js/jquery-1.7.2.js"></script>
<script>
    //获取窗口索引
    // var index = parent.layer.getFrameIndex(window.name);
    //初始化函数 order-1
    $(document).ready(function () {
        init();
    });
    var content;
    //layui模块加载 order-2
    layui.use(['layer', 'form','upload','laydate'], function () {
        var layer = layui.layer,
            form = layui.form,
            upload=layui.upload
        laydate=layui.laydate;

        laydate.render({
            elem:'#test2',
        })
        //监听提交
        form.on('submit(formSave)', function(data){
            var cont=tinymce.activeEditor.getContent();
            data.field.content=cont;
            var url = "/news/update";
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

        //上传图片
        upload.render({
            elem: '#test3'
            ,url: '/file/uploadSingle'
            ,accept: 'images'
            //,multiple:true
            ,done: function(res){
                $("#mg").attr("src","");
                var url=res.url;
                $("#img").val(url);
                $("#mg").attr("src",url);
            }
        });


    })


    function closeWin() {
        parent.layer.close(index);
    }
    //初始化封面
    function init() {
        var url=$("#img").val();
        $("#mg").attr("src",url);
        content=$("#cnt").val();
        $("#cnt").val("");
    }



</script>
</html>