package com.springmvcmaven.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springmvcmaven.controllerform.SMEPojo;

@Component
public class SearchDAOImpl {
	
	public void insertSMETopic(String topic) {
		System.out.println("#####insertSMETopic method 1#####");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sme", 
					"root",
					"********");
			System.out.println("#####insertSMETopic method 2 Databse connection estrablicshed#####");
			PreparedStatement ps = con.prepareStatement("select * from search_table where Search_Name = ?");
			ps.setString(1, topic);
			ResultSet rs = ps.executeQuery();
			int searchCount = 0;
			while(rs.next()) {
				searchCount = rs.getInt(3);
			}
			System.out.println("#####insertSMETopic method 3##### search count value "+searchCount);
			String updateQuery = "";
			if(searchCount == 0) {
				System.out.println("#####insertSMETopic method 4##### search count is 0 inserting newly into database");
				updateQuery = "insert into search_table (Search_Name, Search_Count) values(?,?)";
				ps = con.prepareStatement(updateQuery);
				ps.setString(1, topic);
				ps.setInt(2, searchCount+1);
			} else {
				System.out.println("#####insertSMETopic method 5##### updating search count value");
				updateQuery = "update search_table set Search_count =? where Search_Name =?";
				ps = con.prepareStatement(updateQuery);
				ps.setInt(1, searchCount+1);
				ps.setString(2, topic);
			}
			
			ps.executeUpdate();
			System.out.println("#####insertSMETopic method 6##### updated table");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public ArrayList<SMEPojo> getSMEList(String topic) {
		ArrayList<SMEPojo> smeList = new ArrayList<SMEPojo>();
		
		
		/*for(int i =0; i<3; i++) {
			SMEPojo pojo = new SMEPojo();
			pojo.setFirstName("sai"+i);
			pojo.setLastName("kaushik"+i);
			pojo.setID("121212"+i);
			pojo.setSkills("Devops"+i);
			smeList.add(pojo);
		}*/
		try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sme", 
					"root",
					"*******");
			Statement st = con.createStatement();
			String query = "select * from sme";
			System.out.println(query);
			ResultSet rs = st.executeQuery("select * from sme  where skills like '%"+topic+"%'");
			while(rs.next()) {
				SMEPojo pojo = new SMEPojo();
				pojo.setFirstName(rs.getString(1));
				pojo.setLastName(rs.getString(2));
				pojo.setID(rs.getString(3));
				pojo.setSkills(rs.getString(4));
				smeList.add(pojo);
				/*System.out.println();
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));*/
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return smeList;
	}
	public int insertSME(SMEPojo pojo) {
		int id = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sme", 
					"root",
					"*******");
			PreparedStatement ps = con.prepareStatement("insert into SME values(?,?,?,?,?,?)");
			ps.setString(1, pojo.getFirstName());
			ps.setString(2, pojo.getLastName());
			ps.setString(3, pojo.getID());
			ps.setString(4, pojo.getSkills());
			ps.setInt(5, pojo.getRating());
			ps.setString(6, pojo.getYourname());
			 id = ps.executeUpdate();
			System.out.println("id value:::::"+id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String insertQuery = "insert into SME values(?,?,?,?,?,?)";
		
		
		
		return id;
	}
	
	
	public String getTopSearchList() {
		//1
		List<String> searchList = new ArrayList<String>();
		StringBuffer searchString = new StringBuffer("");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sme", 
					"root",
					"*********");
			//2
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select Search_Name from search_table order by Search_Count desc limit 3");
			//3
			while(rs.next()) {
			//4
				searchString.append(rs.getString(1));
				searchString.append(",");
				System.out.println("*4**"+searchList.toString());
				//searchList.add(rs.getString(1));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.println("--5--");
		//5
		return searchString.toString();
	}
}
