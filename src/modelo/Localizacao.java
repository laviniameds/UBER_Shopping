package modelo;

import java.util.Random;

public class Localizacao{
	
    private Random r = new Random();
    private double distancia;
	
    private double gerarDistancia(){
        return 100 * Math.round(1 + r.nextDouble() * 50);
    }
    
    public String getDistancia(){
    	this.distancia = gerarDistancia();
    	if(distancia >= 1000){
    		return (this.distancia/1000) + "km";
    	}
    	else return (int)distancia + "m";
    }
    
    public double getDistanciaDefinida() {
    	return this.distancia;
    }
}
