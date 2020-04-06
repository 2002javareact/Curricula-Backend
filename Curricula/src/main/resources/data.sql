-- Category inserts
insert into "CATEGORY"(CATEGORY_COLOR,CATEGORY_NAME)
  values('#9400D3','DATABASE'),
  ('#0000FF','SOURCE CODE'),
  ('#00FF00','FRAMEWORK'),
  ('#FFFF00','IDE'),
  ('#FF7F00','DEVOPS'),
  ('#FF0000','ARCHITECTURE');

-- Skill inserts
insert into "SKILL"(SKILL_NAME,CATEGORY_ID)
  values('POSTGRES',1),
  ('GIT',2),
  ('SPRING',3),
  ('VISUAL STUDIO CODE',4),
  ('JENKINS',5),
  ('MVC',6),
  ('TOMCAT',5),
  ('POSTMAN',4),
  ('ANGULAR',3),
  ('ECLIPSE',4),
  ('SOA',6),
  ('INTELLIJ',4);

-- Curriculum inserts
insert into "CURRICULUM"(CURRICULUM_NAME)
  values('FULL-STACK'),
  ('.NET'),
  ('CYBER SECURITY');

--Visualization inserts
insert into "VISUALIZATION"(VISUALIZATION_NAME)
  values('INITIAL DATA');

COMMIT;
-------------------------------------------------------------------------------------

--COMBINED TABLE INSERTS

--Curriculum/Skill inserts
insert into "CURRICULUM_SKILL"(CURRICULUM_ID,SKILL_ID)
  values(1,1),
  (1,2),
  (1,3),
  (1,4),
  (2,5),
  (2,6),
  (2,7),
  (2,8),
  (3,9),
  (3,10),
  (3,11),
  (3,12);

-- --Visualization/Curriculum inserts
insert into "VISUALIZATION_CURRICULUM"(VISUALIZATION_ID,CURRICULUM_ID)
  values(1,1),
  (1,2),
  (1,3);
