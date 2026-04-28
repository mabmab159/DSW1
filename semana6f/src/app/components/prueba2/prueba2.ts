import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-prueba2',
  imports: [FormsModule],
  templateUrl: './prueba2.html',
  styleUrl: './prueba2.css',
})
export class Prueba2 {
  textoGenerativo: string = '';

  public recuperarTexto(): void {
    console.log(this.textoGenerativo);
  }
}
