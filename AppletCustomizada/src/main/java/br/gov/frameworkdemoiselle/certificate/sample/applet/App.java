package br.gov.frameworkdemoiselle.certificate.sample.applet;

import java.applet.Applet;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.swing.JOptionPane;

import br.gov.frameworkdemoiselle.certificate.applet.action.AbstractAppletExecute;
import br.gov.frameworkdemoiselle.certificate.applet.certificate.ICPBrasilCertificate;

public class App extends AbstractAppletExecute
{

	/*� acionado logo ap�s o carregamento da keystore do usu�rio*/
	@Override
	public void execute(KeyStore keystore, String alias, Applet applet) 
	{
		try
		{
			/* Exibe alguns dados do certificado */
			
			/*
			 * O m�todo getICPBrasilCertificate retorna um objeto do tipo ICPBrasilCertificate que possui todas as informa��es 
			 * de um certificado ICPBrasil
			 */
			ICPBrasilCertificate certificado = super.getICPBrasilCertificate(keystore, alias, false); 
			/*	
			 * Os m�todos setFormField escrevem no formul�rio html chamado de mainForm no qual a applet est� sendo executado.
			 *  O terceiro par�metro do m�todo informa em qual campo do formul�rio a informa��o ser� registrada.
			 */
			AbstractAppletExecute.setFormField(applet, "mainForm", "cpf", certificado.getCpf());
			AbstractAppletExecute.setFormField(applet, "mainForm", "nome", certificado.getNome());
			AbstractAppletExecute.setFormField(applet, "mainForm", "nascimento", certificado.getDataNascimento());
			AbstractAppletExecute.setFormField(applet, "mainForm", "email", certificado.getEmail());
		} catch (KeyStoreException e)
		{
			JOptionPane.showMessageDialog(applet, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * O m�todo cancel pode ser utilizado para implementar uma a��o no caso do usu�rio desistir da a��o. 
	 * No c�digo de exemplo � feito apenas a oculta��o da applet.
	 */
	@Override
	public void cancel(KeyStore keystore, String alias, Applet applet)
	{
		/* Seu codigo customizado aqui... */
	}

}
