import { Routes } from '@angular/router';
import { Prueba1 } from './components/prueba1/prueba1';
import { Prueba2 } from './components/prueba2/prueba2';

export const routes: Routes = [
  {path:"", component: Prueba1},
  {path:"prueba2", component: Prueba2},
  {path:"prueba3/**", component: Prueba2}
];
