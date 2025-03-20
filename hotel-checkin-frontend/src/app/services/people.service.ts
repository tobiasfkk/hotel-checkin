import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {
  private apiUrl = `${environment.apiUrl}/people`;

  constructor(private http: HttpClient) {}

  createPerson(person: any): Observable<any> {
    return this.http.post(this.apiUrl, person);
  }

  getAllPeople(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  searchPeople(query: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/search?query=${query}`);
  }
}
