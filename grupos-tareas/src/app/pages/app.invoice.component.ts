import { BreadcrumbService } from './../shared/breadcrumbs/app.breadcrumb.service';
import {Component} from '@angular/core';
 
@Component({
    templateUrl: './app.invoice.component.html'
})
export class AppInvoiceComponent {

    constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([
            {label: 'Invoice'}
        ]);
    }

    print() {
        window.print();
    }
}
