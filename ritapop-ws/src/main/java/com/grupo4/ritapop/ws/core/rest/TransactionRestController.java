package com.grupo4.ritapop.ws.core.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.ritapop.api.core.service.ITransactionService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/transactions")
public class TransactionRestController extends ORestController<ITransactionService> {

 @Autowired
 private ITransactionService transactionService;

 @Override
 public ITransactionService getService() {
  return this.transactionService;
 }
}
