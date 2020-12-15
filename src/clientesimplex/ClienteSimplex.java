package clientesimplex;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.Gui;

public class ClienteSimplex {
	
	public static String direccion = "localhost";
	public static int puerto = 9090;

	public static void main(String[] args) {

		Scanner scan;
		PrintWriter pr;
		
		try {
			
					
			
			Socket socket = new Socket(direccion, puerto); //conectamos el socket a la direccion y el puerto
					
			scan = new Scanner(System.in);
			pr = new PrintWriter(socket.getOutputStream());
			
			Gui gui = new Gui();
			
			while(scan.hasNextLine()) {
				
				String linea = scan.nextLine();
				pr.println(linea);
				pr.flush();
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "NO SE HA PODIDO CONECTAR CON EL SERVIDOR\n"
					+ "- Comprueba que el servidor está levantado\n"
					+ "- Comprueba la dirección y el puerto\n"
					+ "- Si tratas de conectarte a una ip pública, comprueba que el puerto está abierto\n"
					+ "- Ejecuta la aplicación en modo consola para ver más detalles");
		}

	}
	
	public static void actualizaPuerto(int puerto) {
		ClienteSimplex.puerto = puerto;
	}

}
