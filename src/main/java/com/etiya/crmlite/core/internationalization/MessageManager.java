package com.etiya.crmlite.core.internationalization;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageManager implements MessageService {
    private MessageSource messageSource;


    @Override
    public String getMessage(String keyword) {
        return messageSource.getMessage(keyword,null, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessageWithParams(String keyword, Object... params) {
        return messageSource.getMessage(keyword,params,LocaleContextHolder.getLocale());
    }
}
