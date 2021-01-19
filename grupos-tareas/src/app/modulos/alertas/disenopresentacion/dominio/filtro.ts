import { ParametroPaginacionGenerico } from '../../../../utilities/clases/ParametroPaginacionGenerico';
 
export class Filtro {

    constructor() {
        this.paginacion = new ParametroPaginacionGenerico();
    }
    paginacion: ParametroPaginacionGenerico;
      buscar:string;
      tipobusqueda:number;
      
}