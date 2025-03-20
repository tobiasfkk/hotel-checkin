import { Component, OnInit } from '@angular/core';
  import { PeopleService } from '../../services/people.service';
  import { FormsModule } from '@angular/forms';
  import { CommonModule } from '@angular/common';

  @Component({
    selector: 'app-people-list',
    standalone: true,
    templateUrl: './people-list.component.html',
    imports: [FormsModule, CommonModule],
    styleUrls: ['./people-list.component.css']
  })
  export class PeopleListComponent implements OnInit {
    people: any[] = [];
    filteredPeople: any[] = [];
    checkIn = {
      entrada: '',
      saida: '',
      pessoa: '',
      possuiVeiculo: false
    };

    constructor(private peopleService: PeopleService) {}

    ngOnInit(): void {
      this.peopleService.getAllPeople().subscribe(data => {
        this.people = data;
        this.filteredPeople = data;
      });
    }

    incluirPessoa(): void {
      // Lógica para incluir pessoa
    }

    salvarCheckIn(): void {
      // Lógica para salvar check-in
    }

    filtrarPessoas(filtro: string): void {
      if (filtro === 'deixaram') {
        this.filteredPeople = this.people.filter(person => person.deixouHotel);
      } else if (filtro === 'presentes') {
        this.filteredPeople = this.people.filter(person => !person.deixouHotel);
      }
    }
  }
