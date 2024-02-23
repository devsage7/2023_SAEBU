CREATE TABLE Profesores(
  id_p INT AUTO_INCREMENT NOT NULL,
  pnombreyape VARCHAR(50) NOT NULL,
  ptipodoc VARCHAR(30) NOT NULL,
  pnrodoc INT NOT NULL,
  pcuil_cuit BIGINT NOT NULL,
  pdomicilio VARCHAR(50),
  pbarrio VARCHAR(50),
  plocalidad VARCHAR(30),
  pprovincia VARCHAR(30),
  ptel BIGINT NOT NULL,
  pfecNac DATE NOT NULL,
  psexo CHAR(10) NOT NULL,
  pobservaciones VARCHAR(100),
  part VARCHAR(30) NOT NULL,
  pfecIng DATE NOT NULL,
  PRIMARY KEY (id_p)
);

CREATE TABLE Alumnos(
  id_a INT AUTO_INCREMENT NOT NULL,
  anombreyape VARCHAR(50) NOT NULL,
  atipodoc VARCHAR(30) NOT NULL,
  anrodoc INT NOT NULL,
  adomicilio VARCHAR(50),
  abarrio VARCHAR(50),
  alocalidad VARCHAR(30),
  aprovincia VARCHAR(30),
  atel BIGINT NOT NULL,
  afecNac DATE NOT NULL,
  asexo CHAR(10) NOT NULL,
  aobservaciones VARCHAR(100),
  atipo CHAR(18) NOT NULL,
  aseguro CHAR(6) NOT NULL,
  PRIMARY KEY (id_a)
);

CREATE TABLE Disciplinas(
 id_d INT AUTO_INCREMENT NOT NULL,
 dnombre VARCHAR(30) NOT NULL,
 dimporte FLOAT NOT NULL,
 dimportecuota FLOAT NOT NULL,
 PRIMARY KEY (id_d)
 );
 
 CREATE TABLE Operadores(
 id_o INT AUTO_INCREMENT NOT NULL,
 onombreyape VARCHAR(50) NOT NULL,
 onrodoc INT NOT NULL,
 PRIMARY KEY (id_o)
 );
 
CREATE TABLE Inscripciones(
 icod INT AUTO_INCREMENT NOT NULL,
 ifecins DATE NOT NULL,
 ifecven DATE NOT NULL,
 iimporteuni FLOAT NOT NULL,
 iinscripcion CHAR(11) NOT NULL,
 id_o INT NOT NULL,
 id_a INT NOT NULL,
 id_d INT NOT NULL,
 PRIMARY KEY (icod),
 FOREIGN KEY (id_o) REFERENCES Operadores(id_o),
 FOREIGN KEY (id_a) REFERENCES Alumnos(id_a),
 FOREIGN KEY (id_d) REFERENCES Disciplinas(id_d)
);

 
CREATE TABLE Equipos(
 id_e INT AUTO_INCREMENT NOT NULL,
 enombre VARCHAR(30) NOT NULL,
 eintegrantes INT NOT NULL,
 PRIMARY KEY (id_e)
 );
 
 CREATE TABLE Cuotas(
  pmes INT NOT NULL,
  panio INT NOT NULL,
  id_a INT NOT NULL,
  id_d INT NOT NULL,
  icod INT NOT NULL,
  pnum INT DEFAULT -1,
  PRIMARY KEY (pmes, panio, icod),
  FOREIGN KEY (id_a) REFERENCES Alumnos(id_a),
  FOREIGN KEY (id_d) REFERENCES Disciplinas(id_d),
  FOREIGN KEY (icod) REFERENCES Inscripciones(icod)
 );
 
 CREATE TABLE Pagos_cuota(
  pnum INT AUTO_INCREMENT NOT NULL,
  pfecha DATE NOT NULL,
  pimporte FLOAT NOT NULL,
  phora TIME NOT NULL,
  id_o INT NOT NULL,
  pmes INT NOT NULL,
  panio INT NOT NULL,
  icod INT NOT NULL,
  PRIMARY KEY(pnum),
  FOREIGN KEY (id_o) REFERENCES Operadores(id_o),
  FOREIGN KEY (pmes, panio, icod) REFERENCES Cuotas(pmes, panio, icod)
 );
 
CREATE TABLE Pagos_equipo(
  panum INT AUTO_INCREMENT NOT NULL,
  pafecha DATE NOT NULL,
  paimporte FLOAT NOT NULL,
  padescripcion VARCHAR(100) NOT NULL,
  id_o INT NOT NULL,
  id_d INT NOT NULL,
  id_e INT NOT NULL,
  PRIMARY KEY(panum),
  FOREIGN KEY (id_o) REFERENCES Operadores(id_o),
  FOREIGN KEY (id_d) REFERENCES Disciplinas(id_d),
  FOREIGN KEY (id_e) REFERENCES Equipos(id_e)
 );
 
CREATE TABLE ProfesoresDisciplinas(
 id_p INT NOT NULL,
 id_d INT NOT NULL,
 PRIMARY KEY (id_p, id_d),
 FOREIGN KEY (id_p) REFERENCES Profesores(id_p),
 FOREIGN KEY (id_d) REFERENCES Disciplinas(id_d)
 );

INSERT INTO Disciplinas (dnombre,dimporte,dimportecuota) VALUES
('HANDBALL',3000,3000), ('KARATE DO',3000,3000),
('MASTER VOLEY',3000,3000),('MAXI BASQUET FEMENINO',3000,3000),
('MAXI BASQUET MASCULINO',3000,3000), ('MAXI VOLEY',3000,3000),
('RITMICA INFANTIL',3000,3000), ('RUGBY',3000,3000),
('SOCIO ADHERENTE BASQUET',3000,3000),('SOFTBALL',3000,3000),
('TELA',3000,3000), ('VOLEY',3000,3000),('VOLEY CLUB UNIVERSITARIO',3000,3000),
('YOGA',3000,3000), ('ZUMBA',3000,3000), ('AEROBICA',3000,3000), ('AEROBICA INFANTIL',3000,3000),
('ATLETISMO',3000,3000), ('BASQUET',3000,3000), ('BASQUET CLUB',3000,3000), ('FUTBOL',3000,3000),
('FUTBOL FEMENINO 11',3000,3000), ('FUTBOL MASCULINO 11 ESC DEPORT',3000,3000),
('FUTBOL SENIOR MASCULINO',3000,3000), ('FUTSAL MASCULINO',3000,3000), ('GIMNASIA ARTISTICA',3000,3000),
('GIMNASIO',3000,3000);


INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro) VALUES ('Juan Pérez', 'DNI', 34564523, 'Av. Pringles 123', 'Barrio Los Álamos', 'La Punta', 'San Luis', '1152334455', '1990-05-15', 'Masculino', 'Buena condición física, practica fútbol regularmente', 'ESCOLAR', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro) VALUES ('María Gómez', 'DNI', 65421432, 'Calle San Martín 456', 'Barrio Los Venados', 'San Luis', 'San Luis', '5544332211', '1992-08-22', 'Femenino', 'Atleta en competencias de atletismo', 'UNIVERSITARIO', 'TIPO2');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Carlos Rodríguez', 'LE', 11534678, 'Av. Lafinur 789', 'Barrio Los Estribos', 'Villa de Merlo', 'San Luis', '6677889900', '1988-03-10', 'Masculino', 'Practica levantamiento de pesas en su tiempo libre', 'EXTRAUNIVERSITARIO', 'TIPO3');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Laura Fernández', 'DNI', 53454345, 'Av. España 101', 'Barrio Las Vegas', 'Juana Koslay', 'San Luis', '9900112233', '1995-11-05', 'Femenino', 'Nadadora y estudiante de Nutrición', 'UNIVERSITARIO', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Roberto López', 'LC', 56767677, 'Calle Belgrano 456', 'Barrio Las Palmeras', 'Juana Koslay', 'San Luis', '1122003344', '1988-03-10', 'Masculino', 'Jugador de rugby en club local', 'UNIVERSITARIO', 'TIPO2');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Ana Martínez', 'DNI', 99988888, 'Calle General Paz 789', 'Barrio Las Enfermeras', 'San Luis', 'San Luis', '4455667788', '1994-02-27', 'Femenino', 'Practica yoga y participa en maratones', 'ESCOLAR', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Javier García', 'DNI', 4322222, 'Av. Illia 789', 'Barrio Los Olivos', 'La Punta', 'San Luis', '7788990011', '1989-09-14', 'Masculino', 'Entusiasta del ciclismo de montaña', 'EXTRAUNIVERSITARIO', 'TIPO3');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Silvia Torres', 'LC', 65456456, 'Calle Bolívar 456', 'Barrio Las Mirandas', 'Villa de Merlo', 'San Luis', '2233445566', '1991-07-31', 'Femenino', 'Bailarina de salsa y bachata', 'UNIVERSITARIO', 'TIPO2');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Miguel Sánchez', 'DNI', 86788776, 'Av. Centenario 789', 'Barrio Los Paraísos', 'San Luis', 'San Luis', '1122334455', '1996-04-09', 'Masculino', 'Fanático del fitness y la nutrición', 'UNIVERSITARIO', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Cecilia Romero', 'DNI', 22334455, 'Av. Laferrere 789', 'Barrio Los Lapachos', 'La Punta', 'San Luis', '5544332211', '1990-01-12', 'Femenino', 'Juega al tenis en competiciones locales', 'ESCOLAR', 'TIPO3');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Pedro Juárez', 'LE', 43565122, 'Calle Pringles 456', 'Barrio Los Ranqueles', 'San Luis', 'San Luis', '6677889900', '1997-12-03', 'Masculino', 'Practica boxeo y entrena en el gimnasio', 'UNIVERSITARIO', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Lucía Díaz', 'DNI', 65445656, 'Av. 9 de Julio 789', 'Barrio Los Robles', 'La Punta', 'San Luis', '9900112233', '1998-10-26', 'Femenino', 'Corredora de maratones y estudiante de Kinesiología', 'ESCOLAR', 'TIPO2');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Martín Vargas', 'DNI', 11111111, 'Calle San Martín 123', 'Barrio Las Moreras', 'Villa de Merlo', 'San Luis', '1122003344', '1992-05-08', 'Masculino', 'Aficionado al fútbol y estudiante de Ciencias Políticas', 'UNIVERSITARIO', 'TIPO3');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Paula Salazar', 'LC', 22222222, 'Calle Maipú 789', 'Barrio Las Barranquitas', 'San Luis', 'San Luis', '4455667788', '1993-09-17', 'Femenino', 'Entrenadora de gimnasio y estudiante de Nutrición', 'ESCOLAR', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Gabriel Pérez', 'DNI', 33333333, 'Av. San Martín 456', 'Barrio Las Verbenas', 'La Punta', 'San Luis', '7788990011', '1995-02-04', 'Masculino', 'Jugador de hockey en equipo local', 'EXTRAUNIVERSITARIO', 'TIPO2');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Carolina Torres', 'DNI', 44444444, 'Calle Belgrano 789', 'Barrio Los Solares', 'Juana Koslay', 'San Luis', '2233445566', '1996-08-19', 'Femenino', 'Realiza escalada en roca en sus tiempos libres', 'ESCOLAR', 'TIPO3');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Eduardo Gómez', 'LC', 44555555, 'Av. Rivadavia 456', 'Barrio Las Américas', 'San Luis', 'San Luis', '1122334455', '1991-03-23', 'Masculino', 'Estudiante de Psicología Clínica con limitaciones físicas', 'UNIVERSITARIO', 'TIPO1');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Fernando Sánchez', 'LC', 66666666, 'Av. Pringles 789', 'Barrio Las Palmeras', 'Juana Koslay', 'San Luis', '6677889900', '1997-01-29', 'Masculino', 'Aficionado al running y estudiante de Marketing', 'UNIVERSITARIO', 'TIPO3');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Valeria Romero', 'DNI', 77777777, 'Calle Mitre 123', 'Barrio Las Mirandas', 'Villa de Merlo', 'San Luis', '5544332211', '1994-12-16', 'Femenino', 'Entusiasta del deporte acuático y estudiante de Biología', 'EXTRAUNIVERSITARIO', 'TIPO2');
INSERT INTO Alumnos (anombreyape,atipodoc,anrodoc,adomicilio,abarrio,alocalidad,aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro)VALUES ('Ricardo Juárez', 'LE', 88888888, 'Av. Pringles 789', 'Barrio 1° de Mayo', 'San Luis', 'San Luis', '6677889900', '1997-01-29', 'Masculino', 'Entrenador personal y estudiante de Educación Física', 'UNIVERSITARIO', 'TIPO3');

INSERT INTO operadores (onombreyape,onrodoc) VALUES ('PEDRO PEREZ', 345673221);

INSERT INTO Equipos (enombre,eintegrantes) VALUES ('UNSL VOLEY',20);
INSERT INTO Pagos_equipo(pafecha, paimporte, padescripcion, id_o, id_d, id_e) VALUES ('2000-01-22',60000,'Equipo oficial de la UNSL en voley',1,12,1);
