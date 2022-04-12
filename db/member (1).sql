--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "JOB"."MEMBER" 
   (	"ID" VARCHAR2(30 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(30 BYTE), 
	"GENDER" VARCHAR2(5 BYTE), 
	"EMAIL" VARCHAR2(40 BYTE), 
	"PHONE" VARCHAR2(14 BYTE), 
	"ADDRESS" VARCHAR2(200 BYTE), 
	"BIRTH" DATE DEFAULT NULL, 
	"REGDATE" DATE DEFAULT SYSDATE, 
	"U_DELETE" VARCHAR2(10 BYTE) DEFAULT 'N', 
	"DELDATE" DATE DEFAULT SYSDATE, 
	"ADMINOK" VARCHAR2(10 BYTE) DEFAULT 'N', 
	"DJOB" VARCHAR2(200 BYTE) DEFAULT NULL, 
	"GRADE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_MEMBER_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "JOB"."PK_MEMBER_ID" ON "JOB"."MEMBER" ("ID", "REGDATE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "JOB"."MEMBER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("PHONE" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("REGDATE" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("ADMINOK" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" MODIFY ("DJOB" NOT NULL ENABLE);
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "PK_MEMBER_ID" PRIMARY KEY ("ID", "REGDATE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "CK_MEMBER_GENDER" CHECK (GENDER IN('��','��')) ENABLE;
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "CK_MEMBER_U_DELETE" CHECK (U_DELETE IN('Y','N')) ENABLE;
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "NN_MEMBER_ADD" CHECK ("ADDRESS" IS NOT NULL) ENABLE;
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "NN_MEMBER_EMAIL" CHECK ("EMAIL" IS NOT NULL) ENABLE;
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "NN_MEMBER_NAME" CHECK ("NAME" IS NOT NULL) ENABLE;
  ALTER TABLE "JOB"."MEMBER" ADD CONSTRAINT "NN_MEMBER_PASSWORD" CHECK ("PASSWORD" IS NOT NULL) ENABLE;
