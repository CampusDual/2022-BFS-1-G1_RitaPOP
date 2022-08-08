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
    final static int TOTALNUMBERDIGITS=5;

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
    @Transactional(rollbackFor = Exception.class)
    public EntityResult saleDetailsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        EntityResult resultInsertProductsQuery;
        EntityResult resultInsertSalesQuery=null;
        EntityResult resultSalesQuery;
        EntityResult resultClientQuery;
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
            int idLastProducts=(Integer) resultInsertProductsQuery.get("ID");
            attrMap.put(SaleDao.ATTR_ID_PRODUCT,idLastProducts);
            List<String> attrListSales=new ArrayList<>();
            attrListSales.add(SaleDao.ATTR_NATURAL_ID);
            //attrMap.put(SaleDao.ATTR_NATURAL_ID,null);
            resultSalesQuery=this.daoHelper.query(this.saleDao, null,attrListSales);
            List<String> listNaturalID = (ArrayList<String>) resultSalesQuery.get(SaleDao.ATTR_NATURAL_ID);

            // Generates Natural number
            List<Integer> listIDForNaturalId=new ArrayList<>();
            for(String valueString:listNaturalID){
                valueString=valueString.replace(PRE_NATURAL_NUM,"");
                int value=Integer.parseInt(valueString);
                listIDForNaturalId.add(value);
            }
            int maxListNaturalId=Collections.max(listIDForNaturalId);
            maxListNaturalId=maxListNaturalId+1;
            String idValue = ""+maxListNaturalId;
            String naturalNum = (String) (PRE_NATURAL_NUM + String.format("%0"+(TOTALNUMBERDIGITS-idValue.length()+1)+"d", Integer.parseInt(idValue)));
            attrMap.put(SaleDao.ATTR_NATURAL_ID,naturalNum);

            // Incrementar Sales de Clients
            Map<String,Object> keyClientMap=new HashMap<>();
            keyClientMap.put(ClientDao.ATTR_ID,attrMap.get(SaleDao.ATTR_ID_SELLER));
            List<String> columnsClientQuery=new ArrayList<>();
            columnsClientQuery.add(ClientDao.ATTR_SALES);
            resultClientQuery=this.daoHelper.query(this.clientDao,keyClientMap,columnsClientQuery);
            ArrayList<Integer> listSales=(ArrayList<Integer>) resultClientQuery.get(ClientDao.ATTR_SALES);
            int valueSalesClient=listSales.get(0);
            ++valueSalesClient;
            Map<String,Object> newSalesClient=new HashMap<>();
            newSalesClient.put(ClientDao.ATTR_SALES,valueSalesClient);
            this.daoHelper.update(this.clientDao,newSalesClient,keyClientMap);

            resultInsertSalesQuery=this.daoHelper.insert(this.saleDao,attrMap);
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