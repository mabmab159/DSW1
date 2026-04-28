import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Prueba1 } from './components/prueba1/prueba1';
import { Prueba2 } from './components/prueba2/prueba2';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Prueba1, Prueba2],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('semana6f');
}
