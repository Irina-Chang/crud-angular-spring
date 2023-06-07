import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";

import {catchError, config, Observable, of} from "rxjs";

import {Course} from "../../model/course";
import {CoursesService} from "../../services/courses.service";
import {ErrorDialogComponent} from "../../../shared/components/error-dialog/error-dialog.component";
import {ActivatedRoute, Router} from "@angular/router";
import {resetCumulativeDurations} from "@angular-devkit/build-angular/src/builders/browser-esbuild/profiling";
import {MatSnackBar} from "@angular/material/snack-bar";
import {
  ConfirmationDialogComponent
} from "../../../shared/components/confirmation-dialog/confirmation-dialog.component";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit{

courses$ : Observable<Course[]> | null = null;
//courses:Course[] = [];
//coursesService: CoursesService;

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog,
    private router:Router,
    private route:ActivatedRoute,
    private snackBar:MatSnackBar
  ) { this.refresh();}

    refresh (){this.courses$ = this.coursesService.list()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar lista de cursos.')
          return of([])
        })
      );

    }


  onError(errorMsg: string){
    this.dialog.open(ErrorDialogComponent, {
      data:errorMsg,
    });
  }
  ngOnInit() {}

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route});
  }

onEdit(course: Course) {
  this.router.navigate(['edit', course._id], {relativeTo: this.route});
}

  onRemove(course: Course) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse curso?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.coursesService.remove(course._id).subscribe(
          () => {
            this.refresh();
            this.snackBar.open('Curso removido com sucesso!', 'X', {
              duration: 5000,
              verticalPosition: 'top',
              horizontalPosition: 'center'
            });
          },
          () => this.onError('Erro ao tentar remover curso.')
        );
      }
    });
  }

}
