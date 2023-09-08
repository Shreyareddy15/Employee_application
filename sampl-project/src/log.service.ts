import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

// import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogService {
  get(arg0: string) {
    throw new Error('Method not implemented.');
  }
  public test: boolean=false ;
  public url:string='http://localhost:8080/employees'

  constructor(private http: HttpClient) { }
  getEmployeeData(): Observable<any>{
    return this.http.get('http://localhost:8080/employees/');
  }
  getEmployeeById(id: number): Observable<any>{
    return this.http.get(`${this.url}/${id}`);
  }
  updateEmployee(employee: any): Observable<any> {
    return this.http.put(`${this.url}/${employee.eid}`, employee);
  }
  deleteEmployee(emp: any): Observable<any> {
    return this.http.delete(`${this.url}/${emp.eid}`, emp);
  }
}
