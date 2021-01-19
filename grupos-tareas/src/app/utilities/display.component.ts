import { BreadcrumbService } from './../shared/breadcrumbs/app.breadcrumb.service';
import {Component} from '@angular/core';
 
@Component({
    templateUrl: './display.component.html'
})
export class DisplayComponent {

    constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([ 
            {label: 'Display'}
        ]);
    }
}
