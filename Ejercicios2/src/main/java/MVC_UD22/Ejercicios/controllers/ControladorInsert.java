package MVC_UD22.Ejercicios.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import MVC_UD22.Ejercicios.models.Modelo;
import MVC_UD22.Ejercicios.views.*;

public class ControladorInsert implements ActionListener{

	private Modelo modelo;
	private VistaInsert vista;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int dni;
	private Date data;
	
	public ControladorInsert(Modelo mod, VistaInsert vis)
	{
		this.modelo = mod;
		this.nombre = "";
		this.apellidos= "";
		this.direccion = "";
		this.dni = 0;
		this.data = null;
		this.vista=vis;
		this.vista.aceptar.addActionListener(this);
		this.vista.cancelar.addActionListener(this);
	}

	public void iniciarVista()
	{
		vista.setTitle("Insertar cliente");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
	
	private Date convertToDate(String date) {
	    try {
	        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy,HH:mm:ss aaa");
	        return (Date) formatter.parse(date);
	    } catch (ParseException e) {
	       JOptionPane.showMessageDialog(null, "El formato de la fecha es incorrecto...");;
	    }
	    return null;
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		if(vista.aceptar == evento.getSource())
		{
			
			if(!"".equals(vista.nombre.getText())) {
				nombre = vista.nombre.getText();
			}
			if(!"".equals(vista.apellidos.getText()))
			{
				apellidos = vista.apellidos.getText();	
			}
			if(!"".equals(vista.direccion.getText()))
			{
				direccion = vista.direccion.getText();
			}
			if(!"".equals(vista.dni.getText()))
			{
				try {
					dni = Integer.parseInt(vista.dni.getText());
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El formato del dni es incorrecto...");
				}
			}
			if(!"".equals(vista.fecha.getText()))
			{
				data = convertToDate(vista.fecha.getText());
			}
			modelo.insertData("Empresa","cliente", nombre, apellidos, direccion, dni, data);
			vista.nombre.setText("");
			vista.apellidos.setText("");
			vista.direccion.setText("");
			vista.dni.setText("");
			vista.fecha.setText("");
		}else if (vista.cancelar == evento.getSource())
		{
			vista.nombre.setText("");
			vista.apellidos.setText("");
			vista.direccion.setText("");
			vista.dni.setText("");
			vista.fecha.setText("");
			vista.setVisible(false);
		}
	}
}
