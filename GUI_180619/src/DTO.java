public class DTO {
	private String name;
	private int kor, eng, mat, tot, ave;

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

	public int getEng() {
		return eng;
	}

	public void setEng(int mat) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int eng) {
		this.mat = mat;
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