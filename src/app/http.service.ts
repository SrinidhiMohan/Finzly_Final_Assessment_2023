import { Injectable } from '@angular/core';
import {environment} from '../environments/environment'
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
url:string=environment.baseUrl;
constructor(private http:HttpClient) { }


// login(obj:any){
//   return(this.http.post(this.url,obj))
// }
 


}
