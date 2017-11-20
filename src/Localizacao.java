import java.util.Random;

public class Localizacao{
	
	private Random r = new Random();
    
    private double gerarDistancia(){
        return 100 * Math.round(1 + r.nextDouble() * 50);
    }
    
    public String getDistancia(){
    	double distancia = gerarDistancia();
    	if(distancia >= 1000){
    		distancia = distancia/1000;
    		return distancia + "km";
    	}
    	else return (int)distancia + "m";
    }
}
