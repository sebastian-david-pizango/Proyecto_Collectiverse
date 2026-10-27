#  Collectiverse

> Plataforma web para coleccionistas: publica, intercambia, califica y guarda tus productos coleccionables favoritos.

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Backend-6DB33F?logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)
![Codespaces](https://img.shields.io/badge/Dev-GitHub%20Codespaces-181717?logo=github)

---

##  Descripción

**Collectiverse** es un proyecto académico de Ingeniería Web (*Proyecto_IW*) que modela una comunidad de coleccionistas. Los usuarios pueden organizar sus productos en colecciones, publicarlos para venta o intercambio, marcar favoritos, calificar a otros usuarios y reportar contenido inapropiado.

Actualmente el repositorio contiene la **capa de dominio** del backend: el modelo de datos (entidades) y sus repositorios de acceso a datos, construidos con Spring Boot.

##  Integrantes

| Nombre |
| --- |
| Joel Choquepata |
| Joaquin Torres |
| Sebastian David |
| Franco Rojas |

## Tecnologías

- **Lenguaje:** Java 25 (JDK 25)
- **Framework:** Spring Boot
- **Persistencia:** Spring Data JPA (entidades + repositorios)
- **Gestión de dependencias:** Maven
- **Entorno de desarrollo:** GitHub Codespaces + Dev Containers

## Modelo de datos

El diagrama completo de la base de datos está en [`Diagrama.png`](./Diagrama.png).

| Entidad | Descripción |
| --- | --- |
| `Category` | Categorías para clasificar los productos. |
| `CollectionEntity` | Colecciones que agrupan los productos de un usuario. |
| `Product` | Producto coleccionable. |
| `ProductImage` | Imágenes asociadas a un producto. |
| `Publication` | Publicación de un producto en la plataforma. |
| `PublicationExchange` | Propuestas o registros de intercambio ligados a una publicación. |
| `Favorite` | Productos o publicaciones marcadas como favoritas. |
| `Rating` | Calificaciones entre usuarios. |
| `Report` | Reportes de contenido o usuarios. |

## Estructura del repositorio

```
Proyecto_Collectiverse/
├── .devcontainer/
│   └── devcontainer.json *            # Instala el JDK 25 al crear el Codespace
├── .vscode/
│   └── settings.json *                # Configuración del editor
├── collectiverse/
│   ├── .mvn/ *
│   │   └── wrapper/
│   │       └── maven-wrapper.properties *
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/collectiverse/collectiverse/
│   │   │   │       ├── CollectiverseApplication.java
│   │   │   │       └── dominio/
│   │   │   │           ├── entity/
│   │   │   │           │   ├── Category.java
│   │   │   │           │   ├── CollectionEntity.java
│   │   │   │           │   ├── Favorite.java
│   │   │   │           │   ├── Product.java
│   │   │   │           │   ├── ProductImage.java
│   │   │   │           │   ├── Publication.java
│   │   │   │           │   ├── PublicationExchange.java
│   │   │   │           │   ├── Rating.java
│   │   │   │           │   └── Report.java
│   │   │   │           └── repository/
│   │   │   │               ├── RepoCategory.java
│   │   │   │               ├── RepoCollection.java
│   │   │   │               ├── RepoFavorite.java
│   │   │   │               ├── RepoProduct.java
│   │   │   │               ├── RepoProductImage.java
│   │   │   │               ├── RepoPublication.java
│   │   │   │               ├── RepoPublicationExchange.java
│   │   │   │               ├── RepoRating.java
│   │   │   │               └── RepoReport.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │       └── java/
│   │           └── com/collectiverse/collectiverse/
│   │               └── CollectiverseApplicationTests.java
│   ├── .gitignore *
│   ├── mvnw *
│   ├── mvnw.cmd *
│   └── pom.xml *
├── Diagrama.png
└── README.md
```

### Detalle de carpetas

- **`.devcontainer/`**: usamos GitHub Codespaces y, como el entorno debe recrearse cada vez que trabajamos, esta carpeta instala automáticamente el JDK 25 al crear el Codespace, evitando reinstalarlo a mano.
- **`collectiverse/`**: contiene el proyecto Spring Boot con las entidades (que representan las tablas del modelo de datos) y sus respectivos repositorios.

## Cómo ejecutar el proyecto

### Opción 1: GitHub Codespaces (recomendada)

1. En el repositorio, haz clic en **Code → Codespaces → Create codespace on main**.
2. Espera a que el Dev Container termine de instalar el JDK 25.
3. En la terminal:

```bash
cd collectiverse
./mvnw spring-boot:run
```

### Opción 2: Entorno local

**Requisitos:** JDK 25 y Git.

```bash
git clone https://github.com/sebastian-david-pizango/Proyecto_Collectiverse.git
cd Proyecto_Collectiverse/collectiverse
./mvnw spring-boot:run
```

> En Windows usa `mvnw.cmd spring-boot:run`.

### Ejecutar las pruebas

```bash
./mvnw test
```


