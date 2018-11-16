import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/common/api.service';
import {Order} from '../../shared/models/order-model';

@Component({
  selector: 'orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  settings = {
    columns: {
      id: {
        title: 'ID'
      },
      orderDate: {
        title: 'Order Date'
      },
      orderNumber: {
        title: 'Order Number'
      }
    }
  }

  private orderList: Order[];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
     this.apiService.get('orders')
      .subscribe((data => {
        this.orderList = data.json().map((order: Order) => new Order().deserialize(order));
      }));
  }

}
