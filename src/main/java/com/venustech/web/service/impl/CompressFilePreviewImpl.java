package com.venustech.web.service.impl;

import com.venustech.web.model.FileAttribute;
import com.venustech.web.model.ReturnResponse;
import com.venustech.web.service.FilePreview;
import com.venustech.utils.DownloadUtils;
import com.venustech.utils.FileUtils;
import com.venustech.utils.ZipReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * Created by kl on 2018/1/17.
 * Content :处理压缩包文件
 */
@Service
public class CompressFilePreviewImpl implements FilePreview {

    @Autowired
    FileUtils fileUtils;

    @Autowired
    DownloadUtils downloadUtils;

    @Autowired
    ZipReader zipReader;

    @Autowired
    private MessageSource messageSource;

    @Override
    public String filePreviewHandle(String url, Model model) {
        FileAttribute fileAttribute=fileUtils.getFileAttribute(url);
        String fileName=fileAttribute.getName();
        String decodedUrl=fileAttribute.getDecodedUrl();
        String suffix=fileAttribute.getSuffix();
        String fileTree = null;
        // 判断文件名是否存在(redis缓存读取)
        if (!StringUtils.hasText(fileUtils.getConvertedFile(fileName))) {
            ReturnResponse<String> response = downloadUtils.downLoad(decodedUrl, suffix, fileName);
            if (0 != response.getCode()) {
                model.addAttribute("msg", response.getMsg());
                return "fileNotSupported";
            }
            String filePath = response.getContent();
            if ("zip".equalsIgnoreCase(suffix) || "jar".equalsIgnoreCase(suffix) || "gzip".equalsIgnoreCase(suffix)) {
                fileTree = zipReader.readZipFile(filePath, fileName);
            } else if ("rar".equalsIgnoreCase(suffix)) {
                fileTree = zipReader.unRar(filePath, fileName);
            }
            fileUtils.addConvertedFile(fileName, fileTree);
        } else {
            fileTree = fileUtils.getConvertedFile(fileName);
        }
        if (null != fileTree) {
            model.addAttribute("fileTree", fileTree);
            return "compress";
        } else {
            Locale locale = LocaleContextHolder.getLocale();
            String msg =this.messageSource.getMessage("compressfilepreviewerror",null,locale);
            model.addAttribute("msg", msg);
            return "fileNotSupported";
        }
    }
}
