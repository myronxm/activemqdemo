package com.myrom.controller.serializable;

import java.io.Serializable;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:53
 */
public class Email implements Serializable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
