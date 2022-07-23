-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--
--drop database Encheres_ENI
--CREATE DATABASE Encheres_ENI

--USE Encheres_ENI

CREATE TABLE categories (
    noCategorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(50) NOT NULL
)

ALTER TABLE categories ADD constraint categories_pk PRIMARY KEY (noCategorie)

  

CREATE TABLE utilisateurs (
    noUtilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(50) NOT NULL,
    nom              VARCHAR(50) NOT NULL,
    prenom           VARCHAR(50) NOT NULL,
    email            VARCHAR(100) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(50) NOT NULL,
    codePostal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(50) NOT NULL,
    mdp    VARCHAR(100) NOT NULL,
    credit           INTEGER DEFAULT 100,
    administrateur   bit DEFAULT 0
)

ALTER TABLE utilisateurs ADD constraint utilisateurs_pk PRIMARY KEY (noUtilisateur);

-- email et pseudo uniques, pas de doublons
ALTER TABLE utilisateurs ADD CONSTRAINT un_email UNIQUE (email); 
ALTER TABLE utilisateurs ADD CONSTRAINT un_pseudo UNIQUE (pseudo);
ALTER TABLE utilisateurs ADD CONSTRAINT ck_alphanumeric CHECK (pseudo NOT LIKE '%[^A-Z0-9 ]%' );
ALTER TABLE utilisateurs ADD CONSTRAINT ck_credits CHECK (credit > 0);


CREATE TABLE articles (
    noArticle                    INTEGER IDENTITY(1,1) NOT NULL,
    nomArticle                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	dateDebutEncheres           DATETIME NOT NULL,
    datEfinEncheres             DATETIME NOT NULL,
    prixInitial                  INTEGER NOT NULL,
    prixVente                    INTEGER,
    noUtilisateur                INTEGER NOT NULL,
    noCategorie                  INTEGER NOT NULL
)

ALTER TABLE articles ADD constraint articles_pk PRIMARY KEY (noArticle)


CREATE TABLE retraits (
	noArticle       INTEGER NOT NULL,
    rue              VARCHAR(50) NOT NULL,
    codePostal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(50) NOT NULL
)

ALTER TABLE retraits ADD constraint retraits_pk PRIMARY KEY  (noArticle)
ALTER TABLE retraits
    ADD CONSTRAINT retraits_articles_fk FOREIGN KEY ( noArticle ) REFERENCES  ARTICLES (noArticle)
ON DELETE CASCADE
    ON UPDATE no action 


CREATE TABLE encheres(	
	noEnchere  INTEGER IDENTITY(1,1) NOT NULL,
	dateEnchere datetime NOT NULL,
	montantEnchere INTEGER NOT NULL,
	noArticle INTEGER NOT NULL,
	noUtilisateur INTEGER NOT NULL
 )

ALTER TABLE encheres ADD constraint encheres_pk PRIMARY KEY ( noEnchere)
 
ALTER TABLE encheres
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( noUtilisateur ) REFERENCES UTILISATEURS ( noUtilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE encheres
    ADD CONSTRAINT encheres_no_article_fk FOREIGN KEY ( noArticle ) REFERENCES articles ( noArticle )
ON DELETE NO ACTION 
    ON UPDATE no action 
	

ALTER TABLE articles
    ADD CONSTRAINT articles_categories_fk FOREIGN KEY ( noCategorie )
        REFERENCES categories ( noCategorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE articles
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( noUtilisateur )
        REFERENCES utilisateurs ( noUtilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 


	-- Ajout d'un admin

INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, administrateur) VALUES('admin', 'Loury', 'Yvan', 'admin@mail.com', '06000000', '15 rue Victor Hugo', '35000', 'Rennes', 'root', 1)

select * from  utilisateurs

-- ajout d'un utilisateur test 

 INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp) VALUES('test', 'Loury', 'Yvan', 'test@mail.com', '06000000', '15 rue Victor Hugo', '35000', 'Rennes', '1234')
