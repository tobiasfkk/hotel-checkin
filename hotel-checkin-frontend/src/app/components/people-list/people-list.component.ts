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
  filteredPeople: any[] = [];
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
        this.filteredPeople = data;
        this.loadTotalSpent();
      },
      error: (error) => {
        this.errorMessage = 'Erro ao carregar pessoas.';
        console.error(error);
        this.loading = false;
      }
    });
  }

  loadTotalSpent(): void {
    this.people.forEach(person => {
      this.apiService.getCheckinTotal(person.id).subscribe({
        next: (total) => {
          person.totalGasto = total;
        },
        error: (error) => {
          console.error(`Erro ao carregar total gasto para a pessoa com ID ${person.id}`, error);
          person.totalGasto = 0;
        }
      });
    });
    this.loading = false;
  }

  filterPeople(status: string): void {
    this.loading = true;
    this.apiService.getPeople().subscribe({
      next: (data) => {
        this.people = data;
        if (status === 'presentes') {
          this.apiService.getActiveCheckins().subscribe({
            next: (checkins) => {
              const activeIds = checkins.map(checkin => checkin.person.id);
              this.filteredPeople = this.people.filter(person => activeIds.includes(person.id));
              this.loadTotalSpent();
            },
            error: (error) => {
              this.errorMessage = 'Erro ao carregar check-ins ativos.';
              console.error(error);
              this.loading = false;
            }
          });
        } else if (status === 'deixaram') {
          this.apiService.getInactiveCheckins().subscribe({
            next: (checkins) => {
              const inactiveIds = checkins.map(checkin => checkin.person.id);
              this.filteredPeople = this.people.filter(person => inactiveIds.includes(person.id));
              this.loadTotalSpent();
            },
            error: (error) => {
              this.errorMessage = 'Erro ao carregar check-ins inativos.';
              console.error(error);
              this.loading = false;
            }
          });
        }
      },
      error: (error) => {
        this.errorMessage = 'Erro ao carregar pessoas.';
        console.error(error);
        this.loading = false;
      }
    });
  }
}
