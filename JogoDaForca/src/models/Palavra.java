/**
 * 
 */
package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class Palavra {
	
	//private enum categorias { palavrasDiversas, conhecimentoGeral, paises  }
	private String palavra;
	private String dica;
	
	private List<Palavra> palavras = new ArrayList<Palavra>();
	
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
		System.out.println("setPalavra " + palavra);
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}	
	
	public List<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<Palavra> palavras) {
		this.palavras = palavras;
	}	

	/**
	 * 
	 */
	public Palavra() {
		// TODO Auto-generated constructor stub
	}
	
	public Palavra sorteiaPalavra() {		
		
		Palavra resultado =  null;
        JSONParser jsonParser = new JSONParser();
        
        if(palavras != null) {
        	palavras.clear();
        }
         
        try (FileReader reader = new FileReader(this.getClass().getResource("/resources/json/palavras.json").getPath()))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray listPalavra = (JSONArray) obj;
            
            for (Object item : listPalavra) {
                
                JSONObject object = (JSONObject) item;
                var json = (JSONObject)object.get("dicionario");
                
                var p = new Palavra();
                p.dica = (String)json.get("dica");   
                p.palavra = (String)json.get("palavra");   
                
                palavras.add(p);
            }  
            
            System.out.println("palavras.size() " + palavras.size());

            int indice = new Random().ints(0, palavras.size()).findFirst().getAsInt();
			resultado = palavras.get(indice);
			
			System.out.println(resultado.getPalavra());
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		return resultado;
	}		
	
	public int obtemTotalTentativas(String palavra) {
		
		int resultado;
		int tamamho = palavra.length();
		
		if(tamamho < 10) {
			resultado = tamamho + 5;
		}else if(tamamho > 10) {
			resultado = tamamho + 8;
		}else {
			resultado = 9;
		}
		
		return resultado;
	}
	
}
