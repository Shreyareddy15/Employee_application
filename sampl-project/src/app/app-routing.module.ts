import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  {
    path:'home',
    component: HomeComponent
  },
  {
    path:'details',
    component: DetailsComponent
  },
  {
    path:'details/:id',
    component: DetailsComponent
  },
  {
    path:'employee',
    component: EmployeeComponent
  },
  {
    path:'',
    redirectTo:'/home',
    pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
 }
