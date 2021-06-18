import { User } from './../models/user.model';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router'; 
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private router: Router, private http:HttpClient) {}

  //private userUrl = 'http://localhost:8080/api';
	private userUrl = '/api';

  users: User[];
  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  public findById(id: string){
    return this.http.get<User>(this.userUrl + "/find/"+ id);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

  public editeUser(user: User){
    console.log(user);
    console.log(this.userUrl+"/edit/"+ user.id);
    return this.http.put<User>(this.userUrl+"/edit/"+ user.id, user, httpOptions).toPromise()
    .then(() => {
      this.router.navigate(['/users']);
    });
  }

}
