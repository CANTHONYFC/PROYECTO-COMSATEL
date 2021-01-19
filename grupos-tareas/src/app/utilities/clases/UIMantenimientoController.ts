import { MensajeControllerGenerico } from "../dto/MensajeControllerGenerico";

 

export declare interface UIMantenimientoController {
    // listado
    coreNuevo(): void;
    coreBusquedaRapida(filtro: string): void;
    coreBuscar(): void;
    coreFiltro(flag: boolean): void;
    
    // mantenimiento
    coreGuardar(): void;

    // generico
    coreExportar(tipo: string): void;
    coreSalir(): void;
    coreMensaje(mensage: MensajeControllerGenerico): void;

}
