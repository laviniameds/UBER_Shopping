import java.util.Random;

public class Localizacao{
	
	private Random r = new Random();
    
    private double gerarDistancia(){
        return Math.round(100 + r.nextDouble() * 5000);
    }
    
    public String getDistancia(){
    	int distancia = (int)gerarDistancia();
    	if(distancia >= 1000){
    		return distancia + "km";
    	}
    	else return distancia + "m";
    }
}
