import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Prueba2 } from './prueba2';

describe('Prueba2', () => {
  let component: Prueba2;
  let fixture: ComponentFixture<Prueba2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Prueba2],
    }).compileComponents();

    fixture = TestBed.createComponent(Prueba2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
