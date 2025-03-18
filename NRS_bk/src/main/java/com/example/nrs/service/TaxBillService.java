package com.example.nrs.service;

import java.util.HashMap;
import java.util.List;

import com.example.nrs.dto.TaxBillDto;

public interface TaxBillService {
	List<TaxBillDto> selectTaxBillList() throws Exception;
	HashMap<String, Object> insertTaxBill(HashMap<String, Object> taxBillMap) throws Exception;
	TaxBillDto selectTaxBillDetail(int taxBillIdx) throws Exception;
} 