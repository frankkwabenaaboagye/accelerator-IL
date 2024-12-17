import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product.model';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = "http://localhost:8080/products";

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/read-all`);
  }

  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.apiUrl}/create`, product);
  }

  getProductById(id: string){
    const params = new HttpParams().set('id', id);
    return this.http.get<Product>(`${this.apiUrl}/read`, {params: params});
  }

  deleteProduct(id: string): Observable<void> {
    const params = new HttpParams().set('id', id);
    return this.http.delete<void>(`${this.apiUrl}/delete`, {params: params});
  }


}
