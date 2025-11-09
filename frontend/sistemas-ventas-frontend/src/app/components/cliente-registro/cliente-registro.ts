import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Para *ngIf
import { FormsModule } from '@angular/forms'; // ¡MUY IMPORTANTE para [(ngModel)]!
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router'; // Para redirigir

@Component({
  selector: 'app-cliente-registro',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule // <-- Importa esto para que el formulario funcione
  ],
  templateUrl: './cliente-registro.html',
  styleUrl: './cliente-registro.css'
})
// 1. Cambiamos el nombre de la clase
export class ClienteRegistroComponent {

  // 2. Variable para "atar" (bind) al formulario HTML
  public clienteModel = {
    nombre: '',
    correo: ''
  };

  // 3. Variable para dar mensajes al usuario
  public mensaje = '';
  public error = false;

  // 4. Inyectamos el Servicio API y el Router
  constructor(
    private apiService: ApiService,
    private router: Router
  ) { }

  // 5. Método que se llama cuando el usuario envía el formulario
  public registrarCliente(): void {
    this.mensaje = '';
    this.error = false;

    // Llama al servicio
    this.apiService.registrarCliente(this.clienteModel).subscribe(
      (respuesta) => {
        this.error = false;
        this.mensaje = `¡Cliente "${respuesta.nombre}" registrado con éxito! (ID: ${respuesta.id})`;
        
        // Opcional: Limpia el formulario
        this.clienteModel = { nombre: '', correo: '' };

        // Opcional: Redirige a la lista de sorteos después de 2 segundos
        setTimeout(() => {
          this.router.navigate(['/sorteos']);
        }, 2000);
      },
      (error) => {
        this.error = true;
        this.mensaje = 'Error al registrar el cliente. ¿Quizás el correo ya existe?';
        console.error(error);
      }
    );
  }
}