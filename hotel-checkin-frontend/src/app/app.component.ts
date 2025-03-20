import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importa o CommonModule
import { PersonFormComponent } from './components/person-form/person-form.component';
import { CheckinFormComponent } from './components/checkin-form/checkin-form.component';
import { PeopleListComponent } from './components/people-list/people-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [CommonModule, PersonFormComponent, CheckinFormComponent, PeopleListComponent] // Inclua o CommonModule aqui!
})
export class AppComponent {
  activeForm: 'person' | 'checkin' | null = null;

  showForm(formType: 'person' | 'checkin') {
    this.activeForm = this.activeForm === formType ? null : formType;
  }
}
