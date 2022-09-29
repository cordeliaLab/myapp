package com.study.myapp.mapper.admin;

import com.study.myapp.model.admin.CtgrModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CtgrMpp {
    List<CtgrModel> getCtgrList(CtgrModel ctgrModel);
    CtgrModel getCtgr(CtgrModel ctgrModel);
    int setCtgrAdd(CtgrModel ctgrModel);
    int setCtgrModify(CtgrModel ctgrModel);
    int setCtgrDelete(CtgrModel ctgrModel);
    int setCtgrUse(CtgrModel ctgrModel);
    List<CtgrModel> getCtgrPrntsList(CtgrModel ctgrModel);
}
