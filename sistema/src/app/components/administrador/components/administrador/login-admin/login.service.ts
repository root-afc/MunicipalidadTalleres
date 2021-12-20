import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../../../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
  }

  loginJWT(data: any): Observable<any> {
    const url = 'http://localhost:8081/taller-service/auth/authenticate';
    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<any>(url, JSON.stringify(data), {headers: httpHeaders});
  }
}
