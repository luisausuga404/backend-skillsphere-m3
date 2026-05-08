-- Semilla de datos para 10 Vacantes (Job Offers)
INSERT INTO job_offers (title, description, requirements, location, salary_min, salary_max, status, embedding, created_at) VALUES 
('Desarrollador Java Junior', 'Buscamos desarrollador Java con ganas de aprender.', 'Java, Spring Boot, SQL básico', 'Remoto', 1500, 2000, 'OPEN', '[0.1, 0.2, 0.3]', NOW()),
('Analista de Datos Jr', 'Analista para equipo de inteligencia de negocios.', 'Python, Pandas, SQL', 'Ciudad de México', 1800, 2500, 'OPEN', '[0.2, 0.1, 0.4]', NOW()),
('Frontend Developer', 'Experiencia en React y Tailwind.', 'React, TypeScript, CSS', 'Remoto', 2000, 3000, 'OPEN', '[0.3, 0.5, 0.1]', NOW()),
('Backend Developer Med', 'Java Spring Boot y Microservicios.', 'Java 17+, Spring, Docker', 'Bogotá', 2500, 3500, 'OPEN', '[0.1, 0.2, 0.5]', NOW()),
('Data Scientist', 'Desarrollo de modelos de ML e IA.', 'Python, Scikit-Learn, PyTorch', 'Remoto', 3000, 4500, 'OPEN', '[0.8, 0.1, 0.2]', NOW()),
('Ingeniero DevOps', 'Automatización de despliegues y CI/CD.', 'AWS, GitHub Actions, Terraform', 'Remoto', 3500, 5000, 'OPEN', '[0.4, 0.4, 0.4]', NOW()),
('Diseñador UX/UI', 'Diseño de interfaces atractivas.', 'Figma, Adobe XD', 'Remoto', 1800, 2800, 'OPEN', '[0.5, 0.6, 0.1]', NOW()),
('Scrum Master', 'Líder ágil para equipos de desarrollo.', 'Certificación Scrum, JIRA', 'Remoto', 2500, 3500, 'OPEN', '[0.2, 0.3, 0.8]', NOW()),
('QA Tester Automatizador', 'Creación de pruebas E2E y unitarias.', 'Selenium, Cypress, Java', 'Remoto', 2000, 3000, 'OPEN', '[0.3, 0.4, 0.5]', NOW()),
('Soporte Técnico Nivel 2', 'Resolución de problemas técnicos a clientes.', 'Redes, SO, Bases de datos', 'Presencial', 1000, 1500, 'OPEN', '[0.1, 0.1, 0.1]', NOW());
