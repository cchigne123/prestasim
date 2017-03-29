package pe.edu.upc.prestasim.utils;

public enum CodeResult {

	OK("0","","Se realizo correctamente la operacion"), 
	GENERIC_ERROR("1", "001E" ,"Ocurrio un error al ejecutar la operacion solicitada");
	
	private String status;
	private String code;
	private String message;
	
	private CodeResult(String status, String code, String message){
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}
	
}
