import java.util.Random;

public class Localizacao{
	
	private Random r = new Random();
    
    public double getDistancia(){
        return Math.round(1 + r.nextDouble() * 50);
    }
}