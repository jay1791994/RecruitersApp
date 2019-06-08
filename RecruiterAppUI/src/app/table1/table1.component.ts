import { Component, OnInit} from '@angular/core';
import { TableService } from '../service/table.service';
import { Tabledata } from '../model/tabledata';
import { FormGroup, FormControl, Validators, NgModel } from '@angular/forms';
import { Router} from '@angular/router';
import {  HttpClient } from '@angular/common/http';
import { UploadService } from '../service/upload.service';


@Component({
  selector: 'app-table1',
  templateUrl: './table1.component.html',
  styleUrls: ['./table1.component.css']
})
export class Table1Component implements OnInit {

  exceldata : Tabledata[];
  file : File;
  totalpages : number ;
  pageNumber : number = 0 ;
  editing: boolean = false;
  tableData: Tabledata[] = [];
  enableUpdate: boolean[] = [];
  showForm: boolean = false;
  formError: String = null;
  dataForm = new FormGroup({
    name: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.email, Validators.required]),
    currentLocation : new FormControl(''),
    expertise : new FormControl('', Validators.required),
    visa : new FormControl('', Validators.required),
    experience : new FormControl('0'),
    relocation : new FormControl('true'),
    prefferedlocation: new FormControl('Anywhere')
  });
  
  constructor(private tableService: TableService, private router: Router, private http:HttpClient, private uploadService: UploadService) {

   }
  ngOnInit() {
   
    this.tableService.getdata(this.pageNumber).subscribe(res=>{
       this.tableData = res.content;
       this.totalpages = +res.totalPages;
    },
    error =>{
      console.log(error);
    })
    for (var i = 0; i < this.tableData.length; i++) {
      this.enableUpdate[i] = false;
    }
  }
  ondeletedata(index: number) {
    this.tableService.deletedata(this.tableData[index].userId).subscribe(
       
      res=>{
        if(this.tableData.length == 1){
          console.log("it was last index");
          this.pageNumber = this.pageNumber - 1 ;
        }
        if(this.pageNumber < 0){
          this.pageNumber = 0 ;
        }
        console.log("delete response is here");
        this.tableService.getdata(this.pageNumber).subscribe(resp=>{
          this.tableData = resp.content;
          console.log(resp.content);
          this.totalpages = resp.totalPages;
          console.log("the page number is " + (this.pageNumber));
          console.log("total pages remained are " +  resp.totalPages);
        })
      }, err=>{
          return;
      }
        
    );

 
  }
  onSubmitData() {
  
    if (this.dataForm.valid) {
      let tabledata = {
        "name": this.dataForm.get("name").value,
        "age": this.dataForm.get("age").value,
        "email": this.dataForm.get("email").value,
        "expertise": this.dataForm.get("expertise").value,
        "experience" : +this.dataForm.get("experience").value,
        "visaStatus" : this.dataForm.get("visa").value,
        "currentLocation": this.dataForm.get("currentLocation").value,
        "opentorelocation": this.dataForm.get("relocation").value === "true" ? true:false,
        "preffredLocation": [this.dataForm.get("prefferedlocation").value]
      }

      console.log(tabledata);

     this.tableService.addData(tabledata).subscribe(res=>{
       this.showForm = !this.showForm;
      // this.tableData.push(res);
      
       },
       error =>{
         console.log(error);
         this.formError = "Invalid data has been given";
         
       })
    }else{
      console.log(this.dataForm);
      this.formError = "";
      if(!this.dataForm.get("name").valid && this.dataForm.get("name").touched)
      this.formError = this.formError+ `Name can not be empty`;
      if(!this.dataForm.get("name").touched)
      this.formError = this.formError +
                       `Invalid Age.`
      if(!this.dataForm.get("email").valid )
      this.formError = this.formError + 
                       `\n Invalid EmailId.`;
      if(this.dataForm.get("email").untouched)
      this.formError = this.formError +
                       `EmailId can not be empty`;

    }
  }

  toggleenabledarr(i: number) {

    if(this.editing == true){
      return
    }else{
      this.editing = true;
    }
    this.enableUpdate[i] = !this.enableUpdate[i];
   
  }

  updatedata(index: number, nameArg: String, ageArg: String, emailArg: String, expertiseArg:String, experienceArg:String,preffredLocationArg:String , ref:NgModel) {

      if(ref.untouched){
        preffredLocationArg = this.tableData[index].preffredLocation[0];
      }
     
      this.enableUpdate[index] = !this.enableUpdate[index];
      this.editing = false;
      let tableDataupdated = {
        "name": nameArg,
        "age": +ageArg,
        "email": emailArg,
        "expertise": expertiseArg,
        "experience": +experienceArg,
        "currentLocation": this.tableData[index].currentLocation,
        "opentorelocation": this.tableData[index].opentorelocation,
        "visaStatus": this.tableData[index].visaStatus,
        "preffredLocation": [preffredLocationArg],
        "userId": this.tableData[index].userId
      }

      console.log(tableDataupdated);
    
      this.tableService.updateData(tableDataupdated).subscribe(res=>{
          this.tableData[index] = res;
         
        },
        error =>{
          this.formError = "Invalid data has been given"
        })
  }
  viewDetails(index: number) {
    this.router.navigate(['viewdetails', this.tableData[index].userId]);
  }

  setthecurrentLocation(index, print:String){
        this.tableData[index].currentLocation = print;
  }
  settheopentorelocation(index , eventValue:String){
         if(eventValue == "true"){
           console.log("YES HAS BEEN CHOSEN");
           this.tableData[index].opentorelocation = true;
         }else{
          console.log("NO HAS BEEN CHOSEN");
          this.tableData[index].opentorelocation = false;
         }

  }
  onchangevisastatus(index, visa: String){

      this.tableData[index].visaStatus = visa;
  }

  gotofirstpage(){
        this.pageNumber = 0 ;
        this.tableService.getdata(this.pageNumber).subscribe(res=>{
          this.tableData = res.content;
          this.totalpages = res.totalPages;
          
       },
       error =>{
         console.log(error);
       })
       for (var i = 0; i < this.tableData.length; i++) {
         this.enableUpdate[i] = false;
       }
  }
  gotoprevpage(){
   
    console.log("move to prev page")
        this.pageNumber = this.pageNumber-1;
        this.tableService.getdata(this.pageNumber).subscribe(res=>{
          this.tableData = res.content;
          console.log(res);
          this.totalpages = res.totalPages;
       },
       error =>{
         console.log(error);
       })
       for (var i = 0; i < this.tableData.length; i++) {
         this.enableUpdate[i] = false;
       }
  }
  gotonextrpage(){
        this.pageNumber = this.pageNumber+1;
        this.pageNumber = (this.pageNumber === (this.totalpages-1))?(this.totalpages-1):this.pageNumber++;
        this.tableService.getdata(this.pageNumber).subscribe(res=>{
          this.tableData = res.content;
          this.totalpages = res.totalPages;
          
       },
       error =>{
         console.log(error);
       })
       for (var i = 0; i < this.tableData.length; i++) {
         this.enableUpdate[i] = false;
       }

  }
  gotolastpage(){
        this.pageNumber = this.totalpages-1;
        console.log("THE LAST PAGE NUMBER IS " +  this.pageNumber)
        this.tableService.getdata(this.pageNumber).subscribe(res=>{
          this.tableData = res.content;
          this.totalpages = res.totalPages;
         
       },
       error =>{
         console.log(error);
       })
       for (var i = 0; i < this.tableData.length; i++) {
         this.enableUpdate[i] = false;
       }
  }

  selectFile(event) {
    this.file = event.target.files[0];
    this.uploadService.fileupload(this.file);
    //fileupload();

 }

  // fileupload(){
  //   let navigationExtras: NavigationExtras;
  // this.uploadFile("http://localhost:8080/file/upload",this.file).pipe(
  //        map( res=>{
           
  //         return res;
  //        } 
       
  //         )  
  //        ).subscribe(res =>{

  //            this.exceldata = res.body;
            
  //        },
  //        error =>{
  //          console.log("this is called on error")
  //        },
  //        () => {
  //         this.uploadService.setUploadData(this.exceldata);
  //         this.router.navigate(['uploaddata']);
  //        } )
     
  // }

  // uploadFile(url: string, file: File): Observable<any>{

  //   let formData = new FormData();
  //   formData.append('upload', file);

  //   let params = new HttpParams();

  //   const options = {
  //     params: params,
  //     reportProgress: true,
  //   };

  //   const req = new HttpRequest('POST', url, formData, options);
  //   return this.http.request(req);
  // }
 


}
