import java.util.Random;

public class Localizacao{
	
	private Random r = new Random();
    
    public double getDistancia(){
        return r.nextDouble() * 50.0;
    }
}