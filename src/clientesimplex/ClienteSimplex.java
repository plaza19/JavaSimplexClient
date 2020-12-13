package clientesimplex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClienteSimplex {

	public static void main(String[] args) {
		
		String direccion = "localhost";
		int puerto = 9090;
		Scanner scan;
		PrintWriter pr;
		
		try {
			Socket socket = new Socket(direccion, puerto); //conectamos el socket a la direccion y el puerto
			
			scan = new Scanner(System.in);
			pr = new PrintWriter(socket.getOutputStream());
			
			while(scan.hasNextLine()) {
				
				String linea = scan.nextLine();
				pr.println(linea);
				pr.flush();
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "NO SE HA PODIDO CONECTAR CON EL SERVIDOR\n"
					+ "- Comprueba que el servidor est� levantado\n"
					+ "- Comprueba la direcci�n y el puerto\n"
					+ "- Si tratas de conectarte a una ip p�blica, comprueba que el puerto est� abierto\n"
					+ "- Ejecuta la aplicaci�n en modo consola para ver m�s detalles");
		}

	}

}
