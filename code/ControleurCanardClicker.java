package code;

import code.ihm.FrameCanardClicker;
import code.metier.GenerationCanard;
import code.metier.GestionBruitage;

/** ControleurClicker
  * date    : le 24/02/2024
  * @author : Théo Harel
  */ 

public class ControleurCanardClicker 
{
	FrameCanardClicker ihm;
	GenerationCanard   metierGeneration;
	GestionBruitage  metierBruitage  ;

	public ControleurCanardClicker()
	{
		this.ihm = new FrameCanardClicker( this );
		this.metierGeneration = new GenerationCanard( this );
		this.metierBruitage    = new GestionBruitage();
	}

	public static void main(String[] a)
	{
		new ControleurCanardClicker();
	}

	public void clickCanard()
	{
		this.metierGeneration.clickCanard(ihm.getClick());
	}

	public void modificationNbCanard( double modif )
	{
		metierGeneration.modificationNbCanard( modif );
	}

	public int getNbClick()
	{
		return this.ihm.getNbClick();
	}

	public double getGeneration()
	{
		return metierGeneration.getGeneration();
	}

	public void modificationGeneration( double modif )
	{
		metierGeneration.modificationGeneration(modif);
	}

	public void resetGeneration()
	{
		metierGeneration.resetGeneration();
	}

	public double getNbCanard()
	{
		return metierGeneration.getNbCanard();
	}

	public void bruitage( String nomBruit)
	{
		this.metierBruitage.bruitage( nomBruit );
	}

	public void achatAmeliorationNbClick( int nivClick )
	{
		this.ihm.achatAmeliorationNbClick( nivClick );
	}

	public void majIHM()
	{
		this.ihm.majIHM();
	}

}
