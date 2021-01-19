import { Component } from '@angular/core';
import { CoreComponent } from './CoreComponent';
import { ICoreComponente } from './ICoreComponente';

export declare interface IComponente extends ICoreComponente {
    //ICoreComponent
    //coreExportar(tipo: string): void;
    //coreSalir(): void;
    //coreMensaje(mensaje: string): void; 

    //mantenimiento
    coreGuardar(): void;

    //listado
    coreNuevo(): void;
    coreVer(dto:any): void;
    coreEditar(dto:any): void;
    coreAnular(dto:any): void;
    coreEliminar(dto:any): void;

    coreBuscar(): void;
    coreBusquedaRapida(filtro: string): void;    
    coreVerFiltro(flag: boolean): void;
}
  