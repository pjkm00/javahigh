package middle.read;

public class StudentsInfo {
	public int stuId = 0;
	public String stuName = null;
	public String stuPass = null;
	
	public StudentsInfo(int stuId, String stuName, String stuPass) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPass = stuPass;
	}
	
	public int getStuId() {
		return stuId;
	}
	public void setStuID(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPass() {
		return stuPass;
	}
	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}
	
}
