package it.polito.tdp.artsmia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.artsmia.model.ArtObject;
import it.polito.tdp.artsmia.model.ExhibitionObject;

public class ArtsmiaDAO {

	public List<ArtObject> listObjects() {
		
		String sql = "SELECT * from objects";
		List<ArtObject> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				ArtObject artObj = new ArtObject(res.getInt("object_id"), res.getString("classification"), res.getString("continent"), 
						res.getString("country"), res.getInt("curator_approved"), res.getString("dated"), res.getString("department"), 
						res.getString("medium"), res.getString("nationality"), res.getString("object_name"), res.getInt("restricted"), 
						res.getString("rights_type"), res.getString("role"), res.getString("room"), res.getString("style"), res.getString("title"));
				
				result.add(artObj);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<ExhibitionObject> listaAdiacenze(){
		String sql = "select eo1.object_id as ob1, eo2.object_id as ob2, count(*) as cnt " + 
				"from exhibition_objects eo1, exhibition_objects eo2 " + 
				"where eo1.exhibition_id = eo2.exhibition_id and eo1.object_id > eo2.object_id " + 
				"group by eo1.object_id, eo2.object_id";
		
		List<ExhibitionObject> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				ExhibitionObject adiacenze = new ExhibitionObject(res.getInt("ob1"), res.getInt("ob2"), res.getInt("cnt"));
				
				result.add(adiacenze);
				
			}
			
			conn.close();
			return result;

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
