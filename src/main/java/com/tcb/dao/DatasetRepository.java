package com.tcb.dao;

import java.util.List;

import com.tcb.model.Dataset;


public interface DatasetRepository  {
	Dataset findDatasetById(String id) ; 
    List<Dataset> findDatasetsByName(String name);
    List<Dataset> findAllDatasets();
    List<Dataset> findByKeyWord(String keyWord);
}
