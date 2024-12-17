import { Routes } from '@angular/router';
import {AppComponent} from './app.component';
import {ProductComponent} from './product/product.component';
import {OrderComponent} from './order/order.component';

export const routes: Routes = [
  {path: 'products', component: ProductComponent},
  {path: 'orders', component: OrderComponent},
];
