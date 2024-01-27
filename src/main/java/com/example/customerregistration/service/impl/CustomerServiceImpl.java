package com.example.customerregistration.service.impl;

import com.example.customerregistration.dao.individual.AddressEntity;
import com.example.customerregistration.dao.individual.ContactsEntity;
import com.example.customerregistration.dao.individual.IndividualCustomerEntity;
import com.example.customerregistration.repository.AddressRepository;
import com.example.customerregistration.repository.ContactsRepository;

import com.example.customerregistration.repository.IndividualRepository;
import com.example.customerregistration.exception.NoCustomerFoundException;
import com.example.customerregistration.mapper.CustomerMapper;
import com.example.customerregistration.model.AddressDto;
import com.example.customerregistration.model.ContactsDto;

import com.example.customerregistration.model.IndividualCustomerDto;
import com.example.customerregistration.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final IndividualRepository repository;

    private final AddressRepository addressRepository;

    private final ContactsRepository contactsRepository;

    @Override
    public IndividualCustomerDto findById(Integer customerId) {
        IndividualCustomerEntity customerEntity = repository.findById(customerId).orElseThrow(() ->
                new NoCustomerFoundException("Individual customer not found"));
        IndividualCustomerDto inCustomersDto = CustomerMapper.INSTANCE.inCustomerEntityToDto(customerEntity);
        AddressDto addressDto = CustomerMapper.INSTANCE.addressEntityToDto(customerEntity.getAddressEntity());


        List<ContactsDto> contactsDtoList = customerEntity.getContactsEntity()
                .stream()
                .map(it -> CustomerMapper.INSTANCE.contactEntityToDto(it)).collect(Collectors.toList());

        inCustomersDto.setAddressDto(addressDto);
        inCustomersDto.setContactsDtoList(contactsDtoList);

        System.out.println();

        return inCustomersDto;
    }

    @Override
    public List<IndividualCustomerDto> findAll() {
        List<IndividualCustomerEntity> customerEntityList =
                repository.findAll();

        List<IndividualCustomerDto> customerDtoList = customerEntityList.stream()
                .map(it -> CustomerMapper.INSTANCE.inCustomerEntityToDto(it)).collect(Collectors.toList());
        return customerDtoList;
    }

    @Override
    public Integer saveCustomer(IndividualCustomerDto customersDto) {

        IndividualCustomerEntity customerEntity = CustomerMapper.INSTANCE.inCustomerDtoToEntity(customersDto);
        Integer id = repository.save(customerEntity).getId();

        AddressEntity addressEntity = CustomerMapper.INSTANCE.addressDtoToEntity(customersDto.getAddressDto());

        List<ContactsDto> contactsDtoList = customersDto.getContactsDtoList();
        contactsDtoList.forEach(it -> it.setCustomerId(id));

        List<ContactsEntity> contactsEntities = contactsDtoList
                .stream()
                .map(it -> CustomerMapper.INSTANCE.contactDtoToEntity(it))
                .collect(Collectors.toList());

        addressEntity.setCustomerEntityId(id);

        addressRepository.save(addressEntity);
        contactsRepository.saveAll(contactsEntities);
        return id;

    }

    @Override
    public void updateCustomer(Integer customerId, IndividualCustomerDto customersDto) {
        List<ContactsEntity> contactsEntities = new ArrayList<>();
        IndividualCustomerEntity customerEntity = repository.findById(customerId).orElseThrow(() ->
                new NoCustomerFoundException("Individual customer not found "));
        customersDto.setId(customerId);///bunu set edirik ki gedib tezeden insert etmesin


        AddressEntity addressEntity = CustomerMapper.INSTANCE
                .addressDtoToEntity(customersDto.getAddressDto());


        customersDto.getContactsDtoList().stream().forEach(
                it -> contactsEntities.add(CustomerMapper.INSTANCE.contactDtoToEntity(it))
        );
        contactsEntities.stream().forEach(it -> it.getCustomer().setId(customerId));


        int myAddressId = addressRepository.findAddressByCustomerId(customerId).getId();


        addressEntity.setId(myAddressId);
        addressEntity.setCustomerEntityId(customerId);
        repository.save(CustomerMapper.INSTANCE
                .inCustomerDtoToEntity(customersDto));
        addressRepository.save(addressEntity);

        for (ContactsEntity contactEntity : contactsEntities
        ) {
            contactsRepository.save(contactEntity);
        }
    }

    @Override
    public void deleteCustomerById(Integer id) {
        IndividualCustomerEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new NoCustomerFoundException("Individual customer not found"));
        repository.delete(entity);

    }
}
