package io.ffreedom.financial;

public enum Country {

	JAPAN(1, "Japan"),

	USA(2, "USA"),

	UK(3, "UK"),

	CHINA(4, "China"),

	;

	private int countryId;

	private String countryName;

	private Country(int countryId, String countryName) {
		this.countryId = countryId * 100000000;
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

}
