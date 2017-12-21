package model;

import java.util.Random;

public class Localizacao{
	
    private Random random = new Random();
    private double distancia;
	
    private double gerarDistancia(){
        return 100 * Math.round(1 + random.nextDouble() * 50);
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
