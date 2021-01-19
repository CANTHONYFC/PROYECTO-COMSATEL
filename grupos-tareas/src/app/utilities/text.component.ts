import { BreadcrumbService } from './../shared/breadcrumbs/app.breadcrumb.service';
import {Component} from '@angular/core';
 
@Component({
    templateUrl: './text.component.html',
    styles: [`
        .demo-container {
            border: 1px solid var(--surface-d);
        }
    `]
})
export class TextComponent {

    constructor(private breadcrumbService: BreadcrumbService) {
        this.breadcrumbService.setItems([
            {label: 'Text'}
        ]);
    }
}
