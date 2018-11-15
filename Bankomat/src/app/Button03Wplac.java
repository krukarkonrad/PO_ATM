package app;

//WPLATA
import java.awt.event.*;
import javax.swing.*;
import infoBox.InfoBox;
import bankomat.Bankomat;


class Button03Wplac extends JButton implements ActionListener, InputBox {

	private InfoBox infoBox = new InfoBox();
	private Bankomat bankomat1;
	private double kwota;

	
	Button03Wplac(JPanel buttonPanel) {
		super("Wp�a�");
		addActionListener(this);
	}

	Button03Wplac(JPanel buttonPanel, Bankomat bankomat1) {
		super("Wp�a�");
		this.bankomat1 = bankomat1;
		addActionListener(this);
	}
   
	@Override
	public void actionPerformed(ActionEvent e) {
		this.kwota=inputBox();
		if(this.kwota!=-1) {
			bankomat1.wplata(this.kwota);
		}else
			infoBox.InfoBox("Blad", "Rezultat");
	}
}
