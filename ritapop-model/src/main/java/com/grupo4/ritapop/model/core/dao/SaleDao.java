package com.grupo4.ritapop.model.core.dao;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("SalesDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/SaleDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class SaleDao extends OntimizeJdbcDaoSupport {
    // NEW SALES TABLE
    public static final String ATTR_ID = "id";
    public static final String ATTR_NATURAL_ID = "natural_id";
    public static final String ATTR_ID_SELLER = "id_seller";
    public static final String ATTR_ID_PRODUCT = "id_product";
    public static final String ATTR_ID_TRANSACTION = "id_transaction";
    public static final String ATTR_PUBLICATION_DATETIME = "publication_datetime";
    public static final String ATTR_PRICE = "price";
    public static final String ATTR_SALE_STATUS = "sale_status";

    // NEW SALEDETAILS QUERY
    public static final String QUERY_SALE_DETAILS = "details";
}