import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

   

  constructor( private router: Router) {  }

  ngOnInit() {
  }

  onclicktable1(){
    console.log("its working onclick table 1");
     this.router.navigate(['table1']);
  }

  onclicktable2(){
    console.log("its working onclick table 2");
    this.router.navigate(['table2']);
  }
}
