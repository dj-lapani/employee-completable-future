package com.dj.employeecompletablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncController {
 
  private static Logger log = LoggerFactory.getLogger(AsyncController.class);
 
  @Autowired
  private AsyncService service;
 
  @RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
  public void testAsynch() throws InterruptedException, ExecutionException
  {
    Instant start = Instant.now();
    log.info("testAsynch Start");
 
    CompletableFuture<EmployeeAddress> employeeAddress = service.getEmployeeAddress();
    CompletableFuture<EmployeeName> employeeName = service.getEmployeeName();
    CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();
 
    // Wait until they are all done
    CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
     
    log.info("EmployeeAddress--> " + employeeAddress.get());
    log.info("EmployeeName--> " + employeeName.get());
    log.info("EmployeePhone--> " + employeePhone.get());
    Instant end = Instant.now();
    log.info("testAsynch taken -> {}", Duration.between(start, end));
  }
}