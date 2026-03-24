package com.phoenix.api.pojo;

import java.util.Arrays;

public class CreateJobPayload {
	private int mst_service_location_id=0;
	private int mst_platform_id =2;
	private int mst_warrenty_status_id=1;
	private int mst_oem_id=2;
	private Customer customer;
	private CustomerAddress customerAddress;
	private CustomerProduct customerProduct;
	private Problems problem[];
	public CreateJobPayload(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id,
			int mst_oem_id, Customer customer, CustomerAddress customerAddress, CustomerProduct customerProduct,
			Problems[] problem) {
		super();
		this.mst_service_location_id = mst_service_location_id;
		this.mst_platform_id = mst_platform_id;
		this.mst_warrenty_status_id = mst_warrenty_status_id;
		this.mst_oem_id = mst_oem_id;
		this.customer = customer;
		this.customerAddress = customerAddress;
		this.customerProduct = customerProduct;
		this.problem = problem;
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
	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}
	public CustomerProduct getCustomerProduct() {
		return customerProduct;
	}
	public void setCustomerProduct(CustomerProduct customerProduct) {
		this.customerProduct = customerProduct;
	}
	public Problems[] getProblem() {
		return problem;
	}
	public void setProblem(Problems[] problem) {
		this.problem = problem;
	}
	@Override
	public String toString() {
		return "CreateJobPayload [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer=" + customer + ", customerAddress=" + customerAddress + ", customerProduct="
				+ customerProduct + ", problem=" + Arrays.toString(problem) + "]";
	}

}
