package com.grupo4.ritapop.model.core.service;

import com.grupo4.ritapop.api.core.service.ISaleService;
import com.grupo4.ritapop.model.core.dao.ClientDao;
import com.grupo4.ritapop.model.core.dao.ProductsDao;
import com.grupo4.ritapop.model.core.dao.SaleDao;
import com.grupo4.ritapop.model.core.dao.UserRoleDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("SaleService")
@Lazy
public class SaleService implements ISaleService {
    @Autowired
    private SaleDao saleDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ProductsDao productsDao;
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;
    @Autowired
    private ClientService clientService;

    final static String PRE_NATURAL_NUM = "SAL";

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
//    @Transactional(rollbackFor = Exception.class)
    public EntityResult saleDetailsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        EntityResult resultInsertProductsQuery;
        EntityResult resultInsertSalesQuery=null;
        Map<String,Object> attrProductsMap=new HashMap<>();
        attrProductsMap.put(ProductsDao.ATTR_NAME,attrMap.get("NAME_PRODUCTS"));
        attrMap.remove("NAME_PRODUCTS");
        attrProductsMap.put(ProductsDao.ATTR_DESCRIPTION,attrMap.get("DESCRIPTION_PRODUCTS"));
        attrMap.remove("DESCRIPTION_PRODUCTS");
        attrProductsMap.put(ProductsDao.ATTR_PHOTO,attrMap.get("PHOTO"));
        attrMap.remove("PHOTO");
        attrProductsMap.put(ProductsDao.ATTR_ID_CATEGORY,attrMap.get("ID_PRODUCTS_CATEGORY"));
        attrMap.remove("ID_PRODUCTS_CATEGORY");
        resultInsertProductsQuery=this.daoHelper.insert(this.productsDao,attrProductsMap);
        if(resultInsertProductsQuery.getCode() == EntityResult.OPERATION_SUCCESSFUL){
            attrMap.remove("NAME");
            attrMap.remove("SURNAME");
            attrMap.remove("PHONE");
            attrMap.remove("EMAIL");
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            attrMap.put(SaleDao.ATTR_PUBLICATION_DATETIME,timeStamp);
            attrMap.put(SaleDao.ATTR_ID_TRANSACTION,null);
            attrMap.put(SaleDao.ATTR_SALE_STATUS,1);
            List<String> attrListProducts=new ArrayList<>();
            attrListProducts.add("ID");
            EntityResult productsQuery=this.daoHelper.query(this.productsDao, attrProductsMap, attrListProducts);
            List<Integer> lastIdProductsQuery=(List<Integer>) productsQuery.get(ProductsDao.ATTR_ID);
            attrMap.put(SaleDao.ATTR_ID_PRODUCT,lastIdProductsQuery.get(0));
            attrMap.put(SaleDao.ATTR_NATURAL_ID,null);
            resultInsertSalesQuery=this.daoHelper.insert(this.saleDao, attrMap);

            // Generates Natural number
            String idValue = resultInsertSalesQuery.get("ID").toString();
            String naturalNum = (String) (PRE_NATURAL_NUM + String.format("%05d", Integer.parseInt(idValue)));

            Map<String,Object> attrNewValueMap = new HashMap<>();
            Map<String,Object> keysWhere = new HashMap<>();

            attrNewValueMap.put(SaleDao.ATTR_NATURAL_ID, naturalNum);
            keysWhere.put(SaleDao.ATTR_ID, idValue);

            //TODO Hay que hacer que el update funcione primero para que esto nos valga
            EntityResult erUpdateSales = this.daoHelper.update(this.saleDao, attrNewValueMap, keysWhere);


        }
        return resultInsertSalesQuery;
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