package com.tcb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcb.model.Dataset;
import com.tcb.service.DatasetsService;

@RestController
public class DatasetsController {

	//call service rather than repo 
	@Autowired
	private DatasetsService dataservice;
	
	@RequestMapping("/")
	public List<Dataset> home() {
		
		return dataservice.findAllDatasets();
	}
	
	@RequestMapping("/find") 
	public @ResponseBody List<Dataset> find(@RequestParam(value = "key") String keyWord) {
		
		return dataservice.findDatasetsByName(keyWord);
	}
	
	@RequestMapping("/search") 
	public @ResponseBody List<Dataset> search(@RequestParam(value = "key") String keyWord) {
		
		return dataservice.findByKeyWord(keyWord);
	}
	
	@RequestMapping("/detail") 
	public @ResponseBody Dataset detail(@RequestParam(value = "id") String id) {
		
		return dataservice.findDatasetById(id);
	}
	
}
