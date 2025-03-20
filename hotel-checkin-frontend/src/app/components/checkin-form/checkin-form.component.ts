import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-checkin-form',
  standalone: true,
  templateUrl: './checkin-form.component.html',
  styleUrls: ['./checkin-form.component.css'],
  imports: [NgFor, FormsModule]
})
export class CheckinFormComponent implements OnInit {
  checkin = {
    person: { id: null },
    dataEntrada: '',
    dataSaida: '',
    adicionalVeiculo: false
  };
  people: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.loadPeople();
  }

  loadPeople(): void {
    this.apiService.getPeople().subscribe(data => {
      this.people = data;
    });
  }

  onSubmit(): void {
    this.apiService.createCheckin(this.checkin).subscribe(response => {
      alert('Check-in realizado com sucesso!');
      this.resetForm();
    });
  }

  resetForm(): void {
    this.checkin = {
      person: { id: null },
      dataEntrada: '',
      dataSaida: '',
      adicionalVeiculo: false
    };
  }
}
