import { UIMantenimientoController } from 'src/app/utilities/clases/UIMantenimientoController';
import { DtoMenu } from 'src/app/utilities/clases/DtoMenu';

 
export class ObjetoTitulo{  
    constructor(){
        this.menuSeguridad = new DtoMenu();
        this.listaOtros = [];        
    }

    listaOtros: any[];
    titulo: string;
    tipo: number;
    menuSeguridad: DtoMenu;
    componente: UIMantenimientoController;

    //Mantenimiento
    accion: string;
    puedeEditar: boolean;            
}

