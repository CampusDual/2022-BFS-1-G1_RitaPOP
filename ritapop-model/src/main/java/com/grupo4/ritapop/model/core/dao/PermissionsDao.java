package com.grupo4.ritapop.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("PermissionsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/PermissionsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class PermissionsDao extends OntimizeJdbcDaoSupport {
  public static final String ATTR_PERMISSIONS = "PERMISSIONS";
}
