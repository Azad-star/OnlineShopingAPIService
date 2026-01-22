package com.Yusuf.exception;

public class BaseException extends RuntimeException{
	
	public BaseException(ErrorMessage errorMessage) {
		super(errorMessage.prepareErrorMessage());
		// super(...) ifadesi, bu String'i alıp doğruca RuntimeException sınıfına iletir.
	}

}
