import { Component } from '@angular/core';
import { ColDef } from 'ag-grid-community';
import { DataGridComponent } from '@yourorg/ui-components';
@Component({
  selector: 'app-order',
  imports: [DataGridComponent],
  templateUrl: './order.html',
  styleUrl: './order.css',
})
export class Order {
  columnDefs: ColDef[] = [
    { field: 'orderId', headerName: 'Order ID' },
    { field: 'customerName', headerName: 'Customer' },
    { field: 'status', headerName: 'Status' },
    { field: 'total', headerName: 'Total ($)' }
  ];

  orders = [
    { orderId: 'ORD-1001', customerName: 'Acme Corp', status: 'Shipped', total: 1250 },
    { orderId: 'ORD-1002', customerName: 'Globex Inc', status: 'Pending', total: 430 },
    { orderId: 'ORD-1003', customerName: 'Initech', status: 'Delivered', total: 899 }
  ];
}
