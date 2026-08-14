// projects/ui-components/src/lib/data-grid/data-grid.component.ts
import { Component, Input, input } from '@angular/core';
import { AgGridAngular } from 'ag-grid-angular';
import { ColDef, GridOptions } from 'ag-grid-community';

@Component({
  selector: 'lib-data-grid',
  standalone: true,
  imports: [AgGridAngular],
  template: `
    <ag-grid-angular
      class="ag-theme-quartz"
      [rowData]="rowData()"
      [columnDefs]="columnDefs()"
      [gridOptions]="gridOptions"
      style="width: 100%; height: 100%;">
    </ag-grid-angular>
  `
})
export class DataGridComponent {
  rowData = input<any[]>([]);
  columnDefs = input<ColDef[]>([]);
  gridOptions: GridOptions = {
    pagination: true,
    animateRows: true,
  };
}