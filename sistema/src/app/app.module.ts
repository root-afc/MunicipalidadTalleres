import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PortadaComponent } from './layouts/web/portada/portada.component';
import { ContenedorComponent } from './layouts/web/contenedor/contenedor.component';
import { ModulosModule } from './modulos/modulos.module';
import { ActividadesRoutingModule } from './modulos/actividades/actividades-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ResumenCarritoComponent} from './components/resumen-carrito/resumen-carrito.component';
import {ReporteComponent} from './components/reporte/reporte.component';
import {TableModule} from 'primeng/table';
import {DemoMaterialModule} from './material-module';
import {AdministradorComponent} from './components/administrador/components/administrador/administrador.component';
import {NgxSpinnerModule} from 'ngx-spinner';
import {LoginAdminComponent} from './components/administrador/components/administrador/login-admin/login-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    PortadaComponent,
    ContenedorComponent,
    ResumenCarritoComponent,
    ReporteComponent,
    AdministradorComponent,
    LoginAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModulosModule,
    ActividadesRoutingModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    TableModule,
    ReactiveFormsModule,
    DemoMaterialModule,
    NgxSpinnerModule
  ],
  providers: [
    DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
