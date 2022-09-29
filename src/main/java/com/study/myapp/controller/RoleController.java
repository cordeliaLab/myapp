package com.study.myapp.controller;

import com.study.myapp.controller.common.StaticData;
import com.study.myapp.controller.common.StaticMessage;
import com.study.myapp.model.admin.RoleModel;
import com.study.myapp.service.admin.RoleService;
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
@RequestMapping(value = "admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/{param}", method = RequestMethod.GET)
    public String index(HttpServletRequest request, @PathVariable("param") String param) {
        if(param != null && param.isEmpty() != true) {
            return "/screen/" + request.getRequestURI();
        }else {
            return "/screen/index";
        }
    }

    // 권한 리스트
    @RequestMapping(value = "/roleList/getRoleList", method = RequestMethod.POST)
    public String getRoleList(HttpServletRequest request,
                               RoleModel roleModel, Model model) throws Exception {
        List<RoleModel> roleList = this.roleService.getRoleList(roleModel);
        if (roleList == null) {
            model.addAttribute("roleList", null);
            model.addAttribute("msg", StaticMessage.message(0,"권한리스트조회"));
        } else {
            model.addAttribute("roleList", roleList);
            model.addAttribute("msg", StaticMessage.message(200,"권한리스트조회"));
        }
        return StaticData.index(request) + ":: #CommData";
    }

    // 권한 상세
    @RequestMapping(value = "/roleWrite/getRole", method = RequestMethod.POST)
    public String getCtgr(HttpServletRequest request,
                          RoleModel roleModel, Model model) throws Exception {
        RoleModel role = this.roleService.getRole(roleModel);
        if (role == null) {
            model.addAttribute("role", null);
            model.addAttribute("msg", StaticMessage.message(0,"권한상세조회"));
        } else {
            model.addAttribute("role", role);
            model.addAttribute("msg", StaticMessage.message(200,"권한상세조회"));
        }
        return StaticData.index(request) + ":: #CommData";
    }

    // 등록
    @RequestMapping(value = "/roleWrite/setRoleAdd", method = RequestMethod.POST)
    public String setCodeAdd(HttpServletRequest request,
                             RoleModel roleModel, Model model,
                             @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        roleModel.setModifyUserPid(userDetail.getMember().getUserPid());
        roleModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.roleService.setRoleAdd(roleModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"권한등록"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"권한등록"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 수정
    @RequestMapping(value = "/roleWrite/setRoleModify", method = RequestMethod.POST)
    public String setCodeModify(HttpServletRequest request,
                                RoleModel roleModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        roleModel.setModifyUserPid(userDetail.getMember().getUserPid());
        roleModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.roleService.setRoleModify(roleModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"권한수정"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"권한수정"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

    // 삭제여부변경
    @RequestMapping(value = {"/roleList/setRoleDelete", "/roleWrite/setRoleDelete"}, method = RequestMethod.POST)
    public String setCodeDelete(HttpServletRequest request,
                                RoleModel roleModel, Model model,
                                @AuthenticationPrincipal UserDetail userDetail) throws Exception {
        roleModel.setModifyUserPid(userDetail.getMember().getUserPid());
        roleModel.setCreateUserPid(userDetail.getMember().getUserPid());
        int iResult = this.roleService.setRoleDelete(roleModel);
        if (iResult == 1) {
            model.addAttribute("msg", StaticMessage.message(200,"권한삭제여부변경"));
        } else {
            model.addAttribute("msg", StaticMessage.message(0,"권한삭제여부변경"));
        }
        return StaticData.index(request) + ":: #CommMsgData";
    }

}
