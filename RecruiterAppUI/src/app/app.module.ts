import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Table1Component } from './table1/table1.component';
import { HomeComponent } from './Home/home.component';
import { HeaderComponent } from './header/header.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { DetailsComponent } from './details/details.component';
import { HttpClientModule } from '@angular/common/http';
import { UploaddataComponent } from './uploaddata/uploaddata.component';


@NgModule({
  declarations: [
    AppComponent,
    Table1Component,
    HomeComponent,
    HeaderComponent,
    DetailsComponent,
    UploaddataComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
