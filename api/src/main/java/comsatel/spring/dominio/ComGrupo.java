package comsatel.spring.dominio;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "COM_GRUPO")
public class ComGrupo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ComGrupoPk pk;
	
	@Size(min = 0, max = 255)
	@Column(name = "nombre", length = 255, nullable = true)
	private String nombre;
	
	
	@Column(name = "estado", nullable = true)
	private Integer estado;


	public ComGrupoPk getPk() {
		return pk;
	}


	public void setPk(ComGrupoPk pk) {
		this.pk = pk;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
