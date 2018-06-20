public class DTO {
	private String name;
	private int kor, mat, eng, tot, ave, number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getAve() {
		return ave;
	}

	public void setAve(int ave) {
		this.ave = ave;
	}

	@Override
	public String toString() {
		return "ScoreDTO [name=" + name + ", kor=" + kor + ", mat=" + mat + ", eng=" + eng + ", tot=" + tot + ", ave="
				+ ave + "]";
	}
}