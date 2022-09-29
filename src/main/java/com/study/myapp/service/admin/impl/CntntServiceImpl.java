package com.study.myapp.service.admin.impl;

import com.study.myapp.mapper.admin.CntntMpp;
import com.study.myapp.model.admin.CntntModel;
import com.study.myapp.service.admin.CntntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CntntServiceImpl implements CntntService {
    @Autowired
    private CntntMpp CntntMpp;
    @Override
    public List<CntntModel> getCntntList(CntntModel CntntModel) {
        return CntntMpp.getCntntList(CntntModel);
    }
    @Override
    public CntntModel getCntnt(CntntModel CntntModel) {
        return CntntMpp.getCntnt(CntntModel);
    }
    @Override
    public int setCntntAdd(CntntModel CntntModel) {
        return CntntMpp.setCntntAdd(CntntModel);
    }
    @Override
    public int setCntntModify(CntntModel CntntModel) {
        return CntntMpp.setCntntModify(CntntModel);
    }
    @Override
    public int setCntntDelete(CntntModel CntntModel) {
        return CntntMpp.setCntntDelete(CntntModel);
    }
    @Override
    public int setCntntUse(CntntModel CntntModel) {
        return CntntMpp.setCntntUse(CntntModel);
    }
}
