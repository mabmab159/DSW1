import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-prueba1',
  imports: [],
  templateUrl: './prueba1.html',
  styleUrl: './prueba1.css',
})
export class Prueba1 {
  arregloNombres: string[] = ["hola", "pepe", "Raul"];
  nombreDocente: string = "Miguel Berrio";
  numero1: number = 5;
  numero2: any = {}

  constructor(private readonly http: HttpClient) {
    this.invocarConsola();
    this.obtenerInformacion();
  }

  public invocarConsola(): void {
    console.log(this.nombreDocente);
  }

  public obtenerInformacion(): void {
    this.http.get('http://localhost:8081/usuarios/unprotected')
      .subscribe(p => console.log("Informacion recuperada: "+p));
  }
}
