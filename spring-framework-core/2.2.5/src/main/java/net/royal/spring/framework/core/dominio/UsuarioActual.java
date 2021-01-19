
package net.royal.spring.framework.core.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import net.royal.spring.framework.core.UValidador;
import net.royal.spring.framework.core.dominio.dto.Menu;

@SuppressWarnings("serial")
public class UsuarioActual extends UsuarioSeguridad implements Serializable {
	public static final String CONSTRAINTS_NOTNULL = "usuarioactual.constraints.notnull";
	
	public static final String TIPOUSUARIO_EMPLEADO = "EMPL";
	public static final String TIPOUSUARIO_PROVEEDOR = "PROV";
	public static final String TIPOUSUARIO_CLIENTE = "CLIE";
	public static final String TIPOUSUARIO_POSTULANTE = "POST";
	public static final String TIPOUSUARIO_SPRING = "SPRING";
	public static final String TIPOUSUARIO_SOLICTANTEAGRO = "SOLAGRO";
	
	public UsuarioActual() {
		super();
	}
	
	/*****/
	private String tipoUsuario;
	
	private String sidCliente;

	/**
	 * codigo de usuario establecido en la tabla de Persona o Empleado dependiendo
	 * del negocio
	 */
	private String usuarioCodigo;

	/**
	 * login o usuario de base de datos que se uso para entrar al sistema Usuario
	 */
	private String usuarioLoginBaseDatos;

	private String usuarioUniqueIdString;
	private Integer usuarioUniqueIdInteger;

	/**
	 * identificador unico de la entidad principal tipo persona
	 */
	private Integer personaId;

	/**
	 * tipo de documento del usuario logeado
	 */
	private String personaTipoDocumento;

	/**
	 * nro del documento de identificacion del usuario actual
	 */
	private String personaNroDocumento;

	/**
	 * Nombre completo del usuario incluye nombres y apellidos
	 */
	private String personaNombreCompleto;

	/**
	 * nombre o nombres del usuario
	 */
	private String personaNombres;

	/**
	 * apellidos del usuario logeado paterno y materno
	 */
	private String personaApellidos;

	/**
	 * apellido Paterno del usuario logeado
	 */
	private String personaApellidoPaterno;

	/**
	 * apellido Materno del usuario logeado
	 */
	private String personaApellidoMaterno;	

	/**
	 * empleadomast.unidadnegocioasignada = MA_UnidadNegocio.UnidadNegocio
	 * 
	 * @return
	 */
	private String unidadNegocioAsignadaCodigo;
	private String unidadNegocioAsignadaNombre;

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	private String sucursalCodigo;
	private String sucursalNombre;

	/**
	 * empleadomast.deptoorganizacion = DEPARTMENTMST.department
	 * 
	 * @return
	 */
	private String departamentoCodigo;
	private String departamentoNombre;

	/**
	 * empleadomast.codigocargo = HR_PUESTOEMPRESA.codigopuesto
	 * 
	 * @return
	 */
	private Integer puestoEmpresaCodigo;
	private String puestoEmpresaNombre;

	/**
	 * empleadomast.CentroCostos = AC_COSTCENTERMST.COSTCENTER
	 * 
	 * @return
	 */
	private String centroCostosCodigo;
	private String centroCostosNombre;

	private String unidadReplicacionCodigo;
	private String unidadReplicacionNombre;
	
	/**
	 * este valor se usa para inia-Agro
	 */	 
	private BigDecimal unidadReplicacionId;
	
	private String origenCodigo;
	private String origenNombre;

	private String establecimientoFiscalCodigo;
	private String establecimientoFiscalNombre;

	private String almacenCodigo;
	private String almacenNombre;
	
	/* agregado por dario - migracion de requerimiento
	 * */
	private String seguridadPorUnidadNegocio;	
	private String esFiscal;
	private String planContable;
	private String idResponsableEmpleado;
	// fin de lo agregado por dario
	
	/**
	 * identificador unico de la entidad AG_GE_PERSONA
	 */
	private Integer personaAgroId;
	
	private Menu menu;
	private String anio;

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public String getSucursalCodigo() {
		return sucursalCodigo;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public void setSucursalCodigo(String sucursalCodigo) {
		this.sucursalCodigo = sucursalCodigo;
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public String getSucursalNombre() {
		return sucursalNombre;
	}

	/**
	 * empleadomast.sucursal = AC_Sucursal.sucursal
	 * 
	 * @return
	 */
	public void setSucursalNombre(String sucursalNombre) {
		this.sucursalNombre = sucursalNombre;
	}

	/**
	 * identificador unico de la entidad principal tipo persona
	 */
	public Integer getPersonaId() {
		return personaId;
	}

	/**
	 * identificador unico de la entidad principal tipo persona
	 */
	public void setPersonaId(Object personaId) {
		if (!UValidador.esNulo(personaId)) {
			if (personaId instanceof BigDecimal) {
				this.personaId = new BigDecimal(personaId.toString())
						.intValue();
			} else if (personaId instanceof Integer) {
				this.personaId = Integer.parseInt(personaId.toString());
			}
		}
	}
	

	/**
	 * apellidos del usuario logeado
	 */
	public String getPersonaApellidos() {
		String apes = "";

		if (personaApellidos != null) {
			personaApellidos.toLowerCase();
		}

		if (!(this.personaApellidoPaterno == null))
			apes = personaApellidoPaterno;

		if (!(this.personaApellidoMaterno == null))
			apes = apes + " " + personaApellidoMaterno;

		return apes;
	}

	/**
	 * apellidos del usuario logeado
	 */
	public void setPersonaApellidos(String personaApellidos) {
		this.personaApellidos = personaApellidos;
	}

	/**
	 * nombre o nombres del usuario
	 */
	public String getPersonaNombres() {
		return personaNombres;
	}

	/**
	 * nombre o nombres del usuario
	 */
	public void setPersonaNombres(String personaNombres) {
		this.personaNombres = personaNombres;
	}

	/**
	 * Nombre completo del usuario
	 */
	public String getPersonaNombreCompleto() {
		return personaNombreCompleto;
	}

	/**
	 * Nombre completo del usuario
	 */
	public void setPersonaNombreCompleto(String personaNombreCompleto) {
		this.personaNombreCompleto = personaNombreCompleto;
	}

	/**
	 * tipo de documento del usuario logeado
	 */
	public String getPersonaTipoDocumento() {
		return personaTipoDocumento;
	}

	/**
	 * tipo de documento del usuario logeado
	 */
	public void setTipoDocumento(String personaTipoDocumento) {
		this.personaTipoDocumento = personaTipoDocumento;
	}

	/**
	 * nro del documento de identificacion del usuario actual
	 */
	public String getPersonaNroDocumento() {
		return personaNroDocumento;
	}

	/**
	 * nro del documento de identificacion del usuario actual
	 */
	public void setPersonaNroDocumento(String personaNroDocumento) {
		this.personaNroDocumento = personaNroDocumento;
	}

	

	

	public String getPersonaApellidoPaterno() {
		return personaApellidoPaterno;
	}

	public void setPersonaApellidoPaterno(String personaApellidoPaterno) {
		this.personaApellidoPaterno = personaApellidoPaterno;
	}

	public String getPersonaApellidoMaterno() {
		return personaApellidoMaterno;
	}

	public void setPersonaApellidoMaterno(String personaApellidoMaterno) {
		this.personaApellidoMaterno = personaApellidoMaterno;
	}

	/**
	 * codigo de usuario establecido en la tabla de Persona o Empleado dependiendo
	 * del negocio
	 */
	public String getUsuarioCodigo() {
		return usuarioCodigo;
	}

	/**
	 * codigo de usuario establecido en la tabla de Persona o Empleado dependiendo
	 * del negocio
	 */
	public void setUsuarioCodigo(String usuarioCodigo) {
		this.usuarioCodigo = usuarioCodigo;
	}

	public String getUsuarioLoginBaseDatos() {
		return usuarioLoginBaseDatos;
	}

	public void setUsuarioLoginBaseDatos(String usuarioLoginBaseDatos) {
		this.usuarioLoginBaseDatos = usuarioLoginBaseDatos;
	}



	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public String getCentroCostosCodigo() {
		return centroCostosCodigo;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public void setCentroCostosCodigo(String centroCostosCodigo) {
		this.centroCostosCodigo = centroCostosCodigo;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public String getCentroCostosNombre() {
		return centroCostosNombre;
	}

	/**
	 * EmpleadoMast.CentroCostos = AC_CostCenterMst.CostCenter
	 * 
	 * @return
	 */
	public void setCentroCostosNombre(String centroCostosNombre) {
		this.centroCostosNombre = centroCostosNombre;
	}

	public String getUsuarioUniqueIdString() {
		return usuarioUniqueIdString;
	}

	public void setUsuarioUniqueIdString(String usuarioUniqueIdString) {
		this.usuarioUniqueIdString = usuarioUniqueIdString;
	}

	public Integer getUsuarioUniqueIdInteger() {
		return usuarioUniqueIdInteger;
	}

	public void setUsuarioUniqueIdInteger(Integer usuarioUniqueIdInteger) {
		this.usuarioUniqueIdInteger = usuarioUniqueIdInteger;
	}

	public void setPersonaTipoDocumento(String personaTipoDocumento) {
		this.personaTipoDocumento = personaTipoDocumento;
	}

	public String getDepartamentoCodigo() {
		return departamentoCodigo;
	}

	public void setDepartamentoCodigo(String departamentoCodigo) {
		this.departamentoCodigo = departamentoCodigo;
	}

	public String getDepartamentoNombre() {
		return departamentoNombre;
	}

	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
	}

	public String getUnidadNegocioAsignadaCodigo() {
		return unidadNegocioAsignadaCodigo;
	}

	public void setUnidadNegocioAsignadaCodigo(String unidadNegocioAsignadaCodigo) {
		this.unidadNegocioAsignadaCodigo = unidadNegocioAsignadaCodigo;
	}

	public String getUnidadNegocioAsignadaNombre() {
		return unidadNegocioAsignadaNombre;
	}

	public void setUnidadNegocioAsignadaNombre(String unidadNegocioAsignadaNombre) {
		this.unidadNegocioAsignadaNombre = unidadNegocioAsignadaNombre;
	}

	public Integer getPuestoEmpresaCodigo() {
		return puestoEmpresaCodigo;
	}

	public void setPuestoEmpresaCodigo(Integer puestoEmpresaCodigo) {
		this.puestoEmpresaCodigo = puestoEmpresaCodigo;
	}

	public String getPuestoEmpresaNombre() {
		return puestoEmpresaNombre;
	}

	public void setPuestoEmpresaNombre(String puestoEmpresaNombre) {
		this.puestoEmpresaNombre = puestoEmpresaNombre;
	}

	public String getSidCliente() {
		return sidCliente;
	}

	public void setSidCliente(String sidCliente) {
		this.sidCliente = sidCliente;
	}

	public String getUnidadReplicacionCodigo() {
		return unidadReplicacionCodigo;
	}

	public void setUnidadReplicacionCodigo(String unidadReplicacionCodigo) {
		this.unidadReplicacionCodigo = unidadReplicacionCodigo;
	}

	public String getUnidadReplicacionNombre() {
		return unidadReplicacionNombre;
	}

	public void setUnidadReplicacionNombre(String unidadReplicacionNombre) {
		this.unidadReplicacionNombre = unidadReplicacionNombre;
	}

	public String getOrigenCodigo() {
		return origenCodigo;
	}

	public void setOrigenCodigo(String origenCodigo) {
		this.origenCodigo = origenCodigo;
	}

	public String getOrigenNombre() {
		return origenNombre;
	}

	public void setOrigenNombre(String origenNombre) {
		this.origenNombre = origenNombre;
	}

	public String getEstablecimientoFiscalCodigo() {
		return establecimientoFiscalCodigo;
	}

	public void setEstablecimientoFiscalCodigo(String establecimientoFiscalCodigo) {
		this.establecimientoFiscalCodigo = establecimientoFiscalCodigo;
	}

	public String getEstablecimientoFiscalNombre() {
		return establecimientoFiscalNombre;
	}

	public void setEstablecimientoFiscalNombre(String establecimientoFiscalNombre) {
		this.establecimientoFiscalNombre = establecimientoFiscalNombre;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getAlmacenCodigo() {
		return almacenCodigo;
	}

	public void setAlmacenCodigo(String almacenCodigo) {
		this.almacenCodigo = almacenCodigo;
	}

	public String getAlmacenNombre() {
		return almacenNombre;
	}

	public void setAlmacenNombre(String almacenNombre) {
		this.almacenNombre = almacenNombre;
	}

	public String getSeguridadPorUnidadNegocio() {
		return seguridadPorUnidadNegocio;
	}

	public void setSeguridadPorUnidadNegocio(String seguridadPorUnidadNegocio) {
		this.seguridadPorUnidadNegocio = seguridadPorUnidadNegocio;
	}

	public String getEsFiscal() {
		return esFiscal;
	}

	public void setEsFiscal(String esFiscal) {
		this.esFiscal = esFiscal;
	}

	public String getPlanContable() {
		return planContable;
	}

	public void setPlanContable(String planContable) {
		this.planContable = planContable;
	}

	public String getIdResponsableEmpleado() {
		return idResponsableEmpleado;
	}

	public void setIdResponsableEmpleado(String idResponsableEmpleado) {
		this.idResponsableEmpleado = idResponsableEmpleado;
	}

	private BigDecimal dptoareaoperativa;

	public BigDecimal getDptoareaoperativa() {
		return dptoareaoperativa;
	}

	public void setDptoareaoperativa(BigDecimal dptoareaoperativa) {
		this.dptoareaoperativa = dptoareaoperativa;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public BigDecimal getUnidadReplicacionId() {
		return unidadReplicacionId;
	}

	public void setUnidadReplicacionId(BigDecimal unidadReplicacionId) {
		this.unidadReplicacionId = unidadReplicacionId;
	}

	/**
	 * identificador unico de la entidad AG_GE_PERSONA
	 */
	public Integer getPersonaAgroId() {
		return personaAgroId;
	}

	/**
	 * identificador unico de la entidad AG_GE_PERSONA
	 */
	public void setPersonaAgroId(Object  personaAgroId) {
		if (!UValidador.esNulo(personaAgroId)) {
			if (personaAgroId instanceof BigDecimal) {
				this.personaAgroId = new BigDecimal(personaAgroId.toString())
						.intValue();
			} else if (personaAgroId instanceof Integer) {
				this.personaAgroId = Integer.parseInt(personaAgroId.toString());
			}
		}
	}
	
	
}
