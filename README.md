# componentes_parcial_arizola
Parcial

///// Microservicio ms-orders ///////

Este microservicio gestiona las órdenes de compra de un sistema e-commerce. Permite registrar, consultar y filtrar órdenes.

// Cómo ejecutar

./mvnw spring-boot:run

// Coleccion Postman

{
  "info": {
    "name": "ms-orders API",
    "_postman_id": "ms-orders-collection-id",
    "description": "Colecci\u00f3n para pruebas de la API REST de \u00f3rdenes de compra con MongoDB.",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Crear orden",
      "request": {
        "method": "POST",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"customer\": \"Eric Arizola\",\n  \"status\": \"PENDING\",\n  \"products\": [\n    {\n      \"productId\": 1,\n      \"quantity\": 2\n    },\n    {\n      \"productId\": 3,\n      \"quantity\": 1\n    }\n  ]\n}"
        },
        "url": {
          "raw": "http://localhost:8082/api/orders",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8082",
          "path": [
            "api",
            "orders"
          ]
        }
      }
    },
    {
      "name": "Listar todas las \u00f3rdenes",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8082/api/orders",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8082",
          "path": [
            "api",
            "orders"
          ]
        }
      }
    },
    {
      "name": "Buscar por cliente",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8082/api/orders/customer?name=eric",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8082",
          "path": [
            "api",
            "orders",
            "customer"
          ],
          "query": [
            {
              "key": "name",
              "value": "eric"
            }
          ]
        }
      }
    },
    {
      "name": "Buscar por estado",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8082/api/orders/status?status=pending",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8082",
          "path": [
            "api",
            "orders",
            "status"
          ],
          "query": [
            {
              "key": "status",
              "value": "pending"
            }
          ]
        }
      }
    },
    {
      "name": "Buscar por ID",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8082/api/orders/:id",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8082",
          "path": [
            "api",
            "orders",
            ":id"
          ]
        }
      }
    }
  ]
}


// Se aplicó el patrón Builder en la entidad "Order"

-----------------------------------------------------------------------------------------------------------------------

//// Microservicio ms-products ////

Este microservicio permite gestionar el catálogo de productos del e-commerce: crear, listar, actualizar, eliminar, buscar y paginar.

// Cómo ejecutar

./mvnw spring-boot:run

// Coleccion Postman

{
  "info": {
    "name": "ms-products API",
    "_postman_id": "ms-products-collection-id",
    "description": "Colección para pruebas del microservicio ms-products con MongoDB.",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Crear producto",
      "request": {
        "method": "POST",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"name\": \"Laptop Lenovo\",\n  \"description\": \"Laptop para trabajo y estudio\",\n  \"price\": 2599.90,\n  \"stock\": 15,\n  \"category\": \"Tecnología\"\n}"
        },
        "url": {
          "raw": "http://localhost:8081/api/products",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products"]
        }
      }
    },
    {
      "name": "Listar todos los productos",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8081/api/products",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products"]
        }
      }
    },
    {
      "name": "Buscar por nombre",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8081/api/products/search?name=laptop",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products", "search"],
          "query": [
            {
              "key": "name",
              "value": "laptop"
            }
          ]
        }
      }
    },
    {
      "name": "Paginación",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8081/api/products/paged?page=0&size=5",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products", "paged"],
          "query": [
            {
              "key": "page",
              "value": "0"
            },
            {
              "key": "size",
              "value": "5"
            }
          ]
        }
      }
    },
    {
      "name": "Buscar por ID",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8081/api/products/:id",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products", ":id"]
        }
      }
    },
    {
      "name": "Actualizar producto",
      "request": {
        "method": "PUT",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"name\": \"Laptop Lenovo Ideapad\",\n  \"description\": \"Actualizada para 2024\",\n  \"price\": 2999.90,\n  \"stock\": 20,\n  \"category\": \"Tecnología\"\n}"
        },
        "url": {
          "raw": "http://localhost:8081/api/products/:id",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products", ":id"]
        }
      }
    },
    {
      "name": "Eliminar producto",
      "request": {
        "method": "DELETE",
        "url": {
          "raw": "http://localhost:8081/api/products/:id",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8081",
          "path": ["api", "products", ":id"]
        }
      }
    }
  ]
}


// Se usó el patrón Builder en la clase Product.java
