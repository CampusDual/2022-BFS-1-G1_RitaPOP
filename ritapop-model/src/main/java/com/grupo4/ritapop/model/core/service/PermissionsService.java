package com.grupo4.ritapop.model.core.service;

import static com.grupo4.ritapop.model.core.dao.PermissionsDao.ATTR_PERMISSIONS;

import com.grupo4.ritapop.api.core.service.PermissionsApi;
import com.grupo4.ritapop.model.core.dao.PermissionsDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("PermissionsService")
@Lazy
public class PermissionsService implements PermissionsApi {

  @Autowired
  DefaultOntimizeDaoHelper daoHelper;

  @Autowired
  PermissionsDao permissionsDao;

  @Override
  public EntityResult getPermissionsByUser() {
    EntityResultMapImpl entityResultMap = new EntityResultMapImpl();
    List<String> attr = new ArrayList<String>();
    attr.add(ATTR_PERMISSIONS);
    Map<String, Object> map = new HashMap<>();
    String loggedUserRolname = getLoggedUserRolHighest();
    map.put("ROLENAME", loggedUserRolname);
    EntityResult query = this.daoHelper.query(this.permissionsDao, map, attr);
    entityResultMap.addRecord(new HashMap<>(){{put("permission",((List) query.get(ATTR_PERMISSIONS)).get(0));}});
    return entityResultMap;
  }

  public String getLoggedUserRolHighest(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserInformation p = (UserInformation) authentication.getPrincipal();
    Collection<GrantedAuthority> aut = p.getAuthorities();
    Optional<GrantedAuthority> roles = aut.stream().findFirst();
    String rol = roles.get().getAuthority();
    return rol;
  }
}
