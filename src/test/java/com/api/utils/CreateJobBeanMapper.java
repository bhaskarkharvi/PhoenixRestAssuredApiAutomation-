package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.dataproviders.api.bean.CreateJobBean;

public class CreateJobBeanMapper {
	
	private CreateJobBeanMapper() {};
	
	public static CreateJobPayload mapper(CreateJobBean bean ){//bean --> CreateJob payload object
		
		
		int mst_service_location_id = Integer.parseInt(bean.getMst_service_location_id());
		int mst_platform_id= Integer.parseInt((bean.getMst_platform_id()));
		int mst_warrenty_status_id=Integer.parseInt((bean.getMst_warrenty_status_id()));
		int mst_oem_id=Integer.parseInt((bean.getMst_oem_id()));
		
		
		 String first_name= bean.getCustomer__first_name();
		 String last_name=bean.getCustomer__last_name();
		 String mobile_number=bean.getCustomer__mobile_number();
		 String mobile_number_alt=bean.getCustomer__mobile_number_alt();
		 String email_id=bean.getCustomer__email_id();
		 String email_id_alt=bean.getCustomer__email_id_alt();

		
		 
		Customer customer= new Customer(first_name, last_name, mobile_number, mobile_number_alt, email_id, email_id_alt);
		
		 String flat_number=bean.getCustomer_address__flat_number();
		 String apartment_name=bean.getCustomer_address__apartment_name();
		 String street_name=bean.getCustomer_address__street_name();
		 String landmark = bean.getCustomer_address__landmark();
		 String area=bean.getCustomer_address__area();
		 String pincode=bean.getCustomer_address__pincode();
		 String country=bean.getCustomer_address__country();
		 String state=bean.getCustomer_address__state(); 
				
		CustomerAddress customer_address = new CustomerAddress(flat_number, apartment_name, street_name, landmark, area, pincode, country, state);
				
				
				String dop=bean.getCustomer_product__dop();
				String serial_number=bean.getCustomer_product__serial_number();
				String imei1=bean.getCustomer_product__imei1();
				String imei2=bean.getCustomer_product__imei2();
				String popurl=bean.getCustomer_product__popurl();
				//int product_id=Integer.parseInt(bean.getCustomer_product__product_id());
				int productId=Integer.parseInt(bean.getCustomer_product__product_id());
				int mstModelId=Integer.parseInt(bean.getCustomer_product__mst_model_id());

				CustomerProduct customer_product= new CustomerProduct(dop, serial_number, imei1, imei2, popurl, productId, mstModelId);
		
						ArrayList<Problems> problemList= new ArrayList<Problems>();
						int problemId= Integer.parseInt(bean.getProblems__id());
								String remark=bean.getProblems__remark();
								
								
						Problems problems=new Problems(problemId, remark);
						//Problems[] problemsArray = new Problems[]{problems};
						problemList.add(problems);

		CreateJobPayload createJobPayload= new CreateJobPayload(mst_service_location_id,
				mst_platform_id,
				mst_warrenty_status_id,
				mst_oem_id, 
				customer, 
				customer_address, 
				customer_product, 
				problemList);
		return createJobPayload;
		
		
	}
	

}

