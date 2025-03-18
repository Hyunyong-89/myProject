package com.example.nrs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// 아래 어노테이션만으로 알아서 getter/setter메소드와 toString, hashCode, equals등의 메소드도 생성
@Data
@ApiModel(value="ProjectDto : 프로젝트 내용", description="프로젝트 내용")
public class ProjectDto {
	@ApiModelProperty(value="프로젝트번호")
	public String prjCd;
	
	@ApiModelProperty(value="프로젝트명")
	public String prjName;
	
	@ApiModelProperty(value="고객사")
	public String custCom;
	
	@ApiModelProperty(value="수행사")
	public String performCom;
	
	@ApiModelProperty(value="시작일자")
	public String startDate;
	
	@ApiModelProperty(value="종료일자")
	public String endDate;
	
	@ApiModelProperty(value="매출금액")
	public String salesAm;
	
	@ApiModelProperty(value="프로젝트상태")
	public String prjStat;

	@Override
	public String toString() {
		return "ProjectDto [prjCd=" + prjCd + ", prjName=" + prjName + ", custCom=" + custCom + ", performCom="
				+ performCom + ", startDate=" + startDate + ", endDate=" + endDate + ", salesAm=" + salesAm
				+ ", prjStat=" + prjStat + "]";
	}
	
}