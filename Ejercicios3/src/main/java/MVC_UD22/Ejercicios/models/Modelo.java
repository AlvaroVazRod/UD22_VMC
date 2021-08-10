package MVC_UD22.Ejercicios.models;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Date;

public class Modelo {

	// Atributos
	private static Connection conexion;
	private int id;
	private String nombre;
	private String 	apellido;
	private String direccion;
	private String dni;
	private Date fecha;

	public Modelo(int id, String nombre, String apellido, String direccion, String dni, Date fecha) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	// Metodos
// Metodo para abrir la conexion
	public void abrirConnec() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.79:9090?useTimezone=true&serverTimezone=UTC",
					"remote", "1234?");
			System.out.println("Servidor conectado.");

		} catch (SQLException | ClassNotFoundException ex) {

			System.out.println("No se pudo conectar con la BD.");
			System.out.println(ex);

		}

	}

// Metodo para cerrar la conexion
	public void cerrarConnec() {
		try {
			conexion.close();
			System.out.println("Conexión finalizada.");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			System.out.println("Error, cerrando conexión.");

		}
	}

// Metodo para insertar datos en la tabla
	public void insertData(String db, String table_name, String nombre, String apellido, String direccion, String dni,
			Date fecha, int id) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + " " + "(Id, Nombre, Apellido, Direccion, Dni, Fecha) Value("
					+ "\"" + id + "\", " + "\"" + nombre + "\", " + "\"" + apellido + "\", " + "\"" + direccion + "\", "
					+ "\"" + dni + "\", " + "\"" + fecha + "\"); ";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar");
		}

	}

//Metodo para coger el valor
	public void getValuesTable(String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			String resultado = "";
			while (resultSet.next()) {

				resultado = resultado + "ID: " + resultSet.getInt("id") + " " + "Nombre: "
						+ resultSet.getString("nombre") + " " + "Apellido " + resultSet.getString("apellido") + " "
						+ "Direccion " + resultSet.getString("direccion") + " " + "Dni" + resultSet.getString("dni")
						+ " " + "Fecha" + resultSet.getDate("fecha") + "\n ";
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}

	}

// Metodo para coger el valor
	public void getValues(String db, String busqueda, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT " + busqueda + " FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt("id") + " " + "Nombre: " + resultSet.getString("nombre")
						+ " " + "Apellido " + resultSet.getString("apellido") + " " + "Direccion "
						+ resultSet.getString("direccion") + " " + "Dni" + resultSet.getString("dni") + " " + "Fecha"
						+ resultSet.getDate("fecha") + " ");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}

	}
	//Metodo que elimina valores de nuestra base de datos
	public void deleteRecord(String table_name, int id) {
		try {
			String Query = "DELETE FROM " + table_name + " WHERE ID = \""+ id + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el regustro espeficado en la tabla"+table_name+" con id "+id);
		}
	}
}
