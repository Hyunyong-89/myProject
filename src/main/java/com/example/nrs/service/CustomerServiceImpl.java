package com.example.nrs.service;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nrs.config.Constants;
import com.example.nrs.dto.CustomerDto;
import com.example.nrs.mapper.CustomerMapper;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	// 데이터베이스에 접근하는 DAO빈을 선언
	
	@Override
	public List<CustomerDto> selectCustomerList() throws Exception {
		return customerMapper.selectCustomerList();
	}

	@Override
	public HashMap<String, Object> insertCustomer(HashMap<String, Object> customerMap) throws Exception {
		
		CustomerDto customerDto = new CustomerDto();
		
		String section = "";
		
		switch(customerMap.get("section").toString()) {
			case "1": 	section = Constants.COM_CORPORATE_NAME; break;
			case "2": 	section = Constants.COM_INDIVIDUAL_NAME; break;
			case "3": 	section = Constants.COM_WITH_HOLODING_NAME; break;
			default: 	section = Constants.COM_SECTION_ERROR; break;
		}
		
		String phone = customerMap.get("phone1").toString() + customerMap.get("phone2").toString() + customerMap.get("phone3").toString();
		
		
		customerDto.section 	= section;
		customerDto.comName 	= (String) customerMap.get("comName");
		customerDto.name 		= (String) customerMap.get("name");
		customerDto.pno 		= (String) customerMap.get("pno");
		customerDto.phone 		= phone;
		customerDto.email 		= (String) customerMap.get("email");
		customerDto.postNo 		= (String) customerMap.get("postNo");
		customerDto.address 	= (String) customerMap.get("address");
		customerDto.bank 		= (String) customerMap.get("bank");
		customerDto.accNo 		= (String) customerMap.get("accNo");
		customerDto.calcEMail 	= (String) customerMap.get("calcEMail");
		
		customerMapper.insertCustomer(customerDto);
		
		return customerMap;
		
	}

	@Override
	public CustomerDto selectCustomerDetail(String customerNo) throws Exception {
		CustomerDto customerDto = customerMapper.selectCustomerDetail(customerNo);
		
		return customerDto;
	}

	@Override
	public void updateCustomer(CustomerDto customerDto) throws Exception {
		customerMapper.updateCustomer(customerDto);
	}

	@Override
	public void deleteCustomer(String customerNo) throws Exception {
		customerMapper.deleteCustomer(customerNo);
	}
	
	
}