import { BreadcrumbService } from './../shared/breadcrumbs/app.breadcrumb.service';
import {Component} from '@angular/core';
 
@Component({
    templateUrl: './typography.component.html'
})
export class TypographyComponent {
    constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([
            {label: 'Typography'}
        ]);
    }
}
