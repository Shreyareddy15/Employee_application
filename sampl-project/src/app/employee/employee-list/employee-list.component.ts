import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LogService } from 'src/log.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent {
  @Input() expectedVal:any
  @Output() newItemEvent = new EventEmitter<string>();

  Data: any[] = [];
  test: boolean;
  employeeId: number = 0;
  selectedEmployee: any = null;

  sendToparent(){
    this.newItemEvent.emit("test Data");
  }
  constructor(private logService: LogService, private router: Router,private route: ActivatedRoute){
    this.test=true;

  }
  loadEmployeeData(): void {
    if (this.employeeId) {
      this.logService.getEmployeeById(this.employeeId).subscribe(
        (data: any) => {
          this.selectedEmployee = data;
        },
        (error: any) => {
          console.error('Error');
        }
      );
    }
  } 
  
  updateEmployeeData(): void {
    console.log(this.selectedEmployee);
    console.log(this.selectedEmployee.eid);
    this.logService.updateEmployee(this.selectedEmployee).subscribe(
      (data: any) => {
        console.log('updated data',data);
        this.loadEmployees();
      },
      (error: any) => {
        console.error('Error');
      }
    );
  }

  private loadEmployees(): void {
    this.logService.getEmployeeData().subscribe(
      (data: any) => {
        this.selectedEmployee = null; 
        this.Data = data;
      },
      (error: any) => {
        console.error('Error');
      }
    );
  }
}


