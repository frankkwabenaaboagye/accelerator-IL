import {Routes} from '@angular/router';
import {ProductComponent} from './product/product.component';
import {OrderComponent} from './order/order.component';

export const routes: Routes = [
  // { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'products', component: ProductComponent },
  { path: 'orders', component: OrderComponent },
];
