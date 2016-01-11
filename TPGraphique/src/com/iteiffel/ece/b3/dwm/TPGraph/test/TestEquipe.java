package com.iteiffel.ece.b3.dwm.TPGraph.test;

import com.iteiffel.ece.b3.dwm.TPGraph.model.*;

public  class TestEquipe {
	
	public static void main(String args[])
	{
		Equipe tFoot1 = new Foot ("Equipe Foot 1", 1, "1",0);
		
		Equipe tBask1 = new Baskett ("Equipe Baskett 1", 10, "3",0);
		
		Equipe tRug1 = new Rugby ("Equipe Rugby 1", 20, "5",0);

		tFoot1.showStats();
		tBask1.showStats();
		tRug1.showStats();
	} 

}
