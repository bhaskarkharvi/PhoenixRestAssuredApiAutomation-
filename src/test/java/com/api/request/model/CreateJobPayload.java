package com.api.request.model;

import java.util.ArrayList;
import java.util.Arrays;

import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;

public class CreateJobPayload {
	private int mst_service_location_id=0;
	private int mst_platform_id =2;
	private int mst_warrenty_status_id=1;
	private int mst_oem_id=2;
	private Customer customer;
	private CustomerAddress customer_address;
	private CustomerProduct customer_product;
	private ArrayList<Problems> problems;
	public CreateJobPayload(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id,
			int mst_oem_id, Customer customer, CustomerAddress customer_address, CustomerProduct customer_product,
			ArrayList<Problems> problems) {
				
		super();
		this.mst_service_location_id = mst_service_location_id;
		this.mst_platform_id = mst_platform_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.customer = customer;
		this.customer_address = customer_address;
		this.customer_product = customer_product;
		this.problems = problems;
	}

	public int getMst_service_location_id() {
		return mst_service_location_id;
	}
	public void setMst_service_location_id(int mst_service_location_id) {
		this.mst_service_location_id = mst_service_location_id;
	}
	public int getMst_platform_id() {
		return mst_platform_id;
	}
	public void setMst_platform_id(int mst_platform_id) {
		this.mst_platform_id = mst_platform_id;
	}
	public int getMst_warrenty_status_id() {
		return mst_warrenty_status_id;
	}
	public void setMst_warrenty_status_id(int mst_warrenty_status_id) {
		this.mst_warrenty_status_id = mst_warrenty_status_id;
	}
	public int getMst_oem_id() {
		return mst_oem_id;
	}
	public void setMst_oem_id(int mst_oem_id) {
		this.mst_oem_id = mst_oem_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerAddress getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(CustomerAddress customer_address) {
		this.customer_address = customer_address;
	}
	public CustomerProduct getCustomer_product() {
		return customer_product;
	}
	public void setCustomer_product(CustomerProduct customer_product) {
		this.customer_product = customer_product;
	}
	public ArrayList<Problems> getProblems() {
		return problems;
	}
	public void setProblems(ArrayList<Problems> problems) {
		this.problems = problems;
	}
	@Override
	public String toString() {
		return "CreateJobPayload [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer=" + customer + ", customer_address=" + customer_address + ", customer_product="
				+ customer_product + ", problems=" + problems + "]";
	}
	
}
