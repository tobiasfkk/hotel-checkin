import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api'; // Corrigido

  constructor(private http: HttpClient) {}

  createPerson(person: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/people`, person);
  }

  getPeople(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/people`);
  }

  searchPeople(query: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/people/search?query=${query}`);
  }

  createCheckin(checkin: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/checkins`, checkin);
  }

  getCheckins(): Observable<any> {
    return this.http.get(`${this.apiUrl}/checkins`);
  }

  // getActiveCheckins(): Observable<any> {
  //   return this.http.get(`${this.apiUrl}/checkins/active`);
  // }
  //
  // getInactiveCheckins(): Observable<any> {
  //   return this.http.get(`${this.apiUrl}/checkins/inactive`);
  // }

  getActiveCheckins(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/checkins/active`);
  }

  getInactiveCheckins(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/checkins/inactive`);
  }

  getCheckinTotal(checkinId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/checkins/total/${checkinId}`);
  }
}
