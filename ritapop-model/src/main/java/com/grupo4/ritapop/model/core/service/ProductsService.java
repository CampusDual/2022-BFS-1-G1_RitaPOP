package com.grupo4.ritapop.model.core.service;

import com.grupo4.ritapop.api.core.service.IProductsService;
import com.grupo4.ritapop.model.core.dao.ProductsDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service("ProductsService")
@Lazy
public class ProductsService implements IProductsService {
    @Autowired
    private ProductsDao productsDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult productsQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.productsDao, keyMap, attrList);
    }

    @Override
    public EntityResult productsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.productsDao, attrMap);
    }

    @Override
    public EntityResult productsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.productsDao, attrMap, keyMap);
    }

    @Override
    public EntityResult productsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.productsDao, keyMap);
    }
}