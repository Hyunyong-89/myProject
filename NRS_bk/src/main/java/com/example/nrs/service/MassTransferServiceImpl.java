package com.example.nrs.service;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
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
import com.example.nrs.dto.ProjectDto;
import com.example.nrs.dto.TradeDto;
import com.example.nrs.mapper.CustomerMapper;
import com.example.nrs.mapper.ProjectMapper;
import com.example.nrs.mapper.TradeMapper;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class MassTransferServiceImpl implements MassTransferService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TradeMapper tradeMapper;
	
	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public void massTransferExcelDownload(String year, String month) throws Exception {
		log.debug(year);
		log.debug(month);
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("입력정보");
		//TODO 엑셀 텍스트 줄 바꿈
		//CellStyle cellStyle = wb.createCellStyle(); 
		int rowNum = 0;
		Row row = null;
		Cell cell = null;
		FileOutputStream fos = null;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("*입금은행");
		cell = row.createCell(1);
		cell.setCellValue("*입금계좌");      
		cell = row.createCell(2);
		cell.setCellValue("고객관리성명");
		cell = row.createCell(3);
		cell.setCellValue("*입금액");
		cell = row.createCell(4);
		cell.setCellValue("출금통장표시내용");
		cell = row.createCell(5);
		cell.setCellValue("입금통장표시내용");
		cell = row.createCell(6);
		cell.setCellValue("입금인코드");
		cell = row.createCell(7);
		cell.setCellValue("비고");
		cell = row.createCell(8);
		cell.setCellValue("업체사용key");
		
		// Body
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("stYear", year);
		dataMap.put("stMonth", month);
		List<TradeDto> tradeList = tradeMapper.selectTradeListByMassTransfer(dataMap);
		int tradeCnt = tradeList.size();
		
		//해당년월 매입매출
		for(int i=0;i<tradeCnt;i++) {
			TradeDto tradeDto = tradeList.get(i);
			
			//고객정보 조회
			CustomerDto customerDto = customerMapper.selectCustomerDetail(tradeDto.customerNo);
			
			//고객정보 존재
			if(customerDto != null) {
				//log.debug("CUSTDTO : " + customerDto.toString());	
				//TODO 고객 한명당 한 프로젝트에 중복없는것으로 가정
				List<TradeDto> customerTradeList = tradeMapper.selectTradeListByMassTransfer(dataMap);
				TradeDto customerTrade = customerTradeList.get(0);
				
				String note1 = "";
				String note2 = "";
			 	ProjectDto prjDto = projectMapper.selectProjectByPrjCd(customerTrade.prjCd);
				
				if(customerDto.section.equals(Constants.COM_CORPORATE_NAME)) {
					note1 = customerDto.comName;
					note2 = year+"년"+month+"월-"+prjDto.custCom+"-"+customerDto.section+"-"+customerDto.comName+"-"+customerDto.name+"-"+customerTrade.prjName; 
				}
				else if(customerDto.section.equals(Constants.COM_INDIVIDUAL_NAME)) {
					note1 = customerDto.comName+"("+customerDto.name+")";
					note2 = year+"년"+month+"월-"+prjDto.custCom+"-"+customerDto.section+"-"+customerDto.comName+"-"+customerDto.name+"-"+customerTrade.prjName;
				}
				else if(customerDto.section.equals(Constants.COM_WITH_HOLODING_NAME)) {
					note1 = customerDto.name;
					note2 = year+"년"+month+"월-"+prjDto.custCom+"-"+customerDto.section+"-"+customerDto.name+"-"+customerTrade.prjName;
				}
				
				row = sheet.createRow(rowNum++); 
				cell = row.createCell(0);
				cell.setCellValue(customerDto.bank); 
				cell = row.createCell(1); 
				cell.setCellValue(customerDto.accNo);
				cell = row.createCell(2); 
				cell = row.createCell(3);
				cell.setCellValue(customerTrade.am);
				cell = row.createCell(4);
				cell.setCellValue(note1);
				cell = row.createCell(5);
				cell = row.createCell(6);
				cell = row.createCell(7);
				cell = row.createCell(8);
				cell.setCellValue("5일");
				cell = row.createCell(9);
				cell.setCellValue(note2);
				
			}
		}
		
		try {
			String fileName = year+month+"00_나눔솔루션-대량이체.xlsx";
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
		catch (Exception e) {
			throw e;
		}finally {
			log.debug("파일생성 처리");
		}
		
	}
		
}