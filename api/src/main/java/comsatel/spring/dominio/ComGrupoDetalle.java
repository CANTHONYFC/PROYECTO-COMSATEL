package comsatel.spring.dominio;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COM_GRUPO_DETALLE")
public class ComGrupoDetalle  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ComGrupoDetallePk pk;
	
	
	
	@Size(min = 0, max = 255)
	@Column(name = "nombre", length = 255, nullable = true)
	private String nombre;
	
	
	@Column(name = "idgrupo", nullable = true)
	private Integer idgrupo;
	
	@Column(name = "estado", nullable = true)
	private Integer estado;

	public ComGrupoDetallePk getPk() {
		return pk;
	}

	public void setPk(ComGrupoDetallePk pk) {
		this.pk = pk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Integer idgrupo) {
		this.idgrupo = idgrupo;
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
