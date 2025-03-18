package com.example.nrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.nrs.dto.CustomerDto;

@Mapper
public interface CustomerMapper {
	
	List<CustomerDto> selectCustomerList() throws Exception;
	
	void insertCustomer(CustomerDto customerDto) throws Exception;
	
	CustomerDto selectCustomerDetail(String customerNo) throws Exception;
	
	void updateHitCount(int customerIdx) throws Exception;
	
	void updateCustomer(CustomerDto customerDto) throws Exception;
	
	void deleteCustomer(String customerNo) throws Exception;
}