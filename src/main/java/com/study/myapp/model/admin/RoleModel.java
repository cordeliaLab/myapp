package com.study.myapp.model.admin;

import lombok.Data;

@Data
public class RoleModel {
    private Integer RowNum;
	private Integer RolePid;
	private String RoleName;
//    private String UseYn;
    private String DelYn;
    private String CreateDate;
    private Integer CreateUserPid;
    private String CreateUserId;
    private String CreateName;
    private String ModifyDate;
    private Integer ModifyUserPid;
    private String ModifyUserId;
    private String ModifyName;
}
