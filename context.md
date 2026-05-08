# Contexto General y Plan de Integración: SkillSphere (M1/M3)

## 📌 Objetivo Principal y Contexto del Semestre
Nos encontramos en el **Momento 3** (entregable final del semestre). El trabajo realizado previamente en el Momento 1 y 2 en los respectivos repositorios sirve como base para este entregable.

El objetivo principal es tener una **API consumible** por las 3 materias, que respete los temas vistos en cada una, utilizando el backend como "Contrato" o estructura central de datos.

**Requisitos Específicos de Backend (Prioridad Actual):**
- Crear una API consumible desarrollada en Java (Spring Boot) conectada a **Supabase**.
- Implementar operaciones **CRUD** funcionales que actualicen la base de datos.
- Es **obligatorio** el uso de **DTOs** para la transferencia de datos.
- Se debe integrar el uso de **Embeddings**.

*Nota: Las guías detalladas de las materias de Frontend y Python se entregarán posteriormente, por lo que primero avanzaremos en tener el Backend funcional y consumible.*

## 🗂️ Arquitectura del Espacio de Trabajo (Monorepo Virtual)
El usuario clonará y agrupará los 3 repositorios en una misma carpeta padre para facilitar la visibilidad y el trabajo conjunto en el IDE. La estructura final esperada será algo como:

```text
Espacio_de_Trabajo/
 ├── skillsphere-api-m3/       # Backend (Java Spring Boot + Supabase)
 │   └── Repo: https://github.com/C13G0/skillsphere-api-m3.git
 ├── skillsphere_react/        # Frontend (React)
 │   └── Repo: https://github.com/C13G0/skillsphere_react.git
 └── skillsphere_py/           # Análisis de Datos (Python + Pandas)
     └── Repo: https://github.com/luisausuga404/skillsphere_py.git
```

---

## 🚀 Plan de Implementación (Paso a Paso)

### Fase 1: Preparación y Exploración (Al reiniciar el IDE)
- [ ] **1. Agrupar Repositorios:** El usuario abre la carpeta padre que contiene los 3 repositorios en su IDE.
- [ ] **2. Análisis de Python:** Revisaremos los scripts de Python de ejercicios anteriores. Identificaremos qué columnas y datos (salarios, fechas, habilidades, limpieza de nulos) usaron para asegurarnos de que el Backend los provea.
- [ ] **3. Análisis de Frontend:** Revisaremos el código de React para identificar los componentes visuales (tarjetas, tablas) y qué "props" o datos están esperando recibir.

### Fase 2: Definición del "Contrato de Datos" (Data Contract)
- [ ] **1. Ajuste de DTOs en Java:** En base a la Fase 1, modificaremos los DTOs en `skillsphere-api-m3` (`JobOfferDTO`, `CertificateDTO`, etc.) para que contengan exactamente los campos requeridos por Python y React.
- [ ] **2. Actualización de Supabase:** Si hay nuevos campos, actualizaremos las tablas correspondientes en Supabase.
- [ ] **3. Documentación del JSON Final:** Dejaremos un ejemplo claro del JSON que devolverá cada endpoint para que los otros dos proyectos sepan qué esperar.

### Fase 3: Integración de Consumidores
- [ ] **1. Integración en React:** Crear servicios (usando `fetch` o `axios`) en el Frontend para consumir los endpoints (ej. `GET /api/job-offers`).
- [ ] **2. Integración en Python:** Crear un script de ingesta (usando `requests` y `pandas`) que descargue los datos de la API en JSON y los convierta a DataFrames (`df`) listos para el análisis.

---

## 📚 Materiales de Referencia (Backend)
El profesor ha proporcionado repositorios de ejemplo y fragmentos de código que dictan la estructura base y tecnologías permitidas para el Backend:
- **Tecnologías:** Java, Spring Boot, Spring Data JPA, Lombok, PostgreSQL (compatible con Supabase).
- **Estructura Base:** Arquitectura en capas clásica (Controller -> Service -> Repository -> Entity).
- **Conexión a BD:** Mediante variables de entorno en `.env` (ej. `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`) inyectadas en `application.properties`.
- **Repositorios de Ejemplo:**
  - `https://github.com/jfinforecursos/cesde_backend2_ejemplo_api_basica.git`
  - `https://github.com/jfinforecursos/cesde_backend2_ejemplo_servicio.git`

*Nota: Estos ejemplos no implementan DTOs ni Embeddings de forma nativa, por lo que nuestra solución deberá extender esta arquitectura base para cumplir con los requisitos obligatorios del Momento 3 (DTOs y Vector Search/Embeddings).*

---

> [!NOTE]
> **Para continuar la conversación después de reiniciar el IDE:**
> Puedes simplemente adjuntar o mencionar este archivo `context.md` y pedirme: *"Analiza los repositorios de Python y Front que ya están en el espacio de trabajo para empezar con la Fase 1"*.

### Actualización (Refactorización Momento 3):
- **JPA & Hibernate:** Se reemplazó el cliente HTTP REST manual (SupabaseClient) por interfaces nativas `JpaRepository` en `JobOffer`, `Student`, `Certificate` e `Institution`.
- **Embeddings Integrados:** Se agregó el campo `float[] embedding` con `@JdbcTypeCode(SqlTypes.VECTOR)` en las 4 entidades para soporte IA mediante `pgvector`.
- **Data Contract Strict:** Se implementaron mappers manuales en todos los servicios, garantizando que los controladores devuelvan exclusivamente `DTOs`, encapsulando la capa de persistencia como exige la rúbrica del M3.
