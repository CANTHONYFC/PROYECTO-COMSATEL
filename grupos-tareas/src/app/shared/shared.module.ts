
 import { TituloMantenimientoComponent } from './titulos/titulomantenimiento-listado.component';
import { TituloListadoComponent } from './titulos/titulol-listado.component';
import { AuditoriaComponent } from './auditoria/auditoria.component';
import { AppFooterComponent } from './footer/app.footer.component';
import { AppTopBarComponent } from './topbar/app.topbar.component';
import { BreadcrumbService } from './../app.breadcrumb.service';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BlockuiComponent } from './blockui/blockui.component';
import { BlockUIModule } from 'primeng/blockui';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { CardModule } from 'primeng/card';
import { ChartModule } from 'primeng/chart';
import { CheckboxModule } from 'primeng/checkbox';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { FieldsetModule } from 'primeng/fieldset';
import { InputMaskModule } from 'primeng/inputmask';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { PanelModule } from 'primeng/panel';
import { RadioButtonModule } from 'primeng/radiobutton';
import { SplitButtonModule } from 'primeng/splitbutton';
import { TableModule } from 'primeng/table';
import { TabViewModule } from 'primeng/tabview';
import { TreeModule } from 'primeng/tree';
import { KeyFilterModule } from 'primeng/keyfilter';




@NgModule({

  providers: [
    BreadcrumbService,
  ],

  declarations: [
    AppTopBarComponent,
    AppFooterComponent,
    BlockuiComponent,
    AuditoriaComponent,
    TituloListadoComponent,
    TituloMantenimientoComponent,
    
  ],
  imports: [
    CommonModule, RouterModule, BlockUIModule, ProgressSpinnerModule, FormsModule, DialogModule, InputTextareaModule,
    PanelModule, RadioButtonModule, DropdownModule, InputMaskModule, ButtonModule, TableModule, InputTextModule,
    CalendarModule, CheckboxModule, ConfirmDialogModule, TabViewModule, FieldsetModule, TreeModule, ChartModule, CardModule,
    SplitButtonModule , 
    KeyFilterModule
  ],
  exports: [
    BlockuiComponent,
    AppTopBarComponent,
    AppFooterComponent,
    AuditoriaComponent,
    TituloListadoComponent,
    TituloMantenimientoComponent,
    

  ]
})
export class SharedModule { }
