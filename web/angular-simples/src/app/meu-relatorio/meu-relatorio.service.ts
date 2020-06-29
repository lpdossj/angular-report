import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class MeuRelatorioService {

    constructor(private http: HttpClient) { }

    download(url: string) {
      // let options = { headers : {
      //   'Authorization': this.headers.headers.Authorization,
      //   'responseType': 'blob'
      //  }};

        return this.http.get(url, {
          responseType: 'blob',
          //headers: new HttpHeaders().append("Content-Type", "application/pdf")
          // reportProgress
          // content-length
        });
    }

    handleFile(res: any, fileName: string) {
        const file = new Blob([res], {
          type: res.type
        });
    
        // IE
        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
          window.navigator.msSaveOrOpenBlob(file);
          return;
        }
    
        const blob = window.URL.createObjectURL(file);
    
        const link = document.createElement('a');
        link.href = blob;
        link.download = fileName;
    
        // link.click();
        link.dispatchEvent(new MouseEvent('click', {
          bubbles: true,
          cancelable: true,
          view: window
        }));
    
        setTimeout(() => { // firefox
          window.URL.revokeObjectURL(blob);
          link.remove();
        }, 100);
      }
}