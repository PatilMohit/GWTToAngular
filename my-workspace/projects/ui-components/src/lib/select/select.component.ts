// projects/ui-components/src/lib/select/select.component.ts
import { Component, input, output } from '@angular/core';
import { NgSelectModule } from '@ng-select/ng-select';

@Component({
  selector: 'lib-select',
  standalone: true,
  imports: [NgSelectModule],
  template: `
    <ng-select
      [items]="items()"
      [bindLabel]="bindLabel()"
      [multiple]="multiple()"
      (change)="valueChange.emit($event)">
    </ng-select>
  `
})
export class SelectComponent {
  items = input<any[]>([]);
  bindLabel = input<string>('label');
  multiple = input<boolean>(false);
  valueChange = output<any>();
}