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
import com.example.nrs.service.ProjectService;
import com.example.nrs.service.TradeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TradeController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TradeService tradeService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/trade/openTradeList.do")
	public ModelAndView openTradeList() throws Exception {
		log.debug("openTradeList");
		// debug 레벨의 로그를 출력

		ModelAndView mv = new ModelAndView("trade/tradeList");
		// 호출된 요청의 결과를 보여줄 뷰를 위와 같이 /trade/tradeList로 지정한다. -> templates폴더 아래에 있는
		// trade/tradeList.html을 의미

		List<TradeDto> list = tradeService.selectTradeList();
		mv.addObject("list", list);
		mv.addObject("resultType", "0000");
		mv.addObject("returnUrl", "/trade/openTradeList");
		// 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장, 뷰에서 list라는 이름으로 조회결과를 사용가능

		log.debug(list.toString());
		return mv;
	}

	@RequestMapping(path = "/trade/openTradeCustomerList.do")
	public ModelAndView openTradeCustomerList() throws Exception {
		//log.debug("openCustomerList");
		// debug 레벨의 로그를 출력

		ModelAndView mv = new ModelAndView("trade/tradeCustomerList");
		// 호출된 요청의 결과를 보여줄 뷰를 위와 같이 /customer/customerList로 지정한다. -> templates폴더 아래에 있는
		// customer/customerList.html을 의미

		List<CustomerDto> list = customerService.selectCustomerList();
		mv.addObject("list", list);
		mv.addObject("resultType", "0000");
		mv.addObject("returnUrl", "/trade/tradeCustomerList");
		// 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장, 뷰에서 list라는 이름으로 조회결과를 사용가능

		log.debug(list.toString());
		return mv;
	}

	
	@RequestMapping(path = "/trade/openTradeRegister.do") 
	public String openTradeRegister(HttpServletRequest request) throws Exception{ 
		return "trade/TradeRegister"; 
	}
	
	@ResponseBody
	@RequestMapping(path = "/trade/insertTrade.do")
	public HashMap<String, Object> insertTrade(@RequestBody HashMap<String, Object> map) throws Exception {

		log.debug("insertTrade IN");
		log.debug(map.toString());

		HashMap<String, Object> resultMap = tradeService.insertTrade(map);

		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "/trade/openTradeList.do");

		return resultMap;
		// 게시물이 등록된 후 보여줘야하니까 /trade/tradeList가 아닌 위의 주소로 가줘야함.
	}

	@RequestMapping(path = "/trade/openTradeDetail.do")
	public ModelAndView openTradeDetail(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/trade/tradeDetail");
//
//		log.debug(request.getParameter("prjCd"));
//		log.debug(request.getParameter("customerNo"));
//		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("prjCd", request.getParameter("prjCd"));
//		map.put("customerNo", request.getParameter("customerNo"));
//		map.put("stCd", "0");
//		//TODO list 간소화
//		List<TradeDto> list = tradeService.selectTradeListByPrjCdAndCust(map);
//		
//		mv.addObject("list", list);
//		mv.addObject("prjCd", request.getParameter("prjCd"));
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(path = "/trade/selectTradeDetail.do")
	public HashMap<String, Object> selectTradeDetail(@RequestBody HashMap<String, Object> map) throws Exception {
		
		map.put("prjCd", map.get("prjCd"));
		map.put("customerNo", map.get("customerNo"));
		map.put("stCd", "0");
		//TODO list 간소화
		List<TradeDto> list = tradeService.selectTradeListByPrjCdAndCust(map);
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("resultType", "0000");
		
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(path = "trade/updateTrade.do")
	public HashMap<String, Object> updateTrade(@RequestBody HashMap<String, Object> map) throws Exception {
		tradeService.updateTrade(map);
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "/trade/openTradeList.do");
		
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(path = "/trade/openTradePrjList.do")
	// /trade/openTradeList.do 이건 클라이언트가 호출하는 주소인데 이것과 수행할 아래의 메소드를 연결시킨다.
	public ModelAndView openTradePrjList() throws Exception {
		log.debug("openTradePrj");
		// debug 레벨의 로그를 출력

		ModelAndView mv = new ModelAndView("trade/tradePrjList");
		// 호출된 요청의 결과를 보여줄 뷰를 위와 같이 /trade/tradeList로 지정한다. -> templates폴더 아래에 있는
		// trade/tradeList.html을 의미

		List<ProjectDto> list = projectService.selectProjectByStat("0");
		mv.addObject("list", list);
		mv.addObject("resultType", "0000");
		mv.addObject("returnUrl", "/trade/openTradeRegister.do");
		// 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장, 뷰에서 list라는 이름으로 조회결과를 사용가능

		log.debug(list.toString());
		return mv;
	}
	

	@ResponseBody
	@RequestMapping(path = "/trade/selectPrjCdTrade.do")
	public HashMap<String, Object> selectProjectTradeNo(@RequestBody HashMap<String, Object> map) throws Exception {
		log.debug("openTradePrj");
		log.debug(map.toString());
		log.debug(map.get("prjCd").toString());
		// debug 레벨의 로그를 출력

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		//TODO list 간소화
		List<TradeDto> list1 = tradeService.selectTradeListByPrjCd(map.get("prjCd").toString());
		List<TradeDto> list2 = tradeService.selectProjectTradeNo(map.get("prjCd").toString());
		resultMap.put("tradeList", list1);
		resultMap.put("custList", list2);
		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "");

		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(path = "/trade/selectPrjCdAndCustTrade.do")
	public HashMap<String, Object> selectPrjCdAndCustTrade(@RequestBody HashMap<String, Object> map) throws Exception {
		log.debug("selectPrjCdAndCustTrade");
		log.debug(map.toString());
		log.debug(map.get("prjCd").toString());
		log.debug("Done");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		//TODO list 간소화
		List<TradeDto> list = tradeService.selectTradeListByPrjCdAndCust(map);
		resultMap.put("tradeList", list);
		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "");

		return resultMap;
	}
}
