package MVC_UD22.Ejercicios.AppMain;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import MVC_UD22.Ejercicios.controllers.Controlador;
import MVC_UD22.Ejercicios.models.Modelo;
import MVC_UD22.Ejercicios.views.Vista;
 
public class App {
	
 public static void main(String arf[]) {
  try {
   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  } 
  catch (UnsupportedLookAndFeelException e) {
  }
  catch (ClassNotFoundException e) {
  }
  catch (InstantiationException e) {
  }
  catch (IllegalAccessException e) {
  } 
  
  Modelo modelo = new Modelo();
  Vista vista = new Vista();
  Controlador controlador = new Controlador(modelo, vista);
  controlador.iniciarVista();
 }
}
