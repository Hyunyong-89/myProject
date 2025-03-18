package com.example.nrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.nrs.dto.ProjectDto;

@Mapper
public interface ProjectMapper {
	
	List<ProjectDto> selectProjectList() throws Exception;
	
	void insertProject(ProjectDto projectDto) throws Exception;
	
	void updateHitCount(int projectIdx) throws Exception;
	
	void updateProject(ProjectDto projectDto) throws Exception;
	
	void deleteProject(String prjCd) throws Exception;
	
	int selectProjectIdx(String projectNo) throws Exception;
	
	List<ProjectDto> selectProjectByStat(String prjStat) throws Exception;
	
	ProjectDto selectProjectByPrjCd(String prjCd) throws Exception;
}