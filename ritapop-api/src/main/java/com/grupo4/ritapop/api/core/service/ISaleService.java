package com.grupo4.ritapop.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import java.util.List;
import java.util.Map;

public interface ISaleService {
    EntityResult saleQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    EntityResult saleInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    EntityResult saleUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    EntityResult saleDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    EntityResult saleDetailsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    EntityResult saleDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    EntityResult saleDetailsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    EntityResult saleDetailsUpdate(Map<String, Object> keyMap,  Map<String, Object> attrList) throws OntimizeJEERuntimeException;
}
