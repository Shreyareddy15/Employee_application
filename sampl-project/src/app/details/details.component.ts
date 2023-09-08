import { Component } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {
  myParam: any;
  constructor(private route: ActivatedRoute){

  }
  ngOnInit(){
    this.route.params.subscribe((params: Params)=>{
      this.myParam =params['id'];
      console.log(this.myParam);
    });
  }
}
