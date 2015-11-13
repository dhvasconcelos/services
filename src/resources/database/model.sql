USE academia;
INSERT INTO assignment_type(name,description)
VALUES ('summarizer','daily bootcamp activity record'),
  ('homework','homework assignments');

INSERT INTO tag(title)
VALUES ('java'),('mvc'),('js'),('vonneumann'),
  ('memory'),
  ('cpu'),
  ('operatingsystem'),
  ('algorithms'),
  ('git'),
  ('objectorientedprogramming'),
  ('simplegraphics'),
  ('exceptions'),
  ('threads'),
  ('containers'),
  ('javadoc'),
  ('networks'),
  ('javafx'),
  ('softwareengineering'),
  ('agile'),
  ('mysql'),
  ('io');

INSERT INTO resource(name,description)
VALUES ('user','application users section'),
  ('homework','application homeworks section'),
  ('summarizer','application summarizers section');

INSERT INTO bootcamp(name,start_date,end_date)
    VALUES ('unixcornios','2015-09-07','2015-12-11');


INSERT INTO permission(name,description)
    VALUES ('none','no application permission'),
      ('view','view application resource'),
      ('submit','view and submit application resource'),
      ('edit','view, submit and edit application resource'),
      ('create','view, submit, edit and create application resource'),
      ('approve','view, submit, edit, create and approve application resource');

INSERT INTO role(name,description)
    VALUES ('guest','application guest'),
      ('company','company'),
      ('employer','employer'),
      ('junior_cadet','junior code cadet'),
      ('cadet','code cadet'),
      ('staff','academia staff'),
      ('junior_master_coder','junior master coder'),
      ('master_coder','master coder'),
      ('admin','application overseer');


INSERT INTO role_resource_permission(role_id,resource_id,permission_id)
    VALUES (5,1,2),
    (5,2,3),
    (5,3,3),
    (6,1,4),
    (6,2,2),
    (6,3,2),
    (7,1,2),
    (7,2,2),
    (7,3,2),
    (8,1,5),
    (8,2,5),
    (8,3,5),
    (9,1,6),
    (9,2,6),
    (9,3,6);





