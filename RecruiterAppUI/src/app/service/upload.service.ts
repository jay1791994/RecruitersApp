import { Injectable } from '@angular/core';
import { Tabledata } from '../model/tabledata';
import { HttpClient, HttpParams, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NavigationExtras, Router } from '@angular/router';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UploadService {

 
  uploaddata : Tabledata[] ;
  exceldata : Tabledata[];
  constructor( private http: HttpClient, private router: Router) { }

   setUploadData( data :Tabledata[]){
     this.uploaddata = data;
   }

   getUploadData(): Tabledata[]{
     return this.uploaddata ;
   }

   upload( uploadingdata : Tabledata[]): Observable<any>{
   console.log(uploadingdata);
   return  this.http.post("http://localhost:8080/api/user/userlist", uploadingdata) ;
       
   }


   
  fileupload(file: File){
    let navigationExtras: NavigationExtras;
  this.uploadFile("http://localhost:8080/file/upload",file).pipe(
         map( res=>{
           
          return res;
         } 
       
          )  
         ).subscribe(res =>{

             this.exceldata = res.body;
            
         },
         error =>{
           console.log("this is called on error")
         },
         () => {
          this.setUploadData(this.exceldata);
          this.router.navigate(['uploaddata']);
         } )
     
  }

  uploadFile(url: string, file: File): Observable<any>{

    let formData = new FormData();
    formData.append('upload', file);

    let params = new HttpParams();

    const options = {
      params: params,
      reportProgress: true,
    };

    const req = new HttpRequest('POST', url, formData, options);
    return this.http.request(req);
  }
 



}
