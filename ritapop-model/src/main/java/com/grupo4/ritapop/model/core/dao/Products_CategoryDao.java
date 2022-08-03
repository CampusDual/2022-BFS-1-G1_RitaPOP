package com.grupo4.ritapop.model.core.dao;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("Products_CategoryDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/Products_CategoryDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class Products_CategoryDao extends OntimizeJdbcDaoSupport {
    public static final String ATTR_ID = "id";
    public static final String ATTR_NAME = "name";
}
