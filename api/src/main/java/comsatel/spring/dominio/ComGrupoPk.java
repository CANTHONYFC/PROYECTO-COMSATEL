package comsatel.spring.dominio;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ComGrupoPk implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "id", nullable = false)
	private Integer id;

	public ComGrupoPk(Integer id) {
		this.id = id;
	}
	public ComGrupoPk() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
