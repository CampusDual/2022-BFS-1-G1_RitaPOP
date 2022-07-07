package com.grupo4.ritapop.ws.core.rest;

import com.grupo4.ritapop.api.core.service.PermissionsApi;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PermissionController extends ORestController<PermissionsApi> {

  @Autowired
  PermissionsApi permissionsApi;

  @Override
  public PermissionsApi getService() {
    return this.permissionsApi;
  }

  @RequestMapping(value = "/loadPermissions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EntityResult> loadPermissions() {
    return new ResponseEntity<>(permissionsApi.getPermissionsByUser(), HttpStatus.OK);
  }
}
