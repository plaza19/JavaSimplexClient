package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.OptionPaneUI;

import clientesimplex.ClienteSimplex;


public class Gui extends JFrame {
	
	JScrollPane jsp;
	JTextArea text_area = new JTextArea();
	JMenuBar menu_bar = new JMenuBar();
	JMenu menu_config = new JMenu("Configuración");
	JMenu menu_opciones = new JMenu("Opciones");
	JMenu menu_ayuda = new JMenu("Ayuda");
	JMenuItem item_config_direccion = new JMenuItem("Configurar dirección");
	JMenuItem item_config_puerto = new JMenuItem("Configurar puerto");
	JButton btn_enviar = new JButton("Enviar");
	JTextField text_enviar = new JTextField();

	public Gui() {
		
		//añadimos los elementos a la barra del menú
		menu_bar.add(menu_config);
		menu_config.add(item_config_direccion);
		menu_config.add(item_config_puerto);
		menu_bar.add(menu_opciones);
		menu_bar.add(menu_ayuda);
		
		//listeners de las opciones del menu
		item_config_direccion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane optionpane = new JOptionPane();
				String resultado = optionpane.showInputDialog(null, "Introduce la nueva dirección por favor");
				
				
			}
		});
		
		item_config_puerto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					JOptionPane optionpane = new JOptionPane();
					String nuevo_puerto = optionpane.showInputDialog(null, "Introduce el nuevo puerto por favor");
					ClienteSimplex.actualizaPuerto(Integer.parseInt(nuevo_puerto));
					System.out.println("El nuevo puerto es: " + ClienteSimplex.puerto);
				}catch(Exception ex) {
					JOptionPane error = new JOptionPane();
					error.showMessageDialog(null, "-El puerto es un número", "ERROR", JOptionPane.ERROR_MESSAGE, UIManager.getIcon("OptionPane.errorIcon"));
				}
				
				
				
				
			}
		});
		
		//elementos del panel central
		jsp = new JScrollPane(text_area);
		text_area.setEditable(false);
		
		//seccion para enviar elementos al servidor
		JPanel panel_enviar = new JPanel();
		panel_enviar.setLayout(new BorderLayout());
		panel_enviar.add(text_enviar, BorderLayout.CENTER);
		panel_enviar.add(btn_enviar, BorderLayout.LINE_END);
		
		
		
		
		//Modificaciones generales de la ventana
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setTitle("ClienteSimpleX");
		add(menu_bar, BorderLayout.NORTH);
		add(jsp);
		add(panel_enviar, BorderLayout.SOUTH);
		setVisible(true);
		
	}
	
}
