package com.grupo4.ritapop.model.core.service;


import java.sql.Timestamp;
import java.util.*;

import com.grupo4.ritapop.model.core.dao.RoleDao;
import com.grupo4.ritapop.model.core.dao.UserRoleDao;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
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
import org.springframework.transaction.annotation.Transactional;


@Lazy
@Service("UserService")
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserRoleDao userRoleDao;

	public void loginQuery(Map<?, ?> key, List<?> attr) {
	}

	//Sample to permission
	//@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userQuery(Map<?, ?> keyMap, List<?> attrList) {
		return this.daoHelper.query(userDao, keyMap, attrList);
	}

	@Override
	public EntityResult userDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.userDao, keyMap, attrList, userDao.QUERY_USER_DETAILS);
	}

	@Transactional(rollbackFor = Exception.class)
	public EntityResult userInsert(Map<String, Object> attrMap) {
		EntityResult insertNewUser;
		Map<String,Object> attrUserRoleMap = new HashMap<>();

		attrUserRoleMap.put(UserRoleDao.ATTR_USER_,attrMap.get(UserDao.ATTR_USER_TUSER));
		attrUserRoleMap.put(UserRoleDao.ATTR_ID_ROLENAME,attrMap.get(UserDao.ATTR_ID_ROLENAME));

		attrMap.remove(RoleDao.ID_ROLENAME);
		attrMap.put(UserDao.ATTR_USER_, attrMap.get(UserDao.ATTR_USER_TUSER));
		attrMap.remove(UserDao.ATTR_USER_TUSER);

		insertNewUser = this.daoHelper.insert(this.userDao, attrMap);

		if(insertNewUser.getCode() == EntityResult.OPERATION_SUCCESSFUL){
			insertNewUser = this.daoHelper.insert(this.userRoleDao,attrUserRoleMap);
		}
		return insertNewUser;
	}

	public EntityResult userUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
		return this.daoHelper.update(userDao, attrMap, keyMap);
	}

	@Transactional(rollbackFor = Exception.class)
	public EntityResult userDetailsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) {

		keyMap.put(UserDao.ATTR_USER_,keyMap.get(UserDao.ATTR_USER_TUSER));
		keyMap.remove(UserDao.ATTR_USER_TUSER);
		if(attrMap.containsKey(UserRoleDao.ATTR_ID_ROLENAME)){
			Map<String,Object> keyUserRoleMap=new HashMap<>();
			keyUserRoleMap.put(UserRoleDao.ATTR_USER_,keyMap.get(UserDao.ATTR_USER_));
			List<String> nameColum=new ArrayList<>();
			nameColum.add(UserRoleDao.ATTR_ID_USER_ROLE);
			EntityResult idRoleQuery=userRoleQuery(keyUserRoleMap,nameColum);
			Map<String,Object> attrMapUserRole=new HashMap<>();
			attrMapUserRole.put(UserRoleDao.ATTR_ID_ROLENAME,attrMap.get(UserRoleDao.ATTR_ID_ROLENAME));
			attrMap.remove(UserRoleDao.ATTR_ID_ROLENAME);
			Map<String,Object> keyMapRolUser=new HashMap<>();
			List<Integer> listIdRoleQuery= (List<Integer>) idRoleQuery.get(UserRoleDao.ATTR_ID_USER_ROLE);
			keyMapRolUser.put(UserRoleDao.ATTR_ID_USER_ROLE,listIdRoleQuery.get(0));
			this.daoHelper.update(userRoleDao, attrMapUserRole, keyMapRolUser);
		}
		return this.daoHelper.update(userDao, attrMap, keyMap);
	}

	@Transactional(rollbackFor = Exception.class)
	public EntityResult userDetailsDelete(Map<String, Object> keyMap) {
		keyMap.put(UserDao.ATTR_USER_,keyMap.get(UserDao.ATTR_USER_TUSER));
		keyMap.remove(UserDao.ATTR_USER_TUSER);
		List<String> nameColum=new ArrayList<>();
		Map<String,Object> keyUserRoleMap=new HashMap<>();
		keyUserRoleMap.put(UserRoleDao.ATTR_USER_,keyMap.get(UserDao.ATTR_USER_));
		nameColum.add(UserRoleDao.ATTR_ID_USER_ROLE);
		EntityResult idRoleQuery=userRoleQuery(keyUserRoleMap,nameColum);
		Map<String,Object> keyMapRolUser=new HashMap<>();
		List<Integer> listIdRoleQuery= (List<Integer>) idRoleQuery.get(UserRoleDao.ATTR_ID_USER_ROLE);
		keyMapRolUser.put(UserRoleDao.ATTR_ID_USER_ROLE,listIdRoleQuery.get(0));
		this.daoHelper.delete(userRoleDao,keyMapRolUser);
		return this.daoHelper.delete(userDao,keyMap);
	}

	public EntityResult userDelete(Map<?, ?> keyMap) {
		Map<Object, Object> attrMap = new HashMap<>();
		attrMap.put("user_down_date", new Timestamp(Calendar.getInstance().getTimeInMillis()));
		return this.daoHelper.update(this.userDao, attrMap, keyMap);
	}

	@Override
	public EntityResult roleQuery(Map<String, Object> keyMap, List<String> attrList) {
		return this.daoHelper.query(roleDao, keyMap, attrList);

	}

	@Override
	public EntityResult roleInsert(Map<?, ?> attrMap) {
		return this.daoHelper.insert(roleDao, attrMap);
	}

	@Override
	public EntityResult roleUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
		return this.daoHelper.update(roleDao, attrMap, keyMap);
	}

	@Override
	public EntityResult roleDelete(Map<?, ?> keyMap) {
		return this.daoHelper.delete(roleDao, keyMap);
	}

	@Override
	public EntityResult userRoleQuery(Map<String, Object> keyMap, List<String> attrList) {
		return this.daoHelper.query(userRoleDao, keyMap, attrList);

	}
}
