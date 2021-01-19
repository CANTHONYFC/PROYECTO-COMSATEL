import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ParametroPaginacionGenerico } from '../../../../utilities/clases/ParametroPaginacionGenerico';
import { AppConfig } from 'src/environments/appconfig';
import { ComGrupoDetalle } from '../dominio/ComGrupoDetalle';
import { ComGrupo } from '../dominio/ComGrupo';
import {Filtro} from '../dominio/filtro'
import { ComGrupoPk } from '../dominio/ComGrupoPk';
import { ComGrupoDetallePk } from '../dominio/ComGrupoDetallePk';
@Injectable({
  providedIn: 'root'
})
export class ComsatelService {

  private url = `${this.config.getEnv('spring-comsatel-api')}comsatelrest/`;
  private url2 = `${this.config.getEnv('spring-comsatel-api')}comsateldetallerest/`;

  constructor(private http: HttpClient, private config: AppConfig) { }
  public listar(filtro: Filtro): Promise<ParametroPaginacionGenerico> {
    return this.http.post(this.url + 'listar', filtro)
      .toPromise()
      .then(response => response as ParametroPaginacionGenerico)
      .catch(error => error);
  }
  public obtenerDetalle(data: ComGrupo): Promise<ComGrupoDetalle[]> {
    return this.http.post(this.url2 + 'obtenerDetalle', data)
      .toPromise()
      .then(response => response as ComGrupoDetalle[])
      .catch(error => error);
  }
  public registrar(data: ComGrupo): Promise<ComGrupo> {
    return this.http.post(this.url + 'registrar', data)
      .toPromise()
      .then(response => response as ComGrupo)
      .catch(error => error);
  }
  public registrardetalle(data: ComGrupoDetalle): Promise<ComGrupoDetalle> {
    return this.http.post(this.url2 + 'registrar', data)
      .toPromise()
      .then(response => response as ComGrupoDetalle)
      .catch(error => error);
  }

  public eliminar(data: ComGrupoPk): Promise<ComGrupo> {
    return this.http.post(this.url + 'eliminar', data)
      .toPromise()
      .then(response => response as ComGrupo)
      .catch(error => error);
  }
  public eliminardetalle(data: ComGrupoDetallePk): Promise<ComGrupoDetalle> {
    return this.http.post(this.url2 + 'eliminar', data)
      .toPromise()
      .then(response => response as ComGrupoDetalle)
      .catch(error => error);
  }
  public actualizarcabecera(data: ComGrupo): Promise<ComGrupo> {
    return this.http.put(this.url + 'actualizar', data)
      .toPromise()
      .then(response => response as ComGrupo)
      .catch(error => error);
  }
  public actualizardetalle(data: ComGrupoDetalle): Promise<ComGrupoDetalle> {
    return this.http.put(this.url2 + 'actualizar', data)
      .toPromise()
      .then(response => response as ComGrupoDetalle)
      .catch(error => error);
  }



}
