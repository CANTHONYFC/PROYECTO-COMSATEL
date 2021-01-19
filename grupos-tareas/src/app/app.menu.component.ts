import { Component, OnInit } from '@angular/core';
import { AppMainComponent } from './app.main.component';

@Component({
    selector: 'app-menu',
    templateUrl: './app.menu.component.html',
})
export class AppMenuComponent implements OnInit {

    model: any[];

    constructor(public app: AppMainComponent) { }

    ngOnInit() {
        this.model = [
           
            {separator:true},
            {
                label:'Gestion',icon: 'pi pi-fw pi-star', routerLink: ['/uikit'],
                items: [
                    { label: 'Presentacion', icon: 'pi pi-fw pi-id-card', routerLink: ['diseno-carrito'] },
                  
                ]
            }

        ];
    }

    onMenuClick(event) {
        this.app.onMenuClick(event);
    }
}
