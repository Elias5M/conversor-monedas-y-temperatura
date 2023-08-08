import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PagePrincipal {

	private JFrame frame;
	private JLabel tituloConversor;
	private JButton btnTemperatura;
	private JLabel imgMoneda;
	private JLabel imgEmote;
	private JButton btnMoneda;
	private JLabel etiquetaAutor;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagePrincipal window = new PagePrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PagePrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(52, 100, 197));
		frame.setBounds(100, 100, 440, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnTemperatura = new JButton("Temperatura");
		btnTemperatura.setBounds(232, 134, 133, 64);
		frame.getContentPane().add(btnTemperatura);
		btnTemperatura.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PageTemperatura ventanaTemperatura = new PageTemperatura();
		        ventanaTemperatura.main(null); // Abre la ventana de temperatura
		        frame.dispose(); // Cierra la ventana principal
		    }
		});
		
		tituloConversor = new JLabel("CONVERSOR");
		tituloConversor.setHorizontalAlignment(SwingConstants.CENTER);
		tituloConversor.setForeground(new Color(255, 255, 255));
		tituloConversor.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		tituloConversor.setBounds(145, 40, 133, 52);
		frame.getContentPane().add(tituloConversor);
		
		btnMoneda = new JButton("Monedas");
		btnMoneda.setBackground(new Color(255, 255, 255));
		btnMoneda.setBounds(66, 134, 133, 64);
		frame.getContentPane().add(btnMoneda);
		btnMoneda.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PageMoneda ventanaMoneda = new PageMoneda();
		        ventanaMoneda.main(null); // Abre la ventana de moneda
		        frame.dispose(); // Cierra la ventana principal
		    }
		});
		
		imgMoneda = new JLabel("");
		imgMoneda.setIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\moneda.png"));
		imgMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		imgMoneda.setBounds(66, 223, 133, 133);
		frame.getContentPane().add(imgMoneda);
		
		imgEmote = new JLabel("");
		imgEmote.setIcon(new ImageIcon("C:\\Users\\asus\\Downloads\\sudando.png"));
		imgEmote.setHorizontalAlignment(SwingConstants.CENTER);
		imgEmote.setBounds(232, 223, 133, 133);
		frame.getContentPane().add(imgEmote);
		
		etiquetaAutor = new JLabel("autor: Elias5m");
		etiquetaAutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		etiquetaAutor.setForeground(new Color(255, 255, 255));
		etiquetaAutor.setBackground(new Color(255, 255, 255));
		etiquetaAutor.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaAutor.setBounds(10, 376, 91, 14);
		frame.getContentPane().add(etiquetaAutor);
	}
}
