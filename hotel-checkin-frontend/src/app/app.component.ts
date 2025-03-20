import { Component } from '@angular/core';
import { CheckinFormComponent } from './components/checkin-form/checkin-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  template: `<app-checkin-form></app-checkin-form>`,
  imports: [CheckinFormComponent]
})
export class AppComponent {}
