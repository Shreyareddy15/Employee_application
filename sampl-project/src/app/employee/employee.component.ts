import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LogService } from 'src/log.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent {
  [x: string]: any;
  book={title:'principles'};
  parentHandler(event: any){
    console.log(event);
  }
  Data: any[] = [];
  test: boolean;
  empId:number=0;
  employeeId: number = 0;
  selectedEmployee: any = null;
  selecteddeleteEmployee: any = null;

  constructor(private logService: LogService, private route: ActivatedRoute){
    this.test=true;

  }
  ngOnInit(){
    this.logService.getEmployeeData().subscribe(
      (data:any)=>{
      this.Data=data;
      console.log(data);
    },
    (error:any)=>{
      console.log("error");
    }
  )
 
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
        this.selecteddeleteEmployee = null; 
        this.selectedEmployee=null;
        this.Data = data;
      },
      (error: any) => {
        console.error('Error');
      }
    );
  }
  getdeletingData(): void {
    if (this.empId) {
      this.logService.getEmployeeById(this.empId).subscribe(
        (data: any) => {
          this.selecteddeleteEmployee = data;
        },
        (error: any) => {
          console.error('Error');
        }
      );
    }
  } 
  deleteEmployeeData(): void {
    console.log(this.selecteddeleteEmployee.eid);
    if (this.selecteddeleteEmployee && this.selecteddeleteEmployee.eid) {
      this.logService.deleteEmployee(this.selecteddeleteEmployee).subscribe(
        () => {
          console.log('deleted data');
          this.loadEmployees();
        },
        (error: any) => {
          console.error('Error');
        }
      );
    }
  }
}
