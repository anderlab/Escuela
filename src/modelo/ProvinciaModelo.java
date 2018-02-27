package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinciaModelo extends Conector {

	public Provincia get(int id) {

		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from provincias where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Provincia provincia = new Provincia();
				provincia.setId(id);
				provincia.setNombre(rs.getString("nombre"));

				return provincia;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
