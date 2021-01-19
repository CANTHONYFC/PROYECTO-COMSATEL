import { BaseComponent } from 'src/app/utilities/clases/BaseComponent';
import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-auditoria',
  templateUrl: './auditoria.component.html',
  styleUrls: ['./auditoria.component.scss']
})
export class AuditoriaComponent extends BaseComponent implements OnInit {

  @Input() tipoVista = 0;
  @Input() creacionFecha = new Date();
  @Input() creacionUsuario = '';
  @Input() modificacionUsuario = '';
  @Input() modificacionFecha = new Date();


  @Input() aprobacionUsuario = '';
  @Input() aprobacionFecha = new Date();

  constructor(
    messageService: MessageService,
    private cdref: ChangeDetectorRef
  ) { super(messageService); }

  ngOnInit() {
    console.log('iniciarComponente');
  }

  public ngAfterViewInit(): void {
  }

  ngAfterContentChecked() {
    this.cdref.detectChanges();
  }
}
