package controller;

import java.util.concurrent.Semaphore;

public class Ex2Thread extends Thread {
	private int idThread;
	private Semaphore semaforo;
	private String nome;
	private int tempo;
	double tempoini, tempofi;
	private double percentual;

	public Ex2Thread(int idThread, Semaphore semaforo) {
		// TODO Auto-generated constructor stub
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		simulacao();
	}

	private void simulacao() {
		// TODO Auto-generated method stub
		if (idThread % 2 == 0) {
			nome = "Lasanha a Bolonhesa";
			tempo = (int) ((Math.random() * 601) + 600);
		} else {
			nome = "Sopa de Cebola";
			tempo = (int) ((Math.random() * 301) + 500);
		}
		tempofi = tempo;
		System.out.println("#" + idThread + "Prato: " + nome + " iniciado");
		while (tempoini <= tempofi) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempoini += 100;
			percentual = tempoini / tempofi;
			System.out.println("#" + idThread + "Prato: " + nome + " percentual: " + percentual);
		}
		System.out.println("#" + idThread + "Prato: " + nome + " Finalizado");
		try {
			semaforo.acquire();
			entregar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void entregar() {
		// TODO Auto-generated method stub
		System.out.println("#" + idThread + "Prato: " + nome + " realizando entrega...");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#" + idThread + "Prato: " + nome + " Entregue!");
	}
}
