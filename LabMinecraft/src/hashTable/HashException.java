package hashTable;

@SuppressWarnings("serial")
public class HashException extends Exception{

	private int e;
	
	public HashException(int e) {
		super();
		this.e = e;
	}

	@Override
	public String getMessage() {
		
		String mensaje = "";
		
		if(e == 101)
			mensaje = "No Room Left";
		if(e == 102)
			mensaje = "The item does not exist";
		if(e == 103)
			mensaje = "The Table is Empty";
		
		return mensaje;
	}	
	
	

}
