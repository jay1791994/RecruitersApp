import { Component, OnInit, Input } from '@angular/core';
import { Tabledata } from '../model/tabledata';
import { ActivatedRoute, Router } from '@angular/router';
import { TableService } from '../service/table.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

   id: String;
   data: Tabledata;

  constructor(private route: ActivatedRoute, private tableService:TableService, private router: Router) { }

  ngOnInit() {
    this.id= this.route.snapshot.paramMap.get('userId');
    this.tableService.getdataatIndex(this.id).subscribe(res=>{
        console.log(res);
        this.data = res;
        console.log(this.data + "here")
     });
     }

     goback(){
         this.router.navigate(["/table1"]);
     }

}
