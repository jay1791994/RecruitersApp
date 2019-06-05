import { Injectable } from '@angular/core';
import { Tabledata } from '../model/tabledata';

@Injectable({
  providedIn: 'root'
})
export class Tabel2Service {
  private tableData: Tabledata[] = [
   ];

  constructor() { };
  
  getdata(): Tabledata[]{
       console.log("is called")
       return this.tableData;
  };
}
