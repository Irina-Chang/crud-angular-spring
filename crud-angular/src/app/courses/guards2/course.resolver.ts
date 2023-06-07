import { ResolveFn } from '@angular/router';
import {Course} from "../model/course";
import {CoursesService} from "../services/courses.service";
import {inject} from "@angular/core";
import {of} from "rxjs";

export const courseResolver: ResolveFn<Course> = (route, state) => {
  const courseService: CoursesService = inject(CoursesService);
  if (route.params && route.params['id']) {
    return courseService.loadByID(route.params['id']);
  }
  return of({_id:'', name: '', categoria:''});
};
