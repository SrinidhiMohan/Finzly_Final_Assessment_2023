import { Injectable } from '@angular/core';
import {environment} from '../environments/environment'
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private apiUrl='http://localhost:8080/';

url:string=environment.baseUrl;

constructor(private http:HttpClient) { }


// login(obj:any){
//   return(this.http.post(this.url,obj))
// }

getPendingCustomerData(){
  let customerId=1;
  return (this.http.get(`${this.apiUrl}getAllPendingBills/${customerId}`))
}

getPaidCustomerData(){
  let customerId=1;
  return (this.http.get(`${this.apiUrl}getAllPaidBills/${customerId}`))
}

getCustomerDetails(){
  let customerId=1;
  return (this.http.get(`${this.apiUrl}getCustomerDetails/${customerId}`))
}

payonline(obj : any){
  return(this.http.post(`${this.apiUrl}payOnline`,obj))

}

}
