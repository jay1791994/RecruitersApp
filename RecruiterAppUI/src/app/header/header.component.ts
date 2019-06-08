import { Component, OnInit, ElementRef} from '@angular/core';
import { Router, NavigationExtras} from '@angular/router';
import { HttpClient, HttpParams, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Tabledata } from '../model/tabledata';
import { UploadService } from '../service/upload.service';





@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {



  file : File ;
  exceldata : Tabledata[];

  constructor( private router: Router, private http: HttpClient, private uploadService: UploadService) {  }

  ngOnInit() {
  }

  onclicktable1(){
    console.log("its working onclick table 1");
     this.router.navigate(['table1']);
  }

  onclicktable2(){
    console.log("its working onclick table 2");
    this.router.navigate(['home']);
  }
  }