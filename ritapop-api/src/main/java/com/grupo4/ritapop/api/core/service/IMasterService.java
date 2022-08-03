package com.grupo4.ritapop.api.core.service;
import java.util.List;
import java.util.Map;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IMasterService {
    // PAYMENT_METHOD
    EntityResult payment_methodQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    EntityResult payment_methodInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    EntityResult payment_methodUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    EntityResult payment_methodDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    // SALES_STATUS
    EntityResult sales_statusQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    EntityResult sales_statusInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    EntityResult sales_statusUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    EntityResult sales_statusDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

    // PRODUCTS_CATEGORY
    EntityResult products_categoryQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    EntityResult products_categoryInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    EntityResult products_categoryUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult products_categoryDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}
