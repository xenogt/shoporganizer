import { Injectable } from '@angular/core';
import { ApiService } from './common/api.service';
import { Order } from '../shared/models/order-model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private apiService: ApiService) { }

  getOrders(path: string) {
    return this.apiService.get(path).subscribe(orders => orders.json().map((order: Order) => new Order().deserialize(order)));
  }
}
