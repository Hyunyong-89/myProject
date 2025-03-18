package com.example.nrs.service;

import java.util.HashMap;
import java.util.List;

import com.example.nrs.dto.TradeDto;

public interface TradeService {
	List<TradeDto> selectTradeList() throws Exception;
	HashMap<String, Object> insertTrade(HashMap<String, Object> tradeMap) throws Exception;
	TradeDto selectTradeDetail(int tradeIdx) throws Exception;
	void updateTrade(HashMap<String, Object> param) throws Exception;
	List<TradeDto> selectTradeListByPrjCd(String prjCd) throws Exception;
	List<TradeDto> selectTradeListByPrjCdAndCust(HashMap<String, Object> param) throws Exception;
	List<TradeDto> selectProjectTradeNo(String prjCd) throws Exception;
} 