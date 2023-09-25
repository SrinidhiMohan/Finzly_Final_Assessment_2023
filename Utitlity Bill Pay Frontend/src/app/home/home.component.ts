import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service:HttpClient,private router:Router) { }
state:any[]=[
  {sid:1,sname:'Maharastra'},
  {sid:2,sname:'Tamil nadu'}
];

EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

  
  ngOnInit(): void {
  }

  gotoDashBoard(id:any,otp:any){
    // this.service.login()
    this.router.navigate(['/dashboard'])
  }

}
