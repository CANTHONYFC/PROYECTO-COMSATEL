import { BreadcrumbService } from './../shared/breadcrumbs/app.breadcrumb.service';
import {Component} from '@angular/core';
 
@Component({
    templateUrl: './widgets.component.html'
})
export class WidgetsComponent {
    constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([
            {label: 'Widgets'}
        ]);
    }
}
