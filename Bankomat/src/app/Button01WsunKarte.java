package app;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import infoBox.InfoBox;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bankomat.Bankomat;
import bankomat.Karta;


class Button01WsunKarte extends JButton implements ActionListener {

    private InfoBox infoBox = new InfoBox();
	private JPanel buttonPanel;
	private Bankomat bankomat1;
	private Karta karta;
	private int pin;
	
	Button01WsunKarte() {
		super("Wsun kart");
		addActionListener(this);
	}

	Button01WsunKarte(Bankomat bankomat1, Karta karta) {
		super("Wsun karte");
		this.bankomat1 = bankomat1;
		this.karta=karta;
		addActionListener(this);
	}
	    
    public void inputBox() throws BankomatExp, BankomatExpTwo {
    	String temp;
    	temp= JOptionPane.showInputDialog(null,"Wprowadz pin");
    	    	
    	try {
    	this.pin = Integer.parseInt(temp);
    	}catch (NumberFormatException e) {
    		infoBox.InfoBox("Pin sklada si� z cyfr", "Blad");
    	}
    	
    	if(this.pin==0) {
    		throw new BankomatExp();
    	}
    	
    	if(temp.length()<4) {
    		throw new BankomatExpTwo();
    	}
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(Color.YELLOW);

		try {
			inputBox();
		} catch (BankomatExp | BankomatExpTwo e1) {
			
		}
		bankomat1.wlozKarte(karta, pin);
		infoBox.InfoBox(karta.odblokuj(pin),"Rezultat");
	}
}
