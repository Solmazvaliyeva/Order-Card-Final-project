package com.example.customerregistration.controller;

import com.example.customerregistration.model.corporate.CorporateCustomerDto;
import com.example.customerregistration.service.CorporateCustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporate-api")

public class CorporateCustomerController {

    private final CorporateCustomerService customerService;

    public CorporateCustomerController(CorporateCustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/feign/{customerId}")
    public CorporateCustomerDto getCorporateCustomerById(@PathVariable Integer customerId){
        return customerService.findById(customerId);
    }



    @GetMapping("/notfeign")
    public List<CorporateCustomerDto> getCorporateCustomerList(){
        return customerService.findAll();
    }

    @GetMapping("/feign/tin/{customerId}")
    public Integer returnTinNumber(@PathVariable Integer customerId){
        return customerService.getTinNumber(customerId);
    }

    @PostMapping("/notfeign")
    public Integer saveCorporateCustomer(@Valid @RequestBody CorporateCustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @PutMapping("/notfeign/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId ,@Valid @RequestBody CorporateCustomerDto customerDto ){
        customerService.updateCustomer(customerId ,customerDto);
    }

    @DeleteMapping("/notfeign/{customerId}")
    public void deleteCorporateCustomerById(@PathVariable Integer customerId){
        customerService.deleteCustomerById(customerId);
    }

}
