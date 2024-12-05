package code.ihm;
/** FrameCanardClicker
  * date    : le 24/02/2024
  * @author : Théo Harel
  */ 

import java.awt.BorderLayout;

import javax.swing.*;

import code.ControleurCanardClicker;

public class FrameCanardClicker extends JFrame
{	
	PanelCanardGeant panelCanard;
	PanelAmelioration panelAmelioration;

	public FrameCanardClicker( ControleurCanardClicker ctrl )
	{
		this.setTitle("CanardClicker");
		this.setLocation(100, 100);
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panelCanard = new PanelCanardGeant( ctrl );
		this.panelAmelioration = new PanelAmelioration( ctrl );
		this.add( panelCanard , BorderLayout.CENTER );
		this.add( panelAmelioration , BorderLayout.EAST );

		this.setVisible(true);
	}

	public int getClick()
	{
		return panelAmelioration.getClick();
	}

	public int getNbClick()
	{
		return panelCanard.getNbClick();
	}

	public void achatAmeliorationNbClick( int nivClick )
	{
		this.panelCanard.achatAmeliorationNbClick( nivClick );
	}

	public void majIHM()
	{
		this.panelAmelioration.majIHM();
		this.panelCanard.majIHM();
	}
}
