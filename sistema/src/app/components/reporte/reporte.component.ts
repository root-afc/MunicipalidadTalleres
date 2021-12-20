
import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FilterMatchMode, FilterService, SelectItem} from 'primeng/api';
// import {Inscrito} from '../../../models/inscrito.model';
// import {ReporteService} from '../../../services/reporte.service';
// import {Estudiante} from '../../../../pasarela/models/estudiante.model';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
// import {GrupoSanguineo} from '../../../../pasarela/models/grupoSanguineo.model';
// import {Seguro} from '../../../../pasarela/models/seguro.model';
// import {Departamento} from '../../../../pasarela/models/departamento.model';
// import {Provincia} from '../../../../pasarela/models/provincia.model';
// import {Distrito} from '../../../../pasarela/models/distrito.model';
// import {CheckoutService} from '../../../../pasarela/services/checkout.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {Inscrito} from '../../modulos/catalogo/models/inscrito.model';
import {Estudiante} from '../../modulos/pasarela/models/estudiante.model';
import {Apoderado} from '../../modulos/pasarela/models/apoderado.model';
import {GrupoSanguineo} from '../../modulos/pasarela/models/grupoSanguineo.model';
import {Seguro} from '../../modulos/pasarela/models/seguro.model';
import {Departamento} from '../../modulos/pasarela/models/departamento.model';
import {Provincia} from '../../modulos/pasarela/models/provincia.model';
import {Distrito} from '../../modulos/pasarela/models/distrito.model';
import {ReporteService} from '../../modulos/catalogo/services/reporte.service';
import {CheckoutService} from '../../modulos/pasarela/services/checkout.service';
import {InscritosPorSecciones} from '../../modulos/catalogo/models/inscritosPorSecciones.model';
import {MediaMatcher} from '@angular/cdk/layout';
import {Router} from '@angular/router';
// import {Apoderado} from '../../../../pasarela/models/apoderado.model';
// import {InscritosPorSecciones} from '../../../models/inscritosPorSecciones.model';

@Component({
  selector: 'app-reporte',
  templateUrl: './reporte.component.html',
  styleUrls: ['./reporte.component.css']
})
export class ReporteComponent implements OnInit {
  mobileQuery: MediaQueryList;
  inscritos: Inscrito[];
  inscritosFiltro: Inscrito[];
  cols: any[];
  matchModeOptions: SelectItem[];
  coutRowsInscritos: any;
  modalDialog: boolean;
  estudiante?: Estudiante;
  apoderado?: Apoderado;
  isAdult: boolean;
  formEstudiante: FormGroup;
  formApoderado: FormGroup;

  grupoSanguineos: GrupoSanguineo[];
  seguros: Seguro[];
  departamentos: Departamento[];
  provincias: Provincia[];
  distritos: Distrito[];
  departamentosApo: Departamento[];
  provinciasApo: Provincia[];
  distritosApo: Distrito[];
  distritosDomicilio: Distrito[];


  // tslint:disable-next-line:max-line-length
  constructor(private fb: FormBuilder, private filterService: FilterService, private reporteService: ReporteService, private datePipe: DatePipe, private modalService: NgbModal, private checkoutService: CheckoutService,
              changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private router: Router) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
    this.inscritosFiltro = [];
    this.inscritos = [];
    this.cols = [];
    this.coutRowsInscritos = 0;
    this.modalDialog = true;
    this.estudiante = new Estudiante();
    this.isAdult = true;
    this.grupoSanguineos = [];
    this.seguros = [];
    this.departamentos = [];
    this.provincias = [];
    this.distritos = [];
    this.departamentosApo = [];
    this.provinciasApo = [];
    this.distritosApo = [];
    this.distritosDomicilio = [];

    this.formEstudiante = new FormGroup({});
    this.formApoderado = new FormGroup({});
  }
  // tslint:disable-next-line:variable-name
  _mobileQueryListener: () => void;
  Menu(indice: number): void {
    switch (indice) {
      case 0:
        this.router.navigateByUrl('administrador/ver');
        break;
      case 1:
        this.router.navigateByUrl('administrador/crear');
        break;
      case 2:
        this.router.navigateByUrl('administrador/reporte/ver');
        break;
    }
  }
  CloseSession(): void {
    localStorage.removeItem('auth_token');
    localStorage.removeItem('role');
    this.router.navigateByUrl('administrador/login');
  }
  ngOnInit(): void {

    const customFilterName = 'custom-equals';

    this.filterService.register(
      customFilterName,
      (value, filter): boolean => {
        if (filter === undefined || filter === null || filter.trim() === '') {
          return true;
        }

        if (value === undefined || value === null) {
          return false;
        }

        return value.toString() === filter.toString();
      }
    );

    this.cols = [
      { field: 'taller', header: 'taller' },
      { field: 'edad', header: 'categoria' },
      { field: 'dia', header: 'dia' },
      { field: 'hora', header: 'hora' },
      { field: 'e_id', header: 'e_id' },
      { field: 'e_dni', header: 'e_dni' },
      { field: 'e_nombre', header: 'e_nombre' },
      { field: 'e_ape_paterno', header: 'e_ape_paterno' },
      { field: 'e_ape_materno', header: 'e_ape_materno' },
      { field: 'e_movil', header: 'e_movil' },
      { field: 'e_correo', header: 'e_correo' },
      { field: 'e_fecha_nacimiento', header: 'e_fecha_nacimiento' },
      { field: 'fecha', header: 'fecha' },
      { field: 'm_id', header: 'm_id' }
    ];

    this.matchModeOptions = [
      { label: 'Igual a', value: customFilterName },
      { label: 'Inicia con', value: FilterMatchMode.STARTS_WITH },
      { label: 'Contiene', value: FilterMatchMode.CONTAINS }
    ];

    this.reporteService.getInscritos().subscribe(response => {
      this.inscritos  = response;
    });

    this.coutRowsInscritos = this.inscritos.length;

    this.formEstudiante = this.fb.group({
      numero_carnet: [''],
      nombres: ['', Validators.required],
      ape_paterno: ['', Validators.required],
      ape_materno: ['', Validators.required],
      sexo: ['Hombre', Validators.required],
      dni: ['', [Validators.required, Validators.minLength(8)]],
      direccion: ['', Validators.required],
      fecha_nacimiento: ['', Validators.required],
      distrito_de_domicilio: ['150137', Validators.required],
      telefono: '',
      movil: ['', [Validators.required, Validators.minLength(9)]],
      correo: ['', [Validators.required, Validators.email]],
      correo_confirmacion: ['', [Validators.required, Validators.email]],
      seguro: ['', Validators.required],
      enfermedades: [''],
      medicinas: [''],
      sanguineo: [''],
      departamento: [''],
      provincia: [''],
      distrito: ['']
    });
    this.formEstudiante.disable();

    this.formApoderado = this.fb.group({
      dni: ['', [Validators.required, Validators.minLength(8)]],
      nombres: ['', [Validators.required]],
      ape_paterno: ['', [Validators.required]],
      ape_materno: ['', [Validators.required]],
      direccion: ['', [Validators.required]],
      fecha_nacimiento: ['', [Validators.required]],
      distrito_de_domicilio: ['150137', [Validators.required]],
      telefono: [''],
      movil: ['', [Validators.required, Validators.minLength(9)]],
      correo: ['', [Validators.required, Validators.email]],
      departamento: ['', [Validators.required]],
      provincia: ['', [Validators.required]],
      distrito: ['', [Validators.required]]
    });
    this.formApoderado.disable();

    this.getSanguineos();
    this.getSeguros();
    this.getDepartamentos();
    this.mostrarDistritosDomicilio('1501');
  }

  mostrarEstudiante(content: any, dni: any){
    this.buscarEstudiantePorDni(dni);
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'custom-student', centered: true});
  }

  onFilter(event, dt) {
    // this.inscritos = event.filteredValue;
    this.inscritosFiltro = event.filteredValue;
    this.coutRowsInscritos = event.filteredValue.length;
  }

  exportExcelInscritosPorSecciones() {
    this.reporteService.getInscritosPorSecciones().subscribe(response => {
      const inscritosTmp: InscritosPorSecciones[] = [];
      response.forEach(obj => {
        const item = new InscritosPorSecciones();
        item.categoria = obj.categoria;
        item.taller = obj.taller;
        item.edad = obj.edad;
        item.hora = obj.hora;
        item.dia = obj.dia;
        item.precio = obj.precio;
        item.maximo = obj.maximo;
        item.total_Inscritos = obj.total_Inscritos;
        inscritosTmp.push(item);
      });

      import('xlsx').then(xlsx => {
        const worksheet = xlsx.utils.json_to_sheet(inscritosTmp);
        const workbook = { Sheets: { data: worksheet }, SheetNames: ['data'] };
        const excelBuffer: any = xlsx.write(workbook, { bookType: 'xlsx', type: 'array' });
        this.saveAsExcelFile(excelBuffer, 'Inscritos por secciones');
      });
    });


  }

  exportExcel() {

    const inscritosTmp: Inscrito[] = [];
    this.inscritosFiltro.forEach(obj => {
      const item = new Inscrito();
      item.taller = obj.taller;
      item.categoria = obj.categoria;
      item.edad = obj.edad;
      item.hora = obj.hora;
      item.dia = obj.dia;
      item.e_nombre = obj.e_nombre;
      item.e_ape_paterno = obj.e_ape_paterno;
      item.e_ape_materno = obj.e_ape_materno;
      item.e_dni = obj.e_dni;
      item.e_movil = obj.e_movil;
      item.e_correo = obj.e_correo;
      item.e_fecha_nacimiento = obj.e_fecha_nacimiento;
      item.fecha = obj.fecha;
      inscritosTmp.push(item);
    });
    // this.inscritos = inscritosTmp;

    import('xlsx').then(xlsx => {
      const worksheet = xlsx.utils.json_to_sheet(inscritosTmp);
      const workbook = { Sheets: { data: worksheet }, SheetNames: ['data'] };
      const excelBuffer: any = xlsx.write(workbook, { bookType: 'xlsx', type: 'array' });
      this.saveAsExcelFile(excelBuffer, 'Inscritos');
    });
  }

  saveAsExcelFile(buffer: any, fileName: string): void {
    import('file-saver').then(FileSaver => {
      const EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';
      const EXCEL_EXTENSION = '.xlsx';
      const data: Blob = new Blob([buffer], {
        type: EXCEL_TYPE
      });
      FileSaver.saveAs(data, fileName + '_export_' + new Date().getTime() + EXCEL_EXTENSION);
    });
  }

  getSanguineos(): void{
    this.checkoutService.getSanguineos().subscribe(data => {
      this.grupoSanguineos = data;
    });
  }
  getSeguros(): void{
    this.checkoutService.getSeguros().subscribe(data => {
      this.seguros = data;
    });
  }

  getDepartamentos(): void{
    this.checkoutService.getDepartamentos().subscribe(data => {
      this.departamentos = data;
      this.departamentosApo = data;
    });
  }
  mostrarProvincias(cod: string): void{
    this.checkoutService.getProvincias(cod).subscribe(data => {
      this.provincias = data;
      this.distritos = [];
    });
  }
  mostrarDistritos(cod: string): void{
    this.checkoutService.getDistritos(cod).subscribe(data => {
      this.distritos = data;
    });
  }
  mostrarProvinciasApo(cod: string): void{
    this.checkoutService.getProvincias(cod).subscribe(data => {
      this.provinciasApo = data;
      this.distritosApo = [];
    });
  }
  mostrarDistritosApo(cod: string): void{
    this.checkoutService.getDistritos(cod).subscribe(data => {
      this.distritosApo = data;
    });
  }

  mostrarDistritosDomicilio(cod: string): void{
    this.checkoutService.getDistritos(cod).subscribe(data => {
      this.distritosDomicilio = data;
    });
  }
  validarEdad(value: string): void{
    const today = new Date();
    const birthDate = new Date(value);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) { age = age - 1; }
    this.isAdult = (age >= 18) ? true : false;
  }

  buscarEstudiantePorDni(cod: string): void{
    if (cod.length == 8) {
      this.checkoutService.buscarEstudiantePorDni(cod).subscribe(data => {
        if (data != undefined){
          this.estudiante = data;
          this.validarEdad(this.estudiante.fecha_nacimiento);

          if (this.estudiante?.departamento != null && this.estudiante?.departamento != '') { this.mostrarProvincias(this.estudiante.departamento); }
          if (this.estudiante?.provincia != null && this.estudiante?.provincia != '') { this.mostrarDistritos(this.estudiante.provincia); }

          this.formEstudiante.patchValue(this.estudiante);
          this.formEstudiante.patchValue({
            seguro: (this.estudiante?.seguro?.id != null) ? this.estudiante.seguro.id : '',
            sanguineo: (this.estudiante?.sanguineo?.id != null) ? this.estudiante.sanguineo.id : '',
            fecha_nacimiento: this.datePipe.transform(this.estudiante.fecha_nacimiento, 'yyyy-MM-dd')
          });
          console.log('this.estudiante', this.estudiante);
          if (this.estudiante.apoderado_id != '0') { this.buscarApoderadoPorId(this.estudiante.apoderado_id); }
        }
      });
    }
  }

  buscarApoderadoPorId(cod: string): void{
    this.checkoutService.buscarApoderadoPorId(cod).subscribe(data => {
      if (data != undefined) {
        this.apoderado = data;

        this.mostrarProvinciasApo(this.apoderado.departamento);
        this.mostrarDistritosApo(this.apoderado.provincia);

        this.formApoderado.patchValue(this.apoderado);
        this.formApoderado.patchValue({
          fecha_nacimiento: this.datePipe.transform(this.apoderado?.fecha_nacimiento, 'yyyy-MM-dd')
        });
      }
    });
  }

}
