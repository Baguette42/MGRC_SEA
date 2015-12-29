/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 9.4                                */
/*==============================================================*/


drop index CLIENT_PK;

drop table CLIENT;

drop index POSSEDE_FK;

drop index EVENEMENT_PK;

drop table EVENEMENT;

drop index PANEL_PK;

drop table PANEL;

drop index USERLOGIN_PK;

drop table USERLOGIN;

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT (
   CLIENT_ID            SERIAL               not null,
   CLIENT_NOM           VARCHAR(1024)        not null,
   CLIENT_PRENOM        VARCHAR(1024)        not null,
   CLIENT_CIVILITE      VARCHAR(1024)        not null,
   CLIENT_NAISSANCE     DATE                 not null,
   CLIENT_ADRESSE       VARCHAR(1024)        not null,
   CLIENT_TELEPHONE     VARCHAR(1024)        not null,
   CLIENT_EMAIL         VARCHAR(1024)        not null,
   CLIENT_FACEBOOK      VARCHAR(1024)        null,
   CLIENT_TWITTER       VARCHAR(1024)        null,
   CLIENT_LINKEDIN      VARCHAR(1024)        null,
   CLIENT_PROFIL        VARCHAR(1024)        not null,
   CLIENT_REGION        VARCHAR(1024)        not null,
   CLIENT_EMAILREFUS    BOOL                 not null,
   CLIENT_DATECREATION  DATE                 not null,
   constraint PK_CLIENT primary key (CLIENT_ID)
);

/*==============================================================*/
/* Index : CLIENT_PK                                            */
/*==============================================================*/
create unique index CLIENT_PK on CLIENT (
CLIENT_ID
);

/*==============================================================*/
/* Table : EVENEMENT                                            */
/*==============================================================*/
create table EVENEMENT (
   EVENT_ID             SERIAL               not null,
   CLIENT_ID            INT4                 not null,
   EVENT_TYPE           VARCHAR(1024)        not null,
   EVENT_DATE           DATE                 not null,
   EVENT_CREATEUR       VARCHAR(1024)        not null,
   EVENT_LASTUPDATE     DATE                 not null,
   EVENT_LASTUPDATER    VARCHAR(1024)        not null,
   EVENT_DESCRIPTION    VARCHAR(1024)        not null,
   constraint PK_EVENEMENT primary key (EVENT_ID)
);

/*==============================================================*/
/* Index : EVENEMENT_PK                                         */
/*==============================================================*/
create unique index EVENEMENT_PK on EVENEMENT (
EVENT_ID
);

/*==============================================================*/
/* Index : POSSEDE_FK                                           */
/*==============================================================*/
create  index POSSEDE_FK on EVENEMENT (
CLIENT_ID
);

/*==============================================================*/
/* Table : PANEL                                                */
/*==============================================================*/
create table PANEL (
   PANEL_ID             SERIAL               not null,
   PANEL_NOM            VARCHAR(1024)        not null,
   PANEL_AGEMINI        VARCHAR(1024)        null,
   PANEL_AGEMAXI        VARCHAR(1024)        null,
   PANEL_REGION         VARCHAR(1024)        null,
   PANEL_PROFIL         VARCHAR(1024)        null,
   constraint PK_PANEL primary key (PANEL_ID)
);

/*==============================================================*/
/* Index : PANEL_PK                                             */
/*==============================================================*/
create unique index PANEL_PK on PANEL (
PANEL_ID
);

/*==============================================================*/
/* Table : USERLOGIN                                            */
/*==============================================================*/
create table USERLOGIN (
   USER_ID              SERIAL        not null,
   USER_LOGIN           VARCHAR(1024)        not null,
   USER_PASSWORD        VARCHAR(1024)        not null,
   USER_LASTCONNEXION   DATE                 null,
   USER_REGION			VARCHAR(1024)		 not null,
   constraint PK_USERLOGIN primary key (USER_ID)
);

/*==============================================================*/
/* Index : USERLOGIN_PK                                         */
/*==============================================================*/
create unique index USERLOGIN_PK on USERLOGIN (
USER_ID
);

alter table EVENEMENT
   add constraint FK_EVENEMEN_POSSEDE_CLIENT foreign key (CLIENT_ID)
      references CLIENT (CLIENT_ID)
      on delete restrict on update restrict;

