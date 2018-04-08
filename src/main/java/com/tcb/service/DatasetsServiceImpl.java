package com.tcb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcb.dao.DatasetRepository;
import com.tcb.model.Dataset;

@Service
public class DatasetsServiceImpl implements DatasetsService {

	@Autowired
	private DatasetRepository dataDao;

	

	@Override
	public List<Dataset> findDatasetsByName(String name) {
		return dataDao.findDatasetsByName(name);
	}

	@Override
	public List<Dataset> findAllDatasets() {
		return dataDao.findAllDatasets();
	}

	@Override
	public Dataset findDatasetById(String id) {
		return dataDao.findDatasetById(id);
	}

	@Override
	public List<Dataset> findByKeyWord(String keyWord) {
		return dataDao.findByKeyWord(keyWord);
	}

	
	
	

	
}
