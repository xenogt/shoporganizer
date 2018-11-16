import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: Http) { }
  apiUrl = 'http://localhost:8080/shoporganizer/webapi';

  get(specificPath: string) {
    return this.http.get(`${this.apiUrl}/${specificPath}`);
  }
  
}
