import { SharedModule } from './../../shared/shared.module';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';

import { SplitButtonModule } from 'primeng/splitbutton';
import { BreadcrumbService } from './../../shared/breadcrumbs/app.breadcrumb.service';
import { TableModule } from 'primeng/table';
import { FieldsetModule } from 'primeng/fieldset';
 
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastModule } from 'primeng/toast';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { MessageModule } from 'primeng/message';
import { MessagesModule } from 'primeng/messages';
import { RippleModule } from 'primeng/ripple';
import { BlockUIModule } from 'primeng/blockui';
import { InputTextModule } from 'primeng/inputtext';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { KeyFilterModule } from 'primeng/keyfilter';
import { EditorModule } from 'primeng/editor';
import { RadioButtonModule } from 'primeng/radiobutton';
import { TabViewModule } from 'primeng/tabview';
import { CheckboxModule } from 'primeng/checkbox';
import { DialogModule } from 'primeng/dialog';
import { AngularEditorModule } from '@kolkov/angular-editor';
import { PasswordModule } from 'primeng/password';
import { ColorPickerModule } from 'ngx-color-picker';
 
import { CodemirrorModule } from '@ctrl/ngx-codemirror';
import { DisenoCarritoComponent } from './disenopresentacion/diseno-carrito/diseno-carrito.component';
import { ComsatelService } from './disenopresentacion/service/comsatel.service';


@NgModule({

  providers: [
    BreadcrumbService,
    ConfirmationService,
    ComsatelService
  ],

  declarations: [
    DisenoCarritoComponent,

  ],
  imports: [
    CommonModule,
    MessagesModule,
    MessageModule,
    HttpClientModule,
    ToastModule,
    ButtonModule,
    RippleModule,
    DropdownModule,
    FormsModule,
    CalendarModule,
    BrowserModule,
    BrowserAnimationsModule,
    BlockUIModule,
    InputTextModule,
    ProgressSpinnerModule,
    SharedModule,
    FieldsetModule,
    TableModule,
    KeyFilterModule,
    EditorModule,
    RadioButtonModule,
    TabViewModule,
    CheckboxModule,
    SplitButtonModule,
    ConfirmDialogModule,
    DialogModule,
    AngularEditorModule,
    SplitButtonModule,
    NoopAnimationsModule,
    ReactiveFormsModule,
    PasswordModule,
    ColorPickerModule,
    CodemirrorModule,
    FormsModule
  ]
})
export class AlertasModule { }
