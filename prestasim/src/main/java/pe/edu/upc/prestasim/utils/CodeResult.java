package pe.edu.upc.prestasim.utils;

public enum CodeResult {

	OK("0","000","Se realizo correctamente la operacion"),
	GENERIC_ERROR("1", "001E" ,"Ocurrio un error al ejecutar la operacion solicitada"),
	REGISTER_ERROR("1", "002E" ,"No se pudo concretar el registro"),
	LOGIN_ERROR("1", "003E" ,"No se pudo autenticar al usuario"),
	UPDATE_ERROR("1", "004E" ,"No se pudo actualizar el registro"),
	FORBIDDEN_REQUEST_ERROR("1", "005E" ,"No tiene permisos para consultar esta solicitud"),
	INEXISTENT_USER_ERROR("1", "006E" ,"El usuario consultado no existe");

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
