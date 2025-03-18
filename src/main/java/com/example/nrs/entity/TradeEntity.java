package com.example.nrs.entity
;


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
public class TradeEntity {
	
	@Id
	private int tradeNo;
	
	@Column(nullable=false)
	private String prjCd;
	
	@Column(nullable=false)
	private String prjName;
	
	@Column(nullable=false)
	private String purCom;
	
	@Column(nullable=false)
	private String customerNo;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String performCom;
	
	@Column(nullable=false)
	private String year;
	
	@Column(nullable=false)
	private String month;
	
	@Column(nullable=false)
	private String day;
	
	@Column(nullable=false)
	private String am;
	
	@Column(nullable=false)
	private String bank;
	
	@Column(nullable=false)
	private String accNo;
	
	@Column(nullable=false)
	private String valChk;
	
	@Column(nullable=false)
	private String ex;
	
}