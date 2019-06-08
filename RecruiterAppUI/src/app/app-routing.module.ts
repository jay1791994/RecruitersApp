import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Table1Component } from './table1/table1.component';
import { DetailsComponent } from './details/details.component';
import { UploaddataComponent } from './uploaddata/uploaddata.component';
import { HomeComponent } from './Home/home.component';

const routes: Routes = [
  {path:'table1', component:Table1Component},
  {path:'home', component: HomeComponent},
  {path:'viewdetails/:userId', component: DetailsComponent},
  {path:'uploaddata', component: UploaddataComponent},
  {path:'', component:HomeComponent, pathMatch:"full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
