package com.study.myapp.service.admin;

import com.study.myapp.model.admin.CtgrModel;
import java.util.List;

public interface CtgrService {
    List<CtgrModel> getCtgrList(CtgrModel ctgrModel);
    CtgrModel getCtgr(CtgrModel ctgrModel);
    int setCtgrAdd(CtgrModel ctgrModel);
    int setCtgrModify(CtgrModel ctgrModel);
    int setCtgrDelete(CtgrModel ctgrModel);
    int setCtgrUse(CtgrModel ctgrModel);
    List<CtgrModel> getCtgrPrntsList(CtgrModel ctgrModel);
}
