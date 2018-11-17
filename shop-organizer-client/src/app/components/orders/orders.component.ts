import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/common/api.service';
import {Order} from '../../shared/models/order-model';
import { ShopAccount } from 'src/app/shared/models/shop-account-model';
import { Payment } from 'src/app/shared/models/payment';
import { PaymentMethod } from 'src/app/shared/models/payment-method-model';

@Component({
  selector: 'orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  settings = {
    columns: {
      orderID: {
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
  private shopList: ShopAccount[];
  private paymentList: Payment[];
  private paymentMethodList: PaymentMethod[];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
     this.apiService.get('orders')
      .subscribe((data => {
        this.orderList = data.json().map((order: Order) => new Order().deserialize(order));
      }));
      this.apiService.get('payments')
      .subscribe((data => {
        this.paymentList = data.json().map((payment: Payment) => new Payment().deserialize(payment));
      }));
      this.apiService.get('shops')
      .subscribe((data => {
        this.shopList = data.json().map((shop: ShopAccount) => new ShopAccount().deserialize(shop));
      }));
      this.apiService.get('payment-methods')
      .subscribe((data => {
        this.paymentMethodList = data.json().map((paymentMethod: PaymentMethod) => new PaymentMethod().deserialize(paymentMethod));
      }));
  }

}
