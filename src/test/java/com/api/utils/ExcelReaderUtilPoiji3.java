package com.api.utils;

import java.util.Iterator;

import com.api.request.model.CreateJobPayload;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;

public class ExcelReaderUtilPoiji3 {
	
private ExcelReaderUtilPoiji3() {}
	public static void main(String[] args) {
		
Iterator<CreateJobBean>	beanIterator=	 ExcelReaderUtil2Poiji.loadExcelPoijiData("testData/PhoenixTestData.xlsx","CreateJobTestData",CreateJobBean.class);	

CreateJobBean createJobBean;
CreateJobPayload createJobPayload;
while(beanIterator.hasNext()) {
	
	 createJobBean= beanIterator.next();
	 createJobPayload= CreateJobBeanMapper.mapper(createJobBean);
			
	System.out.println(createJobPayload);
	}
		
}
}