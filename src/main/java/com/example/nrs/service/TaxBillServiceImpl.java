package com.example.nrs.service;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nrs.dto.TaxBillDto;
import com.example.nrs.mapper.TaxBillMapper;
import com.example.nrs.util.DateUtils;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class TaxBillServiceImpl implements TaxBillService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TaxBillMapper taxBillMapper;
	// 데이터베이스에 접근하는 DAO빈을 선언
	private DateUtils dateUtils;
	
	@Override
	public List<TaxBillDto> selectTaxBillList() throws Exception {
		return taxBillMapper.selectTaxBillList();
	}

	/*
	 * 프로젝트 등록 메서드
	 * 
	 * @param taxBillMap
	 * @return taxBillMap
	 * 
	 * */
	@SuppressWarnings("static-access")
	@Override
	public HashMap<String, Object> insertTaxBill(HashMap<String, Object> taxBillMap) throws Exception {
//		log.debug("insertTaxBill");
//		log.debug(taxBillMap.toString());
		
		TaxBillDto taxBillDto = new TaxBillDto();
		
		int listCnt = (Integer) taxBillMap.get("listCnt");
		
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		list = (ArrayList<HashMap<String, String>>) taxBillMap.get("list");
		
		HashMap<String,String> map = new HashMap<String,String>();
//		log.debug("before");
		for(int i=0;i<listCnt;i++) {
			map = list.get(i);
			taxBillMapper.insertTaxBill(taxBillDto);
		}
		
		taxBillMap.put("resultType", "0000");
		taxBillMap.put("returnUrl", "/taxBill/openTaxBillList.do");
		
//		log.debug("debug: insertTaxBill success");
		return taxBillMap;
		
	}

	@Override
	public TaxBillDto selectTaxBillDetail(int taxBillIdx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}