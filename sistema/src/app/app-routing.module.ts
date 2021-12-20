import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContenedorComponent } from './layouts/web/contenedor/contenedor.component';
import {ReporteComponent} from './components/reporte/reporte.component';
import {AdministradorComponent} from './components/administrador/components/administrador/administrador.component';
import {Oauth2Guard} from './components/administrador/guards/oauth2.guard';
import {LoginAdminComponent} from './components/administrador/components/administrador/login-admin/login-admin.component';

const routes: Routes = [
  {
    path: '',
    component: ContenedorComponent,
    loadChildren: () => import('./modulos/modulos.module').then(m => m.ModulosModule)
  },
  { path: 'administrador/reporte/ver', component: ReporteComponent, canActivate: [Oauth2Guard] },
  { path: 'administrador/ver', component: AdministradorComponent, canActivate: [Oauth2Guard] },
  { path: 'administrador/crear', component: AdministradorComponent, canActivate: [Oauth2Guard] },
  { path: 'administrador/detalle/:id', component: AdministradorComponent, canActivate: [Oauth2Guard] },
  { path: 'administrador/actualizar/:nidSeccion', component: AdministradorComponent, canActivate: [Oauth2Guard] },
  { path: 'administrador/login', component: LoginAdminComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
