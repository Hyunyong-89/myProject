package com.example.nrs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// 아래 어노테이션만으로 알아서 getter/setter메소드와 toString, hashCode, equals등의 메소드도 생성
@Data
@ApiModel(value="TradeDto : 매입매출 내용", description="매입매출 내용")
public class TradeDto {
	@ApiModelProperty(value="매입매출거래번호")
	public int tradeNo;
	
	@ApiModelProperty(value="프로젝트코드")
	public String prjCd;
	
	@ApiModelProperty(value="프로젝트명")
	public String prjName;
	
	@ApiModelProperty(value="매입처")
	public String purCom;
	
	@ApiModelProperty(value="고객번호")
	public String customerNo;
	
	@ApiModelProperty(value="고객명")
	public String name;
	
	@ApiModelProperty(value="수행사")
	public String performCom;
	
	@ApiModelProperty(value="시작년도")
	public String stYear;
	
	@ApiModelProperty(value="시작월")
	public String stMonth;
	
	@ApiModelProperty(value="시작일")
	public String stDay;
	
	@ApiModelProperty(value="종료년도")
	public String endYear;
	
	@ApiModelProperty(value="종료월")
	public String endMonth;
	
	@ApiModelProperty(value="종료일")
	public String endDay;
	
	@ApiModelProperty(value="금액")
	public String am;
	
	@ApiModelProperty(value="은행")
	public String bank;
	
	@ApiModelProperty(value="계좌번호")
	public String accNo;
	
	@ApiModelProperty(value="검증체크")
	public String valChk;
	
	@ApiModelProperty(value="비고")
	public String ex;
	
	@ApiModelProperty(value="상태코드")
	public String stCd;
    
    @Override
	public String toString() {
		return "TradeDto [tradeNo=" + tradeNo + ", prjCd=" + prjCd + ", purCom=" + purCom + ", customerNo=" + customerNo
				+ ", name=" + name + ", performCom=" + performCom + ", stYear=" + stYear + ", stMonth=" + stMonth
				+ ", stDay=" + stDay + ", endYear=" + endYear + ", endMonth=" + endMonth + ", endDay=" + endDay
				+ ", am=" + am + ", bank=" + bank + ", accNo=" + accNo + ", valChk=" + valChk + ", ex=" + ex + ", stCd="
				+ stCd + "]";
	}
	
}