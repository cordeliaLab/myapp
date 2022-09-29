package com.study.myapp.model.admin;

import lombok.Data;

@Data
public class CodeModel {
    private Integer RowNum;
    private Integer GroupCode;
    private String GroupName;
    private Integer Code;
    private String CodeName;
    private String CodeOptn01;
    private String CodeOptn02;
    private String CodeOptn03;
    private String CodeDesc;
    private Integer Sort;
    private String UseYn;//공개여부
    private String Use;
    private String DelYn;//삭제여부
    private String Del;
    private String CreateName;
    private String CreateDate;
    private Integer CreateUserPid;
    private String CreateUserId;
    private String ModifyName;
    private String ModifyDate;
    private Integer ModifyUserPid;
    private String ModifyUserId;
}
