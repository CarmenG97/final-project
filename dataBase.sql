CREATE SCHEMA stars_final_project;
USE stars_final_project;
DROP SCHEMA stars_final_project;

-- -----------------------------------------------------
-- Table `final_project`.`star_coordinates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS star_coordinates (
  sao BIGINT NOT NULL,
  right_ascension DOUBLE NOT NULL,
  declination DOUBLE NOT NULL,
  distance decimal(19,2) NOT NULL,
  PRIMARY KEY (sao));
  
  /*
  Conversor de grados a decimal
  https://www.vercalendario.info/es/como/convertir-latitud-longitud-grados-decimales.html
  */
  
  INSERT INTO star_coordinates (sao, right_ascension, declination, distance) VALUES 
  /* ARIES */
  (75151, 2.07, 23.27, 66.00), /* 2.07h y 23.27º (mirar esto) */
  (75012, 1.54, 20.48, 60.00),
  (92680, 1.53, 19.17, 204.00),
  
  /* TAURUS */
  (94027, 4.35, 16.30, 65),
  (77168, 5.26, 28.36, 131),
  
  /* GÉMINIS */
  (60198, 7.34, 31.53, 51),
  (79666, 7.45, 28.01, 34),
  (95912, 6.37, 16.23, 104),
  (78682, 6.43, 25.07, 903),
  (79294, 7.20, 21.58, 59),
  (78135, 6.14, 22.30, 349),
  (79031, 7.04, 20.34, 1169),
  
  /* CÁNCER */
  (98267, 8.58, 11.51, 173),
  (98087, 8.44, 18.09, 136),
  (80378, 8.43, 21.29, 158),
  
  /* LEO */
  (157924, 13.25, 11.09, 262),
  (119077, 11.50, 1.45, 36),
  (138918, 12.41, -1.26, 36),
  (138722, 12.19, -0.40, 250),
  (100385, 13.02, 10.57, 102),
  (139825, 14.15, -5.59, 70),
  
  /* VIRGO */
  (157923, 13.25, 11.09, 262),
  (119076, 11.50, 1.45, 35),
  (138917, 12.41, -1.26, 36),
  (138721, 12.19, -0.40, 250),
  (100384, 13.02, 10.57, 102),
  (139824, 14.15, -5.59, 70),
  
  /* LIBRA */ 
  (158840, 14.50, 16.02, 77),
  (140430, 15.17, -9.22, 160),
  
  /* ESCORPIÓN */
  (184415, 16.29, 26.25, 603),
  (159682, 16.05, -19.48, 530),
  (228201, 17.37, -42.59, 272),
  (208954, 17.33, -37.06, 702),
  (184014, 16.00, -22.37, 401),
  (208078, 16.50, -34.17, 65),
  (208896, 17.30, -37.17, 518),
  (184336, 16.21, -25.35, 73),
  
  /* SAGITARIO */
  (210091, 18.24, 34.23, 144),
  (187448, 18.55, -26.17, 224),
  (187600, 19.03, -29.52, 89),
  (186481, 18.28, -25.25, 77),
  (186681, 18.21, -29.49, 305),
  (209696, 18.06, -30.25, 96),
  (187756, 19.09, -21.01, 440),
  
  /* CAPRICORNIO */
  (163427, 20.18, -12.32, 109),
  (163481, 20.21, -14.46, 344),
  (164644, 21.47, -16.07, 38),
  (164560, 21.40, -16.39, 139),
  
  /* ACUARIO */
  (145862, 22.05, 0.19, 758),
  (145457, 21.31, -5.34, 611),
  (165375, 22.54, -15.49, 160),
  (146044, 22.21, -1.23, 158),
  (144810, 20.47, -9.30, 229),
  
  /* PISCIS */
  (110291, 2.02, 2.47, 139);
  
-- -----------------------------------------------------
-- Table `final_project`.`star`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS star (
  sao BIGINT NOT NULL,
  star_name VARCHAR(255),
  star_designation VARCHAR(255),
  constellation VARCHAR(255),
  constellation_id BIGINT,
  app_magnitude DOUBLE NOT NULL,
  abs_magnitude DOUBLE NOT NULL,
  spectrum INT NOT NULL,
  colour DOUBLE NOT NULL,
  image VARCHAR(255),
  PRIMARY KEY (sao));

/* ARIES */
INSERT INTO star(sao, star_name, star_designation, constellation, constellation_id, app_magnitude, abs_magnitude, spectrum, colour, image) VALUES 
(75151, "HAMAL", "ALFA", "ARIES", 1, 2.0, 0.5, 3, 1.15, "./assets/img/Gigante_amarilla.png"),
(75012, "SHERATAN", "BETA", "ARIES", 1, 2.7, 1.3, 5, 0.17, "./assets/img/Enana_amarilla.png"),
(92680, "MESARTHIM", "GAMMA", "ARIES", 1, 3.9, -0.6, 5, -0.04, "./assets/img/Enana_azul.png"),

/* TAURUS */
(94027, "ALDEBARÁN", "ALFA", "TAURUS", 2, 0.8, -0.6, 3, 1.54, "./assets/img/Supergigante_roja.png"),
(77168, "ELNATH", "BETA", "TAURUS", 2, 1.6, -1.4, 3, -0.13, "./assets/img/Supergigante_azul.png"),

/* GÉMINIS */
(60198, "CASTOR", "ALFA", "GÉMINIS", 3, 1.6, 0.9, 5, 0.03, "./assets/img/Enana_amarilla.png"),
(79666, "POLLUX", "BETA", "GÉMINIS", 3, 1.1, 1.1, 3, 0.99, "./assets/img/Gigante_amarilla.png"),
(95912, "ALHENA", "GAMMA", "GÉMINIS", 3, 1.9, -0.6, 4, 0.00, "./assets/img/Subgigante_blanca_fondo.jpg"),
(78682, "MEBSUTA", "EPSILON", "GÉMINIS", 3, 3.0, -4.2, 1, 1.38, "./assets/img/Gigante_amarilla.png"),
(79294, "WASAT", "DELTA", "GÉMINIS", 3, 3.5, 2.2, 4, 0.37, "./assets/img/Gigante_amarilla.png"),
(78135, "PROPUS", "ETA", "GÉMINIS", 3, 3.3, 2.2, 4, 1.60, "./assets/img/Supergigante_roja.png"),
(79031, "MEKBUDA", "ZETA", "GÉMINIS", 3, 3.8, -3.8, 1, 0.90, "./assets/img/Gigante_amarilla.png"),

/* CÁNCER */
(98267, "ACUBENS", "ALFA", "CÁNCER", 4, 4.2, 0.6, 5, 0.14, "./assets/img/Enana_amarilla.png"),
(98087, "ASELLUS AUSTRALIS", "DELTA", "CÁNCER", 4, 3.9, 0.9, 3, 1.08, "./assets/img/Gigante_amarilla.png"),
(80378, "ASELLUS BOREALIS", "GAMMA", "CÁNCER", 4, 4.7, 1.2, 4, 0, "./assets/img/Subgigante_blanca_fondo.jpg"),


/* LEO */
(157924, "REGULUS", "ALFA", "LEO", 5, 1.35, 1.35, 0, 0, "./assets/img/Subgigante_blanca_fondo.jpg"),
(119077,"DENÉBOLA", "BETA", "LEO", 5, 2.14, 2.14, 0, 0, "./assets/img/Enana_amarilla.png"), 
(138918, "ALGIEBA", "GAMMA", "LEO", 5, 2.21, 2.21, 0, 0, "./assets/img/Supergigante_roja.png"), 
(138722, "ZOSMA", "ETTA", "LEO", 5, 2.98, 2.98, 0, 0, "./assets/img/Enana_azul.png"),
(100385, "RAS ELASED AUSTRALIS", "EPSILON", "LEO", 5, 2.98, 2.98, 0, 0, "./assets/img/Enana_amarilla.png"),
(139825, "ALDHAFERA", "IOTA", "LEO", 5, 3.44, 3.44, 0, 0, "./assets/img/Gigante_amarilla.png"),


  /* VIRGO */
  (157923, "SPICA", "ALFA", "VIRGO", 6, 1.0, -3.5, 5, -0.23, "./assets/img/Enana_azul.png"),
  (119076, "ZAVIJAVA", "BETA", "VIRGO", 6, 3.6, 3.4, 5, 0.52, "./assets/img/Enana_amarilla.png"),
  (138917, "PORRIMA", "GAMMA", "VIRGO", 6, 3.5, 3.2, 5, 0.37, "./assets/img/Enana_amarilla.png"),
  (138721, "ZANIAH", "ETTA", "VIRGO", 6, 3.9, -0.5, 4, 0.03, "./assets/img/Gigante_amarilla.png"),
  (100384, "VINDEMIATRIX", "EPSILON", "VIRGO", 6, 2.8, 0.4, 3, 0.93, "./assets/img/Gigante_amarilla.png"),
  (139824, "SYRMA", "IOTA", "VIRGO", 6, 4.2, 2.4, 5, 0.51, "./assets/img/Enana_amarilla.png"),

  /* LIBRA */ 
  (158840, "ZUBELGENUBI", "ALFA", "LIBRA", 7, 2.7, 0.9, 4, 0.40, "./assets/img/Gigante_amarilla.png"),
  (140430, "ZUBENESCHEMALI", "BETA", "LIBRA", 7, 2.6, 0.8, 5, -0.07, "./assets/img/Enana_azul.png"),
  
    /* ESCORPIÓN */
  (184415, "ANTARES", "ALFA", "ESCORPIÓN", 8, 0.9, -5.3, 1, 1.87, "Supergigante_roja.png"),
  (159682, "GRAFFIAS/ACRAB", "BETA", "ESCORPIÓN", 8, 2.6, -4.2, 5, -0.07, "./assets/img/Enana_azul.png"),
  (228201, "SARGAS", "THETA", "ESCORPIÓN", 8, 1.9, -2.8, 3, 0.41, "./assets/img/Gigante_amarilla.png"),
  (208954, "SHAULA", "LAMBDA", "ESCORPIÓN", 8, 1.6, -5.1, 4, -0.23, "./assets/img/Supergigante_azul.png"),
  (184014, "DSCHUBBA", "DELTA", "ESCORPIÓN", 8, 2.3, -3.5, 4, -0.12, "./assets/img/Supergigante_azul.png"),
  (208078, "WEI", "EPSILON", "ESCORPIÓN", 8, 2.3, 0.8, 3, 1.14, "./assets/img/Gigante_amarilla.png"),
  (208896, "LESATH", "UPSILON", "ESCORPIÓN", 8, 2.7, -3.3, 4, -0.18, "./assets/img/Supergigante_azul.png"),
  (184336, "AL NIYAT", "SIGMA", "ESCORPIÓN", 8, 2.9, -5.4, 3, 0.13, "./assets/img/Gigante_amarilla.png"),
  
    /* SAGITARIO */
  (210091, "KAUS AUSTRALIS", "EPSILON", "SAGITARIO", 9, 1.8, -1.5, 3, -0.03, "./assets/img/Gigante_azul.png"),
  (187448, "NUNKI", "SIGMA", "SAGITARIO", 9, 2.0, -2.1, 5, -0.13, "./assets/img/Enana_azul.png"),
  (187600, "ASCELLA", "ZETA", "SAGITARIO", 9, 2.6, 1.1, 4, 0.06, "./assets/img/Gigante_amarilla.png"),
  (186481, "KAUS BOREALIS", "LAMBDA", "SAGITARIO", 9, 2.8, 1.0, 3, 1.02, "./assets/img/Gigante_amarilla.png"),
  (186681, "KAUS MERIDIONALIS", "DELTA", "SAGITARIO", 9, 2.7, -2.1, 3, 1.38, "./assets/img/Gigante_amarilla.png"),
  (209696, "ALNASL", "GAMMA", "SAGITARIO", 9, 3.0, 0.6, 3, 0.98, "./assets/img/Gigante_amarilla.png"),
  (187756, "ALBALDAH", "PI", "SAGITARIO", 9, 2.9, -2.8, 2, 0.38, "./assets/img/Gigante_amarilla.png"),
  
    /* CAPRICORNIO */
  (163427, "ALGEDI", "ALFA", "CAPRICORNIO", 10, 3.6, 1.0, 3, 0.88, "./assets/img/Gigante_amarilla.png"),
  (163481, "DABIH", "BETA", "CAPRICORNIO", 10, 3.1, -2.1, 2, 0.79, "./assets/img/Gigante_amarilla.png"),
  (164644, "DENEB ALGEDI", "DELTA", "CAPRICORNIO", 10, 3.0, 2.5, 4, 0.18, "./assets/img/Gigante_amarilla.png"),
  (164560, "NASHIRA", "GAMMA", "CAPRICORNIO", 10, 3.8, 0.5, 3, 0.32, "./assets/img/Gigante_amarilla.png"),
  
    /* ACUARIO */
  (145862, "SADALMELIK", "ALFA", "ACUARIO", 11, 3.0, -3.9, 1, 0.97, "./assets/img/Gigante_amarilla.png"),
  (145457, "SADALSUD", "BETA", "ACUARIO", 11, 3.0, -3.5, 1, 0.83, "./assets/img/Gigante_amarilla.png"),
  (165375, "SKAT", "DELTA", "ACUARIO", 11, 3.3, -0.2, 5, 0.17, "./assets/img/Enana_amarilla.png"),
  (146044, "SADALCHBIA", "GAMMA", "ACUARIO", 11, 4.0, 0.4, 5, 0.06, "./assets/img/Enana_amarilla.png"),
  (144810, "ALBALI", "EPSILON", "ACUARIO", 11, 3.8, -0.5, 5, 0.00, "./assets/img/Subgigante_blanca_fondo.jpg"),
    
  /* PISCIS */
  (110291, "ALRESCHA", "ALFA", "PISCIS", 12, 3.8, 1.0, 1, 0.00, "./assets/img/Subgigante_blanca_fondo.jpg");
  
  SELECT * FROM star WHERE constellation = "ACUARIO";
  
  
-- -------------------------------------------------- AHORA UTILIZO EL ESCHEMA DE LAS CONSTELACIONES ---------------------------------------------------------------------------
CREATE SCHEMA constellations_final_project;
USE constellations_final_project;
DROP SCHEMA constellations_final_project;


CREATE TABLE IF NOT EXISTS constellation (
  id BIGINT NOT NULL AUTO_INCREMENT,
  constellation_name VARCHAR(255),
  alpha_star_name VARCHAR(255),
  number_of_stars INT,
  profile_picture VARCHAR(255),
  second_profile_picture VARCHAR(255),
  history VARCHAR(255),
  PRIMARY KEY (id));

INSERT INTO constellation(constellation_name, alpha_star_name, number_of_stars, profile_picture, second_profile_picture, history) VALUES 
("ARIES", "Hamal", 3, "./assets/img/Aries.png", "./assets/img/Aries_mit.jpg", ""),
("TAURUS", "Aldebarán", 2, "./assets/img/Taurus.jpg", "./assets/img/Taurus_mit.jpeg", ""),
("GÉMINIS", "Castor", 7, "./assets/img/Geminis.jpg", "./assets/img/Geminis_mit.jpeg", ""),
("CÁNCER", "Acubens", 3, "./assets/img/Cancer.jpg", "./assets/img/Cancer_mit.jpeg", ""),
 ("LEO", "SPICA", 6, "./assets/img/Leo.jpg", "./assets/img/Leo_mit.jpg", ""),
("VIRGO", "Spica", 6, "./assets/img/Virgo.jpg", "./assets/img/Virgo_mit.jpeg", ""),
("LIBRA", "Zubelgenubi", 2, "./assets/img/Libra.jpg", "./assets/img/Libra_mit.jpg", ""),
("ESCORPIÓN", "Antares", 8, "./assets/img/Escorpio.jpg", "./assets/img/Escorpio_mit.jpg", ""),
("SAGITARIO", "No tiene", 7, "./assets/img/Sagitario.jpg", "./assets/img/Sagitario_mit.jpg", ""),
("CAPRICORNIO", "Algedi", 4, "./assets/img/Capricornio.jpg", "./assets/img/Capricornio_mit.jpg", ""),
("ACUARIO", "Sadalmelik", 5, "./assets/img/Acuario.png", "./assets/img/Acuario_mit.jpeg", ""),
("PISCIS", "Alrescha", 1, "./assets/img/Piscis.jpg", "./assets/img/Piscis_mit.jpg", "");

SELECT * FROM constellation;

-- -------------------------------------------------- AHORA UTILIZO EL ESCHEMA DE LOS AMATEURS ---------------------------------------------------------------------------
CREATE SCHEMA amateurs_final_project;
USE amateurs_final_project;
DROP SCHEMA amateurs_final_project;

CREATE TABLE amateur (
  id BIGINT NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NULL DEFAULT NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  password VARCHAR(255) NULL DEFAULT NULL,
  photo VARCHAR(255) NULL DEFAULT NULL,
  years_of_experience INT NOT NULL,
  PRIMARY KEY (id)
  );

CREATE TABLE role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NULL DEFAULT NULL,
  amateur_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (amateur_id) REFERENCES amateur(id)
  );


SELECT * FROM amateur;

-- -------------------------------------------------- AHORA UTILIZO EL ESCHEMA DE LOS EVENTOS ---------------------------------------------------------------------------
CREATE SCHEMA events_final_project;
USE events_final_project;
DROP SCHEMA events_final_project;

CREATE TABLE event(
  id BIGINT NOT NULL AUTO_INCREMENT,
  event_name VARCHAR(255),
  date VARCHAR(255),
  location VARCHAR(255),
  description VARCHAR(255),
  photo VARCHAR(255),
  PRIMARY KEY(id)
);

INSERT INTO event(event_name, date, location, description, photo) VALUES 
("Conjunción de la Luna y Mercurio", "29 de Julio", "Algeciras", "Mercurio pasa a unos 3,4º al sur de la Luna a las 21:08 UTC. La Luna tiene una magnitud de -7,9 y Mercurio una magnitud de -0,7. En este momento la fase lunar es del 1,5%.", "./assets/img/Mercurio.png"),
("Luna llena", "12 de agosto", "Málaga", "La Luna está en el lado opuesto de la Tierra por lo que el Sol la ilumina por completo. La Luna Llena es a las 01:37 UTC.", "./assets/img/Luna_llena.png"),
("Lluvia de meteoritos de las Perseidas", "13 de agosto", "Granada", "A pesar de las condiciones de luz de la Luna, ¡siempre puedes aceptar el reto de capturarlas!", "./assets/img/Perseidas.png"),
("Lluvia de estrellas de las Delta Acuáridas", "15 de Julio", "Almería", "En este momento la fase lunar es del 3,0%, por lo que las condiciones para disfrutarla son muy buenas (no hay Luna). Esta lluvia de estrellas es visible desde ambos hemisferios. Aunque se observa mejor en el hemisferio sur.", "./assets/img/Lluvia.png"),
("Oposición de Saturno", "14 de agosto", "Madrid", "A las 17:02 UTC, Saturno se encuentra en su posición más cercana a la Tierra y su cara visible está completamente iluminada por el Sol a una magnitud de 0,3.
Es más brillante que en cualquier otra época del año y es visible durante toda la noche.", "./assets/img/Saturno.png"),
("Luna Nueva", "27 de agosto", "Barcelona", "La Luna está entre la Tierra y el Sol, así que el lado brillante de la Luna está de espaldas a la Tierra. Además se verá sobre el centro galáctico de la Vía Láctea", "./assets/img/Luna_nueva.png");

CREATE TABLE amateur_attend_event (
	id BIGINT NOT NULL AUTO_INCREMENT,
	amateur_id BIGINT,
    event_id BIGINT,
    PRIMARY KEY(id)
    );
    
SELECT * FROM amateur_attend_event;