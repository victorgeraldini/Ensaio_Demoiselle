import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JButton;

public class App extends JApplet
{
	public void init()
	{
		setLayout(new BorderLayout());
		add(new JButton("norte"),BorderLayout.NORTH);
	}
}
