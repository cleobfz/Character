package controller;

public class RNG {
	Controller c;
	int rndm;
	
	public RNG(Controller c) {
		this.c = c;
		
		rndm = (int)(Math.random()*499+1);
		System.out.println(rndm);
		
	}
	

	/*
	 * Getter & Setter
	 */
	public Controller getC() {
		return c;
	}

	public void setC(Controller c) {
		this.c = c;
	}

	public int getRndm() {
		return rndm;
	}

	public void setRndm(int rndm) {
		this.rndm = rndm;
	}


}
