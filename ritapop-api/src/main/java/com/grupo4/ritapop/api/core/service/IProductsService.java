package com.grupo4.ritapop.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import java.util.List;
import java.util.Map;

public interface IProductsService {
    EntityResult productsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    EntityResult productsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    EntityResult productsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    EntityResult productsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}