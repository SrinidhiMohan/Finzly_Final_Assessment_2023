import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { PaybillComponent } from './paybill/paybill.component';
const routes: Routes = [
  {
    path:"",redirectTo:"/home",pathMatch:"full"
  },
  {
    path:"home",component:HomeComponent
  },
  {
    path:'dashboard',component:DashboardComponent
  },
  {
    path:'paybill',component:PaybillComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
