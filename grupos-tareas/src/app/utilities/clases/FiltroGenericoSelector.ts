import { ParametroPaginacionGenerico } from './ParametroPaginacionGenerico';
export class FiltroGenericoSelector {

    constructor(){
        this.paginacion = new ParametroPaginacionGenerico();
    }

    codigo: number;
    nombre: string;
    documento: string;
    codigocadena: string;
    busqueda: string;
    paginacion: ParametroPaginacionGenerico;
}