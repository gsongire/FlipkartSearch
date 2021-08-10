package DriverManageFactory;

import Enum.Drivers;

public class DriverFactory {
	
	public static DriverManager getDriverManager(Drivers type) {
		
		DriverManager manager = null;
		
		switch(type)
		{
		
		case Chrome:
			manager= new ChromeDriverManager();
			break;
			
		
			
		
		}
		
		return manager;
	}

}
