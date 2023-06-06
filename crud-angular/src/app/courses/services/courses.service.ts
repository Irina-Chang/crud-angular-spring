import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Course} from "../model/course";
import {delay, first, tap} from "rxjs";
import * as url from "url";

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = '/api/courses';
  constructor(private httpClient: HttpClient) { }
  list () {
    return this.httpClient.get<Course[]>(this.API)
      .pipe(
        first(),
        //delay(3000),
        tap(courses => console.log(courses))
      );
  }

  save(record: Partial<Course>) {
    this.httpClient.post<Course>(this.API, record).pipe(first());
  }
}
