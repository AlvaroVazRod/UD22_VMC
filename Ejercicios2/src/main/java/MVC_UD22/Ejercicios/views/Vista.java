package MVC_UD22.Ejercicios.views;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class Vista extends JFrame {

	public JTable table;
	public Button insert, update, delete;
	private DefaultTableModel model;

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
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		String[] columnNames = { "ID", "Nombre", "Apellidos", "Direccion", "DNI", "Fecha" };
		// creo un modelo de datos, sin datos por eso 'null' y establezco los
		// nombres de columna
		model = new DefaultTableModel(null, columnNames);
		// creo la tabla con el modelo de datos creado
		table = new JTable(model);
		table.setBounds(24, 48, 438, 298);
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

		this.setVisible(true);
	}
}
