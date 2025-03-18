package com.example.nrs.service;

import java.util.HashMap;
import java.util.List;

import com.example.nrs.dto.ProjectDto;

public interface ProjectService {
	List<ProjectDto> selectProjectList() throws Exception;
	HashMap<String, Object> insertProject(HashMap<String, Object> projectMap) throws Exception;
	void updateProject(ProjectDto projectDto) throws Exception;
	void deleteProject(String prjCd) throws Exception;
	List<ProjectDto> selectProjectByStat(String prjStat) throws Exception;
	ProjectDto selectProjectByPrjCd(String prjCd) throws Exception;
}