import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PageTemperatura {

	private JFrame frame;
	private JLabel tituloTemperatura;
	private JLabel etiquetaCombo;
	private JComboBox<Temperaturas> listaCombo;
	private JLabel etiquetaCantidad;
	private JTextField textoCantidad;
	private JButton btnConvertir;
	private JLabel etiquetaResultado;
	private JButton btnVolver;

	
	//Creando la lista desplegable
	public enum Temperaturas{
		celsius_fahrenheit,
		celsius_kelvin,
		fahrenheit_celsius,
		fahrenheit_kelvin,
		kelvin_fahrenheit,
		kelvin_celsius,
	}
		
	/**
	//Asignado conversiones ¿Cuanto vale un sol en cada moneda?
	public double dolar = 3.68;
	public double euro = 4.04;
	public double libra = 4.69;
	*/
	
	//Creando variable de entrada
	public double valorInput = 0.00;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageTemperatura window = new PageTemperatura();
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
	public PageTemperatura() {
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
		
		tituloTemperatura = new JLabel("TEMPERATURA");
		tituloTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		tituloTemperatura.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
		tituloTemperatura.setForeground(new Color(255, 255, 255));
		tituloTemperatura.setBounds(107, 35, 209, 47);
		frame.getContentPane().add(tituloTemperatura);
		
		listaCombo = new JComboBox<Temperaturas>();
		listaCombo.setModel(new DefaultComboBoxModel<>(Temperaturas.values()));
		listaCombo.setBounds(107, 112, 209, 29);
		frame.getContentPane().add(listaCombo);
		
		
		//añadiendo evento del boton convertir
		btnConvertir = new JButton("Convertir");
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btnConvertir.setBounds(166, 239, 89, 23);
		frame.getContentPane().add(btnConvertir);
		
		textoCantidad = new JTextField();
		textoCantidad.setBounds(158, 176, 108, 29);
		frame.getContentPane().add(textoCantidad);
		textoCantidad.setColumns(10);
		
		etiquetaCombo = new JLabel("Elige uno:");
		etiquetaCombo.setForeground(new Color(255, 255, 255));
		etiquetaCombo.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaCombo.setBounds(37, 110, 60, 31);
		frame.getContentPane().add(etiquetaCombo);
		
		etiquetaCantidad = new JLabel("Valor:");
		etiquetaCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaCantidad.setForeground(Color.WHITE);
		etiquetaCantidad.setBounds(92, 174, 60, 31);
		frame.getContentPane().add(etiquetaCantidad);
		
		etiquetaResultado = new JLabel("Aqui tu resultado");
		etiquetaResultado.setBackground(new Color(255, 255, 0));
		etiquetaResultado.setFont(new Font("Arial Black", Font.PLAIN, 14));
		etiquetaResultado.setForeground(new Color(255, 255, 0));
		etiquetaResultado.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaResultado.setBounds(35, 293, 354, 29);
		frame.getContentPane().add(etiquetaResultado);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(325, 367, 89, 23);
		frame.getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        PagePrincipal ventanaPrincipal = new PagePrincipal();
		        ventanaPrincipal.main(null); // Abre la ventana principal
		        frame.dispose(); // Cierra la ventana de moneda
		    }
		});
	}
	
	public void Convertir(){
		
		if (Valido(textoCantidad.getText())){
			
			Temperaturas temperaturas = (Temperaturas) listaCombo.getSelectedItem();
			
			double resultado;
			
			switch (temperaturas) {			
			
			case celsius_fahrenheit:
				resultado = (valorInput*9/5)+32;
				etiquetaResultado.setText(Redondea(resultado));
				break;
				
			case celsius_kelvin:
				resultado = (valorInput+273.15);
				etiquetaResultado.setText(Redondea(resultado));
				break;
			
			case fahrenheit_celsius:
				resultado = (valorInput-32)*5/9;
				etiquetaResultado.setText(Redondea(resultado));
				break;
			
			case fahrenheit_kelvin:
				resultado = (valorInput-32)*5/9+273.15;
				etiquetaResultado.setText(Redondea(resultado));
				break;
			
			case kelvin_fahrenheit:
				resultado = (valorInput-273.15)*9/5+32;
				etiquetaResultado.setText(Redondea(resultado));
				break;
			
			case kelvin_celsius:
				resultado = (valorInput-273.15);
				etiquetaResultado.setText(Redondea(resultado));
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + temperaturas);
			}
		}
	}
	
	/**
	public void SolAMoneda (double moneda) {
		double resultado = valorInput / moneda;
		etiquetaResultado.setText(Redondea(resultado));
	}
	
	public void MonedaASol (double moneda) {
		double resultado = valorInput * moneda;
		etiquetaResultado.setText(Redondea(resultado));
	} */

	
	public String Redondea(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	
	//Metodo para validar si el input ingresado es valido
	public boolean Valido(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if (x > 0);
			valorInput = x;
			return true;
			
		}catch (NumberFormatException e){
			etiquetaResultado.setText("Solamente numeros!");
			return false;
			}
	}
}

