/*
   Tasks that need to be performed to create a database inti
   1) create a database
   2) create a user and password for the database
   3) create collection(Table) inside the database
   4) create document(s)(row) inside the collection
   */
//1) create a new database
db = db.getSiblingDB('job');

//2) create user and password
db.createUser({
    user: "job_user",
    pwd: "job_password",
    roles:[
        {
            role: "readWrite",
            db: "job"
        }
    ]
});

//3) create collection(Tables)

db.createCollection('job');

//4) create document
db.job.insertMany([
    {
        description: "senior java developer",
        company: "amazon",
        skills: ["java", "spring", "docker"],
        salary: 100000,
        isRemote: true
    },
    {
        description: "junior java developer",
        company: "apple",
        skills: ["java"],
        salary: 60000,
        isRemote: false
    },
    {
        description: "scrum master",
        company: "amazon",
        skills: ["agile", "jira", "java"],
        salary: 90000,
        isRemote: true
    },
    {
        description: "Lead java developer",
        company: "microsoft",
        skills: ["java", "spring", "docker","agile"],
        salary: 120000,
        isRemote: true
    },
    {
        description: "java developer",
        company: "amazon",
        skills: ["java", "spring", "git"],
        salary: 900000,
        isRemote: true
    },
    {
        description: "senior Cloud developer",
        company: "Intel",
        skills: ["java", "spring", "docker","AWSCloud","Git"],
        salary: 120000,
        isRemote: true
    },
    {
        description: "junior java developer",
        company: "amazon",
        skills: ["JavaScript","Html"],
        salary: 70000,
        isRemote: true
    },
    {
        description: "senior frontEnd developer",
        company: "amazon",
        skills: ["JavaScript","React","Git","Html"],
        salary: 110000,
        isRemote: false
    }

]);