package com.example.nrs.entity
;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_customer")
@NoArgsConstructor
@Data
public class CustomerEntity {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String customerNo;
	
	@Column(nullable=false)
	private String section;
	
	@Column(nullable=true)
	private String comName;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String pno;
	
	@Column(nullable=false)
	private String phone;
	
	@Column(nullable=true)
	private String email;
	
	@Column(nullable=true)
	private String postNo;
	
	@Column(nullable=true)
	private String address;
	
	@Column(nullable=true)
	private String bank;
	
	@Column(nullable=true)
	private String accNo;
	
	@Column(nullable=true)
	private String calcEMail;
	
}