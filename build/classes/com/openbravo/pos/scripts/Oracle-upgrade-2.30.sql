--    Openbravo POS is a point of sales application designed for touch screens.
--    Copyright (C) 2010 Openbravo, S.L.
--    http://sourceforge.net/projects/openbravopos
--
--    This file is part of Openbravo POS.
--
--    Openbravo POS is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    Openbravo POS is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.

-- Database upgrade script for ORACLE

-- v2.30 - v2.30.1

SELECT TO_CHAR(SYSDATE,'DD-MM-YYYY hh24:mi:ss') AS STARTS_SCRIPT FROM DUAL;
SELECT TRIM(0 FROM SYS_CONTEXT('USERENV','INSTANCE_NAME')) AS INSTANCE_NAME, TRIM(0 FROM SYS_CONTEXT('USERENV','CURRENT_USER')) AS CURRENT_USER FROM DUAL;

SET SERVEROUTPUT ON;
SET DEFINE OFF;

ALTER TABLE POS_ADM.POS_ADM.TAXES ADD VALIDFROM TIMESTAMP DEFAULT TO_DATE('2001-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS') NOT NULL;

-- v2.30.1 - v2.30.2

-- final script

DELETE FROM POS_ADM.POS_ADM.SHAREDTICKETS;

UPDATE POS_ADM.APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

COMMIT;

SELECT TO_CHAR(SYSDATE,'DD-MM-YYYY hh24:mi:ss') AS ENDS_SCRIPT FROM DUAL;
