export class ConstanteUI {

    /** para cuando se quiere ver los listados desde los menus**/
    public static ACCION_SOLICITADA_LISTAR = "LISTAR";

    /** desde la venta de listado se da click en boton nuevo **/
    public static ACCION_SOLICITADA_NUEVO = "NUEVO";

    /** desde la ventana de listado se desea modificar la informacion de un registro **/
    public static ACCION_SOLICITADA_EDITAR = "EDITAR";

    /** desde la ventana de listado se desea anular un registro en forma logica**/
    public static ACCION_SOLICITADA_ANULAR = "ANULAR";

    /** desde la ventana de listado se desea eliminar fisicamente un registro **/
    public static ACCION_SOLICITADA_ELIMINAR = "ELIMINAR";

    public static ACCION_SOLICITADA_VER = "VER";

    public static ACCION_SOLICITADA_COPIAR = 'COPIAR';

    public static ACCION_SOLICITADA_REVERTIR = 'REVERTIR';


    // EXPRESIONES REGULARES PARA CAMPOS
    public static EXPRESIONES_REGULARES_ALFANUMERICO = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ,.\d\-_\s]+$/;

    public static expresion_mayusminus = /^[a-zA-Z\d\-_\s]+$/;

    public static EXPRESIONES_REGULARES_LETRAS = /^[a-zA-Z ]/;

    public static EXPRESIONES_REGULARES_NUMERICO = /^[0-9]/;

    public static EXPRESIONES_REGULARES_EMAIL = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

    //MENU SEGURIDAD
    public static MENUSEGURIDAD = 'menu-seguridad';

}

