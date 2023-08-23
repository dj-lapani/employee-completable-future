package com.dj.employeecompletablefuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping(value = "/address")
    public EmployeeAddress getAddresses() {
        return new EmployeeAddress("address");
    }

    @GetMapping(value = "/phone")
    public EmployeePhone getPhoneNumbers() {
        return new EmployeePhone("9876543210");
    }

    @GetMapping(value = "/name")
    public EmployeeName getEmployeeName() {
        return new EmployeeName("name");
    }
}
