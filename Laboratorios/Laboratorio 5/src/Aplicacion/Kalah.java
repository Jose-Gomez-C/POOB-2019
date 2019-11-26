package Aplicacion;
import java.util.*;

public class Kalah{
	
	private int[] game;
	private boolean turno;
	private int jugadas;
	public Kalah(int casas, int semillas){
		jugadas=0;
		turno=true;
		game= new int[(casas*2)+2];
		for (int i=0; i<game.length;++i){
			game[i]=semillas;
		}
		game[0]=0;
		game[game.length/2]=0;
		
	}
	public boolean juegue(int casa)throws KalahException{
		++jugadas;
		if (casa==0 || casa==game.length/2)throw new KalahException(KalahException.ES_UN_ALMACEN);
		if (game[casa]==0) throw new KalahException(KalahException.NO_HAY_SEMILLAS);
		int semillas=game[casa];
		game[casa]=0;
		
		int recorer=casa+1;
		for(int i=0;i<semillas;++i){
			if(turno){
				if(casa > game.length/2) throw new KalahException(KalahException.NO_ES_SU_CASA);
				if(recorer== game.length) recorer=1;
				game[recorer]+=1;
				++recorer;
				
			}else{
				if(casa< game.length/2) throw new KalahException(KalahException.NO_ES_SU_CASA);
				if(recorer== game.length) recorer=0;
				if(recorer== game.length/2) recorer=game.length/2+1;
				game[recorer]+=1;
				++recorer;
			}
		}
		--recorer;
		if(recorer==game.length/2 && turno){
			turno = true;
		}else if(recorer==0 && !(turno)){
			turno=false;
		}else{
			if(turno){
				if(game[recorer]==1){
					game[game.length/2]+=1+game[game.length-recorer];
					game[recorer]=0;
					game[game.length-recorer]=0;
				}
				turno=false;
			}else{
				if(game[recorer]==1){
					game[0]+=1+game[game.length-recorer];
					game[recorer]=0;
					game[game.length-recorer]=0;
				}
				turno=true;
			}
		}
		return turno;
	}
	/*
	public void imprimir(){
		for(int i=0;i<game.length;++i){
			System.out.print(game[i]+", ");
		}
		System.out.println("juego");
		for(int i=0;i<game.length/2;++i){
			System.out.print(game[i]+", ");
		}
		System.out.println(" J1");
		for(int i=game.length/2;i<game.length;++i){
			System.out.print(game[i]+", ");
		}
		System.out.println(" J2");
		
	}
	*/
	public int[] estado(){
		return game;
	}
	public boolean gano()throws KalahException{
		boolean acabo = true;
		int totalJ1=0;
		int totalJ2=0;
		for(int i=1;i<game.length/2;++i){
			totalJ1+=game[i];
		}
		totalJ1+=game[game.length/2];
		for(int i=game.length/2+1;i<game.length/2;++i){
			totalJ2+=game[i];
		}
		totalJ1+=game[0];
		if( totalJ1 > totalJ2)acabo= true;
		else if (totalJ1==totalJ2)throw new KalahException(KalahException.NO_HAY_GANADOR);
		else acabo=false;
		return acabo;	
	}
	public boolean termino(){
		boolean sinsemillasJ1=true;
		boolean sinsemillasJ2=true;
		for(int i=1;i<game.length/2&& sinsemillasJ1;++i){
			if(game[i]!=0)sinsemillasJ1=false;
		}
		for(int i=game.length/2+1;i<game.length&&sinsemillasJ2;++i){
			if(game[i]!=0)sinsemillasJ2=false;
		}
		return (sinsemillasJ1||sinsemillasJ2);
	}
	public int getJugadoas(){
		return jugadas;
	}
	public boolean turnoMaquina(){
		return turno;
	}
}