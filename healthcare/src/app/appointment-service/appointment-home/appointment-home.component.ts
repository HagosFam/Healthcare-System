
import {Component} from '@angular/core';

@Component({
  selector: 'app-appointment-home',
  templateUrl: './appointment-home.component.html',
  styleUrls: ['./appointment-home.component.css']
})
export class AppointmentHomeComponent {
  foods = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ];

}
