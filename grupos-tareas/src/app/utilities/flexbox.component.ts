import { BreadcrumbService } from './../shared/breadcrumbs/app.breadcrumb.service';
import {Component} from '@angular/core';
 
@Component({
    templateUrl: './flexbox.component.html',
    styleUrls: ['./flexbox.scss']
})
export class FlexboxComponent {
    constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([
            {label: 'FlexBox'}
        ]);
    }
}
