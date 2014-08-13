package socketclient;

import java.util.Vector;

public class ConstructionVResult {
	
public static Vector<String> getVResult(String result){
	
	Vector<String> v = new Vector<String>();
	String resultArray[] = result.split("\\.");
	for(int i = 1 ; i<resultArray.length; i ++ ){
		v.set(i-1, resultArray[i]);
	}
	return v; 
}
}
