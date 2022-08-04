package com.grupo4.ritapop.model.core.dao;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("TransactionDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/TransactionDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class TransactionDao extends OntimizeJdbcDaoSupport {

 /*
 public static final String ATTR_ID = "ID";
 public static final String ATTR_SELLER_CLI = "SELLER_CLI";
 public static final String ATTR_BUYER_CLI = "BUYER_CLI";
 public static final String ATTR_START_DATE = "START_DATE";
 public static final String ATTR_END_DATE = "END_DATE";
 public static final String ATTR_PRICE = "PRICE";
 public static final String ATTR_PRODUCT_NAME = "PRODUCT_NAME";
 public static final String ATTR_PRODUCT_CATEGORY = "PRODUCT_CATEGORY";
 public static final String QUERY_OFFER_DETAILS = "details";
 public static final String ATTR_NIF_SELLER = "NIF_SELLER";
 public static final String ATTR_NIF_BUYER = "NIF_BUYER";
 public static final String ATTR_PAYMENT_METHOD = "PAYMENT_METHOD";
 */

 // NEW TRANSACTIONS TABLE
 public static final String ATTR_ID = "id";
 public static final String ATTR_SELLER_CLI = "seller_cli";
 public static final String ATTR_BUYER_CLI = "buyer_cli";
 public static final String ATTR_START_DATE = "start_date";
 public static final String ATTR_PAYMENT_METHOD = "id_payment_method";
 // NEW TRANSACTIONDETAILS QUERY
 public static final String QUERY_TRANSACTION_DETAILS = "details";
 public static final String ATTR_SALE_STATUS = "sale_status";
}
