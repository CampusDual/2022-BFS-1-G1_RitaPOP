package com.grupo4.ritapop.model.core.service;

import com.grupo4.ritapop.api.core.service.ISaleService;
import com.grupo4.ritapop.model.core.dao.ClientDao;
import com.grupo4.ritapop.model.core.dao.SaleDao;
import com.grupo4.ritapop.model.core.dao.TransactionDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SaleService")
@Lazy
public class SaleService implements ISaleService {
    @Autowired
    private SaleDao saleDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;
    @Autowired
    private ClientService clientService;

    @Override
    public EntityResult saleQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.saleDao, keyMap, attrList);
    }

    @Override
    public EntityResult saleInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        /*int id_seller = getIdFromNIF(attrMap.get("NIF_SELLER"));
        attrMap.put("SELLER_CLI",id_seller);
        int id_buyer = getIdFromNIF(attrMap.get("NIF_BUYER"));
        attrMap.put("BUYER_CLI",id_buyer);*/
        return this.daoHelper.insert(this.saleDao, attrMap);
    }

    /*public int getIdFromNIF(Object nif){
        List<String> attrList = new ArrayList<>();
        attrList.add("id");
        Map<String,Object> keyMap = new HashMap<>();
        keyMap.put("nif",nif);
        EntityResult id_entity_result = this.daoHelper.query(this.clientDao, keyMap,attrList);
        Object id_object = id_entity_result.get("id");
        String id_string = id_object.toString();
        String id_string_final = id_string.replace("[","");
        id_string_final = id_string_final.replace("]","");
        int id = Integer.parseInt(id_string_final);
        return id;
    }*/

    @Override
    public EntityResult saleUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.saleDao, attrMap, keyMap);
    }

    @Override
    public EntityResult saleDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.saleDao, keyMap);
    }

    @Override
    public EntityResult saleDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.saleDao, keyMap, attrList, SaleDao.QUERY_SALE_DETAILS);
    }


    @Override
    public EntityResult saleDetailsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

        /*int id_seller = getIdFromNIF(attrMap.get("NIF_SELLER"));
        attrMap.put("SELLER_CLI",id_seller);
        int id_buyer = getIdFromNIF(attrMap.get("NIF_BUYER"));
        attrMap.put("BUYER_CLI",id_buyer);*/
        return this.daoHelper.insert(this.saleDao, attrMap);
    }


    @Override
    public EntityResult saleDetailsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        /*keyMap.put("id", keyMap.get("ID_TRANSACTION"));
        keyMap.remove("ID_TRANSACTION");*/
        return this.daoHelper.delete(this.saleDao, keyMap);
    }


    @Override
    public EntityResult saleDetailsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        keyMap.put("id", keyMap.get("ID_TRANSACTION"));
        keyMap.remove("ID_TRANSACTION");
        return this.daoHelper.update(this.saleDao,attrMap, keyMap);
    }
}