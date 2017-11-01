package webservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

import org.xml.sax.DTDHandler;

public class DateUtil {
	public static String formatDateTime(Date data) throws Exception {
		
		String dataFormatada = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		if(data == null){
			throw new DataFormatException("Data nula!");
		}
		
		try{
			dataFormatada = sdf.format(data);
		}catch(Exception e){
			throw new DataFormatException("Erro ao tentar formatar data: " + e.getMessage());
		}
		
		return dataFormatada;
		
	}
	
	public static Date formatToDateTime(String data) throws Exception {
		
		Date dtHora = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		if(data == null || "".equals(data)){
			throw new DataFormatException("Data nula!");
		}
		
		try{
			dtHora = sdf.parse(data);
		}catch(Exception e){
			throw new DataFormatException("Erro ao tentar formatar data: " + e.getMessage());
		}
		
		return dtHora;
	}
}
