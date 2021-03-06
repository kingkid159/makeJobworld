--------------------------------------------------------
--  DDL for Table CMAIN
--------------------------------------------------------

  CREATE TABLE "JOB"."CMAIN" 
   (	"C_NO" NUMBER(20,0), 
	"C_LOGO" VARCHAR2(255 BYTE), 
	"C_NAME" VARCHAR2(100 BYTE), 
	"C_POSTNAME" VARCHAR2(500 BYTE), 
	"C_LINK" VARCHAR2(500 BYTE), 
	"C_JOBNO" NUMBER(20,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_CMAIN_CNO
--------------------------------------------------------

  CREATE UNIQUE INDEX "JOB"."PK_CMAIN_CNO" ON "JOB"."CMAIN" ("C_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table CMAIN
--------------------------------------------------------

  ALTER TABLE "JOB"."CMAIN" ADD CONSTRAINT "PK_CMAIN_CNO" PRIMARY KEY ("C_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "JOB"."CMAIN" MODIFY ("C_JOBNO" NOT NULL ENABLE);
  ALTER TABLE "JOB"."CMAIN" MODIFY ("C_POSTNAME" NOT NULL ENABLE);
  ALTER TABLE "JOB"."CMAIN" MODIFY ("C_NAME" NOT NULL ENABLE);
