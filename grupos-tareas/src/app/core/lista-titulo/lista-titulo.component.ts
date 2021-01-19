import {Component} from '@angular/core';
import { BreadcrumbService } from './../../shared/breadcrumbs/app.breadcrumb.service';
import {MenuItem} from 'primeng/api';

@Component({
    selector: 'app-lista-titulo',
    templateUrl: './lista-titulo.component.html'
})
export class ListaTituloComponent {
    
    items: MenuItem[];

    ngOnInit() {
        this.items = [
            {label: 'Formato 1', icon: 'pi pi-print'},
            {label: 'Formato 2', icon: 'pi pi-print'},
            {label: 'Formato 3', icon: 'pi pi-print'},
        ];
    }
     constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([
            {label: 'Venta'},{label:'Zona Venta'}
        ]);
    }
}