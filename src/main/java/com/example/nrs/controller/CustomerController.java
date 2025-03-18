package com.example.nrs.controller;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.mapping.ResultMap;
import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.nrs.dto.CustomerDto;
import com.example.nrs.service.CustomerService;

import io.swagger.annotations.ApiModelProperty;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="/customer/openCustomerList.do")
	public ModelAndView openCustomerList()throws Exception {
		
		ModelAndView mv = new ModelAndView("customer/customerList");
		//호출된 요청의 결과를 보여줄 뷰를 위와 같이 /customer/customerList로 지정한다. -> templates폴더 아래에 있는 customer/customerList.html을 의미
		
		List<CustomerDto> list = customerService.selectCustomerList();
		mv.addObject("list", list);
		mv.addObject("resultType", "0000");
		mv.addObject("returnUrl", "/customer/openCustomerList");
		// 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장, 뷰에서 list라는 이름으로 조회결과를 사용가능
		
		//log.debug(list.toString());
		return mv;
	}
	
	
	@RequestMapping(path = "/customer/openCustomerRegister.do")
	public String openCustomerRegister() throws Exception{
		return "/customer/customerRegister";
	}
	
	@ResponseBody
	@RequestMapping(path = "/customer/insertCustomer.do")
	public HashMap<String, Object> insertCustomer(@RequestBody HashMap<String, Object> map) throws Exception {
		
		log.debug("insertCustomer IN");
		log.debug(map.toString());

		HashMap<String, Object> resultMap = customerService.insertCustomer(map);
		
		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "/customer/openCustomerList.do");
		
		return resultMap;
		// 게시물이 등록된 후 보여줘야하니까 /customer/customerList가 아닌 위의 주소로 가줘야함.
	}
	
	@RequestMapping(path="/customer/openCustomerDetail.do")
	public ModelAndView openCustomerDetail(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/customer/customerDetail");
		
		CustomerDto resultMap = customerService.selectCustomerDetail(request.getParameter("customerNo"));
		
		mv.addObject("customerNo", resultMap.customerNo);
		mv.addObject("section", resultMap.section);
		mv.addObject("comName", resultMap.comName);
		mv.addObject("name", resultMap.name);
		mv.addObject("pno", resultMap.pno);
		mv.addObject("phone", resultMap.phone);
		mv.addObject("email", resultMap.email);
		mv.addObject("postNo", resultMap.postNo);
		mv.addObject("address", resultMap.address);
		mv.addObject("bank", resultMap.bank);
		mv.addObject("accNo", resultMap.accNo);
		mv.addObject("calcEMail", resultMap.calcEMail);
		
		//log.debug(mv.toString());
		
		return mv;
	}
	
	@RequestMapping(path="customer/updateCustomer.do")
	public String updateCustomer(HttpServletRequest request) throws Exception {
		
		//log.debug(request.getParameter("customerNo"));
		
		CustomerDto customerDto = new CustomerDto();
		
		customerDto.customerNo = request.getParameter("customerNo");
		customerDto.section = request.getParameter("section");
		customerDto.comName = request.getParameter("comName");
		customerDto.name = request.getParameter("name");
		customerDto.pno = request.getParameter("pno");
		customerDto.phone = request.getParameter("phone");
		customerDto.email = request.getParameter("email");
		customerDto.postNo = request.getParameter("postNo");
		customerDto.address = request.getParameter("address");
		customerDto.bank = request.getParameter("bank");
		customerDto.accNo = request.getParameter("accNo");
		customerDto.calcEMail = request.getParameter("calcEMail");
		
		log.debug(customerDto.toString());
		customerService.updateCustomer(customerDto);
		return "redirect:/customer/openCustomerList.do";
	}
	
	@RequestMapping(path = "customer/deleteCustomer.do")
	public String deleteCustomer(HttpServletRequest request) throws Exception {
		customerService.deleteCustomer(request.getParameter("customerNo"));
		return "redirect:/customer/openCustomerList.do";
	}
	
}
