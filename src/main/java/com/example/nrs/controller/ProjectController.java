package com.example.nrs.controller;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.mapping.ResultMap;
import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.nrs.dto.CustomerDto;
import com.example.nrs.dto.ProjectDto;
import com.example.nrs.service.ProjectService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(path="/project/openProjectList.do")
	// /project/openProjectList.do 이건 클라이언트가 호출하는 주소인데 이것과 수행할 아래의 메소드를 연결시킨다.
	public ModelAndView openProjectList()throws Exception {
		//log.debug("openProjectList");
		// debug 레벨의 로그를 출력
		
		ModelAndView mv = new ModelAndView("project/projectList");
		//호출된 요청의 결과를 보여줄 뷰를 위와 같이 /project/projectList로 지정한다. -> templates폴더 아래에 있는 project/projectList.html을 의미
		
		List<ProjectDto> list = projectService.selectProjectList();
		mv.addObject("list", list);
		mv.addObject("resultType", "0000");
		mv.addObject("returnUrl", "/project/openProjectList");
		// 실행된 비즈니스 로직의 결과값을 뷰에 list라는 이름으로 저장, 뷰에서 list라는 이름으로 조회결과를 사용가능
		
		//log.debug(list.toString());
		return mv;
	}
	
	
	@RequestMapping(path = "/project/openProjectRegister.do")
	public String openProjectRegister() throws Exception{
		return "/project/projectRegister";
	}
	
	@ResponseBody
	@RequestMapping(path = "/project/insertProject.do")
	public HashMap<String, Object> insertProject(@RequestBody HashMap<String, Object> map) throws Exception {
		
		log.debug("insertProject IN");
		log.debug(map.toString());

		HashMap<String, Object> resultMap = projectService.insertProject(map);
		
		resultMap.put("resultType", "0000");
		resultMap.put("returnUrl", "/project/openProjectList.do");
		
		return resultMap;
		// 게시물이 등록된 후 보여줘야하니까 /project/projectList가 아닌 위의 주소로 가줘야함.
	}

	@RequestMapping(path="/project/openProjectDetail.do")
	public ModelAndView openCustomerDetail(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("project/projectDetail");
		
		ProjectDto proejctDto = projectService.selectProjectByPrjCd(request.getParameter("prjCd"));
		
		mv.addObject("project", proejctDto);
		log.debug(mv.toString());
		
		return mv;
	}
	
	@RequestMapping(path="project/updateProject.do")
	public String updateProject(HttpServletRequest request) throws Exception {
		
		log.debug(request.getParameter("prjCd"));
		
		ProjectDto projectDto = new ProjectDto();
		
		projectDto.prjCd 		= request.getParameter("prjCd");
		projectDto.prjName		= request.getParameter("prjName");
		projectDto.custCom 		= request.getParameter("custCom");
		projectDto.performCom 	= request.getParameter("performCom");
		projectDto.startDate 	= request.getParameter("startDate");
		projectDto.endDate 		= request.getParameter("endDate");
		projectDto.salesAm 		= request.getParameter("salesAm");
		projectDto.prjStat 		= request.getParameter("prjStat");
		
		projectService.updateProject(projectDto);
		return "redirect:/project/openProjectList.do";
	}
	
	@RequestMapping(path = "project/deleteProject.do")
	public String deleteProject(HttpServletRequest request) throws Exception {
		log.debug(request.getParameter("prjCd"));
		projectService.deleteProject(request.getParameter("prjCd"));
		return "redirect:/project/openProjectList.do";
	}
	
	@ResponseBody
	@RequestMapping(path="/project/selectProjectList.do")
	public HashMap<String, Object> selectProjectList()throws Exception {
		log.debug("openProjectList");
		// debug 레벨의 로그를 출력
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<ProjectDto> list = projectService.selectProjectList();
		resultMap.put("list", list);
		resultMap.put("resultType", "0000");
		
		log.debug(list.toString());
		return resultMap;
	}
}
