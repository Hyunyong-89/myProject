package com.example.nrs.util;

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
import org.springframework.stereotype.Component;

import com.example.nrs.config.Constants;
import com.example.nrs.dto.TaxBillDto;
import com.example.nrs.mapper.TaxBillMapper;

public abstract class ExcelFile {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	Workbook wb = new XSSFWorkbook();
	
	Sheet sheet = wb.createSheet(Constants.TAX_BILL_SHEET_NAME);
	int rowNum = 0;
	
	public void taxBillExcelDownload(List<TaxBillDto> taxBillList, String date, String prjName) throws Exception {
			
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet(Constants.TAX_BILL_SHEET_NAME);
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
