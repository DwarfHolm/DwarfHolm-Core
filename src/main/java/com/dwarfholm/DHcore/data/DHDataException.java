package com.dwarfholm.DHcore.data;

public class DHDataException extends Exception{
	private static final long serialVersionUID = 1L;
	public DHDataException()	{}
	public DHDataException(Throwable cause) {	super(cause);	}
	public DHDataException(String msg) {	super(msg);	}
	public DHDataException(String msg, Throwable cause) {	super(msg, cause);	}
}
