CREATE DATABASE AgenciaTransporte CHARACTER SET utf8 COLLATE utf8_general_ci;
USE AgenciaTransporte;

CREATE TABLE Clientes (
    Codigo INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Identificacion VARCHAR(50) NOT NULL,
    Contrasena VARCHAR(255) NOT NULL,
    Correo VARCHAR(255) NOT NULL
);

CREATE TABLE FlotillaBuses (
    Placa VARCHAR(10) PRIMARY KEY,
    Tipo ENUM('Microbus', 'County', 'Pullman') NOT NULL,
    Capacidad INT NOT NULL,
    Color VARCHAR(50) NOT NULL,
    Estado ENUM('Disponible', 'No disponible') NOT NULL
);

CREATE TABLE Destinos (
    Codigo INT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Fecha_salida DATE NOT NULL,
    Costo_persona DECIMAL(10, 2) NOT NULL,
    Estado ENUM('Confirmado', 'Pendiente') NOT NULL,
    Descripcion TEXT
);

CREATE TABLE AsigBusDestino (
    Codigo INT PRIMARY KEY,
    Codigo_destino INT,
    Fecha_salida_destino DATE,
    Placa_bus VARCHAR(10),
    Hora_asignacion TIME,
    FOREIGN KEY (Codigo_destino) REFERENCES Destinos(Codigo),
    FOREIGN KEY (Placa_bus) REFERENCES FlotillaBuses(Placa)
);

CREATE TABLE Ticket (
    Codigo_asignacion INT,
    Hora_seleccionada TIME,
    Codigo_destino INT,
    Placa_bus VARCHAR(10),
    Codigo_cliente INT,
    Costo_generado DECIMAL(10, 2),
    PRIMARY KEY (Codigo_asignacion, Hora_seleccionada),
    FOREIGN KEY (Codigo_destino) REFERENCES Destinos(Codigo),
    FOREIGN KEY (Placa_bus) REFERENCES FlotillaBuses(Placa),
    FOREIGN KEY (Codigo_cliente) REFERENCES Clientes(Codigo)
);

-- Inserciones de datos de ejemplo
-- Clientes adicionales
INSERT INTO Clientes (Codigo, Nombre, Identificacion, Contrasena, Correo) VALUES
(1, 'Juan Pérez', '123456789', 'contraseña1', 'juan.perez@example.com'),
(2, 'María López', '987654321', 'contraseña2', 'maria.lopez@example.com'),
(3, 'Carlos Rodríguez', '555444333', 'contraseña3', 'carlos.rodriguez@example.com'),
(4, 'Luisa Fernández', '111222333', 'contraseña4', 'luisa.fernandez@example.com'),
(5, 'Marta Pérez', '987654321', 'contraseña5', 'marta.perez@example.com'),
(6, 'José Ramírez', '123456789', 'contraseña6', 'jose.ramirez@example.com'),
(7, 'Andrea Soto', '567890123', 'contraseña7', 'andrea.soto@example.com'),
(8, 'Fernando López', '456789012', 'contraseña8', 'fernando.lopez@example.com');

-- Flotilla de buses adicionales
INSERT INTO FlotillaBuses (Placa, Tipo, Capacidad, Color, Estado) VALUES
('P456DEF', 'Pullman', 45, 'Verde', 'Disponible'),
('P654WYZ', 'County', 28, 'Amarillo', 'Disponible'),
('P123ABC', 'Microbus', 10, 'Rojo', 'Disponible'),
('P987ZYX', 'County', 25, 'Azul', 'No disponible'),
('P789GHI', 'Microbus', 10, 'Azul', 'Disponible'),
('P890JKL', 'County', 24, 'Rojo', 'No Disponible'),
('P678MNO', 'Pullman', 45, 'Blanco', 'Disponible'),
('P432PQR', 'Microbus', 10, 'Negro', 'Disponible');

-- Destinos turísticos adicionales
INSERT INTO Destinos (Codigo, Nombre, Fecha_salida, Costo_persona, Estado, Descripcion) VALUES
(1, 'Destino A', '2023-04-01', 100.00, 'Confirmado', 'Un hermoso destino turístico.'),
(2, 'Destino B', '2023-04-15', 150.00, 'Pendiente', 'Otro increíble lugar para visitar.'),
(3, 'Destino C', '2023-05-01', 200.00, 'Confirmado', 'Un destino turístico lleno de aventuras.'),
(4, 'Destino D', '2023-06-01', 250.00, 'Pendiente', 'Un lugar lleno de historia y cultura.'),
(5, 'Destino E', '2023-05-15', 150.00, 'Confirmado', 'Descubre la belleza natural de este destino.'),
(6, 'Destino F', '2023-06-10', 300.00, 'Pendiente', 'Un viaje al corazón de la selva tropical.'),
(7, 'Destino G', '2023-07-01', 350.00, 'Confirmado', 'Explora las montañas y los senderos de aventura.'),
(8, 'Destino H', '2023-08-01', 180.00, 'Pendiente', 'Una experiencia cultural y gastronómica única.');


-- Asignación de buses a destinos turísticos adicionales
INSERT INTO AsigBusDestino (Codigo, Codigo_destino, Fecha_salida_destino, Placa_bus, Hora_asignacion) VALUES
(1, 1, '2023-04-01', 'P123ABC', '08:00:00'),
(2, 1, '2023-04-01', 'P456DEF', '10:00:00'),
(3, 3, '2023-05-01', 'P654WYZ', '08:00:00'),
(4, 4, '2023-06-01', 'P456DEF', '09:00:00'),
(5, 5, '2023-05-15', 'P789GHI', '07:00:00'),
(6, 6, '2023-06-10', 'P890JKL', '06:00:00'),
(7, 7, '2023-07-01', 'P678MNO', '08:30:00'),
(8, 8, '2023-08-01', 'P432PQR', '10:30:00');

-- Tickets adicionales
INSERT INTO Ticket (Codigo_asignacion, Hora_seleccionada, Codigo_destino, Placa_bus, Codigo_cliente, Costo_generado) VALUES
(1, '06:00:00', 1, 'P123ABC', 1, 100.00),
(2, '10:00:00', 1, 'P456DEF', 1, 100.00),
(2, '10:00:00', 1, 'P456DEF', 3, 100.00),
(3, '08:00:00', 3, 'P654WYZ', 2, 200.00),
(3, '08:00:00', 3, 'P654WYZ', 4, 200.00),
(4, '09:00:00', 4, 'P456DEF', 3, 250.00),
(4, '09:00:00', 4, 'P456DEF', 4, 250.00),
(5, '07:00:00', 5, 'P789GHI', 1, 150.00),
(5, '07:00:00', 5, 'P789GHI', 5, 150.00),
(6, '06:00:00', 6, 'P890JKL', 2, 300.00),
(6, '06:00:00', 6, 'P890JKL', 6, 300.00);

