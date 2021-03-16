package view;

import java.util.concurrent.Semaphore;

import controller.Ex2Thread;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissoes=1;
		Semaphore semaforo=new Semaphore(permissoes);
		for(int idThread=1;idThread<=5;idThread++){
			Thread tSimul=new Ex2Thread(idThread,semaforo);
			tSimul.start();
		}
	}
}

