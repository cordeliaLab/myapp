package com.study.myapp.service.sign;

import com.study.myapp.mapper.sign.SignMpp;
import com.study.myapp.model.sign.SignModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SignMpp signMpp;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        logger.info("loadUserByUsername userId =" + userId);


//        SignModel memberModel = signMpp.findByUserId(userId);
//        if(memberModel != null) {
//            return new UserDetail(memberModel);
//        }
//        return null;

        SignModel memberModel = signMpp.findByUserId(userId);
        if(memberModel == null) {
            throw new UsernameNotFoundException(userId + " not found");
        } else {
            return new UserDetail(memberModel);
        }


        //MemberModel UserRole = memberMpp.findByUserId(userId);
        //if(UserRole != null && UserRole.getRoleNames().isEmpty() == false) {
        //    String[] RoleNames = UserRole.getRoleNames().split("\\||\\,");
        //    int i;
        //    String RoleNm = "";
        //    List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        //    for (i=0; i < RoleNames.length; i++) {
        //        if (i%2 == 0) {
        //            continue;
        //        }
        //        RoleNm = RoleNames[i];
        //        roles.add(new SimpleGrantedAuthority(RoleNm));
        //    }
        //    return new User(userId, UserRole.getUserPswd(), roles);
        //}

        //if(RoleList != null && RoleList.size() > 0) {
        //    int i;
        //    String RoleNm = "";
        //    List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        //    for(i=0; i< RoleList.size(); i++){
        //        RoleNm = RoleList.get(i).getRoleName().trim();
        //        if (RoleNm.equals("")) {
        //            continue;
        //        }
        //        roles.add(new SimpleGrantedAuthority(RoleNm));
        //    }
        //    return new User(userId, RoleList.get(0).getUserPswd(), roles);
        //}
    }
}
