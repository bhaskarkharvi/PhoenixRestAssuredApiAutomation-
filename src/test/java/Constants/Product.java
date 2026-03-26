package Constants;

public enum Product {
	
	NEXUS_2(1), PIXEL(2);
	int code;
	Product(int code) { //ENUM ONLY can have private constructor, means Object cannot be created outside ENUM
		this.code=code; // code=1, 2
	}
	public int getCode() { // get method to get code and have to return that code to createJobAPITest class constructor
		return code;
	}
}
