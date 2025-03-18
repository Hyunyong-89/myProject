package com.example.nrs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value="ProjectDto : 프로젝트 내용", description="프로젝트 내용")
public @Data class TaxBillDto {
	
	@ApiModelProperty(value="세금계산서번호")
	public String taxBillNo;
    
	@ApiModelProperty(value="프로젝트코드") 
    public String prjCd;

	@ApiModelProperty(value="세금계산서날짜") 
    public String taxBillDate;
	
	@ApiModelProperty(value="세금계산서종류") 
    public String billType;
    
	@ApiModelProperty(value="작성일자") 
    public String writeDate;
    
	@ApiModelProperty(value="공급자등록번호") 
	public String supNo;
    
	@ApiModelProperty(value="공급자종사업번호") 
	public String supKindNo;
    
	@ApiModelProperty(value="공급자상호") 
	public String supComName;
    
	@ApiModelProperty(value="공급자성명") 
	public String supName;
    
	@ApiModelProperty(value="공급자사업장주소") 
	public String supAddr;
    
	@ApiModelProperty(value="공급자업태") 
	public String supBusin;
    
	@ApiModelProperty(value="공급자종목") 
	public String supKind;
    
	@ApiModelProperty(value="공급자이메일") 
	public String supEMail;
    
	@ApiModelProperty(value="공급받는자등록번호") 
	public String supiedNo;
    
	@ApiModelProperty(value="공급받는자종사업자번호") 
	public String supiedKindNo;
    
	@ApiModelProperty(value="공급받는자상호") 
	public String supiedComName;
    
	@ApiModelProperty(value="공급받는자성명") 
	public String supiedName;
    
	@ApiModelProperty(value="공급받는자사업장주소") 
	public String supiedAddr;
    
	@ApiModelProperty(value="공급받는자업태") 
	public String supiedBusin;
    
	@ApiModelProperty(value="공급받는자종목") 
	public String supiedKind;
    
	@ApiModelProperty(value="공급받는자이메일1") 
	public String supiedEMail1;
    
	@ApiModelProperty(value="공급받는자이메일2") 
	public String supiedEMail2;
    
	@ApiModelProperty(value="공급가액") 
	public String supVal;
    
	@ApiModelProperty(value="세액") 
	public String taxAm;
    
	@ApiModelProperty(value="비고") 
	public String note;
	
    @ApiModelProperty(value="일자1") 
    public String day1;
    
    @ApiModelProperty(value="품목1") 
    public String item1;
    
    @ApiModelProperty(value="규격1") 
    public String standard1;
    
    @ApiModelProperty(value="수량1") 
    public int vol1;
    
    @ApiModelProperty(value="단가1") 
    public int cost1;
    
    @ApiModelProperty(value="공급가액1")
    public String supVal1;
    
    @ApiModelProperty(value="세액1") 
    public String taxAm1;
    
    @ApiModelProperty(value="품목비고1") 
    public String itemNote1;
    
    @ApiModelProperty(value="일자2") 
    public String day2;
    
    @ApiModelProperty(value="품목2") 
    public String item2;
    
    @ApiModelProperty(value="규격2") 
    public String standard2;
    
    @ApiModelProperty(value="수량2") 
    public int vol2;
    
    @ApiModelProperty(value="단가2") 
    public int cost2;
    
    @ApiModelProperty(value="공급가액2")
    public String supVal2;
    
    @ApiModelProperty(value="세액2") 
    public String taxAm2;
    
    @ApiModelProperty(value="품목비고2") 
    public String itemNote2;
    
    @ApiModelProperty(value="현금") 
    public String cash;
    
    @ApiModelProperty(value="수표") 
    public String cheque;
    
    @ApiModelProperty(value="어음") 
    public String draft;
    
    @ApiModelProperty(value="외상미수금") 
    public String unpaidCrd;
    
    @ApiModelProperty(value="영수청구") 
    public String receiClam;
    
    @ApiModelProperty(value="상태코드") 
    public String stCd;

	@Override
	public String toString() {
		return "TaxBillDto [taxBillNo=" + taxBillNo + ", billType=" + billType + ", writeDate=" + writeDate + ", supNo="
				+ supNo + ", supKindNo=" + supKindNo + ", supComName=" + supComName + ", supName=" + supName
				+ ", supAddr=" + supAddr + ", supBusin=" + supBusin + ", supKind=" + supKind + ", supEMail=" + supEMail
				+ ", supiedNo=" + supiedNo + ", supiedKindNo=" + supiedKindNo + ", supiedComName=" + supiedComName
				+ ", supiedName=" + supiedName + ", supiedAddr=" + supiedAddr + ", supiedBusin=" + supiedBusin
				+ ", supiedKind=" + supiedKind + ", supiedEMail1=" + supiedEMail1 + ", supiedEMail2=" + supiedEMail2
				+ ", supVal=" + supVal + ", taxAm=" + taxAm + ", note=" + note + ", day1=" + day1 + ", item1=" + item1
				+ ", standard1=" + standard1 + ", vol1=" + vol1 + ", cost1=" + cost1 + ", supVal1=" + supVal1
				+ ", taxAm1=" + taxAm1 + ", itemNote1=" + itemNote1 + ", day2=" + day2 + ", item2=" + item2
				+ ", standard2=" + standard2 + ", vol2=" + vol2 + ", cost2=" + cost2 + ", supVal2=" + supVal2
				+ ", taxAm2=" + taxAm2 + ", itemNote2=" + itemNote2 + ", cash=" + cash + ", cheque=" + cheque + ", draft="
				+ draft + ", unpaidCrd=" + unpaidCrd + ", receiClam=" + receiClam + ", stCd=" + stCd + "]";
	}
    

}
