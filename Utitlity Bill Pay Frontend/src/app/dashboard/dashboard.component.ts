import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  customerPaidBills:any[]=[];
  customerPendingBills:any[]=[];
  customerDetails:any[]=[];

  constructor(private service:HttpService,private router: Router) { }

  ngOnInit(): void {
    this.GetPaidData();
    this.GetUnpaidData();
    this.GetCusotmerData();
  }

  GetPaidData(){
    this.service.getPaidCustomerData()
    .subscribe((response:any)=>{
      this.customerPaidBills=response;
    })
  }
  GetCusotmerData(){
    this.service.getCustomerDetails()
    .subscribe((response:any)=>{
      this.customerDetails=response;
    })
  }


  GetUnpaidData(){
    this.service.getPendingCustomerData()
    .subscribe((response:any)=>{
      this.customerPendingBills=response;
      
      
    })
  }

  pay(){

    this.router.navigate(['/paybill']);

    alert("Navigating to secure Payment Page");
  }

}
