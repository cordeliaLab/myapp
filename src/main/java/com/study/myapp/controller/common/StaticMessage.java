package com.study.myapp.controller.common;

import lombok.Data;

public class StaticMessage {

    @Data
    private static class MessageModel {
        private Integer Status;
        private String Title;
        private String Message;
    }

    private static MessageModel messageModel;

    public static String messageCode(int number) {
        String temp = "";
        switch (number){
            case 200 :
                temp = "작업을 성공했습니다!";
                break;
            case 0 :
                temp = "작업을 실패했습니다!";
                break;
            default :
                temp = "정의 할 코드값이 없습니다!";
                break;            
        }
        return temp;
    }

    public static MessageModel message(int number, String title) {
        messageModel = new MessageModel();
        messageModel.setStatus(number);
        messageModel.setTitle(title);
        messageModel.setMessage(messageCode(number));
        return messageModel;
    }
}
