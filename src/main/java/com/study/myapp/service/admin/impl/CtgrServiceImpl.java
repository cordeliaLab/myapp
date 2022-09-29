package com.study.myapp.service.admin.impl;

import com.study.myapp.mapper.admin.CtgrMpp;
import com.study.myapp.model.admin.CtgrModel;
import com.study.myapp.service.admin.CtgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CtgrServiceImpl implements CtgrService {
    @Autowired
    private CtgrMpp ctgrMpp;
    @Override
    public List<CtgrModel> getCtgrList(CtgrModel ctgrModel) {
        return ctgrMpp.getCtgrList(ctgrModel);
    }
    @Override
    public CtgrModel getCtgr(CtgrModel ctgrModel) {
        return ctgrMpp.getCtgr(ctgrModel);
    }
    @Override
    public int setCtgrAdd(CtgrModel ctgrModel) {
        return ctgrMpp.setCtgrAdd(ctgrModel);
    }
    @Override
    public int setCtgrModify(CtgrModel ctgrModel) {
        return ctgrMpp.setCtgrModify(ctgrModel);
    }
    @Override
    public int setCtgrDelete(CtgrModel ctgrModel) { return ctgrMpp.setCtgrDelete(ctgrModel); }
    @Override
    public int setCtgrUse(CtgrModel ctgrModel) {
        return ctgrMpp.setCtgrUse(ctgrModel);
    }
    @Override
    public List<CtgrModel> getCtgrPrntsList(CtgrModel ctgrModel) {
        return ctgrMpp.getCtgrPrntsList(ctgrModel);
    }
}
