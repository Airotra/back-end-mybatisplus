package com.example.mybatisplus.web.controller;


import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.common.utls.SecurityUtils;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.service.FileService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileController {
    protected FileService fileService;

    protected ResourceLoader resourceLoader;

    public FileController(FileService fileService, ResourceLoader resourceLoader) {
        this.fileService = fileService;
        this.resourceLoader = resourceLoader;
    }

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> upload(MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap();
        if (SecurityUtils.getCurrentUserInfo() == null) {
            map.put("message", "请登录后重试");
            return ResponseEntity.badRequest().body(map);
        }
        map = fileService.upload(file);
        return ResponseEntity.ok().body(map);
    }

    private static String suffix(String fileName) {
        int i = fileName.lastIndexOf('.');
        return i == -1 ? "" : fileName.substring(i + 1);
    }

    @RequestMapping("/picture")
    public JsonResponse getPicture(String url, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");

        String path = "file/" + url.substring(1, url.length());
        FileInputStream is = null;
        OutputStream toClient = null;
        File filePic = new File(path);
        if (filePic.exists()) {
            try {
                is = new FileInputStream(filePic);
            } catch (FileNotFoundException e) {
                throw e;
            }
        }
        if (is != null) {
            int size = is.available();
            byte data[] = new byte[size];
            is.read(data);
            is.close();
            toClient = response.getOutputStream();
            toClient.write(data);
            toClient.close();
        }

        return JsonResponse.success(toClient);
    }

    @RequestMapping("/delPicture")
    public JsonResponse delPicture(String url, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");

        String path = "file/" + url.substring(1, url.length());
        File filePic = new File(path);
        if (filePic.exists()) {
            filePic.delete();
            return JsonResponse.success(true);
        }
        else {
            return JsonResponse.success(false);
        }
    }

}
