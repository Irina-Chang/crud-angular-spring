import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoursesComponent } from './courses/courses.component';
import { CoursesRoutingModule } from './courses-routing.module';

import {AppMaterialModule} from "../shared/app-material/app-material.module";
import {SharedModule} from "../shared/shared.module";
import { CourseFormComponent } from './course-form/course-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import { CoursesListComponent } from './courses-list/courses-list.component';


@NgModule({
  declarations: [
    CoursesComponent,
    CourseFormComponent,
    CoursesListComponent
  ],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule,
    MatInputModule
  ]
})
export class CoursesModule { }
