import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import {AppMaterialModule} from "./app-material/app-material.module";
import {MatButtonModule} from "@angular/material/button";
import { CategoriaPipe } from './pipes/categoria.pipe';



@NgModule({
  declarations: [
    ErrorDialogComponent,
    CategoriaPipe,
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    MatButtonModule
  ],

  exports:[
    ErrorDialogComponent,
    CategoriaPipe]
})
export class SharedModule { }
