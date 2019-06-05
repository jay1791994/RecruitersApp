import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Table1Component } from './table1/table1.component';
import { Table2Component } from './table2/table2.component';
import { DetailsComponent } from './details/details.component';

const routes: Routes = [
  {path:'table1', component:Table1Component},
  {path:'table2', component:Table2Component},
  {path:'viewdetails/:userId', component: DetailsComponent},
  {path:'', component:Table2Component, pathMatch:"full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
