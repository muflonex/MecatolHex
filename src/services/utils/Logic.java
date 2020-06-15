package services.utils;

public class Logic {
	public static boolean isAllFalse(boolean[] errores)
	{
	    for(boolean b : errores) if(b) return false;
	    return true;
	}
}
