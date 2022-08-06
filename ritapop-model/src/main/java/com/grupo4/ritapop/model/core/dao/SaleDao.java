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
    public static final String ATTR_ID = "ID";
    public static final String ATTR_NATURAL_ID = "NATURAL_ID";
    public static final String ATTR_ID_SELLER = "ID_SELLER";
    public static final String ATTR_ID_PRODUCT = "ID_PRODUCT";
    public static final String ATTR_ID_TRANSACTION = "ID_TRANSACTION";
    public static final String ATTR_PUBLICATION_DATETIME = "PUBLICATION_DATETIME";
    public static final String ATTR_PRICE = "PRICE";
    public static final String ATTR_SALE_STATUS = "SALE_STATUS";

    // NEW SALEDETAILS QUERY
    public static final String QUERY_SALE_DETAILS = "details";
}