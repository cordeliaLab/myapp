package com.study.myapp.model.admin;

import lombok.Data;

@Data
public class CntntModel {
    private Integer RowNum;//순번

    private Integer MppCtgrPid;//매핑카테고리
    private String MppCtgrName;//매핑카테고리이름
    private Integer CntntPid;//컨텐츠일련번호
    private String CntntTitle;//컨텐츠제목
    private String Cntnt;//컨텐츠내용
    private String CntntDspy;//컨텐츠디스플레이권한(0:모두,1:개별)
    private Integer VwCnt;//컨텐츠조회수
    private Integer Sort;//정렬순서
    private String UseYn;//공개여부(1:사용,0:미사용)
    private String Use;
    private String DelYn;//삭제여부(1:삭제,0:미삭제)
    private String Del;
    private String CreateDate;
    private Integer CreateUserPid;
    private String CreateUserId;
    private String CreateName;
    private String ModifyDate;
    private Integer ModifyUserPid;
    private String ModifyUserId;
    private String ModifyName;
}
