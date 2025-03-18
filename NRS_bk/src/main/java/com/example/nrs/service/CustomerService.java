package com.example.nrs.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.nrs.dto.CustomerDto;

public interface CustomerService {
	List<CustomerDto> selectCustomerList() throws Exception;
	HashMap<String, Object> insertCustomer(HashMap<String, Object> customerMap) throws Exception;
	CustomerDto selectCustomerDetail(String string) throws Exception;
	void updateCustomer(CustomerDto customerDto) throws Exception;
	void deleteCustomer(String customerIdx) throws Exception;
}