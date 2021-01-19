
import {ComGrupoDetallePk} from './ComGrupoDetallePk'
export class ComGrupoDetalle{
    pk:ComGrupoDetallePk = new ComGrupoDetallePk();
    constructor(){
        this.pk = new ComGrupoDetallePk();
    }
	
	 nombre:string;
	
	 idgrupo:number;
    
    estado:number;

}