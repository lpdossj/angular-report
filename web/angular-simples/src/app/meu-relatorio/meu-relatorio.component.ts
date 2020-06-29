import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MeuRelatorioService } from './meu-relatorio.service';
import * as fileSaver from 'file-saver';

@Component({
  selector: 'app-meu-relatorio',
  templateUrl: './meu-relatorio.component.html',
  styleUrls: ['./meu-relatorio.component.css'],
  providers: [MeuRelatorioService]
})
export class MeuRelatorioComponent implements OnInit {

  group: FormGroup;
  
  constructor(private formBuilder: FormBuilder,
    private service: MeuRelatorioService) { }

  ngOnInit() {
    this.group = this.formBuilder.group({

    });
  }

  submit() {
    console.log("ação de submit");
  }

  onDownload() {
    this.service.download("http://localhost:8080/report/download/produtos")
    .subscribe((res: any) => {
        console.log("Download do arquivo!");
        console.log(res);
        this.service.handleFile(res, 'relatorio.pdf');
        console.log("Download do arquivo 2!");
      });
  }

}
