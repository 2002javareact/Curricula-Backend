   create table category (
       category_id serial primary key,
       category_color text,
       category_name text
    );

    create table skill (
       skill_id serial primary key,
        skill_name text,
        category_id int references category(category_id) on delete cascade
    );

    create table curriculum (
       curriculum_id serial primary key,
       curriculum_name text
    );

    create table curriculum_skill (
       curriculum_id int not null references curriculum(curriculum_id) on delete cascade,
       skill_id int not null references skill(skill_id) on delete cascade
    );

    create table visualization (
       visualization_id serial primary key,
       visualization_name text
    );

    create table visualization_curriculum (
       visualization_id int not null references visualization(visualization_id) on delete cascade,
       curriculum_id int not null references curriculum(curriculum_id) on delete cascade
    );