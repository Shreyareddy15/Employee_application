import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'sampl-project';
  Text:string="john";
  ques:boolean=true;
  val!:number;
constructor(){
  this.val=89;
}
clicked(){
    console.log("Clicked");
    alert("Clicked")
}
}