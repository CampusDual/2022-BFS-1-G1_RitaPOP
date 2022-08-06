package com.grupo4.ritapop.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("ProductsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/ProductsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ProductsDao extends OntimizeJdbcDaoSupport {
    public static final String ATTR_ID = "ID";
    public static final String ATTR_NAME = "NAME";
    public static final String ATTR_DESCRIPTION = "DESCRIPTION";
    public static final String ATTR_PHOTO = "PHOTO";
    public static final String ATTR_ID_CATEGORY = "ID_CATEGORY";
}