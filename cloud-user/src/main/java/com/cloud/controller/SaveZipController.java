package com.cloud.controller;

import org.apache.commons.compress.archivers.zip.ZipFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class SaveZipController {

    @PostMapping("saveZip")
    public void saveFilesAsZip(@RequestParam("files") MultipartFile[] files, @RequestParam("password") String password) {
        // 创建一个临时的zip文件
        File zipFile = new File("temp.zip");

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            // 设置zip文件的解压密码
//            zos.setMethod(ZipOutputStream.STORED);
            zos.setComment(password);

            // 将上传的文件依次写入zip文件
            for (MultipartFile file : files) {
                ZipEntry zipEntry = new ZipEntry(file.getOriginalFilename());
                zipEntry.setSize(file.getSize());
                zos.putNextEntry(zipEntry);

                FileInputStream fis = (FileInputStream) file.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                fis.close();
                zos.closeEntry();
            }

            // 关闭流并保存zip文件到本地目录
            zos.close();
            fos.close();

            // 将zip文件移动到指定的目录
            File targetDirectory = new File("/Users/zhangfei/Desktop");
            zipFile.renameTo(new File(targetDirectory, zipFile.getName()));

            // 删除临时zip文件
            zipFile.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
