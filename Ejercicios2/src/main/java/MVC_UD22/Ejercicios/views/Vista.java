package MVC_UD22.Ejercicios.views;

<<<<<<< Updated upstream
public class Vista {

=======

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Button;

public class Vista extends JFrame{

	public JTable table;
	public Button insert, update, delete;

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 624, 423);
		this.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(24, 29, 438, 317);
		this.getContentPane().add(table);
		
		insert = new Button("Insertar");
		insert.setBounds(495, 48, 66, 21);
		this.getContentPane().add(insert);
		
		update = new Button("Actualizar");
		update.setBounds(495, 96, 66, 21);
		this.getContentPane().add(update);
		
		delete = new Button("Eliminar");
		delete.setBounds(495, 148, 66, 21);
		this.getContentPane().add(delete);
	}
>>>>>>> Stashed changes
}
