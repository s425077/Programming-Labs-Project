	import { Component, OnInit } from '@angular/core';
  import { Router } from '@angular/router';

	@Component({
	  selector: 'app-root',
	  templateUrl: './app.component.html',
	  styleUrls: ['./app.component.css']
	})
	export class AppComponent implements OnInit {

	  title: string;

	  constructor(private router: Router) {
	    this.title = 'Programming Labs Project';
	  }

    ngOnInit() {
      this.router.navigate(['homepage'])
    }

	}
