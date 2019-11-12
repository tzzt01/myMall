package com.myMall.service.impl;

import com.google.common.collect.Lists;
import com.myMall.service.IFileService;
import com.myMall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        /*
         * 扩展名 abc.jpg
         */
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);//jpg
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;//防止上传的文件同名
        logger.info("开始上传文件，上传文件的文件名：{}，上传的路径：{}，新文件名{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {// 不存在
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            // 文件上传成功
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            // 上传完成后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("文件上传异常", e);
            return null;
        }
        return targetFile.getName();
    }
}
