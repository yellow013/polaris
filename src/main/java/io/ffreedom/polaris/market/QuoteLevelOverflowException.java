package io.ffreedom.polaris.market;

public class QuoteLevelOverflowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuoteLevelOverflowException(String msg) {
		super(new ArrayIndexOutOfBoundsException(msg));
	}

}
