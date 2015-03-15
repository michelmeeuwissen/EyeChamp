# EyeChamp

################# GIT:
Best way to setup git project In Windows cmd:
C:\temp>md EyeChamp

C:\temp>cd EyeChamp

C:\temp\EyeChamp>git init

Initialized empty Git repository in C:/temp/EyeChamp/.git/

C:\temp\EyeChamp>git remote add origin https://github.com/michelmeeuwissen/EyeChamp.git

C:\temp\EyeChamp>git fetch

remote: Counting objects: 107, done.
remote: Compressing objects: 100% (60/60), done.
remote: Total 107 (delta 24), reused 103 (delta 24)
Receiving objects: 100% (107/107), 266.62 KiB | 0 bytes/s, done.
Resolving deltas: 100% (24/24), done.
From https://github.com/michelmeeuwissen/EyeChamp
 * [new branch]      HEAD       -> origin/HEAD
 * [new branch]      master     -> origin/master

C:\temp\EyeChamp>git checkout -t origin/master

Branch master set up to track remote branch master from origin.
Already on 'master'

################# Installation directory

Create install directory on system (also on windows root drive):

/eyechamp/config/eyechamp.properties

/eyechamp/log/


################# MongoDB:
Download:
http://www.mongodb.org/downloads

Install MongoDB for your system.
Windows:
http://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/

* After install open MongoDB console
Create db eyechamp and repositories by running the following comando's in mongo console:

> use eyechamp

> db.createCollection("players")
