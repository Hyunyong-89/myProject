package com.example.nrs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.nrs.dto.TaxBillDto;
import com.example.nrs.service.CustomerService;
import com.example.nrs.service.ProjectService;
import com.example.nrs.service.TaxBillService;
import com.example.nrs.service.TradeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TaxBillController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TaxBillService taxBillService;
	
	@RequestMapping(path = "/taxBill/openTaxBillList.do")
	public ModelAndView openTaxBillList() throws Exception {
		log.debug("openTaxBillList");
		// debug 레벨의 로그를 출력

		ModelAndView mv = new ModelAndView("/taxBill/taxBillList");

		List<TaxBillDto> list = taxBillService.selectTaxBillList();
		mv.addObject("list", list);
		mv.addObject("resultType", "0000");
		mv.addObject("returnUrl", "/taxBill/openTaxBillList");
		// 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장, 뷰에서 list라는 이름으로 조회결과를 사용가능

		log.debug(list.toString());
		return mv;
	}

}
