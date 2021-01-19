package comsatel.spring.dominio.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DtolistarGrupoDetalle {
private String nombre;
private Integer id;
private Integer estado;
private BigInteger item;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getEstado() {
	return estado;
}
public void setEstado(Integer estado) {
	this.estado = estado;
}
public BigInteger getItem() {
	return item;
}
public void setItem(BigInteger item) {
	this.item = item;
}



	


}
