package code.ihm;
/** PanelAmelioration
  * date    : le 24/02/2024
  * @author : Théo Harel
  */ 

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.*;

import code.ControleurCanardClicker;

import java.awt.event.*;

public class PanelAmelioration extends JPanel implements ActionListener
{
	ControleurCanardClicker ctrl;

	JPanel panelConstru;
	JPanel panelAmelioration;

	JScrollPane spConstru;
	JScrollPane spAmelioration;

	/* niveau par click */
	

// --------------------------------------------------------------------------------

	/* toutes les constructions */
	String [] nomConstru   = {"Toilette", "Vache", "Skibidi", "Usine a Canard"};
	int       nbConstru    = this.nomConstru.length;

	JButton[] construction ;

	/*prix constru */
	double[] prixConstru = {10, 50, 150, 400, 1200};

	/*niveau Constru */
	int[] nivConstru;

	/*generation personnel */
	double[] generationPersonnel;
//--------------------------------------------------------------------------------

	/*Toutes les Améliorations */

	String[] nomAmelioration = { "Click","Toilette", "Vache", "Skibidi", "Usine a Canard" };
	int nbAmelioration = this.nomAmelioration.length;

	JButton[] amelioration;

	double [] prixAmelioration = { 100, 450, 750, 1005, 3400, 5000 };
	/* niveau Amelioration */
	int[] nivAmelioration;

	/*Creation du Panel */
	public PanelAmelioration( ControleurCanardClicker ctrl )
	{	
		this.ctrl = ctrl;

		this.setLayout( new BorderLayout() );

		this.construction       = new JButton[this.nbConstru]      ;
		this.nivConstru          = new int[this.nbConstru]         ;
		this.generationPersonnel = new double[this.nbConstru]      ;


		this.amelioration        = new JButton[this.nbAmelioration];
		this.nivAmelioration     = new int[this.nbAmelioration]    ;

		/*Creation des Panels */
		this.panelConstru      = new JPanel( new GridLayout( this.nbConstru, 1) );
		this.panelAmelioration = new JPanel( new GridLayout( 2, 2)         );

		/*Ajout des Panels */

		this.add(this.panelAmelioration, BorderLayout.NORTH );
		this.add(this.panelConstru     , BorderLayout.CENTER);

		/*Creation des Ameliorations */
		for ( int i = 0; i < this.nbAmelioration; i++ ){  this.amelioration[i] = new JButton() ; this.nivAmelioration[i] = 0; }
		
		
		for ( int i = 0; i < this.nbAmelioration; i++ ){ this.panelAmelioration.add( amelioration[i] );  }
		
		for ( int i = 0; i < this.nbAmelioration; i++ ){ for ( int y = 0; y < this.nivAmelioration[i] ; y++ ){this.setPrixAmelioration(i);}}
		
		
		for ( int i = 0; i < this.nbAmelioration; i++ ){ this.amelioration[i].setText(nomAmelioration[i]); this.amelioration[i].setVisible(false); }
		for ( int i = 0; i < this.nbAmelioration; i++ ){ this.amelioration[i].addActionListener(this); }


		/*Creation des constru */
		for ( int i = 0; i < this.nbConstru; i++ ){  this.construction[i] = new JButton() ; this.nivConstru[i] = 0; this.construction[i].setOpaque(false);}
		
		
		for ( int i = 0; i < this.nbConstru; i++ ){ this.panelConstru.add( construction[i] ); }
		
		for ( int i = 0; i < this.nbConstru; i++ ){ for ( int y = 0; y < this.nivConstru[i]; y++ ){this.setPrixConstru(i);}}
		
		
		for ( int i = 0; i < this.nbConstru; i++ ){ this.construction[i].setText(this.constructionToString(i)); }
		for ( int i = 0; i < this.nbConstru; i++ ){ this.construction[i].addActionListener(this); }

		


		this.setVisible(true);

	}

	/*renvoie la puissance du click */
	public int getClick()
	{	
		int click;
		
		switch (nivAmelioration[0])
		{
			case (0) -> click = 1;
			default  -> click = 2 * nivAmelioration[0];
		}

		return click;
	}

	public boolean achatAmelioration( int amelioration)
	{
		if ( ctrl.getNbCanard() >= this.prixAmelioration[amelioration] )
		{
			 ctrl.modificationNbCanard(-this.prixAmelioration[amelioration]);
			switch (amelioration)
			{
				case (0) -> {   this.nivAmelioration[amelioration] += 1; ctrl.achatAmeliorationNbClick( nivAmelioration[0] ); }
				case (1) -> this.nivAmelioration[amelioration] += 1;
				case (2) -> this.nivAmelioration[amelioration] += 1;
				case (4) -> this.nivAmelioration[amelioration] += 1;
				case (5) -> this.nivAmelioration[amelioration] += 1;
				case (6) -> this.nivAmelioration[amelioration] += 1;
			}
			this.setAmelioration( amelioration - 1);
			return true;
		}
		return false;
	}



	/*change le prix des amelioration après achat de l'amelioration */
	public void setPrixAmelioration(int constru){ this.prixAmelioration[constru] = Math.round(this.prixAmelioration[constru] * 7  ); }



	/*Achat des construction pour farme auto les Canards */
	public boolean achatConstruction(int construction)
	{
		if ( ctrl.getNbCanard() >= this.prixConstru[construction])
		{
			ctrl.modificationNbCanard( -this.prixConstru[construction] );
			this.setGeneration( construction );
			return true;
		}
		
		return false;
	}

	public void setGeneration(int i)
	{	
		switch (i)
			{
				case (0) -> {this.generationPersonnel[i] += 0.1 * Math.pow(2, this.nivAmelioration[i + 1]); }
				case (1) -> {this.generationPersonnel[i] += 1   * Math.pow(2, this.nivAmelioration[i + 1]); }
				case (2) -> {this.generationPersonnel[i] += 10  * Math.pow(2, this.nivAmelioration[i + 1]); }
				case (4) -> {this.generationPersonnel[i] += 15  * Math.pow(2, this.nivAmelioration[i + 1]); }
				case (5) -> {this.generationPersonnel[i] += 22  * Math.pow(2, this.nivAmelioration[i + 1]); }
				case (6) -> {this.generationPersonnel[i] += 34  * Math.pow(2, this.nivAmelioration[i + 1]); }
			}
		
			ctrl.resetGeneration();

			for(int y = 0; y < this.nbConstru; y++){ ctrl.modificationGeneration(this.generationPersonnel[y]);}
	}

	public void setAmelioration( int i )
	{
		switch (i)
			{
				case (0) -> {this.generationPersonnel[i] = this.generationPersonnel[i] * 2; }
				case (1) -> {this.generationPersonnel[i] = this.generationPersonnel[i] * 2; }
				case (2) -> {this.generationPersonnel[i] = this.generationPersonnel[i] * 2; }
				case (4) -> {this.generationPersonnel[i] = this.generationPersonnel[i] * 2; }
				case (5) -> {this.generationPersonnel[i] = this.generationPersonnel[i] * 2; }
				case (6) -> {this.generationPersonnel[i] = this.generationPersonnel[i] * 2; }
			}

			ctrl.resetGeneration();

			for(int y = 0; y < this.nbConstru; y++){ ctrl.modificationGeneration( this.generationPersonnel[y] );}
	}


	/*change le prix des constru après achat de l'amelioration */
	public void setPrixConstru(int constru){ this.prixConstru[constru] = Math.round(this.prixConstru[constru] * 1.35  ); }

	/*Change le niveau des construction */
	public void setNiveauConstru(int constru){ this.nivConstru[constru] += 1; }

	/*rend visible ou non les amelioration*/
	public boolean setVisible( int i )
	{	
		if ( i == 0 ) { if ( ctrl.getNbClick() >= 100 * (nivAmelioration[0] + 1) ){ return true; } return false; }
		else { if ( this.nivConstru[i - 1] >= 10 * (nivAmelioration[i] + 1) ) { return true;} }
		return false;
	}


	/*toString pour les construction */
	public String constructionToString(int constru)
	{
		return "<html>" + this.nomConstru[constru] + "<br/>niveau : " + this.nivConstru[constru] + "<br/>prix :" + String.format("%.0f", this.prixConstru[constru]) + "</html>";
	}

	/* toString pour les amelioration */
	public String ameliorationToString(int amelioration)
	{
		return "<html>" + this.nomAmelioration[amelioration] + "<br/>niveau : " + this.nivAmelioration[amelioration] + "<br/>prix :" + String.format("%.0f", this.prixAmelioration[amelioration]) + "</html>";
	}

	

	public void actionPerformed ( ActionEvent e)
	{
		for ( int i = 0; i < this.nbConstru; i++ )
		{
			if ( e.getSource() == construction[i])
			{
				if ( this.achatConstruction(i) )
				{
					this.setNiveauConstru(i);
					this.setPrixConstru(i);
					this.construction[i].setText(this.constructionToString(i));
					this.ctrl.bruitage("achat");
				};

				
			}
		}

		for (int i = 0; i < this.nbAmelioration; i++)
		{
			if (e.getSource() == amelioration[i])
			{
				if (this.achatAmelioration(i))
				{
					this.setPrixAmelioration(i);
					this.amelioration[i].setText(this.ameliorationToString(i));
				}
				;

			}
		}
		
	}



	/*Actualise le texte sur les constructions */
	public void majIHM()
	{
		for (int i = 0; i <this.nbConstru; i++){this.construction[i].setText(this.constructionToString(i));  }
		for (int i = 0; i <this.nbAmelioration; i++){ this.amelioration[i].setVisible(this.setVisible(i)); this.amelioration[i].setText(this.ameliorationToString(i));  }
		
		
	}
}