package com.qh.hwebsite.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUpload {

    /**
     * 多文件上传
     * @param request
     * @param files
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) throws FileNotFoundException {
        JSONObject obj=new JSONObject();
        if(files.length==0){
            obj.put("state","error");
            obj.put("msg","上传失败");
            return obj.toString();
        }
        String url[] = new String[files.length];
        //设置上传文件保存路径**********************
        //获取springboot项目中的跟目录
        File path=new File(ResourceUtils.getURL("classpath:static").getPath());
        //获取文件要保存的目录文件夹
        String ymd=new SimpleDateFormat("yyyyMMdd").format(new Date());
        File saveDir=new File(path.getAbsolutePath(),"/upload/file/"+ymd);
        if (!saveDir.exists()){
            saveDir.mkdirs();
        }
        int i=0;
        for(MultipartFile file:files){
            //获取文件名
            String filename=file.getOriginalFilename();
            //获取文件名(如果带有路径,则去除路径)
            filename=filename.substring(filename.lastIndexOf("/")+1);
            //获取文件后缀名
            int flag=filename.lastIndexOf(".");
            //给文件重新命名
            String newName= UUID.randomUUID().toString();
            if(flag!=-1){
                //说明文件名有后缀,获取后缀名
                String suffix=filename.substring(flag);
                newName+=suffix;
            }
            File fos=new File(saveDir,newName);
            try {
                file.transferTo(fos);
                int len=(saveDir +"/"+ newName).indexOf("static");
                url[i] =(saveDir +"/"+ newName).substring(len-1);
            } catch (IOException e) {
                e.printStackTrace();
                obj.put("state","1");
                obj.put("message","上传失败");
            }
            i++;
        }
            obj.put("location",url[0]);
        return obj.toString();
    }

    /**
     * 单文件上传
     * @param request
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping("/uploadSingle")
    @ResponseBody
    public String uploadSingle(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws FileNotFoundException {
        JSONObject obj=new JSONObject();
        obj.put("state","error");
        obj.put("msg","上传失败");
       if(file.isEmpty()){
           return obj.toString();
       }
        //获取文件名
        String filename=file.getOriginalFilename();
       //获取文件名(如果带有路径,则去除路径)
        filename=filename.substring(filename.lastIndexOf("/")+1);
       //获取文件后缀名
       int flag=filename.lastIndexOf(".");
        //给文件重新命名
        String newName= UUID.randomUUID().toString();
       if(flag!=-1){
           //说明文件名有后缀,获取后缀名
           String suffix=filename.substring(flag);
           newName+=suffix;
       }
        //设置上传文件保存路径**********************
        //获取springboot项目中的跟目录
        File path=new File(ResourceUtils.getURL("classpath:static").getPath());
//        File path=ResourceUtils.getFile("classpath:static");
       //获取文件要保存的目录文件夹
        String ymd=new SimpleDateFormat("yyyyMMdd").format(new Date());
        File saveDir=new File(path.getAbsolutePath(),"/upload/photo/"+ymd);
        if (!saveDir.exists()){
            saveDir.mkdirs();
        }
        File fos=new File(saveDir,newName);
        int len=(saveDir +"/"+ newName).indexOf("static");
        String url = (saveDir + "/" + newName).substring(len - 1);
        try {
            file.transferTo(fos);
            obj.put("state","ok");
            obj.put("msg","上传成功");
            obj.put("url",url);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return obj.toString();
    }

    /**
     * 文件下载
     * @return
     */
    @RequestMapping("/download")
    public void fileDownLoad(HttpServletRequest request, HttpServletResponse response, String path){

        InputStream fis = null;
        try {
            path = request.getRealPath("/") + path;
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            fis = new BufferedInputStream(new FileInputStream(path));
            // 以流的形式下载文件。
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
