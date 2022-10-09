-- noinspection SpellCheckingInspectionForFile

INSERT INTO users (id, username, alias, password, email)
VALUES ('1', 'user', 'joe doe', '$2a$10$TGhynuWFfZZQ5TCkRcyH4uHEHU7DLrjJs/xZVMmtjAOlQSrtb/mXW', 'alalalalong@lal.com');
INSERT INTO users (id, username, alias, password, email)
VALUES ('2', 'user2', 'joe doe2', '$2a$10$TGhynuWFfZZQ5TCkRcyH4uHEHU7DLrjJs/xZVMmtjAOlQSrtb/mXW', 'hello@lal.com');
INSERT INTO users (id, username, alias, password, email)
VALUES ('3', 'user3', 'joe doe3', '$2a$10$TGhynuWFfZZQ5TCkRcyH4uHEHU7DLrjJs/xZVMmtjAOlQSrtb/mXW', 'hello2@lal.com');


Insert into posts (ID, AUTHOR, CONTENT, CREATION_DATE)
VALUES ('944112d0-41f1-4ccb-a012-5b6aafabeea3', 'Johnutzu',
        'Morbi sodales elit nec neque tempor, in pellentesque quam porta. Ut imperdiet, ligula ac sollicitudin luctus, ex lacus tempor mauris, eu gravida purus neque vel neque. Vivamus condimentum condimentum purus, eget feugiat arcu mollis a. Suspendisse dolor erat, ultricies et urna sed, ultricies dictum turpis.',
        {ts '2021-09-17 18:47:52.69'});

Insert into posts (ID, AUTHOR, CONTENT, CREATION_DATE)
VALUES ('4a83cb99-f595-47cd-bf94-c4a4e00afef8', 'Joni',
        'Ut rhoncus elementum sapien, eget eleifend lorem. Duis ac ante rutrum, eleifend lacus vel, iaculis purus. Pellentesque a molestie arcu, sed lacinia lorem. Fusce mauris mauris, eleifend sit amet condimentum a, condimentum id enim. Aliquam facilisis erat non pharetra viverra.',
        {ts '2022-04-01 13:17:52.69'});

Insert into posts (ID, AUTHOR, CONTENT, CREATION_DATE)
VALUES ('40e73f83-9c01-4166-bc80-80625bd040ab', 'ArianaGrande',
        'Here I am again on my own, no ctime to spend on all of these',
        {ts '2022-04-04 11:47:51.69'});

Insert into posts (ID, AUTHOR, CONTENT, CREATION_DATE)
VALUES ('d66760fa-7bcf-42dc-b5fb-5d2669537182', 'MlonEusk',
        'Phasellus porttitor mollis arcu et ultricies. Nullam vitae ligula id purus ultricies mattis. Nunc laoreet rhoncus metus, ac ultricies neque tincidunt vel. Duis in suscipit lacus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec a fermentum nunc, ac sodales lacus. Aenean enim nisl, luctus sollicitudin sapien sit amet, tristique placerat lacus. In hac habitasse platea dictumst. Integer interdum tortor leo, quis venenatis metus facilisis in. Vivamus suscipit sapien elementum ligula scelerisque, vitae accumsan odio accumsan.',
        {ts '2022-04-10 18:23:50.69'});