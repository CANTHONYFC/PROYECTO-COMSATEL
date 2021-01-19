import { DtoMenu } from './../../utilities/clases/DtoMenu';
import { ObjetoTitulo } from './../dominio/ObjetoTitulo';
 
import { Component, OnInit, ViewChild, ElementRef, ChangeDetectorRef, Input } from '@angular/core';
import { AppConfig } from 'src/environments/appconfig';
 

@Component({
    selector: 'app-titulol-listado',
    templateUrl: 'titulol-listado.component.html'
})

export class TituloListadoComponent implements OnInit {

    flgVerFiltro: boolean;
    valorFiltro: string;
    tipoExportar: string;
    urlAyuda: string;

    @Input() objTitulo = new ObjetoTitulo();
    @Input() tipoExp = '';

    constructor(
        private changeRef: ChangeDetectorRef,
        private config: AppConfig
    ) { }
    DialogAyuda:string;
   // @ViewChild(TipoExportarSelectorComponent, { static: false }) tipoExportarSelectorComponent: TipoExportarSelectorComponent;
    //@ViewChild(DialogAyuda, { static: false }) dialogayuda: DialogAyuda;

    ngOnInit() {
        console.log('iniciarComponente');
        this.flgVerFiltro = false;
        this.objTitulo.menuSeguridad;
    }

    @ViewChild('busquedarapida') private elementRef: ElementRef;

    ngAfterViewChecked(): void { this.changeRef.detectChanges(); }

    busquedaRapida() {
        this.objTitulo.componente.coreBusquedaRapida(this.valorFiltro);
    }

    tablaIconoNuevo() {
        this.buscar();
    }

    buscar() {
        this.objTitulo.componente.coreBuscar();
    }

    nuevo() {
        this.objTitulo.componente.coreNuevo();
    }
    exportar() {
        this.objTitulo.componente.coreExportar(this.tipoExportar);
    }
    verfiltro() {
        switch (this.flgVerFiltro) {
            case true: {
                this.flgVerFiltro = false;
                break;
            }
            case false: {
                this.flgVerFiltro = true;
                break;
            }
            default: {
                this.flgVerFiltro = false;
                break;
            }
        }
        this.objTitulo.componente.coreFiltro(this.flgVerFiltro);
    }

    ayuda() {
        var url = this.obtenerPaginaAyuda(this.objTitulo.menuSeguridad);
        if (url != undefined && url != null) {
            //this.dialogayuda.iniciarComponente(true, url);
        }
    }

    exportarDatos() {
        if (this.tipoExp == '2') {
            this.exportarDatosPdfXls();
        } else if (this.tipoExp == '3') {
            this.objTitulo.componente.coreExportar('XLS');
        } else {
           // this.tipoExportarSelectorComponent.iniciarComponente();
        }
    }

    exportarDatosPdfXls() {
       // this.tipoExportarSelectorComponent.iniciarComponente2();
    }

    guardar() {
        this.objTitulo.componente.coreGuardar();
    }

    seleccionarExportarTipo(tipo: any) {
        this.tipoExportar = tipo;
        this.exportar();
    }

    obtenerPaginaAyuda(menu: DtoMenu): string {
        this.urlAyuda = this.config.getEnv('manuales') + menu.urlAyuda;
        console.log(this.urlAyuda);
        return this.urlAyuda;
    }

    defaultBuscar(event) {
        if (event.keyCode === 13) {
            this.busquedaRapida();
        }
    }

    salir() {
        this.objTitulo.componente.coreSalir();
    }
    ejecutarAccion() {
        alert('EJECUTAR');
    }

}
