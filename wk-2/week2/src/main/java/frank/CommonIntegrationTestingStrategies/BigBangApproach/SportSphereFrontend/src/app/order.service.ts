import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {NewOrder, Order} from './order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl: string = "http://localhost:8080/orders"

  constructor(private http: HttpClient) { }

  public getOrders(): Observable<Order[]>{
    return this.http.get<Order[]>(`${this.apiUrl}/read-all`);
  }

  public createOrders(newOrder: NewOrder):Observable<Order>{
    return this.http.post<Order>(`${this.apiUrl}/create`, newOrder)
  }

  public getOrderById(id: string):Observable<Order>{
    const params = new HttpParams().set('id', id);
    return this.http.get<Order>(`${this.apiUrl}/read`, {params: params});
  }

  public deleteOrder(id: string): Observable<void> {
    const params = new HttpParams().set('id', id);
    return this.http.delete<void>(`${this.apiUrl}/delete`, {params: params});
  }

}
