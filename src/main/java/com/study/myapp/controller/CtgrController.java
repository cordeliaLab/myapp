package com.study.myapp.controller;

import com.study.myapp.controller.common.StaticData;
import com.study.myapp.controller.common.StaticMessage;
import com.study.myapp.model.admin.CtgrModel;
import com.study.myapp.service.admin.CtgrService;
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
@RequestMapping(value = "admin/ctgr")
public class CtgrController {
    @Autowired
    private CtgrService ctgrService;

    @RequestMapping(value = "/{param}", method = RequestMethod.GET)
    public String index(HttpServletRequest request, @PathVariable("param") String param) {
        if(param != null && param.isEmpty() != true) {
            return "/screen/" + request.getRequestURI();
        }else {
            return "/screen/index";
        }
    }

    // 카테고리 리스트 조회
    @RequestMapping(value = {"/ctgrList/getCtgrList", "/ctgrList/getGnbCtgrList"}, method = RequestMethod.POST)
    public String getCtgrList(HttpServletRequest request,
                              CtgrModel ctgrModel, Model model) throws Exception {
        List<CtgrModel> ctgrList = this.ctgrService.getCtgrList(ctgrModel);
        if (ctgrList == null) {
            model.addAttribute("ctgrList", null);
            model.addAttribute("msg", StaticMessage.message(0,"코드리스트조회"));
        } else {
            model.addAttribute("ctgrList", ctgrList);
            model.addAttribute("msg", StaticMessage.message(200,"코드리스트조회"));
        }

        String url = request.getRequestURI();
        if (url.equals("/admin/ctgr/ctgrList/getGnbCtgrList")) {
            return "/screen/fragment/gnb" + ":: #CommData";
        } else {
            return StaticData.index(request) + ":: #CommData";
        }
//        return StaticData.index(request) + ":: #CommData";
    }

    // 카테고리 상세 조회
    @RequestMapping(value = "/ctgrWrite/getCtgr", method = RequestMethod.POST)
    public String getCtgr(HttpServletRequest request,
                          CtgrModel ctgrModel, Model model) throws Exception {
        CtgrModel ctgr = this.ctgrService.getCtgr(ctgrModel);
        List<CtgrModel> ctgrPrntsList = this.ctgrService.getCtgrPrntsList(ctgrModel);
        if (ctgr == null) {
            model.addAttribute("ctgr", null);
            model.addAttribute("ctgrPrntsList", null);
            model.addAttribute("msg", StaticMessage.message(0,"카테고리상세조회"));
        } else {
            model.addAttribute("ctgr", ctgr);
            model.addAttribute("ctgrPrntsList", ctgrPrntsList);
            model.addAttribute("msg", StaticMessage.message(200,"카테고리상세조회"));
        }
        return StaticData.index(request) + ":: #CommData";
    }

    // 카테고리등록
    @RequestMapping(value = "/ctgrWrite/setCtgrAdd", method = RequestMethod.POST)
    public String setCodeAdd(HttpServletRequest request,
                             CtgrModel ctgrModel, Model model,
                             @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        ctgrModel.setModifyUserPid(userDetail.getMember().getUserPid());
        ctgrModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.ctgrService.setCtgrAdd(ctgrModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"카테고리등록"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"카테고리등록"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 카테고리수정
    @RequestMapping(value = "/ctgrWrite/setCtgrModify", method = RequestMethod.POST)
    public String setCodeModify(HttpServletRequest request,
                                CtgrModel ctgrModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        ctgrModel.setModifyUserPid(userDetail.getMember().getUserPid());
        ctgrModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.ctgrService.setCtgrModify(ctgrModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"카테고리수정"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"카테고리수정"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 카테고리삭제여부변경
    @RequestMapping(value = {"/ctgrList/setCtgrDelete", "/ctgrWrite/setCtgrDelete"}, method = RequestMethod.POST)
    public String setCodeDelete(HttpServletRequest request,
                                CtgrModel ctgrModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        ctgrModel.setModifyUserPid(userDetail.getMember().getUserPid());
        ctgrModel.setCreateUserPid(userDetail.getMember().getUserPid());
        // 하위 카테고리 삭제여부 '1'로 변경
        // 하위 컨텐츠 삭제여부 '1'로 변경
        int iResult = this.ctgrService.setCtgrDelete(ctgrModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"카테고리삭제여부변경"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"카테고리삭제여부변경"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 카테고리공개여부변경
    @RequestMapping(value = {"/ctgrList/setCtgrUse", "/ctgrWrite/setCtgrUse"}, method = RequestMethod.POST)
    public String setCtgrUse(HttpServletRequest request,
                                CtgrModel ctgrModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        ctgrModel.setModifyUserPid(userDetail.getMember().getUserPid());
        ctgrModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.ctgrService.setCtgrUse(ctgrModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"카테고리공개여부변경"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"카테고리공개여부변경"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }
}
