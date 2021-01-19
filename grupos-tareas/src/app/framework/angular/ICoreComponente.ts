import { Component } from '@angular/core';
import { CoreComponent } from './CoreComponent';
import { MensajeComponente } from '../core/dominio/MensajeComponente';

export declare interface ICoreComponente {
    coreExportar(tipo: string): void;
    coreSalir(): void;
    coreMensaje(mensaje: MensajeComponente): void;
}
  