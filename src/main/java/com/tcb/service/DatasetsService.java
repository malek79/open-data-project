package com.tcb.service;

import java.util.List;

import com.tcb.model.Dataset;

public interface DatasetsService {
	Dataset findDatasetById(String id) ; 
	 List<Dataset> findByKeyWord(String keyWord);
    List<Dataset> findDatasetsByName(String name);
    List<Dataset> findAllDatasets();
	
}
