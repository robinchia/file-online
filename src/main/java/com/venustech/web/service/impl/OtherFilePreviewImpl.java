package com.venustech.web.service.impl;

import com.venustech.web.model.FileAttribute;
import com.venustech.web.service.FilePreview;
import com.venustech.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Locale;

/**
 * Created by kl on 2018/1/17.
 * Content :其他文件
 */
@Service
public class OtherFilePreviewImpl implements FilePreview {
    @Autowired
    FileUtils fileUtils;
    @Autowired
    private MessageSource messageSource;

    @Override
    public String filePreviewHandle(String url, Model model) {
        FileAttribute fileAttribute=fileUtils.getFileAttribute(url);

        Locale locale = LocaleContextHolder.getLocale();
        String msg =this.messageSource.getMessage("otherFilePreviewmsg",null,locale);
        model.addAttribute("fileType",fileAttribute.getSuffix());
        model.addAttribute("msg", msg);
        return "fileNotSupported";
    }
}
