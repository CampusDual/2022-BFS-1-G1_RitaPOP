# Proyecto RitaPOP (Business CRM) ![icoRP36px](https://user-images.githubusercontent.com/71487857/207843204-59a1ca7c-c635-433a-baa3-1ea7ac78f850.png)

## Realizado por:

| Nombre                     | Correo |
| -------------------------- | ----------------------------- |
| ✔ JAVIER FANDIÑO CASAL    | javierfandinho@gmail.com      |               
| ✔ ADRIAN CARNEIRO DIZ    | adriancarndi@gmail.com         |
| ✔ CINTA TAFUR CERREJON  | cintatafur@gmail.com|
| ✔ TOMAS CARRALERO CORREDERAS    | 	tcaralero@gmail.com      |
| ✔ DONATO RAMOS MARTINEZ    |donatoramos@hotmail.com   |

##  🔧 Instalaciones en Back

# Instalar


Ir al directorio principal y usar Maven para instalar la aplicación

```
  mvn install
```

# Arrancar Base de Datos

Ir al directorio model y ejecutar el comando:

```
  mvn exec:java -Prun_database
```

# Arrancar el servidor Backend

Ir al directorio boot y ejecutar el comando:

```
 mvn spring-boot:run
```

##  🔧 Instalaciones en front

 *ANGULAR
 
 ```
  npm install -g @angular/cli
 ```
  *Node 
  v12.22.10
  
  ```
  🐛Si da error de npm:
  
  Debeís lanzar el siguiente comando
  npm cache clean --force
  
  Eliminar la carpeta de 
  node_modules
  
  Hecho esto volvemos a lanzar el 
  npm install
  
```

# Arrancar el servidor web

Ir al directorio frontend y ejecutar el comando

```
npm start
```

Para acceder a la aplicación navegar a la URL:

https://localhost:4200
