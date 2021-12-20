import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdministradorService {
  constructor(private http: HttpClient) { }
  getTalleres(): Observable<any> {
    const url = environment.API_TALLERES_FIND;
    return this.http.get<any[]>(url);
  }
  getEdades(): Observable<any> {
    const url = environment.API_EDADES;
    return this.http.get<any[]>(url);
  }
  getTemporadas(): Observable<any> {
    const url = environment.API_TEMPORADAS;
    return this.http.get<any[]>(url);
  }
  getHoras(): Observable<any> {
    const url = environment.API_HORAS;
    return this.http.get<any[]>(url);
  }
  getDias(): Observable<any> {
    const url = environment.API_DIAS;
    return this.http.get<any[]>(url);
  }
  getLugares(): Observable<any> {
    const url = environment.API_LUGARES;
    return this.http.get<any[]>(url);
  }
  getTallerLista(): Observable<any> {
    const url = environment.API_TALLERES + '/fewx';
    return this.http.get<any[]>(url);
  }
  insertTaller(taller: any): Observable<any> {
    const url = environment.API_TALLERES;
    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(taller), {headers: httpHeaders});
  }
  insertTallerSeccion(tallerSeccion: any): Observable<any> {
    const url = environment.API_SECCIONES + '/savex';
    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(tallerSeccion), {headers: httpHeaders});
  }
  EliminarTaller(id: any): Observable<any> {
    const url = environment.API_BASE_TALLERES + 'talleres/eliminarx';
    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(id), {headers: httpHeaders});
  }
  byIdTaller(id: any): Observable<any> {
    const url = environment.API_BASE_TALLERES + 'talleres/byidx';
    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(id), {headers: httpHeaders});
  }
  ActualizarSeccion(SeccionUpdate: any): Observable<any> {
    const url = environment.API_SECCIONES + '/updatex';
    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(SeccionUpdate), {headers: httpHeaders});
  }
}
