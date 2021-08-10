package MVC_UD22.Ejercicios.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import MVC_UD22.Ejercicios.models.Modelo;
import MVC_UD22.Ejercicios.views.*;


public class Controlador implements ActionListener{
	
	private Modelo modelo;
	private Vista vista;
	
	
	public Controlador(Modelo mod, Vista vis)
	{
		this.modelo = mod;
		this.vista=vis;
		this.vista.insert.addActionListener(this);
		this.vista.update.addActionListener(this);
		this.vista.delete.addActionListener(this);
	}

	public void iniciarVista()
	{
		vista.setTitle("CRUD TABLA CLIENTES");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		modelo.getValuesTable("Empresa", "cliente");
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		if(vista.insert == evento.getSource())
		{
			VistaInsert vInsert = new VistaInsert();
			ControladorInsert cInsert = new ControladorInsert(this.modelo, vInsert);
			cInsert.iniciarVista();
		}
<<<<<<< Updated upstream
		/***
=======
>>>>>>> Stashed changes
		else
		{
			if(vista.update == evento.getSource())
			{
				VistaUpdate vUpdate = new VistaUpdate();
				ControladorUpdate cUpdate = new ControladorUpdate(this.modelo, vUpdate);
				cUpdate.iniciarVista();
			}
			else
			{
				if(vista.delete == evento.getSource())
<<<<<<< Updated upstream
				{
					VistaDelete vDelete = new VistaDelete();
					ControladorDelete cDelete = new ControladorDelete(this.modelo, vDelete);
					cDelete.iniciarVista();
				}
			}
		}
		***/
=======
				{ 
					int id = 0;
					modelo.deleteRecord("cliente", id );
					//esto hay que cambiarlo
				}
			}
		}
>>>>>>> Stashed changes
	}
	
}
