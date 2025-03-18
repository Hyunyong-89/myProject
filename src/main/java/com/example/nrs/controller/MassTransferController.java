package com.example.nrs.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.nrs.dto.CustomerDto;
import com.example.nrs.dto.ProjectDto;
import com.example.nrs.dto.TradeDto;
import com.example.nrs.service.CustomerService;
import com.example.nrs.service.MassTransferService;
import com.example.nrs.service.ProjectService;
import com.example.nrs.service.TradeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MassTransferController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TradeService tradeService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private MassTransferService massTransferService;

	@RequestMapping(path = "/massTransfer/massTransferMake.do")
	public ModelAndView massTransferMake() throws Exception {
		
		ModelAndView mv = new ModelAndView("/massTransfer/massTransferMake");
		//log.debug("makeMassTransfer");
		// debug 레벨의 로그를 출력
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(path = "/massTransfer/makeMassTransfer.do")
	public HashMap<String, String> makeMassTransfer(@RequestBody HashMap<String, Object> map) throws Exception {
		//log.debug("makeMassTransfer");
		// debug 레벨의 로그를 출력
		String year  = (String) map.get("year");
		String month = String.format("%2s", map.get("month")).replace(" ", "0");
		//log.debug(year +" "+month);
		massTransferService.massTransferExcelDownload(year,month);
		
		HashMap<String, String> resultMap = new HashMap<>();
		
		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "/massTransfer/massTransferMake");
		//log.debug(resultMap.toString());
		return resultMap;
	}

}
