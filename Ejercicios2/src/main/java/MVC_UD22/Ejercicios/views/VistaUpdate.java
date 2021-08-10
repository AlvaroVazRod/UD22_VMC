package MVC_UD22.Ejercicios.views;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaUpdate extends JFrame {

	public JTextField nombre, apellidos, direccion, dni, fecha;
	public Button cambiar, cancelar;

	/**
	 * Create the application.
	 */
	public VistaUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 559, 400);
		getContentPane().setLayout(null);

		nombre = new JTextField();
		nombre.setBounds(135, 57, 176, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);

		apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBounds(135, 103, 176, 19);
		getContentPane().add(apellidos);

		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(135, 152, 176, 19);
		getContentPane().add(direccion);

		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(135, 199, 176, 19);
		getContentPane().add(dni);

		fecha = new JTextField();
		fecha.setColumns(10);
		fecha.setBounds(135, 244, 176, 19);
		getContentPane().add(fecha);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 60, 61, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 106, 61, 13);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(41, 155, 84, 13);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(41, 202, 61, 13);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fecha");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(41, 247, 61, 13);
		getContentPane().add(lblNewLabel_4);

		cambiar = new Button("Cambiar");
		cambiar.setBounds(135, 305, 66, 21);
		getContentPane().add(cambiar);

		cancelar = new Button("Cancelar");
		cancelar.setBounds(245, 305, 66, 21);
		getContentPane().add(cancelar);
		this.setVisible(true);

	}
}
