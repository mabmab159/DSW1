import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Prueba1 } from './prueba1';

describe('Prueba1', () => {
  let component: Prueba1;
  let fixture: ComponentFixture<Prueba1>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Prueba1],
    }).compileComponents();

    fixture = TestBed.createComponent(Prueba1);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
