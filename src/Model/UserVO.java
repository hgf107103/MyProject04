package Model;

public class UserVO {
	private String name;
    private String id;
    private String pwd;
    private String sex;

    public UserVO(String name, String id, String pwd, String sex) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.sex = sex;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
    
}
