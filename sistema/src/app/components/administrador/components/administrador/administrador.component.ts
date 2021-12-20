import {ChangeDetectorRef, Component, HostListener, Injectable, OnDestroy, OnInit, Pipe, ViewChild} from '@angular/core';
import {NgxSpinnerService} from 'ngx-spinner';
import {Categoria} from 'src/app/modulos/catalogo/models/categoria.model';
import {CategoriaService} from 'src/app/modulos/catalogo/services/categoria.service';
import {Form, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import Swal from 'sweetalert2';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import {APP_DATE_FORMATS, AppDateAdapter} from './format-datepicker';
import {DatePipe} from '@angular/common';
import {ActivatedRoute, Router} from '@angular/router';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MediaMatcher} from '@angular/cdk/layout';
import {AdministradorService} from './administrador.service';

export interface Filtro {
  name: string;
}

@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css'],
  providers: [{provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}, DatePipe]
})
@Injectable()
export class AdministradorComponent implements OnInit, OnDestroy  {
  mobileQuery: MediaQueryList;
  buscarForm = new FormControl();
  categoria = '';
  // @ts-ignore
  @ViewChild(MatTable) table: MatTable<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  displayedColumns: string[] = ['nidSeccion', 'snombreTaller', 'snombreCategoria', 'precio', 'minimo', 'maximo', 'snombreEdades',
    'snombreHoras', 'snombreDias', 'snombreLugares', 'inscritos', 'dfechaSeccionDesde', 'dfechaSeccionHasta', 'username', 'dfchActualizacion',
    'actions'];
  minDate = new Date();
  menuCrear = false;
  menuVer = false;
  menuDetalle = false;
  menuActualizar = false;
  menuReporte = false;
  p = 1;
  filtros: Filtro[] = [{name: 'Deportes'}, {name: 'Arte'}, {name: 'Danza/Baile'}, {name: 'Música'}, {name: 'Idiomas'},
    {name: 'Educativo'}, {name: 'Academia CepreMuni'}];
  categorias: Categoria[] = [];
  edades: any[] = [];
  temporadas: any[] = [];
  talleres: any[] = [];
  horas: any[] = [];
  dias: any[] = [];
  lugares: any[] = [];
  talleresFilter = new MatTableDataSource<any>();
  idDetalle = undefined;
  nidSeccion = undefined;
  fgTaller: FormGroup | undefined;
  fgTallerActualizar: FormGroup | undefined;
  fgCategoria: FormGroup | undefined;
  objTallerSeccion: any = [];
  talleresLista: any[] = [];

  constructor(private activatedRoute: ActivatedRoute, private spinner: NgxSpinnerService, private categoriaService: CategoriaService,
              private administradorService: AdministradorService, private fb: FormBuilder, private datePipe: DatePipe,
              private router: Router, changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
    this.activatedRoute.params.subscribe(res => {
      this.idDetalle = res.id;
      this.nidSeccion = res.nidSeccion;
    });
    const ruta = this.router.url;
    switch (ruta) {
      case '/administrador/ver':
        this.menuVer = true;
        break;
      case '/administrador/crear':
        this.menuCrear = true;
        break;
      case '/administrador/detalle/' + this.idDetalle:
        this.menuDetalle = true;
        break;
      case '/administrador/actualizar/' + this.nidSeccion:
        this.menuActualizar = true;
        break;
    }
    this.newFgTaller();
    this.newFgCategoria();
    this.newFgTallerActualizar();
  }

  // tslint:disable-next-line:variable-name
  _mobileQueryListener: () => void;

  async ngOnInit(): Promise<void> {
    await this.Main();
    // @ts-ignore
    this.talleresFilter.paginator = this.paginator;
    await this.CargarDataFgTallerActualizar();
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.talleresFilter.filter = filterValue.trim().toLowerCase();
  }

  newFgTaller(): void {
    this.fgTaller = this.fb.group({
      tallerid: ['', [Validators.required]],
      descripcion: ['', []],
      edad: ['', [Validators.required]],
      temporada: ['', [Validators.required]],
      estado: [1, [Validators.required]],
      precio: ['', [Validators.required, Validators.min(30), Validators.max(500)]],
      calificacion: [9, [Validators.required]],
      hora: ['', [Validators.required]],
      dia: ['', [Validators.required]],
      lugar: ['', [Validators.required]],
      fchInicio: ['', [Validators.required]],
      fchFin: ['', [Validators.required]],
      minima: ['', [Validators.required, Validators.min(8), Validators.max(30)]],
      maxima: [30, [Validators.required, Validators.max(30)]],
    });
  }

  newFgTallerActualizar(): void {
    this.fgTallerActualizar = this.fb.group({
      tallerid: [{value: ''}, [Validators.required]],
      descripcion: ['', []],
      edad: ['', [Validators.required]],
      temporada: ['', [Validators.required]],
      estado: [1, [Validators.required]],
      precio: ['', [Validators.required, Validators.min(30), Validators.max(500)]],
      calificacion: [9, [Validators.required]],
      hora: ['', [Validators.required]],
      dia: ['', [Validators.required]],
      lugar: ['', [Validators.required]],
      fchInicio: ['', [Validators.required]],
      fchFin: ['', [Validators.required]],
      minima: ['', [Validators.required, Validators.min(8), Validators.max(30)]],
      maxima: ['', [Validators.required, Validators.max(30)]],
    });
  }

  async CargarDataFgTallerActualizar(): Promise<void> {
    if (this.nidSeccion !== undefined) {
      await this.administradorService.byIdTaller({nidSeccion: this.nidSeccion}).toPromise().then(res => {
        this.objTallerSeccion = res;
      });
      // tslint:disable-next-line:max-line-length
      this.fgTallerActualizar?.controls.tallerid.setValue(this.talleresLista.find(value => value.id === this.objTallerSeccion[0].nidTaller));
      this.fgTallerActualizar?.controls.descripcion.setValue(this.objTallerSeccion[0].descripcion);
      this.fgTallerActualizar?.controls.edad.setValue(this.edades.find(value => value.id === this.objTallerSeccion[0].edad_id));
      // tslint:disable-next-line:max-line-length
      this.fgTallerActualizar?.controls.temporada.setValue(this.temporadas.find(value => value.id === this.objTallerSeccion[0].temporada_id));
      this.fgTallerActualizar?.controls.precio.setValue(this.objTallerSeccion[0].precio);
      this.fgTallerActualizar?.controls.hora.setValue(this.horas.find(value => value.id === this.objTallerSeccion[0].hora_id));
      this.fgTallerActualizar?.controls.dia.setValue(this.dias.find(value => value.id === this.objTallerSeccion[0].dia_id));
      this.fgTallerActualizar?.controls.lugar.setValue(this.lugares.find(value => value.id === this.objTallerSeccion[0].lugar_id));
      this.fgTallerActualizar?.controls.fchInicio.setValue(this.objTallerSeccion[0].dfechaSeccionDesde);
      this.fgTallerActualizar?.controls.fchFin.setValue(this.objTallerSeccion[0].dfechaSeccionHasta);
      this.fgTallerActualizar?.controls.minima.setValue(this.objTallerSeccion[0].minimo);
      this.fgTallerActualizar?.controls.maxima.setValue(this.objTallerSeccion[0].maximo);
    }
  }

  async ActualizarSeccion(): Promise<void> {
    this.fgTallerActualizar?.markAsDirty();
    if (this.fgTallerActualizar?.valid) {
      const fgTallerObj = this.fgTallerActualizar.controls;
      // tslint:disable-next-line:max-line-length
      // const taller = {nombre: fgTallerObj.nombre.value, categoria_id: fgTallerObj.categoria.value.id, id: this.objTallerSeccion[0].nidTaller};

      const fchInicio = this.datePipe.transform(fgTallerObj.fchInicio.value, 'YYYY-MM-dd');
      const fchFin = this.datePipe.transform(fgTallerObj.fchFin.value, 'YYYY-MM-dd');
      const tallerSeccion = {
        id: this.objTallerSeccion[0].nidSeccion,
        // tslint:disable-next-line:max-line-length
        descripcion: fgTallerObj.descripcion.value,
        taller_id: this.fgTallerActualizar.controls.tallerid.value.id,
        edad_id: fgTallerObj.edad.value.id,
        temporada_id: fgTallerObj.temporada.value.id,
        estado: fgTallerObj.estado.value,
        precio: fgTallerObj.precio.value
        ,
        calificacion: fgTallerObj.calificacion.value,
        hora_id: fgTallerObj.hora.value.id,
        dia_id: fgTallerObj.dia.value.id,
        fecha_desde: fchInicio,
        fecha_hasta: fchFin,
        lugar_id: fgTallerObj.lugar.value.id,
        minimo: fgTallerObj.minima.value,
        maximo: fgTallerObj.maxima.value,
        nidUserActualizacion: localStorage.getItem('id_user')
      };
      await Swal.fire({
        icon: 'question',
        title: '¿Está seguro de actualizar el curso seleccionado?',
        showConfirmButton: true,
        showCancelButton: true,
        cancelButtonColor: '#d33',
        showCloseButton: true,
        heightAuto: false
      }).then(async (response) => {
        if (response.isConfirmed) {
          this.spinner.show();
          await this.administradorService.ActualizarSeccion(tallerSeccion).toPromise();
         // await this.administradorService.ActualizarUsuarioLog({id: localStorage.getItem('id_user')}).toPromise();
          this.spinner.hide();
          await Swal.fire(
            {
              title: 'Se actualizó con exito!',
              html: 'Click en OK para continuar!',
              icon: 'success',
              allowOutsideClick: false,
              confirmButtonText: 'Aceptar',
              confirmButtonColor: 'green',
              heightAuto: false
            }
          );
          await this.router.navigateByUrl('/administrador/ver');
        }
      });
    }
  }

  newFgCategoria(): void {
    this.fgCategoria = this.fb.group({
      categoria: ['', [Validators.required]]
    });
  }

  Main = async (): Promise<any> => {
    return new Promise<any>(async (resolve) => {
      this.spinner.show();
      const ServiceCategorias = this.categoriaService.getCategorias().toPromise();
      const ServiceTalleres = this.administradorService.getTalleres().toPromise();
      const ServiceEdades = this.administradorService.getEdades().toPromise();
      const ServiceTemporadas = this.administradorService.getTemporadas().toPromise();
      const ServiceHoras = this.administradorService.getHoras().toPromise();
      const ServiceDias = this.administradorService.getDias().toPromise();
      const ServiceLugares = this.administradorService.getLugares().toPromise();
      const ServiceTalleresLista = this.administradorService.getTallerLista().toPromise();
      await Promise.all([ServiceCategorias, ServiceTalleres, ServiceEdades, ServiceTemporadas,
        ServiceHoras, ServiceDias, ServiceLugares, ServiceTalleresLista]).then((value) => {
        this.categorias = value[0].map(({id, nombre, estado}) => {
          return {id, nombre, estado};
        });
        this.edades = value[2].data;
        this.temporadas = value[3];
        this.horas = value[4].data;
        this.dias = value[5].data;
        this.lugares = value[6].data;
        this.talleres = value[1];
        this.talleresLista = value[7];
        console.log(this.talleresLista);
        this.talleresFilter.data = this.talleres.filter((v => v.snombreCategoria.includes('Deportes')));
        this.categoria = 'Deportes';
        this.spinner.hide();
        resolve('Ok.');
      });
    });
  }

  async insertTaller(): Promise<any> {
    this.fgTaller?.markAsDirty();
    if (this.fgTaller?.valid) {
      // const taller = {nombre: this.fgTaller.controls.nombre.value, categoria_id: this.fgTaller.controls.categoria.value.id};
      await Swal.fire({
        icon: 'question',
        title: '¿Está seguro de crear el curso?',
        showConfirmButton: true,
        showCancelButton: true,
        cancelButtonColor: '#d33',
        showCloseButton: true,
        heightAuto: false
      }).then(async (x) => {
        if (x.isConfirmed) {
          this.spinner.show();
          // @ts-ignore
          const fgTallerObj = this.fgTaller.controls;
          // const fchNow = this.datePipe.transform(new Date(), 'YYYY-MM-dd');
          const fchInicio = this.datePipe.transform(fgTallerObj.fchInicio.value, 'YYYY-MM-dd');
          const fchFin = this.datePipe.transform(fgTallerObj.fchFin.value, 'YYYY-MM-dd');
          const tallerSeccion = {
            // tslint:disable-next-line:max-line-length
            descripcion: fgTallerObj.descripcion.value,
            taller_id: this.fgTaller?.controls.tallerid.value.id,
            edad_id: fgTallerObj.edad.value.id,
            temporada_id: fgTallerObj.temporada.value.id,
            estado: fgTallerObj.estado.value,
            precio: fgTallerObj.precio.value
            ,
            calificacion: fgTallerObj.calificacion.value,
            hora_id: fgTallerObj.hora.value.id,
            dia_id: fgTallerObj.dia.value.id,
            fecha_desde: fchInicio,
            fecha_hasta: fchFin,
            lugar_id: fgTallerObj.lugar.value.id,
            minimo: fgTallerObj.minima.value,
            maximo: fgTallerObj.maxima.value,
            nidUserCreacion: localStorage.getItem('id_user')
          };
          await this.administradorService.insertTallerSeccion(tallerSeccion).toPromise().then(async () => {
            this.spinner.hide();
            await Swal.fire(
              {
                title: 'Se creó con exito!',
                html: 'Click en OK para continuar!',
                icon: 'success',
                allowOutsideClick: false,
                confirmButtonText: 'Aceptar',
                confirmButtonColor: 'green',
                heightAuto: false
              }
            );
            this.router.navigateByUrl('/administrador/ver');
          });
          /*await this.administradorService.insertTaller(taller).toPromise().then(async (value) => {
          });*/
        }
      });
    }
  }

  // tslint:disable-next-line:typedef
  public noWhitespaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : {whitespace: true};
  }

  CategoriaSeleccionada(evento: any): void {
    this.buscarForm.setValue('');
    this.talleresFilter.filter = '';
    this.categoria = evento.value.nombre;
    this.talleresFilter.data = this.talleres.filter((value => value.snombreCategoria.includes(this.categoria)));
    this.p = 1;
  }

  Menu(indice: number): void {
    switch (indice) {
      case 0:
        this.router.navigateByUrl('administrador/ver');
        this.menuVer = true;
        this.menuCrear = false;
        break;
      case 1:
        this.router.navigateByUrl('administrador/crear');
        this.menuCrear = true;
        this.menuVer = false;
        break;
      case 2:
        this.router.navigateByUrl('administrador/reporte/ver');
        break;
    }
  }

  EliminarTaller(nidSeccion: any): void {
    Swal.fire({
      icon: 'question',
      title: '¿Está seguro de eliminar el curso seleccionado?',
      showConfirmButton: true,
      showCancelButton: true,
      cancelButtonColor: '#d33',
      showCloseButton: true,
      heightAuto: false
    }).then(async res => {
      if (res.isConfirmed) {
        this.spinner.show();
        await this.administradorService.EliminarTaller({nidSeccion}).toPromise().then(x => x);
        await this.administradorService.getTalleres().toPromise().then((data: any) => {
          this.talleres = data;
        });
        this.talleresFilter.data = this.talleres.filter((v => v.snombreCategoria.includes(this.categoria)));
        this.spinner.hide();
        await Swal.fire({
          icon: 'success',
          title: 'Se eliminó el curso seleccionado.',
          showCloseButton: true,
          showConfirmButton: true,
          heightAuto: false
        });
      }
    });
  }

  ActualizarT(nidSeccion: any): void {
    this.router.navigateByUrl('administrador/actualizar/' + nidSeccion);
  }

  CloseSession(): void {
    localStorage.removeItem('auth_token');
    localStorage.removeItem('role');
    this.router.navigateByUrl('administrador/login');
  }

  // @ts-ignore
  CheckDate(date: any): boolean {
    const actualDate = new Date();
    const stripedDate = this.datePipe.transform(actualDate, 'YYYY-MM-dd');
    if (stripedDate !== date) {
      return true;
    }
  }

  ngOnDestroy(): void {
  }
}
