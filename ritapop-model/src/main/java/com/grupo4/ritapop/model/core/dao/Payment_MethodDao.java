package com.grupo4.ritapop.model.core.dao;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("Payment_MethodDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/Payment_MethodDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class Payment_MethodDao extends OntimizeJdbcDaoSupport{
    public static final String ATTR_ID = "id";
    public static final String ATTR_NAME = "name";
    public static final String ATTR_DESCRIPTION = "description";
}
