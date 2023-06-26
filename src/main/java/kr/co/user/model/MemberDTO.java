package kr.co.user.model;

public class MemberDTO {
	String id;
	String pw;
	String name;
	String phone;
	String email;
	String statetype;
	String roletype;
	
	public MemberDTO(String id, String pw, String name, String phone, String email, String statetype,String roletype) {
		this.id = id;
		this.pw = pw;
		this.name = name;	
		this.phone = phone;
		this.email = email;
		this.statetype = statetype;
		this.roletype = roletype;
	}

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatetype() {
		return statetype;
	}

	public void setStatetype(String statetype) {
		this.statetype = statetype;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
}
