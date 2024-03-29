package com.grupo4.ritapop.api.core.service;


import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ITransactionService {


 public EntityResult transactionQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult transactionInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult transactionUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult transactionDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult transactionDetailsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult transactionDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult transactionDetailsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult transactionDetailsUpdate(Map<String, Object> keyMap,  Map<String, Object> attrList) throws OntimizeJEERuntimeException;
}
