package com.example.nrs.entity
;


import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_project")
@NoArgsConstructor
@Data
public class ProjectEntity {
	
	@Id
	private String prjCd;
	
	@Column(nullable=false)
	private String prjName;
	
	@Column(nullable=false)
	private String custCom;
	
	@Column(nullable=false)
	private String performCom;
	
	@Column(nullable=false)
	private String startDate;
	
	@Column(nullable=false)
	private String endDate;
	
	@Column(nullable=false)
	public String salesAm;
	
	@Column(nullable=false)
	public String prjStat;
	
}