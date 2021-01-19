import { Component } from '@angular/core';
import { BreadcrumbService } from './../../shared/breadcrumbs/app.breadcrumb.service';
import { CoreComponent } from './CoreComponent';
import { IComponente } from './IComponente';
import { ConstanteUI } from './../core/constante/ConstanteUI';

export class MantenimientoComponent extends CoreComponent  { 
    constructor(private breadcrumbService: BreadcrumbService) {
        super();
        this.breadcrumbService.setItems([
            {label: 'Venta'}
        ]);
    }
    
}
  