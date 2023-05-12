package middle.read;

public class LectureList {
	public int lecno = 0;
	public String lecname = null;
	public String lecprofessor = null;
	public String lecloc = null;
	public int lecscore = 0;
	public int leccredit = 0;
	public String lecdiv = null;
	public int lecyear = 0;
	
	
	public int getLecno() {
		return lecno;
	}


	public void setLecno(int lecno) {
		this.lecno = lecno;
	}


	public String getLecname() {
		return lecname;
	}


	public void setLecname(String lecname) {
		this.lecname = lecname;
	}


	public String getLecprofessor() {
		return lecprofessor;
	}


	public void setLecprofessor(String lecprofessor) {
		this.lecprofessor = lecprofessor;
	}


	public String getLecloc() {
		return lecloc;
	}


	public void setLecloc(String lecloc) {
		this.lecloc = lecloc;
	}


	public int getLecscore() {
		return lecscore;
	}


	public void setLecscore(int lecscore) {
		this.lecscore = lecscore;
	}


	public int getLeccredit() {
		return leccredit;
	}


	public void setLeccredit(int leccredit) {
		this.leccredit = leccredit;
	}


	public String getLecdiv() {
		return lecdiv;
	}


	public void setLecdiv(String lecdiv) {
		this.lecdiv = lecdiv;
	}


	public int getLecyear() {
		return lecyear;
	}


	public void setLecyear(int lecyear) {
		this.lecyear = lecyear;
	}


	public LectureList(int lecno, String lecname, String lecprofessor, String lecloc, int lecscore, int leccredit,
			String lecdiv, int lecyear) {
		super();
		this.lecno = lecno;
		this.lecname = lecname;
		this.lecprofessor = lecprofessor;
		this.lecloc = lecloc;
		this.lecscore = lecscore;
		this.leccredit = leccredit;
		this.lecdiv = lecdiv;
		this.lecyear = lecyear;
	}
	
}
