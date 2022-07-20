import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  { id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'user', name: 'USER', icon: 'people', route: '/main/users'},
  { id: 'client', name: 'CLIENT', icon: 'people', route: '/main/clients'},
  { id: 'transaction', name: 'TRANSACTIONS', icon: 'business_center', route: '/main/transactions'},
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
