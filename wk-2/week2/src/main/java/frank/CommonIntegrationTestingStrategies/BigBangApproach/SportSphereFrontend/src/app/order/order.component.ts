import {Component, OnInit} from '@angular/core';
import {OrderService} from '../order.service';
import {NewOrder, Order} from '../order.model';
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-order',
  imports: [
    FormsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './order.component.html',
  standalone: true,
  styleUrl: './order.component.css'
})
export class OrderComponent implements OnInit{

  orders: Order[] = [];
  newOrder: NewOrder = { productId: '', quantity: 0 };

  constructor(private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.fetchOrders();
  }


  public fetchOrders(): void {
    this.orderService.getOrders().subscribe({
      next:(data)=>{
        this.orders = data;
      },
      error: (err) => {
        console.log('Error fetching orders: ', err)
      }
    });
  }

  public createOrder(): void {
    this.orderService.createOrders(this.newOrder).subscribe({
      next: (data) => {
        this.orders.push(data);
        this.newOrder = { productId: '', quantity: 0 }; // resetting it
      },
      error: (err) => {
        console.error('Error creating order: ', err);
      }
    });
  }

  public deleteOrder(id: string): void {
    this.orderService.deleteOrder(id).subscribe({
      next: (data) => {
        this.orders = this.orders.filter(order => order.id !== id);
      },
      error: (err) => {
        console.error('Error deleting order: ', err);

      }
    });
  }

}
