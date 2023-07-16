package in.pandit.Entity;

import java.io.Serializable;

public class LeadListEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String lead_id;
	private String client_id;
	private String code;
	private String source_id;
	private String interested_in;
	private String remarks;
	private String assigned_to;
	private String user_id;
	private String status;
	public LeadListEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeadListEntity(String lead_id, String client_id, String code, String source_id, String interested_in,
			String remarks, String assigned_to, String user_id, String status) {
		super();
		this.lead_id = lead_id;
		this.client_id = client_id;
		this.code = code;
		this.source_id = source_id;
		this.interested_in = interested_in;
		this.remarks = remarks;
		this.assigned_to = assigned_to;
		this.user_id = user_id;
		this.status = status;
	}
	public String getLead_id() {
		return lead_id;
	}
	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getInterested_in() {
		return interested_in;
	}
	public void setInterested_in(String interested_in) {
		this.interested_in = interested_in;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
