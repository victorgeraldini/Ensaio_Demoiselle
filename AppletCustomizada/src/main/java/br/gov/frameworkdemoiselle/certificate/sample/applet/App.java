package br.gov.frameworkdemoiselle.certificate.sample.applet;

import java.applet.Applet;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.swing.JOptionPane;

import br.gov.frameworkdemoiselle.certificate.applet.action.AbstractAppletExecute;
import br.gov.frameworkdemoiselle.certificate.applet.certificate.ICPBrasilCertificate;

public class App extends AbstractAppletExecute
{

	/*É acionado logo após o carregamento da keystore do usuário*/
	@Override
	public void execute(KeyStore keystore, String alias, Applet applet) 
	{
		try
		{
			/* Exibe alguns dados do certificado */
			
			/*
			 * O método getICPBrasilCertificate retorna um objeto do tipo ICPBrasilCertificate que possui todas as informações 
			 * de um certificado ICPBrasil
			 */
			ICPBrasilCertificate certificado = super.getICPBrasilCertificate(keystore, alias, false); 
			/*	
			 * Os métodos setFormField escrevem no formulário html chamado de mainForm no qual a applet está sendo executado.
			 *  O terceiro parâmetro do método informa em qual campo do formulário a informação será registrada.
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
	 * O método cancel pode ser utilizado para implementar uma ação no caso do usuário desistir da ação. 
	 * No código de exemplo é feito apenas a ocultação da applet.
	 */
	@Override
	public void cancel(KeyStore keystore, String alias, Applet applet)
	{
		/* Seu codigo customizado aqui... */
	}

}
