import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-person-form',
  standalone: true,
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css'],
  imports: [CommonModule, FormsModule]
})
export class PersonFormComponent {
  person = {
    nome: '',
    documento: '',
    telefone: ''
  };
  successMessage = '';

  constructor(private apiService: ApiService) {}

  onSubmit(): void {
    this.apiService.createPerson(this.person).subscribe({
      next: () => {
        this.successMessage = 'Pessoa cadastrada com sucesso!';
        this.resetForm();
      },
      error: () => {
        alert('Erro ao cadastrar pessoa.');
      }
    });
  }

  resetForm(): void {
    this.person = {
      nome: '',
      documento: '',
      telefone: ''
    };
  }
}
