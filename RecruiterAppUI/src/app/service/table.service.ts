import { Injectable } from '@angular/core';
import { Tabledata } from '../model/tabledata';
import { HttpClient } from '@angular/common/http';
import { Observable , } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TableService {


  host : String = "http://ec2-18-222-165-200.us-east-2.compute.amazonaws.com:8080/UserApp-0.0.1-SNAPSHOT";
  localhost: String = "http://localhost:8080";
  constructor(private http: HttpClient){

    
  }

  getdata(pageNumber: Number): Observable<any>{
      let url =  this.localhost+"/api/user/page/"+pageNumber;
      console.log(url);
      return this.http.get<any>(url);
  };

  getdataatIndex(userId:String): Observable<any>{
    let url = this.localhost+"/api/user/"+userId ;
   return this.http.get(url);
  }
  
  deletedata( userId : String) : Observable<any>{
      console.log(userId);
      let url =  this.localhost+"/api/user/"+userId ;
      return  this.http.delete(url);
  }

  addData(newdata : Tabledata): Observable<any>{
  
    console.log("new data is here")
    return  this.http.post(this.localhost+"/api/user/" , newdata) ;
  
  }
  updateData(tabledataUpdated: Tabledata): Observable<any>{
      
     return this.http.put(this.localhost+"/api/user/", tabledataUpdated);
     
  }

  
}