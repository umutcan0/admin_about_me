package com.etiya.crmlite.core.internationalization;

public interface MessageService {
    String getMessage(String keyword);
    String getMessageWithParams(String keyword, Object ...params);
}
