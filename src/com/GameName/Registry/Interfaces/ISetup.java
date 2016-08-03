package com.GameName.Registry.Interfaces;

public interface ISetup {

	public void preInit();
	public void init();
	public void postInit(); 
	
	public String getVersion();
	
}
