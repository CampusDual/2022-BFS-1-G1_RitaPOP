package com.grupo4.ritapop.model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.grupo4.ritapop.api.core.service.ITransactionService;
import com.grupo4.ritapop.model.core.dao.ClientDao;
import com.grupo4.ritapop.model.core.dao.TransactionDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("TransactionService")
@Lazy
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionDao transactionDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Autowired
	private ClientService clientService;

	@Override
/*	public EntityResult transactionQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.transactionDao, keyMap, attrList);
	}
*/
	public EntityResult transactionQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.transactionDao, keyMap, attrList);
	}
	
	@Override
	public EntityResult transactionInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
//  return this.daoHelper.insert(this.transactionDao, attrMap);

		Map<String, Object> nonTransactionData = removeNonRelatedData(attrMap, TransactionDao.ATTR_SELLER_CLI,
				TransactionDao.ATTR_BUYER_CLI);
		this.insertNonRelatedData(nonTransactionData);
		attrMap.putAll(nonTransactionData);
		return this.daoHelper.insert(this.transactionDao, attrMap);
	}

	@Override
	public EntityResult transactionUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
//  return this.daoHelper.update(this.transactionDao, attrMap, keyMap);

		Map<String, Object> nonTransactionData = removeNonRelatedData(attrMap, TransactionDao.ATTR_SELLER_CLI,
				TransactionDao.ATTR_BUYER_CLI);
		this.insertNonRelatedData(nonTransactionData);
		attrMap.putAll(nonTransactionData);
		return this.daoHelper.update(this.transactionDao, attrMap, keyMap);
	}

	@Override
	public EntityResult transactionDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.transactionDao, keyMap);
	}

	private Map<String, Object> removeNonRelatedData(Map<String, Object> attrMap, String... attrToExclude) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		for (String attr : attrToExclude) {
			if (attrMap.containsKey(attr) && attrMap.get(attr) instanceof String) {
				data.put(attr, attrMap.remove(attr));
			}
		}
		return data;
	}

	private void insertNonRelatedData(Map<String, Object> nonTransactionData) {
		for (Entry<String, Object> entry : nonTransactionData.entrySet()) {
			Map<String, Object> data = new HashMap<String, Object>();
			List<String> attr = new ArrayList<String>();
			EntityResult toret, query;
			switch (entry.getKey()) {
			case TransactionDao.ATTR_SELLER_CLI:
				data.put(ClientDao.ATTR_NIF, entry.getValue());
				attr.add(ClientDao.ATTR_ID);
				query = this.clientService.clientQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(ClientDao.ATTR_ID));
				} else {
					toret = this.clientService.clientInsert(data);
					entry.setValue(toret.get(ClientDao.ATTR_ID));
				}
				break;
			case TransactionDao.ATTR_BUYER_CLI:
				data.put(ClientDao.ATTR_NIF, entry.getValue());
				attr.add(ClientDao.ATTR_ID);
				query = this.clientService.clientQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(ClientDao.ATTR_ID));
				} else {
					toret = this.clientService.clientInsert(data);
					entry.setValue(toret.get(ClientDao.ATTR_ID));
				}
				break;
			default:
				break;
			}
		}
	}
	@Override
	 public EntityResult offerTransactionDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
	   throws OntimizeJEERuntimeException {
	  return this.daoHelper.query(this.transactionDao, keyMap, attrList, transactionDao.QUERY_OFFER_DETAILS);
	 }
}
