insert into sys_user values(1, 'admin', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', null);
insert into sys_user values(2, 'user', '$2a$10$trT3.R/Nfey62eczbKEnueTcIbJXW.u1ffAo/XfyLpofwNDbEB86O', 'rOqBvdpppk38SvvUqtWeCQ==');

insert into sys_role values(1, 'ROLE_ADMIN');
insert into sys_role values(2, 'ROLE_USER');

insert into sys_r_user_role values(1, 1, 1);
insert into sys_r_user_role values(2, 1, 2);
insert into sys_r_user_role values(3, 2, 2);
