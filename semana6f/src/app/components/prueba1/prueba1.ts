import { ChangeDetectorRef, Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../../interfaces/usuario';

@Component({
  selector: 'app-prueba1',
  standalone: true,
  imports: [],
  templateUrl: './prueba1.html',
  styleUrl: './prueba1.css',
})
export class Prueba1 {
  arregloNombres: string[] = ['hola', 'pepe', 'Raul'];
  nombreDocente: string = 'Miguel Berrio';
  numero1: number = 5;
  usuario: Usuario = {} as Usuario;
  usuarios: Usuario[] = [];

  constructor(
    private readonly http: HttpClient,
    private cdr: ChangeDetectorRef,
  ) {
    this.obtenerInformacion2();
    //this.obtenerInformacion3();
    this.obtenerToken();
    this.obtenerInformacionConSeguridad();
  }

  public invocarConsola(): void {
    console.log(this.nombreDocente);
  }

  public obtenerInformacion(): void {
    this.http
      .get('http://localhost:8081/usuarios/unprotected')
      .subscribe((p) => console.log('Informacion recuperada: ' + p));
  }

  public obtenerInformacion2(): void {
    this.http.get<Usuario>('http://localhost:8081/usuarios/unprotected/2').subscribe({
      next: (p) => {
        console.log('Usuario recibido:', p);
        this.usuario = { ...p };
        this.cdr.detectChanges();
      },
      error: (e) => console.error('Error al obtener usuario:', e),
    });
  }

  public obtenerInformacion3(): void {
    this.http.get<Usuario[]>('http://localhost:8081/usuarios/unprotected').subscribe((p) => {
      this.usuarios = p;
      this.cdr.detectChanges();
    });
  }

  public obtenerToken(): void {
    this.http
      .post(
        'http://localhost:8081/usuarios/login',
        {
          "usuario": 'user',
          "password": 'password',
        },
        { responseType: 'text', observe: 'response' },
      )
      .subscribe((p) => {
        if (p.status === 200) {
          if (typeof p.body === 'string') {
            localStorage.setItem('token', p.body);
          }
        }
      });
  }

  public obtenerInformacionConSeguridad(): void {
    this.http
      .get<Usuario[]>('http://localhost:8081/usuarios', {
        headers: {
          Authorization: `${localStorage.getItem("token")}`},
      })
      .subscribe((p) => {
        this.usuarios = p;
        this.cdr.detectChanges();
      });
  }
}
