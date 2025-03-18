package com.example.nrs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// 아래 어노테이션만으로 알아서 getter/setter메소드와 toString, hashCode, equals등의 메소드도 생성
@Data
@ApiModel(value="CustomerDto : 고객명단 내용", description="고객명단 내용")
public class CustomerDto {
	@ApiModelProperty(value="고객번호")
	public String customerNo;
	
	@ApiModelProperty(value="고객구분")
	public String section;
	
	@ApiModelProperty(value="회사이름")
	public String comName;
	
	@ApiModelProperty(value="이름")
	public String name;
	
	@ApiModelProperty(value="구분번호")
	public String pno;
	
	@ApiModelProperty(value="핸드폰번호")
	public String phone;
	
	@ApiModelProperty(value="이메일")
	public String email;
	
	@ApiModelProperty(value="우편번호")
	public String postNo;
	
	@ApiModelProperty(value="주소")
	public String address;
	
	@ApiModelProperty(value="은행")
	public String bank;
	
	@ApiModelProperty(value="계좌번호")
	public String accNo;
	
	@ApiModelProperty(value="계산서이메일")
	public String calcEMail;

	@Override
	public String toString() {
		return "CustomerDto [customerNo=" + customerNo + ", section=" + section + ", comName=" + comName + ", name="
				+ name + ", pno=" + pno + ", phone=" + phone + ", email=" + email + ", postNo=" + postNo + ", address="
				+ address + ", bank=" + bank + ", accNo=" + accNo + ", calcEMail=" + calcEMail + "]";
	}
	

	
}