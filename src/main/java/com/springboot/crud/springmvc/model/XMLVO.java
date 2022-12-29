package com.springboot.crud.springmvc.model;

public class XMLVO {
private String stateCode;
private String errorCode;
private String from;
private String toAddress;
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getToAddress() {
	return toAddress;
}
public void setToAddress(String toAddress) {
	this.toAddress = toAddress;
}
@Override
public String toString() {
	return String.format("XMLVO [getStateCode()=%s, getErrorCode()=%s, getFrom()=%s, getToAddress()=%s " ,getStateCode(),getErrorCode(),getFrom(),getToAddress());
}

}
