package com.example.nrs.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.nrs.dto.TradeDto;

@Mapper
public interface TradeMapper {
	
	List<TradeDto> selectTradeList() throws Exception;
	
	void insertTrade(TradeDto tradeDto) throws Exception;
	
	TradeDto selectTradeDetail(int tradeIdx) throws Exception;
	
	void updateHitCount(int tradeIdx) throws Exception;
	
	void updateTrade(TradeDto tradeDto) throws Exception;
	
	void deleteTrade(TradeDto tradeDto) throws Exception;
	
	int selectTradeIdx(String tradeNo) throws Exception;
	
	List<TradeDto> selectTradeListByPrjCd(String prjCd) throws Exception;
	
	List<TradeDto> selectTradeListByPrjCdAndCust(HashMap<String, Object> param) throws Exception;
	
	List<TradeDto> selectProjectTradeNo(String prjCd) throws Exception;
	
	List<TradeDto> selectTradeListByMassTransfer(HashMap<String, Object> param) throws Exception;
}