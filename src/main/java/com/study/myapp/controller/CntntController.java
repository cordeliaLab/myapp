package com.study.myapp.controller;

import com.study.myapp.controller.common.StaticData;
import com.study.myapp.controller.common.StaticMessage;
import com.study.myapp.model.admin.CntntModel;
import com.study.myapp.service.admin.CntntService;
import com.study.myapp.service.sign.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "admin/cntnt")
public class CntntController {

    @Autowired
    private CntntService cntntService;

    @RequestMapping(value = "/{param}", method = RequestMethod.GET)
    public String index(HttpServletRequest request, @PathVariable("param") String param) {
        if(param != null && param.isEmpty() != true) {
            return "/screen/" + request.getRequestURI();
        }else {
            return "/screen/index";
        }
    }

    // 컨텐츠 리스트
    @RequestMapping(value = "/cntntList/getCntntList", method = RequestMethod.POST)
    public String getCntntList(HttpServletRequest request,
                              CntntModel cntntModel, Model model) throws Exception {
        List<CntntModel> cntntList = this.cntntService.getCntntList(cntntModel);
        if (cntntList == null) {
            model.addAttribute("cntntList", null);
            model.addAttribute("msg", StaticMessage.message(0,"컨텐츠리스트조회"));
        } else {
            model.addAttribute("cntntList", cntntList);
            model.addAttribute("msg", StaticMessage.message(200,"컨텐츠리스트조회"));
        }
        return StaticData.index(request) + ":: #CommData";
    }

    // 컨텐츠 상세
    @RequestMapping(value = "/cntntWrite/getCntnt", method = RequestMethod.POST)
    public String getCtgr(HttpServletRequest request,
                          CntntModel cntntModel, Model model) throws Exception {
        CntntModel cntnt = this.cntntService.getCntnt(cntntModel);
        if (cntnt == null) {
            model.addAttribute("cntnt", null);
            model.addAttribute("msg", StaticMessage.message(0,"컨텐츠상세조회"));
        } else {
            model.addAttribute("cntnt", cntnt);
            model.addAttribute("msg", StaticMessage.message(200,"컨텐츠상세조회"));
        }
        return StaticData.index(request) + ":: #CommData";
    }

    // 등록
    @RequestMapping(value = "/cntntWrite/setCntntAdd", method = RequestMethod.POST)
    public String setCodeAdd(HttpServletRequest request,
                             CntntModel cntntModel, Model model,
                             @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        cntntModel.setModifyUserPid(userDetail.getMember().getUserPid());
        cntntModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.cntntService.setCntntAdd(cntntModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"컨텐츠등록"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"컨텐츠등록"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 수정
    @RequestMapping(value = "/cntntWrite/setCntntModify", method = RequestMethod.POST)
    public String setCodeModify(HttpServletRequest request,
                                CntntModel cntntModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        cntntModel.setModifyUserPid(userDetail.getMember().getUserPid());
        cntntModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.cntntService.setCntntModify(cntntModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"컨텐츠수정"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"컨텐츠수정"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 삭제여부변경
    @RequestMapping(value = {"/cntntList/setCntntDelete", "/cntntWrite/setCntntDelete"}, method = RequestMethod.POST)
    public String setCodeDelete(HttpServletRequest request,
                                CntntModel cntntModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        cntntModel.setModifyUserPid(userDetail.getMember().getUserPid());
        cntntModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.cntntService.setCntntDelete(cntntModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"컨텐츠삭제여부변경"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"컨텐츠삭제여부변경"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 공개여부변경
    @RequestMapping(value = {"/cntntList/setCntntUse", "/cntntWrite/setCntntUse"}, method = RequestMethod.POST)
    public String setCtgrUse(HttpServletRequest request,
                             CntntModel cntntModel, Model model,
                             @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        cntntModel.setModifyUserPid(userDetail.getMember().getUserPid());
        cntntModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.cntntService.setCntntUse(cntntModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"컨텐츠공개여부변경"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"컨텐츠공개여부변경"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }
}
