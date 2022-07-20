package com.grupo4.ritapop.model.core.dao;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("TransactionDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/TransactionDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class TransactionDao extends OntimizeJdbcDaoSupport {

 public static final String ATTR_ID = "id";
 public static final String ATTR_SELLER_CLI = "seller_cli";
 public static final String ATTR_BUYER_CLI = "buyer_cli";
 public static final String ATTR_START_DATE = "start_date";
 public static final String ATTR_END_DATE = "end_date";
 public static final String ATTR_PRICE = "price";
 public static final String ATTR_PRODUCT_NAME = "product_name";
 public static final String ATTR_PRODUCT_CATEGORY = "product_category";
 public static final String QUERY_OFFER_DETAILS = "details";
 public static final String ATTR_NIF_SELLER = "nif_seller";
 public static final String ATTR_NIF_BUYER = "nif_buyer";
 public static final String ATTR_PAYMENT_METHOD = "payment_method";
}
