package com.example.nrs.service;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nrs.config.Constants;
import com.example.nrs.dto.ProjectDto;
import com.example.nrs.mapper.ProjectMapper;
import com.example.nrs.util.DateConstants;
import com.example.nrs.util.DateUtils;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class ProjectServiceImpl implements ProjectService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProjectMapper projectMapper;
	// 데이터베이스에 접근하는 DAO빈을 선언
	private DateUtils dateUtils;
	private Constants constants;
	
	@Override
	public List<ProjectDto> selectProjectList() throws Exception {
		return projectMapper.selectProjectList();
	}
	
	/*
	 * 프로젝트 등록 메서드
	 * 
	 * @param projectMap
	 * @return projectMap
	 * 
	 * */
	@SuppressWarnings("static-access")
	@Override
	public HashMap<String, Object> insertProject(HashMap<String, Object> projectMap) throws Exception {
		
		ProjectDto projectDto = new ProjectDto();
		log.debug("debug: " + dateUtils.getCurrentDateString());
		String prjCd = "";
		String prjCdIdx = dateUtils.getCurrentDateString() + projectMap.get("performCom");
		
		int prjCnt = projectMapper.selectProjectIdx(prjCdIdx);
		//12자리
		//YYYYMMDD + (수행사코드 2자리) + 000n
		
		if(prjCnt > 0) {
			prjCd = prjCdIdx + String.format("%4s", prjCnt).replace(" ", "0");
		}else {
			prjCd = prjCdIdx + "0001";
		}
		
		String startDate 	= ((String) projectMap.get("stDate")).replaceAll("-", "");
		String endDate 		= ((String) projectMap.get("endDate")).replaceAll("-", "");
		String salesAm 		= ((String) projectMap.get("salesAm")).replaceAll(",", "");
		
		projectDto.prjCd 		= prjCd;
		projectDto.prjName 		= (String) projectMap.get("prjName");
		projectDto.custCom 		= (String) projectMap.get("custCom");
		projectDto.performCom 	= (String) projectMap.get("performCom");
		projectDto.startDate 	= startDate;
		projectDto.endDate 		= endDate;
		projectDto.salesAm 		= salesAm;
		projectDto.prjStat      = constants.COM_PRJ_STAT_START;
		log.debug("debug: " + projectDto.toString());
		
		projectMapper.insertProject(projectDto);
		log.debug("debug: insertProject success");
		return projectMap;
		
	}

	@Override
	public void updateProject(ProjectDto projectDto) throws Exception {
		projectMapper.updateProject(projectDto);
	}

	@Override
	public void deleteProject(String prjCd) throws Exception {
		projectMapper.deleteProject(prjCd);
	}

	@Override
	public List<ProjectDto> selectProjectByStat(String prjStat) throws Exception {
		//프로젝트 상태코드
		//COM_PRJ_STAT_START = "0"; //정상
		//COM_PRJ_STAT_END = "1"; //종료
		return projectMapper.selectProjectByStat(prjStat);
	}

	@Override
	public ProjectDto selectProjectByPrjCd(String prjCd) throws Exception {
		return projectMapper.selectProjectByPrjCd(prjCd);
	}
	
	
}