package com.study.myapp.service.admin;

import com.study.myapp.model.admin.CntntModel;

import java.util.List;

public interface CntntService {
    List<CntntModel> getCntntList(CntntModel CntntModel);
    CntntModel getCntnt(CntntModel CntntModel);
    int setCntntAdd(CntntModel CntntModel);
    int setCntntModify(CntntModel CntntModel);
    int setCntntDelete(CntntModel CntntModel);
    int setCntntUse(CntntModel CntntModel);
}
