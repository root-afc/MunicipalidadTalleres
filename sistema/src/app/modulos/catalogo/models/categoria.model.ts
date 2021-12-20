import { Taller } from './taller.model';

export class Categoria {
  id: number;
  nombre: string;
  talleres?: Array<Taller>;
  estado?: boolean;

  constructor() {
    this.id = 0;
    this.nombre = '';
    this.talleres = [];
  }

}
