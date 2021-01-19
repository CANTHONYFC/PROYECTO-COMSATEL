import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { Panel } from 'primeng/panel';
import { LazyLoadEvent, MessageService, SelectItem, ConfirmationService } from 'primeng/api';
import { FilterUtils } from 'primeng/utils';
import { PrimeNGConfig } from 'primeng/api';
import { BaseComponent } from 'src/app/utilities/clases/BaseComponent';
import { Example } from '../dominio/example';
import { CardModule } from 'primeng/card';
import { Filtro } from '../dominio/filtro';

import { ComsatelService } from '../service/comsatel.service';
import { ComGrupo } from '../dominio/ComGrupo';
import { ComGrupoDetalle } from '../dominio/ComGrupoDetalle';
import { ComGrupoPk } from '../dominio/ComGrupoPk';
import { ComGrupoDetallePk } from '../dominio/ComGrupoDetallePk';
@Component({
  selector: 'app-diseno-carrito',
  templateUrl: './diseno-carrito.component.html',
  styleUrls: ['./diseno-carrito.component.scss']
})
export class DisenoCarritoComponent extends BaseComponent implements OnInit {
  nombregrupo: string;
  lstexample: Example[] = [];
  lstDetalleActual: ComGrupoDetalle[] = [];
  ex: Example;
  comGrupoPk:ComGrupoPk = new ComGrupoPk();
  displayAdicional: boolean = true;
  a: number;
  comGrupoDetallePk :ComGrupoDetallePk= new ComGrupoDetallePk();
  grupodetalle:ComGrupoDetalle = new ComGrupoDetalle();
nombregrupodetalle:string;
  grupo: ComGrupo = new ComGrupo();
  filtro: Filtro = new Filtro();
  constructor(messageService: MessageService,
    private confirmationService: ConfirmationService,
    private comsatelService: ComsatelService,
  ) { super(messageService) }

  ngOnInit(): void {
    this.displayAdicional = false;
this.filtro.tipobusqueda=1;



  }


  listar(event: LazyLoadEvent) {
    this.bloquearPagina();
    this.filtro.paginacion.paginacionListaResultado = [];
    this.filtro.paginacion.paginacionRegistroInicio = event.first;
    this.filtro.paginacion.paginacionRegistrosPorPagina = event.rows;
    this.comsatelService.listar(this.filtro).then(
      resp => {
        this.filtro.paginacion = resp;
        this.desbloquearPagina();
      }
    )
  }



  editar(data: any) {
    this.lstDetalleActual = [];
    this.grupo = new ComGrupo();
    this.grupo.pk.id = data.id;
    this.grupo.nombre = data.nombre;
    this.comsatelService.obtenerDetalle(this.grupo).then(
      resp => {
        this.lstDetalleActual = resp
        this.displayAdicional = true;
        this.desbloquearPagina();
      }
    )
  }

agregarnuevogrupo(){
  this.bloquearPagina();
  this.grupo = new ComGrupo();
  this.grupo.nombre=this.nombregrupo;
  this.grupo.estado=1;
  this.comsatelService.registrar(this.grupo).then(
    resp => {
      this.desbloquearPagina()
      this.recargar()
      this.nombregrupo=''
    })

}


agregarnuevodetalle(){
  this.grupodetalle = new ComGrupoDetalle();
  this.grupodetalle.nombre=this.nombregrupodetalle;
  this.grupodetalle.estado=0;
  this.grupodetalle.idgrupo=this.grupo.pk.id
  this.bloquearPagina();
  this.comsatelService.registrardetalle(this.grupodetalle).then(
    resp => {
      this.grupodetalle.pk.id=resp.pk.id
      this.recargar();
      this.desbloquearPagina()
      this.nombregrupodetalle=''
      this.lstDetalleActual.push(this.grupodetalle);
    })
}

eliminargrupo(data:any){
  this.confirmationService.confirm({
    header: 'Confirmación',
    message: 'Se elminará el grupo : ' + data.nombre + '. ¿Desea continuar?',
    accept: () => {
      this.bloquearPagina();
      this.comGrupoPk = new ComGrupoPk();
      this.comGrupoPk.id=data.id
      this.comsatelService.eliminar(this.comGrupoPk).then(
        resp => {
         this.recargar();
          this.desbloquearPagina();
        })
    }
    })

}

eliminardetalle(data:any, indice: number){


  this.confirmationService.confirm({
    header: 'Confirmación',
    message: 'Se elminará el item : ' + data.nombre + '. ¿Desea continuar?',
    accept: () => {
      this.bloquearPagina();
      this.comGrupoDetallePk = new ComGrupoDetallePk();
      this.comGrupoDetallePk.id=data.pk.id
      this.comsatelService.eliminardetalle(this.comGrupoDetallePk).then(
        resp => {
         this.recargar();
         this.lstDetalleActual.slice()
         this.lstDetalleActual.splice(indice, 1);
          this.desbloquearPagina();
        })
    }
    })
}

actualizargrillacabecera(data:any){
  this.bloquearPagina()
  this.grupo = new ComGrupo();
  this.grupo.pk.id=data.id
  this.grupo.estado=data.estado
  this.grupo.nombre=data.nombre
  this.comsatelService.actualizarcabecera(this.grupo).then(
    resp => {
      this.desbloquearPagina();
    })
}

listarproboton(data:number){
this.filtro.tipobusqueda=data
this.recargar();
}

actualizardetalle(data:any){
  this.bloquearPagina()
  this.grupodetalle = new ComGrupoDetalle();
  if(data.estado==false){
    data.estado=0;
  }else{
    data.estado=1;
  }
  this.grupodetalle=data;
  this.comsatelService.actualizardetalle(this.grupodetalle).then(
    resp => {
      this.recargar();
      this.desbloquearPagina();
    })
}

recargar(){ 
  this.filtro.paginacion.paginacionListaResultado = [];
  this.filtro.paginacion.paginacionRegistroInicio = 0;
  this.filtro.paginacion.paginacionRegistrosPorPagina = 5;
  this.comsatelService.listar(this.filtro).then(
    resp => {
      this.filtro.paginacion = resp;
      this.desbloquearPagina();
    }
  )}

  regresar() {
    this.displayAdicional = false;
  }

  
}
