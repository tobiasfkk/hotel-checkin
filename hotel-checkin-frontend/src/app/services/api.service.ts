import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = `${environment.apiUrl}/people`;

  constructor(private http: HttpClient) {}

  createPerson(person: any): Observable<any> {
    return this.http.post(this.apiUrl, person);
  }

  getPeople(): Observable<any> {
    return this.http.get(`${this.apiUrl}/people`);
  }

  searchPeople(query: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/search?query=${query}`);
  }

  createCheckin(checkin: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/checkins`, checkin);
  }
}
