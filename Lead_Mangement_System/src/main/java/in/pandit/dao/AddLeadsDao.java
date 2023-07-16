package in.pandit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.pandit.Entity.ClientListEntity;
import in.pandit.Entity.LeadListEntity;
import in.pandit.persistance.DatabaseConnection;

public class AddLeadsDao {
	private static final String ADD_LEAD = "INSERT INTO lead_list(lead_id,client_id,source_id,interested_in,remarks,assigned_to,user_id,status) VALUES(?,?,?,?,?,?,?,?)";
	private static final String ADD_CLIENT = "INSERT INTO client_list(id,firstname,lastname,gender,dob,contact,email,address) VALUES(?,?,?,?,?,?,?,?)";
	
	public static int addLead(ClientListEntity ce,LeadListEntity le,int user_id) {
		int i2 = 0;
		try {
			i2 = AddLeadsDao.addLeadInfo(ce, le, user_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return i2;
	}
	
	public static String addClient(ClientListEntity ce) {
		int i = 0;
		Connection con = DatabaseConnection.getConnection();
		String id = Long.toString(System.currentTimeMillis());
		try {
			PreparedStatement pst = con.prepareStatement(ADD_CLIENT);
			pst.setString(1,id);
			pst.setString(2,ce.getFirstname());
			pst.setString(3,ce.getLastname());
			pst.setString(4,ce.getGender());
			pst.setString(5,ce.getDob()+"");
			pst.setString(6,ce.getContact());
			pst.setString(7,ce.getEmail());
			pst.setString(8,ce.getAddress());
			
			i = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return id;
		}else {
			return id=null;
		}
	}
	
	public static int addLeadInfo(ClientListEntity client,LeadListEntity le,int user_id) {
		int i1 = 0;
		Connection con1 = DatabaseConnection.getConnection();
		try {
			String client_id = AddLeadsDao.addClient(client);
			String lead_id = Long.toString(System.currentTimeMillis());
			if(client_id!=null) {
				PreparedStatement pst = con1.prepareStatement(ADD_LEAD);
				pst.setString(1,lead_id);
				pst.setString(2,client_id);
				pst.setString(3,le.getSource_id());
				pst.setString(4,le.getInterested_in());
				pst.setString(5,le.getRemarks());
				pst.setString(6,le.getAssigned_to());
				pst.setInt(7,user_id);
				pst.setString(8,le.getStatus());
				i1 = pst.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i1;
	}
}
