package com.dj.employeecompletablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
 
  private static Logger log = LoggerFactory.getLogger(AsyncService.class);
 
  @Autowired
  private RestTemplate restTemplate;
 
  @Async
  public CompletableFuture<EmployeeName> getEmployeeName() throws InterruptedException
  {
    Instant start = Instant.now();
    log.info("getEmployeeName starts");
 
    EmployeeName employeeNameData = restTemplate.getForObject("http://localhost:8080/employee/name", EmployeeName.class);
 
    log.info("employeeNameData, {}", employeeNameData);
    Thread.sleep(1000L);  //Intentional delay
    log.info("employeeNameData completed");
    Instant end = Instant.now();
    log.info("getEmployeeName taken -> {}",Duration.between(start, end));
    return CompletableFuture.completedFuture(employeeNameData);
  }
 
  @Async
  public CompletableFuture<EmployeeAddress> getEmployeeAddress() throws InterruptedException
  {
    Instant start = Instant.now();
    log.info("getEmployeeAddress starts");
 
    EmployeeAddress employeeAddressData = restTemplate.getForObject("http://localhost:8080/employee/address", EmployeeAddress.class);
 
    log.info("employeeAddressData, {}", employeeAddressData);
    Thread.sleep(1000L);  //Intentional delay
    log.info("employeeAddressData completed");
    Instant end = Instant.now();
    log.info("getEmployeeAddress taken -> {}",Duration.between(start, end));
    return CompletableFuture.completedFuture(employeeAddressData);
  }
 
  @Async
  public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException 
  {
    Instant start = Instant.now();
    log.info("getEmployeePhone starts");
 
    EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8080/employee/phone", EmployeePhone.class);
 
    log.info("employeePhoneData, {}", employeePhoneData);
    Thread.sleep(1000L);  //Intentional delay
    log.info("employeePhoneData completed");
    Instant end = Instant.now();
    log.info("getEmployeePhone taken -> {}",Duration.between(start, end));
    return CompletableFuture.completedFuture(employeePhoneData);
  }
}