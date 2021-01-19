import {ComGrupoPk} from './ComGrupoPk'

export class ComGrupo{
    pk:ComGrupoPk = new ComGrupoPk();
    constructor(){
        this.pk = new ComGrupoPk();
    }
	nombre:string;
    estado:number;

}