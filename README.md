# **StudentConnect**

StudentConnect es una plataforma para la gestión de estudiantes, diseñada para profesores y estudiantes. Los profesores pueden gestionar asistencia, calificaciones y comentarios sobre los estudiantes. Los estudiantes pueden consultar sus notas, historial académico y calificar a los profesores.

---

## **Características principales**
- Gestión de asistencia, calificaciones y comentarios por parte de los profesores.
- Visualización de notas, asistencia y trayectoria académica para estudiantes.
- Exportación de datos a PDF para reportes.
- Conexión dinámica entre el backend (Spring Boot) y el frontend (React).

---

## **Requisitos**

### **Backend**
- Java 17 o superior.
- Maven.
- MySQL o H2 Database.

### **Frontend**
- Node.js 16 o superior.
- npm o yarn.

---

## **Configuración del proyecto**

### **1. Backend (Spring Boot)**

#### **Paso 1: Clonar el repositorio**
Clona este proyecto en tu máquina local:

```bash
git clone https://github.com/tu-usuario/studentconnect.git
cd studentconnect/backend


Paso 2: Configurar la base de datos
H2 (base de datos en memoria para pruebas)
Si usas H2, no necesitas configuraciones adicionales. Asegúrate de que el archivo application.properties tenga esta configuración:

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update


Accede a la consola de H2 en http://localhost:8080/h2-console usando:

Usuario: sa
Contraseña: password
MySQL (base de datos persistente)
Si prefieres usar MySQL, actualiza application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/studentconnect
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect


Crea una base de datos llamada studentconnect:

CREATE DATABASE studentconnect;


Paso 3: Ejecutar el backend
Compila y ejecuta el backend con Maven:

mvn spring-boot:run
El backend estará disponible en: http://localhost:8080.

2. Frontend (React)
Paso 1: Moverse al directorio del frontend

cd ../frontend

Paso 2: Instalar dependencias
npm install

Paso 3: Configurar la URL de la API
En src/api/config.js o en la configuración de Axios, asegúrate de que la URL apunta a http://localhost:8080/api.

Paso 4: Ejecutar el frontend
npm run dev
El frontend estará disponible en: http://localhost:5173.

Uso del programa
1. Profesor
Accede al panel del profesor para:
Ver la lista de estudiantes.
Gestionar asistencia (porcentajes).
Calificar estudiantes y agregar comentarios.
Exportar reportes a PDF.
2. Estudiante
Accede al panel del estudiante para:
Consultar notas y promedios.
Visualizar asistencia y trayectoria académica.
Calificar a profesores.
API Endpoints
Estudiantes
GET /api/students: Obtiene todos los estudiantes.
GET /api/students/{id}: Obtiene un estudiante por ID.
POST /api/students: Crea un nuevo estudiante.
PUT /api/students/{id}: Actualiza los datos de un estudiante.
DELETE /api/students/{id}: Elimina un estudiante.
Funciones futuras
Integrar autenticación con JWT.
Mejorar estadísticas gráficas.
Soporte para exportación a Excel.
Contribuciones
Si deseas contribuir, haz un fork del repositorio y crea un Pull Request con tus cambios.

Autores:

JOEL
LAURA
ANDREI