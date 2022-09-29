package com.study.myapp.model.admin;

import lombok.Data;

@Data
public class CtgrModel {
    private Integer RowNum;//순번
    private Integer CtgrPid;//카테고리Pid
    private String CtgrName;//카테고리명
    private Integer CtgrPrntsPid;//상위카테고리Pid
    private String CtgrPrntsName;//상위카테고리명
    private Integer CtgrChildCnt; //하위카테고리카운트
    private String CtgrLevel;//카테고리단계
    private String CtgrDspyType;//카테고리디스플레이타입(0:일반,1:썸네일)
    private String CtgrDspy;//카테고리디스플레이권한(0:모두,1:개별)
    private Integer Sort;//정렬순서
    private String UseYn;//공개여부
    private String Use;
    private String DelYn;//삭제여부
    private String Del;
    private String CreateDate;
    private Integer CreateUserPid;
    private String CreateUserId;
    private String CreateName;
    private String ModifyDate;
    private Integer ModifyUserPid;
    private String ModifyUserId;
    private String ModifyName;

//    private HashMap<Integer,String> CtgrPrntsList;
}
