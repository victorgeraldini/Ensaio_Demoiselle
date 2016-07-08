package br.gov.frameworkdemoiselle.certificate.sample.applet;

import java.security.KeyStore;

import javax.swing.JApplet;
import javax.swing.JButton;

import br.gov.frameworkdemoiselle.certificate.applet.view.JKeyStoreDialog;
import br.gov.frameworkdemoiselle.certificate.applet.view.JKeyStorePanel;
import br.gov.frameworkdemoiselle.certificate.applet.view.JPanelApplet;

public class Teste extends JApplet
{
	public void init()
	{
		JKeyStorePanel keyStorePanel = new JKeyStorePanel();
		this.getContentPane().add(keyStorePanel);	
		
//		JKeyStoreDialog dialog = new JKeyStoreDialog();
//		dialog.setModal(true);
//		dialog.setVisible(true);
//
//		KeyStore keystoreDialog = dialog.getKeyStore();
		
//		JPanelApplet applet = new JPanelApplet();
	}
}
