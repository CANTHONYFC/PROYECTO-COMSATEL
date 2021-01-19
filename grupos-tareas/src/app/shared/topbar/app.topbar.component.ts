import { BreadcrumbService } from './../breadcrumbs/app.breadcrumb.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { AppMainComponent } from '../../app.main.component';
import { Subscription } from 'rxjs';
import { MenuItem } from 'primeng/api';

@Component({
    selector: 'app-topbar',
    templateUrl: './app.topbar.component.html'
})
export class AppTopBarComponent implements OnDestroy, OnInit {

    subscription: Subscription;
    items: MenuItem[];

    public photoUrl: string
    public name: string = 'Falcon Cristopher';
    public showInitials = false;
    public initials: string;
    public circleColor: string;
    colorClass:string;
    private colors = [
        '#EB7181',//red,
        '#468547', //green,
        '#FFD558', //YELOLOW
        '#3670B2', // blue

    ]


    constructor(public breadcrumbService: BreadcrumbService, public app: AppMainComponent) {
        this.subscription = breadcrumbService.itemsHandler.subscribe(response => {
            this.items = response;
            console.log("items", this.items)
        });

     }
    ngOnInit(): void {
         if(!this.photoUrl){
            this.showInitials = true;
            this.createIniatials();
            
            const randomIndex = Math.floor(Math.random() * Math.floor(this.colors.length));
            this.circleColor = this.colors[randomIndex];
             console.log("circleColor" ,  this.circleColor);
            
         }
    }


    createIniatials(): void {
        let initials = "";
        for (let i = 0; i < this.name.length; i++) {
            if (this.name.charAt(i) === ' ') {
                continue;
            }

            if (this.name.charAt(i) === this.name.charAt(i).toUpperCase()) {
                initials += this.name.charAt(i);

                if (initials.length == 2) {
                    break;
                
                }
            }
        }
        console.log("initials" , initials);
        
        this.initials = initials
    }

    ngOnDestroy() {
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }
}
