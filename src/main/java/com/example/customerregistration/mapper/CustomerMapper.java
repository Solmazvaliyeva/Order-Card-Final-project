package com.example.customerregistration.mapper;

import com.example.customerregistration.dao.corporate.CorporateAddressEntity;
import com.example.customerregistration.dao.corporate.CorporateContactEntity;
import com.example.customerregistration.dao.corporate.CorporateCustomerEntity;
import com.example.customerregistration.dao.individual.AddressEntity;
import com.example.customerregistration.dao.individual.ContactsEntity;
import com.example.customerregistration.dao.individual.IndividualCustomerEntity;
import com.example.customerregistration.model.AddressDto;
import com.example.customerregistration.model.ContactsDto;
import com.example.customerregistration.model.IndividualCustomerDto;
import com.example.customerregistration.model.corporate.CorporateAddressDto;
import com.example.customerregistration.model.corporate.CorporateContactDto;
import com.example.customerregistration.model.corporate.CorporateCustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    IndividualCustomerDto inCustomerEntityToDto(IndividualCustomerEntity customerEntity);

    IndividualCustomerEntity inCustomerDtoToEntity(IndividualCustomerDto customerDto);


    @Mapping(target = "customerId" ,source = "customerEntityId")
    AddressDto addressEntityToDto(AddressEntity addressEntity);


//    @Mapping(target = "customerEntityId" ,source = "customerDto.id")
    AddressEntity addressDtoToEntity(AddressDto addressDto);


    @Mapping(target = "customer.id" ,source = "customerId")
    ContactsEntity contactDtoToEntity(ContactsDto contactsDto);

    @Mapping(target = "customerId" ,source = "customer.id")
    ContactsDto contactEntityToDto(ContactsEntity contactsEntity);

    CorporateCustomerDto corporateCustomerEntityToDto(CorporateCustomerEntity corporateCustomerEntity);

  CorporateCustomerEntity corporateCustomerDtoToEntity(CorporateCustomerDto corporateCustomerDto);

  @Mapping(target = "customerDto.id" ,source = "addressEntity.id")
  CorporateAddressDto corporateAddressEntityToDto(CorporateAddressEntity addressEntity);

    @Mapping(target = "addressEntity.id" ,source = "customerDto.id")
  CorporateAddressEntity corporateAddressDtoToEntity(CorporateAddressDto addressDto);


    @Mapping(target = "customer.id" ,source = "customerDto.id")
  CorporateContactEntity corporateContactDtoToEntity(CorporateContactDto contactDto);

    @Mapping(target = "customerDto.id" ,source = "customer.id")
  CorporateContactDto corporateContactEntityToDto(CorporateContactEntity contactEntity);



}
