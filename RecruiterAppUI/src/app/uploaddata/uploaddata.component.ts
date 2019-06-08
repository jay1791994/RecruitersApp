import { Component, OnInit, Input } from '@angular/core';
import { Tabledata } from '../model/tabledata';
import { UploadService } from '../service/upload.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-uploaddata',
  templateUrl: './uploaddata.component.html',
  styleUrls: ['./uploaddata.component.css']
})
export class UploaddataComponent implements OnInit {


   color : String = "orange";
   uploaddata : Tabledata[]; 
   file : File ;
  constructor( private uploadService : UploadService, private router : Router) { 
   
  }
  changecolor(){
    if(this.color == "orange"){
      this.color = "white";
    }else{
      this.color = "orange";
    }
  }

  ngOnInit() {
      this.uploaddata = this.uploadService.getUploadData();
  }

  uploadthisdata(){
    this.uploadService.upload(this.uploaddata).subscribe(res =>{
      
      console.log(res);
      this.router.navigate(['table1']);
    });
  }

  goback(){
    this.router.navigate(['table1']);
  }


}
