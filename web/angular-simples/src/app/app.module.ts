import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule }  from '@angular/forms';

import { AppComponent } from './app.component';
import { MeuRelatorioComponent } from './meu-relatorio/meu-relatorio.component';
import { CommonModule } from '@angular/common';
import { MeuRelatorioModule } from './meu-relatorio/meu-relatorio.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    CommonModule, 
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    MeuRelatorioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
