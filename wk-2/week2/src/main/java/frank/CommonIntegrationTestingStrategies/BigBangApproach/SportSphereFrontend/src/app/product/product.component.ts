import {Component, OnInit} from '@angular/core';
import {Product} from '../product.model';
import {ProductService} from '../product.service';
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-product',
  imports: [
    FormsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './product.component.html',
  standalone: true,
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  products: Product[] = []
  newProduct: Product = {
    id: "",
    name: "",
    price : 0,
    description: ""
  }

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.fetchProducts();
  }

  public fetchProducts(): void {
    this.productService.getProducts().subscribe({
      next: (data) => {
        this.products = data;
      },
      error: (err) => {
        console.error('Error fetching products:', err);
      }
    });
  }

  createProduct(): void {
    this.productService.createProduct(this.newProduct).subscribe(data => {
      this.products.push(data);
      this.newProduct = { id: '', name: '', price: 0, description: '' }; // resetting it
    });
  }

  deleteProduct(id: string): void {
    this.productService.deleteProduct(id).subscribe(() => {
      this.products = this.products.filter(product => product.id !== id);  // Remove product from list
    });
  }

}
