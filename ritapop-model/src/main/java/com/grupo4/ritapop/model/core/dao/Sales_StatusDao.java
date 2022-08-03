package com.grupo4.ritapop.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("Sales_StatusDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/Sales_StatusDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class Sales_StatusDao extends OntimizeJdbcDaoSupport {
    public static final String ATTR_ID = "id";
    public static final String ATTR_NAME = "name";
}