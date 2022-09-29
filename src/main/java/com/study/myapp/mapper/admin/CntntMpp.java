package com.study.myapp.mapper.admin;

import com.study.myapp.model.admin.CntntModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CntntMpp {
    List<CntntModel> getCntntList(CntntModel CntntModel);
    CntntModel getCntnt(CntntModel CntntModel);
    int setCntntAdd(CntntModel CntntModel);
    int setCntntModify(CntntModel CntntModel);
    int setCntntDelete(CntntModel CntntModel);
    int setCntntUse(CntntModel CntntModel);
}
