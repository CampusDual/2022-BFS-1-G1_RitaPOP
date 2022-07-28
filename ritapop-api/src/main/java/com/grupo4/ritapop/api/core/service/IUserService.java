package com.grupo4.ritapop.api.core.service;


import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;


public interface IUserService {

	public EntityResult userQuery(Map<?, ?> keyMap, List<?> attrList);
	public EntityResult userDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult userInsert(Map<String, Object> attrMap);
	public EntityResult userUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap);
	public EntityResult userDelete(Map<?, ?> keyMap);
	public EntityResult sessionProfileQuery(Map<?, ?> keyMap, List<?> attrList);

	//--ROLE--
	public EntityResult roleQuery(Map<?, ?> keyMap, List<?> attrList);
	public EntityResult roleInsert(Map<?, ?> attrMap);
	public EntityResult roleUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap);
	public EntityResult roleDelete(Map<?, ?> keyMap);
}
