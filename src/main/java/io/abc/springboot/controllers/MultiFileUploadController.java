package io.abc.springboot.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class MultiFileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/uploads")
    public String upload(MultipartFile[] uploadedFiles, HttpServletRequest request) {
        List fileNames = new ArrayList<String>();
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        for (MultipartFile multipartFile : uploadedFiles) {

            String oldName = multipartFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());

            try {
                multipartFile.transferTo(new File(folder, newName));
                String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
                fileNames.add(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败！";
            }
        }
        return fileNames.toString();
    }
}
