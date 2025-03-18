package com.example.nrs.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nrs.config.Constants;
import com.example.nrs.dto.CustomerDto;
import com.example.nrs.dto.TaxBillDto;
import com.example.nrs.dto.TradeDto;
import com.example.nrs.mapper.CustomerMapper;
import com.example.nrs.mapper.TaxBillMapper;
import com.example.nrs.mapper.TradeMapper;
import com.example.nrs.util.DateUtils;
import com.example.nrs.util.ExcelFile;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class TradeServiceImpl implements TradeService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TradeMapper tradeMapper;
	
	@Autowired
	private TaxBillMapper taxBillMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	private ExcelFile excelFile;
	
	private DateUtils dateUtils;
	
	@Override
	public List<TradeDto> selectTradeList() throws Exception {
		return tradeMapper.selectTradeList();
	}
	
	/*
	 * 프로젝트 등록 메서드
	 * 
	 * @param tradeMap
	 * @return tradeMap
	 * 
	 * */
	@SuppressWarnings("static-access")
	@Override
	public HashMap<String, Object> insertTrade(HashMap<String, Object> tradeMap) throws Exception {
		//log.debug("insertTrade");
		//log.debug(tradeMap.toString());
		
		TradeDto tradeDto = new TradeDto();
		
		int listCnt = (Integer) tradeMap.get("listCnt");
		
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		list = (ArrayList<HashMap<String, String>>) tradeMap.get("list");
		
		HashMap<String,String> map = new HashMap<String,String>();
		//log.debug("before");
		for(int i=0;i<listCnt;i++) {
			map = list.get(i);
			tradeDto = new TradeDto();
			tradeDto.prjCd 		= (String) tradeMap.get("prjCd");
			tradeDto.prjName 	= (String) tradeMap.get("prjName");
			tradeDto.purCom 	= map.get("purCom");
			tradeDto.customerNo = map.get("customerNo");
			tradeDto.name 		= map.get("name");
			tradeDto.performCom = (String) tradeMap.get("performCom");
			tradeDto.stYear 	= map.get("stYear");
			tradeDto.stMonth	= map.get("stMonth");
			tradeDto.stDay 		= map.get("stDay");
			tradeDto.endYear 	= map.get("endYear");
			tradeDto.endMonth	= map.get("endMonth");
			tradeDto.endDay 	= map.get("endDay");
			tradeDto.am 		= map.get("am");
			tradeDto.bank 		= map.get("bank");
			tradeDto.accNo 		= map.get("accNo");
			tradeDto.valChk 	= (String) tradeMap.get("valChk");
			tradeDto.ex 		= (String) tradeMap.get("ex");
			tradeDto.stCd 		= "0";
			
			tradeMapper.insertTrade(tradeDto);
			
			CustomerDto customerDto = customerMapper.selectCustomerDetail(map.get("customerNo"));
			
			//법인일 경우만 세금계산서
			if(customerDto.section.equals(Constants.COM_CORPORATE_NAME)) {
				int taxAm = Integer.parseInt(map.get("am"))/10;
				
				//세금계산서 작성 TODO 데이터 확인 필요
				//프로젝트별로 세금계산서 생성, 파일명 법인명
				//하드코딩 부분 DB 적재하여 사용 TODO
				TaxBillDto taxBillDto   = new TaxBillDto();
				taxBillDto.prjCd 		= (String) tradeMap.get("prjCd");
				taxBillDto.taxBillDate	= map.get("stYear")+map.get("stMonth");
				taxBillDto.billType 	= "01";
				taxBillDto.writeDate 	= map.get("stYear")+map.get("stMonth")+map.get("endDay"); //말일(5,10,15,20)
				taxBillDto.supNo 		= "1138684561";
				taxBillDto.supKindNo 	= "";
				taxBillDto.supComName 	= map.get("purCom");
				taxBillDto.supName		= "오창선";
				taxBillDto.supAddr 		= "서울특별시 강서구 양천로 532, 502호,503호(등촌동,더리브아너비즈타워)";
				taxBillDto.supBusin 	= "서비스";
				taxBillDto.supKind 		= "소프트웨어자문개발및공급";
				taxBillDto.supEMail 	= "tax@nanumsol.com";
				taxBillDto.supiedNo 	= map.get("customerNo");
				taxBillDto.supiedKindNo = "";
				taxBillDto.supiedComName = customerDto.comName;
				taxBillDto.supiedName 	= map.get("name");
				taxBillDto.supiedAddr 	= customerDto.address;
				taxBillDto.supiedBusin 	= "서비스";
				taxBillDto.supiedKind 	= "소프트웨어개발,소프트웨어자문";
				taxBillDto.supiedEMail1 = customerDto.calcEMail;
				taxBillDto.supiedEMail2 = "";
				taxBillDto.supVal 		= map.get("am");
				taxBillDto.taxAm 		= Integer.toString(taxAm);
				taxBillDto.note 		= "";
				taxBillDto.day1 		= map.get("stDay");
				taxBillDto.item1 		= (String) tradeMap.get("prjName")+"-("+map.get("name")+")-"+map.get("stMonth")+"월 용역비";
				taxBillDto.standard1 	= "";
				taxBillDto.vol1 		= Integer.parseInt(map.get("am"));
				taxBillDto.cost1 		= taxAm;
				taxBillDto.supVal1 		= "";
				taxBillDto.taxAm1 		= "";
				taxBillDto.itemNote1 	= "";
				taxBillDto.cash 		= "";
				taxBillDto.cheque 		= "";
				taxBillDto.draft 		= "";
				taxBillDto.unpaidCrd 	= "";
				taxBillDto.receiClam 	= "02";
				taxBillDto.stCd 		= "0";
				
				taxBillMapper.insertTaxBill(taxBillDto);
			}
		}
		try {
			
			/* 세금계산서 파일 생성 */
			List<String> dateList = taxBillMapper.selectTaxBillLGroupDate((String) tradeMap.get("prjCd"));
			int dateCnt = dateList.size();
			
			for(int i=0;i<dateCnt;i++) {
				String date = dateList.get(i);
				HashMap<String, String> dataMap = new HashMap<>();
				dataMap.put("prjCd", (String) tradeMap.get("prjCd"));
				dataMap.put("taxBillDate", dateList.get(i));
				List<TaxBillDto> taxBillList = taxBillMapper.selectTaxBillListByPrjCdTaxBillDate(dataMap);
				//excelFile.taxBillExcelDownload(taxBillList, date, (String) tradeMap.get("prjName"));
				
				taxBillExcelDownload(taxBillList, date, (String) tradeMap.get("prjName"));
			}
			
		}catch(Exception e) {
			log.debug(e.toString());
			throw e;
		}finally {
			
		}

		
		tradeMap.put("resultType", "0000");
		tradeMap.put("returnUrl", "/trade/openTradeList.do");
		
		////log.debug("debug: insertTrade success");
		return tradeMap;
		
	}

	@Override
	public TradeDto selectTradeDetail(int tradeIdx) throws Exception {
		TradeDto tradeDto = tradeMapper.selectTradeDetail(tradeIdx);
		
		// 선택된 게시물보여주기와 선택된 게시물의 조회수 올려주기 이렇게 두 가지 기능을 수행하기 위함
		tradeMapper.updateHitCount(tradeIdx);
		// 트랜젝션 성능검사 고의 오류
		//int i = 10 / 0;
		return tradeDto;
	}

	@Override
	public void updateTrade(HashMap<String, Object> param) throws Exception {
		
		////log.debug(param.toString());
		//update
		List<HashMap<String, String>> modiList = (List<HashMap<String, String>>) param.get("modiList");
		
		for(int i=0;i<modiList.size();i++) {
			HashMap<String, String> modiMap = modiList.get(i);
			if(modiMap.get("mode").equals("modi")) {
				TradeDto tradeDto = new TradeDto();
				tradeDto.tradeNo 	= Integer.parseInt(modiMap.get("tradeNo"));
				tradeDto.prjCd 		= modiMap.get("prjCd");
				tradeDto.prjName	= modiMap.get("prjName");
				tradeDto.purCom 	= modiMap.get("purCom");
				tradeDto.customerNo = modiMap.get("customerNo");
				tradeDto.name 		= modiMap.get("name");
				tradeDto.stYear 	= modiMap.get("stYear");
				tradeDto.stMonth 	= modiMap.get("stMonth");
				tradeDto.stDay 		= modiMap.get("stDay");
				tradeDto.endYear 	= modiMap.get("endYear");
				tradeDto.endMonth 	= modiMap.get("endMonth");
				tradeDto.endDay 	= modiMap.get("endDay");
				tradeDto.am 		= modiMap.get("am");
				tradeDto.bank 		= modiMap.get("bank");
				tradeDto.accNo 		= modiMap.get("accNo");
				
				tradeMapper.updateTrade(tradeDto);
			}
		}
		
		//log.debug(modiList.toString());
		//delete
		List<HashMap<String, String>> delList = (List<HashMap<String, String>>) param.get("delList");
		
		for(int i=0;i<delList.size();i++) {
			HashMap<String, String> delMap = delList.get(i);
			if(delMap.get("mode").equals("del")) {
				TradeDto tradeDto = new TradeDto();
				tradeDto.tradeNo = Integer.parseInt(delMap.get("tradeNo"));
				tradeDto.stCd 	 = "1";
				
				tradeMapper.deleteTrade(tradeDto);
			}
		}
		
		//log.debug(delList.toString());
	}


	@Override
	public List<TradeDto> selectProjectTradeNo(String prjCd) throws Exception {
		return tradeMapper.selectProjectTradeNo(prjCd);
	}


	@Override
	public List<TradeDto> selectTradeListByPrjCd(String prjCd) throws Exception {
		return tradeMapper.selectTradeListByPrjCd(prjCd);
	}


	@Override
	public List<TradeDto> selectTradeListByPrjCdAndCust(HashMap<String, Object> param) throws Exception {
		return tradeMapper.selectTradeListByPrjCdAndCust(param);
	}
	
	//TODO 아래 엑셀 메서드 유틸 클래스로 빼기
	public void taxBillExcelDownload(List<TaxBillDto> taxBillList, String date, String prjName) throws Exception {
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet(Constants.TAX_BILL_SHEET_NAME);
		//TODO 엑셀 텍스트 줄 바꿈
		//CellStyle cellStyle = wb.createCellStyle(); 
		int rowNum = 0;
		Row row = null;
		Cell cell = null;
		FileOutputStream fos = null;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue(Constants.TAX_BILL_ROW_1);
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue(Constants.TAX_BILL_ROW_2);      
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue(Constants.TAX_BILL_ROW_3);
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue(Constants.TAX_BILL_ROW_4);
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue(Constants.TAX_BILL_ROW_5);
		
		row = sheet.createRow(rowNum++);
		
		//데이터 헤더부
		for(int k=0; k<60;k++) {
			createRow6Head(k,row);
		}
		
		// Body
		//세금계산서 조회
		//log.debug(dateList.get(i));
		List<TaxBillDto> list = taxBillList;
		//log.debug(list.toString());
		int cnt = list.size();
		
		for (int j=0; j<cnt; j++) {
			//log.debug(list.get(j).toString());
			
			TaxBillDto taxBillDto = list.get(j);
			
			row = sheet.createRow(rowNum++); 
			cell = row.createCell(0);
			cell.setCellValue(taxBillDto.billType); 
			cell = row.createCell(1); 
			cell.setCellValue(taxBillDto.writeDate);
			cell = row.createCell(2); 
			cell.setCellValue(taxBillDto.supNo);
			cell = row.createCell(3);
			cell.setCellValue(taxBillDto.supKindNo    );
			cell = row.createCell(4);                 
			cell.setCellValue(taxBillDto.supComName   );
			cell = row.createCell(5);                 
			cell.setCellValue(taxBillDto.supName      );
			cell = row.createCell(6);                 
			cell.setCellValue(taxBillDto.supAddr      );
			cell = row.createCell(7);                 
			cell.setCellValue(taxBillDto.supBusin     );
			cell = row.createCell(8);                 
			cell.setCellValue(taxBillDto.supKind      );
			cell = row.createCell(9);                 
			cell.setCellValue(taxBillDto.supEMail     );
			cell = row.createCell(10);                
			cell.setCellValue(taxBillDto.supiedNo     );
			cell = row.createCell(11);                
			cell.setCellValue(taxBillDto.supiedKindNo );
			cell = row.createCell(12);                
			cell.setCellValue(taxBillDto.supiedComName);
			cell = row.createCell(13);                
			cell.setCellValue(taxBillDto.supiedName   );
			cell = row.createCell(14);                
			cell.setCellValue(taxBillDto.supiedAddr   );
			cell = row.createCell(15);                
			cell.setCellValue(taxBillDto.supiedBusin  );
			cell = row.createCell(16);                
			cell.setCellValue(taxBillDto.supiedKind   );
			cell = row.createCell(17);                
			cell.setCellValue(taxBillDto.supiedEMail1 );
			cell = row.createCell(18);                
			cell.setCellValue(taxBillDto.supiedEMail2); 
			cell = row.createCell(19);                 
			cell.setCellValue(taxBillDto.supVal      ); 
			cell = row.createCell(20);                 
			cell.setCellValue(taxBillDto.taxAm       ); 
			cell = row.createCell(21);                 
			cell.setCellValue(taxBillDto.note        ); 
			cell = row.createCell(22);                 
			cell.setCellValue(taxBillDto.day1        ); 
			cell = row.createCell(23);                 
			cell.setCellValue(taxBillDto.item1       ); 
			cell = row.createCell(24);                 
			cell.setCellValue(taxBillDto.standard1   ); 
			cell = row.createCell(25);                 
			cell.setCellValue(taxBillDto.vol1        ); 
			cell = row.createCell(26);                 
			cell.setCellValue(taxBillDto.cost1       ); 
			cell = row.createCell(27);                 
			cell.setCellValue(taxBillDto.supVal1     ); 
			cell = row.createCell(28);                 
			cell.setCellValue(taxBillDto.taxAm1      ); 
			cell = row.createCell(29);                 
			cell.setCellValue(taxBillDto.itemNote1   ); 
			cell = row.createCell(30);                 
			cell = row.createCell(31);                 
			cell = row.createCell(32);                 
			cell = row.createCell(33);                 
			cell = row.createCell(34);                 
			cell = row.createCell(35);                
			cell = row.createCell(36);
			cell = row.createCell(37);
			cell = row.createCell(38);
			cell = row.createCell(39);
			cell = row.createCell(40);
			cell = row.createCell(41);
			cell = row.createCell(42);
			cell = row.createCell(43);
			cell = row.createCell(44);
			cell = row.createCell(45);
			cell = row.createCell(46);
			cell = row.createCell(47);
			cell = row.createCell(48);
			cell = row.createCell(49);
			cell = row.createCell(50);
			cell = row.createCell(51);
			cell = row.createCell(52);
			cell = row.createCell(53);
			cell = row.createCell(54);
			cell.setCellValue(taxBillDto.cash); 
			cell = row.createCell(55);
			cell.setCellValue(taxBillDto.cheque);
			cell = row.createCell(56);
			cell.setCellValue(taxBillDto.draft);
			cell = row.createCell(57);
			cell.setCellValue(taxBillDto.unpaidCrd); 
			cell = row.createCell(58);
			cell.setCellValue(taxBillDto.receiClam);
			
		}
		
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		//log.debug("■■■■■■■■■■■■■■■■■■■■■■ dateList.get(i):" + dateList.get(i) + " year: " + year +" month: "+month);
		String fileName = date+"01_세금계산서등록양식("+prjName+"_"+year+"년"+month+"월분).xlsx";
		//log.debug(fileName);
		String path = "C:\\javadown/";
		fos = null;
		fos = new FileOutputStream(path+fileName); // file 생성
		wb.write(fos); // excel 저장
		if (fos != null) {
			fos.close(); // file resource 반환
		}
		if (wb != null) {
			wb.close(); // excel resource 반환
		}
			
	}
	
	
	public void createRow6Head(int i, Row row) {
		Cell cell = null;
		String headTxt = "";
		cell = row.createCell(i);
		
		switch(i) {
			case 	0: headTxt = Constants.TAX_BILL_ROW_6_CELL_1;break;
			case 	1: headTxt = Constants.TAX_BILL_ROW_6_CELL_2;break;
			case	2 : headTxt = Constants.TAX_BILL_ROW_6_CELL_3;break; 
			case	3 : headTxt = Constants.TAX_BILL_ROW_6_CELL_4;break; 
			case	4 : headTxt = Constants.TAX_BILL_ROW_6_CELL_5;break; 
			case	5 : headTxt = Constants.TAX_BILL_ROW_6_CELL_6;break; 
			case	6 : headTxt = Constants.TAX_BILL_ROW_6_CELL_7;break; 
			case	7 : headTxt = Constants.TAX_BILL_ROW_6_CELL_8;break; 
			case	8 : headTxt = Constants.TAX_BILL_ROW_6_CELL_9;break; 
			case	9 : headTxt = Constants.TAX_BILL_ROW_6_CELL_10;break;
			case	10: headTxt = Constants.TAX_BILL_ROW_6_CELL_11;break;
			case	11: headTxt = Constants.TAX_BILL_ROW_6_CELL_12;break;
			case	12: headTxt = Constants.TAX_BILL_ROW_6_CELL_13;break;
			case	13: headTxt = Constants.TAX_BILL_ROW_6_CELL_14;break;
			case	14: headTxt = Constants.TAX_BILL_ROW_6_CELL_15;break;
			case	15: headTxt = Constants.TAX_BILL_ROW_6_CELL_16;break;
			case	16: headTxt = Constants.TAX_BILL_ROW_6_CELL_17;break;
			case	17: headTxt = Constants.TAX_BILL_ROW_6_CELL_18;break;
			case	18: headTxt = Constants.TAX_BILL_ROW_6_CELL_19;break;
			case	19: headTxt = Constants.TAX_BILL_ROW_6_CELL_20;break;
			case	20: headTxt = Constants.TAX_BILL_ROW_6_CELL_21;break;
			case	21: headTxt = Constants.TAX_BILL_ROW_6_CELL_22;break;
			case	22: headTxt = Constants.TAX_BILL_ROW_6_CELL_23;break;
			case	23: headTxt = Constants.TAX_BILL_ROW_6_CELL_24;break;
			case	24: headTxt = Constants.TAX_BILL_ROW_6_CELL_25;break;
			case	25: headTxt = Constants.TAX_BILL_ROW_6_CELL_26;break;
			case	26: headTxt = Constants.TAX_BILL_ROW_6_CELL_27;break;
			case	27: headTxt = Constants.TAX_BILL_ROW_6_CELL_28;break;
			case	28: headTxt = Constants.TAX_BILL_ROW_6_CELL_29;break;
			case	29: headTxt = Constants.TAX_BILL_ROW_6_CELL_30;break;
			case	30: headTxt = Constants.TAX_BILL_ROW_6_CELL_31;break;
			case	31: headTxt = Constants.TAX_BILL_ROW_6_CELL_32;break;
			case	32: headTxt = Constants.TAX_BILL_ROW_6_CELL_33;break;
			case	33: headTxt = Constants.TAX_BILL_ROW_6_CELL_34;break;
			case	34: headTxt = Constants.TAX_BILL_ROW_6_CELL_35;break;
			case	35: headTxt = Constants.TAX_BILL_ROW_6_CELL_36;break;
			case	36: headTxt = Constants.TAX_BILL_ROW_6_CELL_37;break;
			case	37: headTxt = Constants.TAX_BILL_ROW_6_CELL_38;break;
			case	38: headTxt = Constants.TAX_BILL_ROW_6_CELL_39;break;
			case	39: headTxt = Constants.TAX_BILL_ROW_6_CELL_40;break;
			case	40: headTxt = Constants.TAX_BILL_ROW_6_CELL_41;break;
			case	41: headTxt = Constants.TAX_BILL_ROW_6_CELL_42;break;
			case	42: headTxt = Constants.TAX_BILL_ROW_6_CELL_43;break;
			case	43: headTxt = Constants.TAX_BILL_ROW_6_CELL_44;break;
			case	44: headTxt = Constants.TAX_BILL_ROW_6_CELL_45;break;
			case	45: headTxt = Constants.TAX_BILL_ROW_6_CELL_46;break;
			case	46: headTxt = Constants.TAX_BILL_ROW_6_CELL_47;break;
			case	47: headTxt = Constants.TAX_BILL_ROW_6_CELL_48;break;
			case	48: headTxt = Constants.TAX_BILL_ROW_6_CELL_49;break;
			case	49: headTxt = Constants.TAX_BILL_ROW_6_CELL_50;break;
			case	50: headTxt = Constants.TAX_BILL_ROW_6_CELL_51;break;
			case	51: headTxt = Constants.TAX_BILL_ROW_6_CELL_52;break;
			case	52: headTxt = Constants.TAX_BILL_ROW_6_CELL_53;break;
			case	53: headTxt = Constants.TAX_BILL_ROW_6_CELL_54;break;
			case	54: headTxt = Constants.TAX_BILL_ROW_6_CELL_55;break;
			case	55: headTxt = Constants.TAX_BILL_ROW_6_CELL_56;break;
			case	56: headTxt = Constants.TAX_BILL_ROW_6_CELL_57;break;
			case	57: headTxt = Constants.TAX_BILL_ROW_6_CELL_58;break;
			case	58: headTxt = Constants.TAX_BILL_ROW_6_CELL_59;break;
			default: break;
		}
		
		cell.setCellValue(headTxt);
	}
	
}