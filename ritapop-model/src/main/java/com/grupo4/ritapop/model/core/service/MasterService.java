package com.grupo4.ritapop.model.core.service;
import java.util.List;
import java.util.Map;

import com.grupo4.ritapop.model.core.dao.Payment_MethodDao;
import com.grupo4.ritapop.model.core.dao.Products_CategoryDao;
import com.grupo4.ritapop.model.core.dao.Sales_StatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.grupo4.ritapop.api.core.service.IMasterService;

@Service("MasterService")
@Lazy
public class MasterService implements IMasterService{
    @Autowired private Payment_MethodDao payment_methodDao;
    @Autowired private Sales_StatusDao sales_statusDao;
    @Autowired private Products_CategoryDao products_categoryDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult payment_methodQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.payment_methodDao, keyMap, attrList);
    }

    @Override
    public EntityResult payment_methodInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.payment_methodDao, attrMap);
    }

    @Override
    public EntityResult payment_methodUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.payment_methodDao, attrMap, keyMap);
    }

    @Override
    public EntityResult payment_methodDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.payment_methodDao, keyMap);
    }

    @Override
    public EntityResult sales_statusQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.sales_statusDao, keyMap, attrList);
    }

    @Override
    public EntityResult sales_statusInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.sales_statusDao, attrMap);
    }

    @Override
    public EntityResult sales_statusUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.sales_statusDao, attrMap, keyMap);
    }

    @Override
    public EntityResult sales_statusDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.sales_statusDao, keyMap);
    }

    @Override
    public EntityResult products_categoryQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.products_categoryDao, keyMap, attrList);
    }

    @Override
    public EntityResult products_categoryInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.products_categoryDao, attrMap);
    }

    @Override
    public EntityResult products_categoryUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.products_categoryDao, attrMap, keyMap);
    }

    @Override
    public EntityResult products_categoryDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.products_categoryDao, keyMap);
    }
}


