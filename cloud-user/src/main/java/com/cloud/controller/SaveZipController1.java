package com.cloud.controller;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class SaveZipController1 {

    @PostMapping("saveZip1")
    public void saveFilesAsZip(@RequestParam("files") MultipartFile[] files, @RequestParam("password") String password) {
        // 创建一个临时zip文件
        File zipFile = new File("temp.zip");

        try (ZipArchiveOutputStream zos = new ZipArchiveOutputStream(new FileOutputStream(zipFile))) {
            // 设置zip文件的加密密码
            zos.setCreateUnicodeExtraFields(ZipArchiveOutputStream.UnicodeExtraFieldPolicy.ALWAYS);
            zos.setFallbackToUTF8(true);
//            zos.setPassword(password);

            for (MultipartFile multipartFile : files) {
                File file = File.createTempFile(multipartFile.getOriginalFilename(), ".tmp");
                multipartFile.transferTo(file);
                ArchiveEntry entry = zos.createArchiveEntry(file, multipartFile.getOriginalFilename());
                zos.putArchiveEntry(entry);
//                zos.write(file.);
                zos.closeArchiveEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将zip文件移动到指定的目录
        File targetDirectory = new File("your_target_directory_path");
        zipFile.renameTo(new File(targetDirectory, zipFile.getName()));

        // 删除临时zip文件
        zipFile.delete();
    }


}
