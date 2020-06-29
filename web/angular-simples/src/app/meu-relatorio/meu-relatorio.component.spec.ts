import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeuRelatorioComponent } from './meu-relatorio.component';

describe('MeuRelatorioComponent', () => {
  let component: MeuRelatorioComponent;
  let fixture: ComponentFixture<MeuRelatorioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeuRelatorioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeuRelatorioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
