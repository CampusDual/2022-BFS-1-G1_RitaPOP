package com.grupo4.ritapop.model.core.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.grupo4.ritapop.api.core.service.ITransactionService;
import com.grupo4.ritapop.model.core.dao.TransactionDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("CandidateService")
@Lazy
public class TransactionService implements ITransactionService{

 @Autowired private TransactionDao transactionDao;
 @Autowired private DefaultOntimizeDaoHelper daoHelper;
 
 @Override
 public EntityResult transactionQuery(Map<String, Object> keyMap, List<String> attrList)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.query(this.transactionDao, keyMap, attrList);
 }

 @Override
 public EntityResult transactionInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.insert(this.transactionDao, attrMap);
 }

 @Override
 public EntityResult transactionUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
   throws OntimizeJEERuntimeException {
  return this.daoHelper.update(this.transactionDao, attrMap, keyMap);
 }

 @Override
 public EntityResult transactionDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
  return this.daoHelper.delete(this.transactionDao, keyMap);
 }

}
