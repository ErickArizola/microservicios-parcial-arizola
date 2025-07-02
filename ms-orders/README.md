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