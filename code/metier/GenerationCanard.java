package code.metier;


import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.ControleurCanardClicker;

/** GenerationCanardClicker
  * date    : le 24/02/2024
  * @author : Théo Harel
  */ 

public class GenerationCanard 
{
	private double nbCanard     ;
	private double generation ;
	
	

	public GenerationCanard( ControleurCanardClicker ctrl )
	{
		Timer timer;
		timer = new Timer(1000, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				nbCanard += generation;
				ctrl.majIHM();
			}
		});
		timer.start();
	}


	/*ajoute des Canard a chaque click */
	public void clickCanard( int click )
	{
		this.nbCanard += click;
	}

	public void modificationNbCanard( double modif )
	{
		this.nbCanard += modif;
	}

	public void resetGeneration()
	{
		this.generation = 0;
	}

	public void modificationGeneration(double modif)
	{
		this.generation += modif;
	}

	public double getGeneration()
	{
		return this.generation;
	}

	public double getNbCanard()
	{
		return this.nbCanard;
	}

	

	
}
