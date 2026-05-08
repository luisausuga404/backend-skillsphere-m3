# SkillSphere - API de Gestión de Certificados y Oportunidades Laborales

## Descripción del Proyecto

SkillSphere es una API REST desarrollada en **Spring Boot 3.5.11** que permite gestionar certificados, oportunidades laborales, instituciones y estudiantes usando **Supabase** como base de datos en la nube.

### Características Principales
- ✅ API REST con documentación automática (OpenAPI/Swagger)
- ✅ Integración con Supabase (base de datos en la nube)
- ✅ DTOs para respuestas limpias (sin datos sensibles)
- ✅ Endpoints para CRUD de: Certificates, Job Offers, Institutions, Students
- ✅ Exportable a Postman
- ✅ Multi-plataforma (funciona en cualquier PC con Java 21+)

---

## 📋 Requisitos Previos

Antes de empezar, asegúrate de tener instalado:

1. **Java 21+** (OpenJDK o Eclipse Temurin)
   - Descarga desde: https://adoptium.net/ o https://jdk.java.net/

2. **Maven 3.8+** (incluido en el proyecto con `mvnw`)
   - Generalmente no necesitas instalarlo manualmente

3. **Git** (opcional, pero recomendado)
   - Descarga desde: https://git-scm.com/

4. **Editor/IDE** (recomendado)
   - Visual Studio Code
   - IntelliJ IDEA (Community Edition)
   - Eclipse

5. **Cuenta en Supabase** (para la base de datos)
   - Crea una cuenta gratis en: https://app.supabase.com

---

## 🚀 Pasos para Inicializar el Proyecto

### 1️⃣ **Clonar o Descargar el Repositorio**

Si aún no tienes el proyecto:

```bash
# Opción A: Clonar desde Git
git clone <URL-del-repositorio>
cd skillsphere

# Opción B: Si solo descargaste el ZIP
unzip skillsphere.zip
cd skillsphere
```

### 2️⃣ **Configurar las Variables de Entorno**

#### Crear archivo `.env` en la raíz del proyecto:

```bash
# En Windows (CMD):
copy .env.example .env

# En Windows (PowerShell):
Copy-Item .env.example .env

# En macOS/Linux:
cp .env.example .env
```

#### Abrir `.env` y reemplazar los placeholders:

```
SUPABASE_URL=https://tu-proyecto.supabase.co
SUPABASE_KEY=tu-api-key-aqui
```

**¿Cómo obtener estas credenciales?**

1. Ve a https://app.supabase.com
2. Selecciona tu proyecto (o crea uno nuevo)
3. Ve a **Settings** > **API**
4. Copia:
   - **Project URL** → `SUPABASE_URL` (ejemplo: `https://ubafnnnjgedgueilqihx.supabase.co`)
   - **Service Role Key** o **Public Key** → `SUPABASE_KEY`

> ⚠️ **IMPORTANTE**: 
> - Nunca compartas tu `.env` en público ni lo commits a Git
> - Está excluido en `.gitignore` automáticamente
> - Cada PC debe tener su propio `.env` con sus credenciales

### 3️⃣ **Instalar Dependencias y Compilar**

```bash
# En Windows:
mvnw clean install

# En macOS/Linux:
./mvnw clean install
```

Esto descargará todas las dependencias necesarias y compilará el proyecto.
Esperado: debería terminar con `BUILD SUCCESS`

### 4️⃣ **Ejecutar la Aplicación**

```bash
# En Windows:
mvnw spring-boot:run

# En macOS/Linux:
./mvnw spring-boot:run
```

Deberías ver algo como:
```
2026-05-02T11:55:44.170-05:00  INFO 9568 --- [skillsphere] c.g.skillsphere.SkillSphereApplication   : 
Started SkillSphereApplication in 3.024 seconds
```

✅ **¡La aplicación está lista!** Estará disponible en: `http://localhost:8080`

---

## 📚 Acceder a la API

### 1. **Documentación Interactiva (Swagger UI)**
```
http://localhost:8080/swagger-ui.html
```
Aquí puedes ver todos los endpoints y probarlos directamente desde el navegador.

### 2. **JSON de OpenAPI (para Postman)**
```
http://localhost:8080/v3/api-docs
```

**Para importar en Postman:**
1. Abre Postman
2. **File** > **Import**
3. Selecciona **Link** y pega: `http://localhost:8080/v3/api-docs`
4. ¡Automáticamente importará todos los endpoints!

### 3. **Endpoints Disponibles**

| Recurso | GET | POST | PUT | DELETE |
|---------|-----|------|-----|--------|
| `/api/certificates` | ✅ | ✅ | ✅ | ✅ |
| `/api/job-offers` | ✅ | ✅ | ✅ | ✅ |
| `/api/institutions` | ✅ | ✅ | ✅ | ✅ |
| `/api/students` | ✅ | ✅ | ✅ | ✅ |

**Ejemplo de request:**
```bash
# Obtener todos los certificados
curl -X GET http://localhost:8080/api/certificates

# Crear un nuevo certificado
curl -X POST http://localhost:8080/api/certificates \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Certificado de Java",
    "description": "Certificado de programación en Java",
    "issueDate": "2026-05-02",
    "studentId": 1,
    "institutionId": 1
  }'
```

---

## 🔧 Estructura del Proyecto

```
skillsphere/
├── src/
│   ├── main/
│   │   ├── java/com/grupo10/skillsphere/
│   │   │   ├── controller/          # Endpoints REST
│   │   │   │   ├── CertificateController.java
│   │   │   │   ├── JobOfferController.java
│   │   │   │   ├── InstitutionController.java
│   │   │   │   └── StudentController.java
│   │   │   ├── service/             # Lógica de negocio
│   │   │   │   ├── CertificateService.java
│   │   │   │   ├── JobOfferService.java
│   │   │   │   ├── InstitutionService.java
│   │   │   │   └── StudentService.java
│   │   │   ├── model/
│   │   │   │   ├── entity/          # Modelos JPA (referencia)
│   │   │   │   └── dto/             # Data Transfer Objects
│   │   │   │       ├── CertificateDTO.java
│   │   │   │       ├── JobOfferDTO.java
│   │   │   │       ├── InstitutionDTO.java
│   │   │   │       └── StudentDTO.java
│   │   │   ├── repository/          # (Deshabilitados, usa Supabase)
│   │   │   ├── config/              # Configuración de Spring
│   │   │   │   ├── SupabaseClient.java
│   │   │   │   ├── SupabaseConfig.java
│   │   │   │   └── OpenApiConfig.java
│   │   │   └── SkillSphereApplication.java  # Clase principal
│   │   └── resources/
│   │       └── application.properties  # Configuración de la app
│   └── test/
│       └── java/                    # Tests unitarios
├── .env                             # Variables de entorno (NO COMITEAR)
├── .env.example                     # Plantilla de variables
├── .gitignore                       # Archivos a ignorar en Git
├── pom.xml                          # Dependencias de Maven
├── mvnw / mvnw.cmd                  # Maven Wrapper (Windows/Unix)
└── README.md                        # Este archivo
```

---

## 🔐 Arquitectura de Seguridad

### Por qué las credenciales están en `.env`?

1. **No aparecen en el repositorio** (excluidas en `.gitignore`)
2. **Se cargan en tiempo de ejecución** desde variables de entorno
3. **Cada PC puede tener sus propias credenciales**
4. **No se exponen en el código fuente**

### Flujo de carga de credenciales:

```
.env (local) → application.properties → SupabaseClient → API REST
```

- `application.properties` usa: `${SUPABASE_URL:}` y `${SUPABASE_KEY:}`
- Si las variables no existen en `.env`, usa valores por defecto (para desarrollo local)
- En producción, debes establecer las variables en tu servidor/plataforma (Heroku, Railway, Azure, etc.)

---

## 🤝 Crear un Nuevo Repositorio Git desde Cero

Si clonaste de otro proyecto y quieres crear tu propio repositorio:

### 1️⃣ **Eliminar el Git anterior**
```bash
# En Windows (PowerShell como Admin):
Remove-Item -Recurse -Force .git

# En Windows (CMD):
rmdir /s /q .git

# En macOS/Linux:
rm -rf .git
```

### 2️⃣ **Inicializar un nuevo repositorio**
```bash
git init
git config user.name "Tu Nombre"
git config user.email "tu.email@example.com"
```

### 3️⃣ **Agregar archivos (sin .env)**
```bash
git add .
git status  # Verifica que .env NO aparezca aquí
```

Deberías ver:
- ✅ `.gitignore`
- ✅ `README.md`
- ✅ `pom.xml`
- ✅ `src/`
- ❌ `.env` (NO debe aparecer)

### 4️⃣ **Hacer el primer commit**
```bash
git commit -m "Initial commit: SkillSphere API with Supabase integration"
```

### 5️⃣ **Agregar repositorio remoto (GitHub, GitLab, Bitbucket, etc.)**

**Opción A: GitHub**
1. Ve a https://github.com/new
2. Crea un nuevo repositorio (sin README)
3. Copia el nombre del repositorio
4. En tu terminal:

```bash
git remote add origin https://github.com/tu-usuario/skillsphere.git
git branch -M main
git push -u origin main
```

**Opción B: GitLab**
```bash
git remote add origin https://gitlab.com/tu-usuario/skillsphere.git
git branch -M main
git push -u origin main
```

**Opción C: Bitbucket**
```bash
git remote add origin https://bitbucket.org/tu-usuario/skillsphere.git
git branch -M main
git push -u origin main
```

### 6️⃣ **Verificar que `.env` está ignorado**
```bash
git check-ignore .env
```
Debería retornar: `.env`

### 7️⃣ **Agregar otros cambios posteriormente**
```bash
git add .
git commit -m "Add new features"
git push origin main
```

---

## 🐛 Solución de Problemas

### ❌ Error: "Port 8080 already in use"
```bash
# En Windows (CMD):
netstat -ano | findstr :8080
# Nota el PID y luego:
taskkill /PID <numero> /F

# En macOS/Linux:
lsof -i :8080
kill -9 <PID>

# O ejecuta en otro puerto:
mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### ❌ Error: "Supabase URL: null" o "Supabase Key: null"
- Verifica que `.env` existe en la **raíz del proyecto**
- Verifica que contiene:
  ```
  SUPABASE_URL=https://...
  SUPABASE_KEY=...
  ```
- Reinicia la aplicación después de cambiar `.env`
- Comprueba que NO hay espacios antes/después de `=`

### ❌ Error: "Java version not found"
```bash
# Verifica la versión de Java:
java -version

# Si no está instalado, descarga Java 21 desde:
# https://adoptium.net/
# Luego reinicia tu terminal
```

### ❌ Error: "BUILD FAILURE" al compilar
```bash
# Limpia el cache de Maven y reintenta:
mvnw clean install -U

# Si persiste, verifica que tienes internet
# y que Java está correctamente instalado
```

### ❌ Error: "Failed to connect to Supabase"
- Verifica tu conexión a internet
- Comprueba que `SUPABASE_URL` es correcto
- Asegúrate de que tu proyecto Supabase existe y está activo
- Verifica que `SUPABASE_KEY` es válida

### ❌ Error: "The application failed to start" con "UnsatisfiedDependencyException"
- Elimina la carpeta `target/`:
  ```bash
  # Windows:
  rmdir /s /q target
  
  # macOS/Linux:
  rm -rf target
  ```
- Recompila:
  ```bash
  mvnw clean install
  ```

---

## 📖 Tecnologías y Herramientas

| Tecnología | Versión | Propósito |
|------------|---------|----------|
| Java | 21 | Lenguaje de programación |
| Spring Boot | 3.5.11 | Framework REST |
| Spring Web | - | Controladores REST |
| Maven | 3.8+ | Gestión de dependencias |
| Lombok | - | Reducir boilerplate |
| SpringDoc OpenAPI | 2.6.0 | Documentación automática |
| Supabase | - | Base de datos en la nube |

---

## 📖 Documentación Adicional

- **Spring Boot**: https://spring.io/projects/spring-boot
- **Supabase Docs**: https://supabase.com/docs
- **OpenAPI Specification**: https://swagger.io/specification/
- **Maven**: https://maven.apache.org/
- **Java 21 Docs**: https://docs.oracle.com/en/java/javase/21/

---

## 👥 Contribuciones

Si encuentras un bug o tienes una mejora:
1. Haz un fork del repositorio
2. Crea una rama: `git checkout -b feature/nueva-funcion`
3. Haz commit de tus cambios: `git commit -m "Add feature description"`
4. Push a la rama: `git push origin feature/nueva-funcion`
5. Abre un Pull Request

---

## 📝 Licencia

Este proyecto se proporciona "tal cual está". Siéntete libre de usarlo, modificarlo y distribuirlo.

---

## 📧 Contacto

Para preguntas o soporte, abre un issue en el repositorio.

---

**¡Feliz desarrollo! 🚀**

Última actualización: Mayo 2026
