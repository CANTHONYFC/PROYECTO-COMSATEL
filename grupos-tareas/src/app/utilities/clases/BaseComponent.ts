import { ConstanteUI } from 'src/app/utilities/constante/ConstanteUI';
import { MessageService } from 'primeng/api';
import { DtoUsuarioActual } from './DtoUsuarioActual';

export class BaseComponent {
    blocked: boolean = false;
    usuarioActual: DtoUsuarioActual = new DtoUsuarioActual();
    es: any;
    fr: any;
    languaje: string;

    public alfanumerico: RegExp = ConstanteUI.EXPRESIONES_REGULARES_ALFANUMERICO;
    public solonumeros: RegExp = ConstanteUI.EXPRESIONES_REGULARES_NUMERICO;
    public sololetras: RegExp = ConstanteUI.EXPRESIONES_REGULARES_LETRAS;
    public emailexpresion: RegExp = ConstanteUI.EXPRESIONES_REGULARES_EMAIL;

    constructor(protected messageService: MessageService) {

        this.init();
    }

    init() {
        this.es = {
            firstDayOfWeek: 1,
            dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
            dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
            dayNamesMin: ['D', 'L', 'M', 'X', 'J', 'V', 'S'],
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']
        };
        this.fr = {
            firstDayOfWeek: 1,
            dayNames: ['dimanche', 'lundi', 'mardi', 'mercredi', 'jeudi', 'vendredi', 'samedi'],
            dayNamesShort: ['dim', 'lun', 'mar', 'mer', 'jeu', 'ven', 'sam'],
            dayNamesMin: ['D', 'L', 'M', 'X', 'J', 'V', 'S'],
            monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'mai', 'juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
            monthNamesShort: ['jan', 'fev', 'mar', 'avr', 'mai', 'jui', 'jul', 'aou', 'sep', 'oct', 'nov', 'dec']
        };
        window.onbeforeunload = null;
        this.languaje = localStorage.getItem('lang');


        const ss = sessionStorage.getItem('usuarioActual');
        if (ss !== undefined && ss != null) {
            const usuario = JSON.parse(ss) as DtoUsuarioActual;
            this.usuarioActual = usuario;
        }

    }


    mostrarMensajeAdvertencia(mensaje: string): void {
        this.mostrarMensaje(mensaje, 'warn');
    }
    mostrarMensajeAdvertenciaFechas(): void {
        this.mostrarMensaje("La fecha fin no debe ser menor a la fecha de inicio.", 'warn');
    }

    mostrarMensaje(mensaje: string, tipo: string): void {
        this.messageService.clear();
        this.messageService.add({ severity: tipo, summary: 'Mensaje', detail: mensaje });
    }

    mostrarMensajeExito(mensaje: string): void {
        this.mostrarMensaje(mensaje, 'success');
    }

    mostrarMensajeInfo(mensaje: string): void {
        this.mostrarMensaje(mensaje, 'info');
    }

    mostrarMensajeError(mensaje: string): void {
        this.mostrarMensaje(mensaje, 'error');
    }
    
    getMensajeGrabado(value: any): string {
        return 'El Registro Nro. ' + value + ' se guardó con éxito';
    }

    getMensajeGrabadoObs(value: any): string {
        return 'Se ha generado el informe de Observaciones N° ' + value;
    }

    getMensajeActualizado(value: any): string {
        return 'La Actualización Nro. ' + value + ' se guardó con éxito';
    }

    getMensajeEliminado(value: any): string {
        return 'El Registro Nro. ' + value + ' fue eliminado';
    }

    getMensajeInactivado(value: any): string {
        return 'El Registro Nro. ' + value + ' fue inactivado';
    }


    getMensajeInactivadoMensaje(): string {
        return '¿Desea inactivar este registro?';
    }


    getMensajeInactivadoHeader(): string {
        return 'Inactivar Registro';
    }


    bloquearPagina(): void {
        if (!this.blocked) {
            this.blocked = true;
            console.log("block")
        }
    }

    desbloquearPagina(): void {
        if (this.blocked) { this.blocked = false; }
    }

    esFechaVacia(fecha: Date): boolean {
        if (fecha == null) {
            return true;
        }
        if (fecha == undefined) {
            return true;
        }

        return false;
    }


    esListaVacia(lista: any): boolean {
        if (lista == null) {
            return true;
        }
        if (lista == undefined) {
            return true;
        }
        if (lista.length == 0) {
            return true;
        }
        return false;
    }

    estaVacio(cadena: string): boolean {
        if (cadena == null) {
            return true;
        }
        if (cadena == undefined) {
            return true;
        }
        if (cadena.trim() === '') {
            return true;
        }
        return false;
    }

    esNumeroVacio(numero): boolean {
        if (numero == null) {
            return true;
        }
        if (numero === undefined) {
            return true;
        }
        // if (numero == '') {
        //     return true;
        // }
        return false;
    }

    esNumeroVacioCero(numero): number {
        if (numero == null) {
            return 0;
        }
        if (numero === undefined) {
            return 0;
        } else {
            return numero
        }
    }

}