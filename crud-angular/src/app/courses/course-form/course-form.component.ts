import { Component, OnInit} from '@angular/core';
import { Location } from "@angular/common"
import { MatSnackBar } from "@angular/material/snack-bar";
import { FormControl, FormGroup,NonNullableFormBuilder } from "@angular/forms";

import { CoursesService } from "../services/courses.service";


@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form = this.formBuilder.group(controls: {
    name:[' '],
  categoria: [' ']
});


  constructor(private formBuilder: NonNullableFormBuilder,
              private service: CoursesService,
              private snackBar: MatSnackBar,
              private location: Location) {
}

  ngOnInit()  { }

  onSubmit(): {
    this.service.save(this.form.value)
      .subscribe(result => this.onSuccess(), error => this.onError());
  }

  onCancel(){
this.location.back()
  }

  private onSuccess() {
    this.snackBar.open('Curso salvo com sucesso!', '', {duration: 3000});
    this.onCancel();
  }

  private onError()  {
    this.snackBar.open('Erro ao salvar curso!', '', {duration: 3000});
  }
}
