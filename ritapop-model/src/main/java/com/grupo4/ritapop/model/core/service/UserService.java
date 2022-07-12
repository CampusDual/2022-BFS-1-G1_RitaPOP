package com.grupo4.ritapop.model.core.service;


import java.sql.Timestamp;
import java.util.*;

import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.services.user.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.grupo4.ritapop.api.core.service.IUserService;
import com.grupo4.ritapop.model.core.dao.UserDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;


@Lazy
@Service("UserService")
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	public void loginQuery(Map<?, ?> key, List<?> attr) {
	}

	//Sample to permission
	//@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userQuery(Map<?, ?> keyMap, List<?> attrList) {
		return this.daoHelper.query(userDao, keyMap, attrList);
	}

	public EntityResult userInsert(Map<?, ?> attrMap) {
		return this.daoHelper.insert(userDao, attrMap);
	}

	public EntityResult userUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
		return this.daoHelper.update(userDao, attrMap, keyMap);
	}

	public EntityResult userDelete(Map<?, ?> keyMap) {
		Map<Object, Object> attrMap = new HashMap<>();
		attrMap.put("user_down_date", new Timestamp(Calendar.getInstance().getTimeInMillis()));
		return this.daoHelper.update(this.userDao, attrMap, keyMap);
	}

	public EntityResult sessionProfileQuery(Map<?, ?> keyMap, List<?> attrList){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserInformation p = (UserInformation) authentication.getPrincipal();
		Collection<GrantedAuthority> aut = p.getAuthorities();
		Optional<GrantedAuthority> roles = aut.stream().findFirst();
		String rol = roles.get().getAuthority();
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("rol",rol);
		return new EntityResultMapImpl(hashMap);
	}

}
