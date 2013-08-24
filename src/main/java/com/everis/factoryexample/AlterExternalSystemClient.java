package com.everis.factoriesexample;

public class AlterExternalSystemClient {
	
	public void delete(long id){
		//stuff
	}
	
	public void create(AESElement e){
		//stuff
	}
	
	public AESElement findById(long id){
		return new AESElement();
	}
	
	public AESElement[] searchByProperty(String property){
		AESElement[] result = new AESElement[10];
		for(int i=0;i<10;i++){
			result[i] = new AESElement();
		}
		return result;
	}
}
