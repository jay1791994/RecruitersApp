import { Component, OnInit} from '@angular/core';
import { TableService } from '../service/table.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

   constructor(private tableService: TableService){}
   

   ngOnInit(){
    
   }

   genratedata(){
    this.tableService.generatedata().subscribe(
      res =>{
      
        alert("Data Generated Successfully!!!");
      },
      err =>{
        console.log(err)
      },
      () =>{

      }
    )
   }


   deletedata(){
     this.tableService.deletealldata().subscribe(
        res => {
          console.log(res)
          alert("Data Deleted Successfully!!!");
         },
        err => {console.log(err)}
     )
   }
  
}