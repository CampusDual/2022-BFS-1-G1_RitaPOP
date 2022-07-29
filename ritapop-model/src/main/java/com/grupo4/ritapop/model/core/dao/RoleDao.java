package com.grupo4.ritapop.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Lazy
@Repository("RoleDao")
@ConfigurationFile(configurationFile = "dao/RoleDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class RoleDao extends OntimizeJdbcDaoSupport{

    public static final String ID_ROLENAME = "ID_ROLENAME";
    public static final String ROLENAME = "ROLENAME";

}
