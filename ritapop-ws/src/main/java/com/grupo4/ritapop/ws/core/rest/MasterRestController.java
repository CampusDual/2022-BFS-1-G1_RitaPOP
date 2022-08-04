package com.grupo4.ritapop.ws.core.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo4.ritapop.api.core.service.IMasterService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/master")
public class MasterRestController extends ORestController<IMasterService> {
    @Autowired
    private IMasterService masterService;

    @Override
    public IMasterService getService() {
        return this.masterService;
    }
}