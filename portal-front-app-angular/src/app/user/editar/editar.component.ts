import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router'; 
import { NgForm } from '@angular/forms';
import { User } from '../../models/user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  user: User;

  constructor(private route: ActivatedRoute,
  	private router: Router, private userService: UserService) { 
    }

  ngOnInit() {
    const id = +this.route.snapshot.params['user'];
    this.userService.findById(id.toString()).subscribe( data => {
      this.user = data;
    });
  }

  editUser(user: User){
    this.userService.editeUser(this.user);
  }

}
