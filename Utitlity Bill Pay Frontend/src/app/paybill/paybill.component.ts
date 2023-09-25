// import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';
import { PayObj } from 'src/model/payBill';
import { HttpErrorResponse } from '@angular/common/http';

type payObj = {
  cid:any,
  bid:any,
  cardnumber:any
 }

@Component({
  selector: 'app-paybill',
  templateUrl: './paybill.component.html',
  styleUrls: ['./paybill.component.css']
})

export class PaybillComponent implements OnInit {
  cid:number=0;
  bid:number=0;
  cardnumber:number=0;
  obj :PayObj= new PayObj(this.cid,this.bid,this.cardnumber);
  constructor(private service:HttpService,private router:Router) { }
   ngOnInit(): void {
  

  }

    
  payonline(){
    console.log(this.obj)
    this.service.payonline(this.obj)
    .subscribe((response:any)=>{
      console.log(response.status);
    },
    (error) => {
      console.error('Error:', error);
      if (error instanceof HttpErrorResponse) {
        if (error.status === 200) {
          // Handle 404 Not Found error
          console.error(error.message);
        } else if (error.status === 500) {
          // Handle 500 Internal Server Error
          console.error('Internal Server Error.');
        } else {
          // Handle other HTTP errors
          console.error('An error occurred:', error.error);
        }
      } else {
        // Handle other types of errors
        console.error('An unexpected error occurred:', error);
      }
    }
  );
}
    
    

    // this.service.getCustomerDetails()
    // .subscribe((response:any)=>{
    //   console.log(response)
    // })
  }

