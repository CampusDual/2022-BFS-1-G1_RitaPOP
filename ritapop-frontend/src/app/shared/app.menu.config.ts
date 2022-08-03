import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  { id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'users', name: 'USERS', icon: 'person', route: '/main/users'},
  { id: 'client', name: 'CLIENT', icon: 'people', route: '/main/clients'},
  { id: 'transaction', name: 'TRANSACTIONS', icon: 'credit_card', route: '/main/transactions'},
];