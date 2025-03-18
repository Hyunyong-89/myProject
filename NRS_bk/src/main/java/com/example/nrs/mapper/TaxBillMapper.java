package com.example.nrs.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.nrs.dto.TaxBillDto;

@Mapper
public interface TaxBillMapper {
	
	List<TaxBillDto> selectTaxBillList() throws Exception;
	
	void insertTaxBill(TaxBillDto taxBillDto) throws Exception;
	
	List<TaxBillDto> selectTaxBillListByPrjCdTaxBillDate(HashMap<String, String> map) throws Exception;
	
	List<String> selectTaxBillLGroupDate(String prjCd)throws Exception;
}