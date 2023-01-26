package util;

import java.util.regex.Pattern;

public class Normaliza {

	public static boolean validaCpf(String cpf)throws Exception {
		
		cpf.replace(".", "");
		cpf.replace("-", "");
		if(cpf.length() != 11) {
			throw new Exception("CPF INVALIDO");
			
		}
		
		return true;
	
	}
	
	public static boolean validaPlaca(String placa) throws Exception {
		
		if(placa.length() < 7 && placa.length() > 8) 
			{
			  throw new Exception("Placa Invalida");
			}
		if(!placa.matches("[A-Z{3}[0-9][A-Z][0-9]{2}]") && !placa.matches("[A-Z]{3}-\\d{4}") && !placa.matches("[A-Z]{3}[0-9]{4}")) 
		 {
			 throw new Exception("Placa Invalida");
		 }
		
		return true;
	}
}
