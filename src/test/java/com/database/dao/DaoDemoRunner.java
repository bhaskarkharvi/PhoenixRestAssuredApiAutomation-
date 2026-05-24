package com.database.dao;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobPayload;
import com.api.utils.CreateJobBeanMapper;
import com.dataproviders.api.bean.CreateJobBean;

public class DaoDemoRunner {

	public static void main(String[] args) {
		
		
		List<CreateJobPayload> payloadList= new ArrayList<CreateJobPayload>();
		List<CreateJobBean> beanList=    CreateJobPayloadDataDao.getCreateJobPayloadData();
	    for(CreateJobBean createJobBean :beanList ) {
		CreateJobPayload payload = CreateJobBeanMapper.mapper(createJobBean);
		
		payloadList.add(payload);
		// System.out.println("________________________________________");
		
	}
	    
		System.out.println("________________________________________");
for(CreateJobPayload payload:payloadList) {
	System.out.println(payload);
}
	}

}
