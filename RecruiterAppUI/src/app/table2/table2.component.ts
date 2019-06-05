import { Component, OnInit } from '@angular/core';
import { Tabledata } from '../model/tabledata';

import { Tabel2Service } from '../service/tabel2.service';


@Component({
  selector: 'app-table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {

  tableData: Tabledata[] = [];
  constructor(private tableService: Tabel2Service) { }

  ngOnInit() {
      this.tableData = this.tableService.getdata();
  }
  

}
