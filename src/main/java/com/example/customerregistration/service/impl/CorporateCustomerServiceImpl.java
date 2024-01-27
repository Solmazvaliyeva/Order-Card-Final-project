package com.example.customerregistration.service.impl;

import com.example.customerregistration.dao.corporate.CorporateAddressEntity;
import com.example.customerregistration.dao.corporate.CorporateContactEntity;
import com.example.customerregistration.dao.corporate.CorporateCustomerEntity;
import com.example.customerregistration.repository.corporate.CorporateAddressRepository;
import com.example.customerregistration.repository.corporate.CorporateContactRepository;
import com.example.customerregistration.repository.corporate.CorporateRepository;
import com.example.customerregistration.exception.NoCustomerFoundException;
import com.example.customerregistration.mapper.CustomerMapper;
import com.example.customerregistration.model.corporate.CorporateContactDto;
import com.example.customerregistration.model.corporate.CorporateCustomerDto;
import com.example.customerregistration.service.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CorporateRepository customerRepository;
    private final CorporateAddressRepository addressRepository;

    private final CorporateContactRepository contactRepository;

    @Override
    public CorporateCustomerDto findById(Integer customerId) {

        CorporateCustomerEntity customerEntity =
                customerRepository.findById(customerId).orElseThrow(()-> new NoCustomerFoundException(" corporate customer not found"));

        CorporateCustomerDto customerDto = CustomerMapper.INSTANCE.corporateCustomerEntityToDto(customerEntity);

        customerDto
                .setAddressDto(CustomerMapper
                        .INSTANCE.corporateAddressEntityToDto(customerEntity.getCorporateAddressEntity()));

        List<CorporateContactDto> contactDtoList = customerEntity.getContactsEntity().stream().map(it->
                CustomerMapper.INSTANCE.corporateContactEntityToDto(it)).collect(Collectors.toList());

        customerDto.setContactsDtoList(contactDtoList);
        return customerDto;
    }

    @Override
    public List<CorporateCustomerDto> findAll() {
        List<CorporateCustomerEntity> customerEntityList = customerRepository.findAll();
        List<CorporateCustomerDto> customerDtoList =
                customerEntityList.stream()
                        .map(it-> CustomerMapper.INSTANCE.corporateCustomerEntityToDto(it))
                        .collect(Collectors.toList());

        System.out.println(customerDtoList);
        return customerDtoList;
    }

    @Override
    public Integer saveCustomer(CorporateCustomerDto customersDt) {

        CorporateCustomerEntity corporateCustomerEntity =
                CustomerMapper.INSTANCE.corporateCustomerDtoToEntity(customersDt);

        Integer  customerId = customerRepository.save(corporateCustomerEntity).getId();

        customersDt.getAddressDto().setCustomerDto(customersDt);
        customersDt.getAddressDto().getCustomerDto().setId(customerId);

        CorporateAddressEntity corporateAddress =
                CustomerMapper.INSTANCE.corporateAddressDtoToEntity(customersDt.getAddressDto());


        customersDt.getContactsDtoList().stream().forEach(it->it.setCustomerDto(customersDt));
        customersDt.getContactsDtoList().stream().forEach(it->it.getCustomerDto().setId(customerId));

        List<CorporateContactEntity> contactEntities =  customersDt.getContactsDtoList().
                stream().map(it->CustomerMapper.INSTANCE.corporateContactDtoToEntity(it)).collect(Collectors.toList());

       addressRepository.save(corporateAddress);

        contactRepository.saveAll(contactEntities);
        return customerId;
    }

    @Override
    public void updateCustomer(Integer customerId, CorporateCustomerDto customersDto) {
        CorporateCustomerEntity customerEntity =
                customerRepository.findById(customerId)
                        .orElseThrow(()->new NoCustomerFoundException("Corporate Customer Not Found"));
        customersDto.setId(customerId);

        CorporateAddressEntity addressEntity =
                CustomerMapper.INSTANCE.corporateAddressDtoToEntity(customersDto.getAddressDto());
        Integer addressId = addressRepository.getCorporateAddressEntitiesBy(customerId).getId();
        addressEntity.setAddressEntity(customerEntity);
        addressEntity.setId(addressId);



        List<CorporateContactEntity> contactEntityList =
                customersDto.getContactsDtoList().stream().map(it->
                CustomerMapper.INSTANCE.corporateContactDtoToEntity(it)).collect(Collectors.toList());


        contactEntityList.stream().forEach(it-> it.setCustomer(customerEntity));

        customerRepository.save(CustomerMapper.INSTANCE.corporateCustomerDtoToEntity(customersDto));
        addressRepository.save(addressEntity);
        contactRepository.saveAll(contactEntityList);

    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository
                .delete(customerRepository.findById(id).orElseThrow(()-> new NoCustomerFoundException("corporate customer not found")));
    }

    @Override
    public Integer getTinNumber(Integer customerId) {
        return customerRepository.getCustomerTinNumber(customerId);
    }
}
