import { Component } from '@angular/core';
import { MenuSeguridad } from './../core/dominio/MenuSeguridad';
import { TituloVentana } from '../core/dominio/TituloVentana';
import { ConstanteUI } from '../core/constante/ConstanteUI';
import { IComponente } from './IComponente';

export class CoreComponent { 
    menuSeguridad: MenuSeguridad = new MenuSeguridad();
    tituloVentana: TituloVentana = new TituloVentana();

    tituloAsignar(tipo: number, componente: IComponente){ 
        const ss = sessionStorage.getItem(ConstanteUI.MENUSEGURIDAD);
        if (ss !== undefined && ss != null) {
            const seguridad = JSON.parse(ss) as MenuSeguridad;
            this.menuSeguridad = seguridad;
        }
        this.tituloVentana
    }
}
  