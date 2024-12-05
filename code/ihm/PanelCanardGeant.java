package code.ihm;
/** PanelCanardGeant
  * date    : le 24/02/2024
  * @author : Théo Harel
  */ 


import java.awt.BorderLayout;

import javax.swing.*;

import code.ControleurCanardClicker;

import java.awt.event.*;

public class PanelCanardGeant extends JPanel implements ActionListener
{	
	private int nbClick = 0   ;

	private JButton CanardBouton;
	private JLabel  lblCanard   ;

	private ControleurCanardClicker ctrl;

	public PanelCanardGeant( ControleurCanardClicker ctrl)
	{	
		this.ctrl = ctrl;

		this.CanardBouton = new JButton(new ImageIcon("../../fichier/image/Canard.png"));
		this.lblCanard    = new JLabel("0 Canard");

		this.setLayout( new BorderLayout() );
		this.add(this.CanardBouton, BorderLayout.CENTER);
		this.add(this.lblCanard   , BorderLayout.NORTH );

		this.CanardBouton.addActionListener(this);

		this.setVisible(true);
	}

	/*Actualise l'affichage du nombre de Canard */
	public void majIHM()
	{
		this.lblCanard.setText("<html>" + String.format("%.1f", ctrl.getNbCanard()) + " Canard" + "<br/>" + "Generation : " + String.format("%.1f" , ctrl.getGeneration()) + " (Canard/s)" + "</html>");
	}

	public int  getNbClick(){ return this.nbClick; }
	public void achatAmeliorationNbClick( int nivClick ){ this.nbClick -= 100 * nivClick; }

	public void actionPerformed ( ActionEvent e)
	{
		if ( e.getSource() == this.CanardBouton)
		{
			ctrl.clickCanard();
			this.ctrl.majIHM();
			this.nbClick += 1;
			this.ctrl.bruitage( "pet" );
		}
	}
}