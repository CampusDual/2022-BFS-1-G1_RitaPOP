package com.grupo4.ritapop.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("ClientDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/ClientDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ClientDao extends OntimizeJdbcDaoSupport {

 public static final String ATTR_ID = "ID";
 public static final String ATTR_NAME = "NAME";
 public static final String ATTR_SURNAME = "SURNAME";
 public static final String ATTR_NIF = "NIF";
 public static final String ATTR_BIRTH_DATE = "BIRTH_DATE";


}
