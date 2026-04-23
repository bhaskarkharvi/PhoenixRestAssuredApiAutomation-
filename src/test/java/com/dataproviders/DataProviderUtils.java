package com.dataproviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobPayload;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.FakeDataGenerator;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;

public class DataProviderUtils {

	@DataProvider(name = "LoginAPIDataProvider", parallel = true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReaderUtil.loadCSV("testData/loginCreds.csv", UserBean.class);

	}

	@DataProvider(name = "createJobAPIDataProvider", parallel = true)
	public static Iterator<CreateJobPayload> createJobAPIDataProvider() {
		Iterator<CreateJobBean> createJobBeanIterator = CSVReaderUtil.loadCSV("testData/createJobData.csv",
				CreateJobBean.class);

		List<CreateJobPayload> createJobPayload = new ArrayList<CreateJobPayload>();
		CreateJobBean tempBean;
		CreateJobPayload tempCreateJobPayload;
		while (createJobBeanIterator.hasNext()) {
			tempBean = createJobBeanIterator.next();
			tempCreateJobPayload = CreateJobBeanMapper.mapper(tempBean);
			createJobPayload.add(tempCreateJobPayload);

		}

		return createJobPayload.iterator();

	}
	
	
	@DataProvider(name="CreateJobAPIFakerDataProvider", parallel = true)
	public static Iterator<CreateJobPayload> createJobAPIFakerDataProvider() {
		//Introduce git bash terminal entry for data(number of payload) count -> to remove hardcoding of count
		String fakerCount= System.getProperty("fakerCount", "5");
		int fakerCountInt=Integer.parseInt(fakerCount);
		Iterator<CreateJobPayload> createJobPayloadIterator= FakeDataGenerator.generateFakeCreateJobData(fakerCountInt);

		//Iterator<CreateJobPayload> createJobPayloadIterator= FakeDataGenerator.generateFakeCreateJobData(2);
		return createJobPayloadIterator;
	}

}
