import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-people-list',
  standalone: true,
  templateUrl: './people-list.component.html',
  styleUrls: ['./people-list.component.css'],
  imports: [CommonModule]
})
export class PeopleListComponent implements OnInit {
  people: any[] = [];
  loading = false;
  errorMessage = '';

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.loadPeople();
  }

  loadPeople(): void {
    this.loading = true;
    this.apiService.getPeople().subscribe({
      next: (data) => {
        this.people = data;
        this.loading = false;
      },
      error: (error) => {
        this.errorMessage = 'Erro ao carregar pessoas.';
        console.error(error);
        this.loading = false;
      }
    });
  }
}
