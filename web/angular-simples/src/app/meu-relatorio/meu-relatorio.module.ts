import { NgModule } from '@angular/core';
import { MeuRelatorioComponent } from './meu-relatorio.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
    declarations: [ 
        MeuRelatorioComponent
    ],
    imports: [ 
        BrowserModule,
        CommonModule, 
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
    ],
    exports: [
        MeuRelatorioComponent
    ]
})
export class MeuRelatorioModule {}