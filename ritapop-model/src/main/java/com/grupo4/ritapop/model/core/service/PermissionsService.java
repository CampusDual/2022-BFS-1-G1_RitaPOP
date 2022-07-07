package com.grupo4.ritapop.model.core.service;

import static com.grupo4.ritapop.model.core.dao.PermissionsDao.ATTR_PERMISSIONS;

import com.grupo4.ritapop.api.core.service.PermissionsApi;
import com.grupo4.ritapop.model.core.dao.PermissionsDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("PermissionsService")
@Lazy
public class PermissionsService implements PermissionsApi {

  public static final String PLANNER_PERMISSION = "{\"menu\": [{\"attr\": \"home\",\"visible\": false,\"enabled\": false},{\"attr\": \"client\",\"visible\": false,\"enabled\": false},{\"attr\": \"transaction\",\"visible\": true,\"enabled\": false},{\"attr\": \"logout\",\"visible\": false,\"enabled\": false}]}";

  @Autowired
  DefaultOntimizeDaoHelper daoHelper;

  @Autowired
  PermissionsDao permissionsDao;

  @Override
  public EntityResult getPermissionsByUser() {
    EntityResultMapImpl entityResultMap = new EntityResultMapImpl();
    List<String> attr = new ArrayList<String>();
    attr.add(ATTR_PERMISSIONS);
    Map<String, Object> map = new HashMap<>();
    map.put("ID", "1");
    EntityResult query = this.daoHelper.query(this.permissionsDao, map, attr);
    entityResultMap.addRecord(new HashMap<>(){{put("permission",((List) query.get(ATTR_PERMISSIONS)).get(0));}});
    return entityResultMap;
  }
}
