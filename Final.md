Self-grade: 2.25/5

- Database with multiple tables
  - Utilized traditional database from Mort tech talk to [store user login information](https://github.com/zenxha/musicgacha/tree/main/src/main/java/com/musicgacha/controllers/database/person) in table format
  - Quered our [JSON files](https://github.com/zenxha/musicgacha/tree/main/src/main/resources/static/json/characters) within [the roll controller](https://github.com/zenxha/musicgacha/blob/6a1ef76752ce09fdc7434989592676fa50d11ee0/src/main/java/com/musicgacha/controllers/RollController.java#L47-L51) to establish a JSON formatted database for "rolling" characters through our gacha system
- Authentication and authorization controls
  - User authentication is required via [spring security](https://github.com/zenxha/musicgacha/tree/main/src/main/java/com/musicgacha/controllers/security) to establish an account to store characters into their inventory (note: this inventory feature wasn't fully implemented at the end)
- Meaningful Capture (ex: notes/upload and associated tables)
  - Added a [notes section](https://github.com/zenxha/musicgacha/tree/main/src/main/java/com/musicgacha/controllers/database/note), which was modified into a profile page and bio section, with plans to act as an inventory system for each user
- Creativity and applications of new Tech feature features to Sponsor Project
  - Tech features were creativity added by modifying it to fit our theme. (ex: notes -> user profile/inventory, upload -> create your own character card)
- Not adding distracting features for Sponsor theme, ie non-applicable games, non-applicable fun zones
  - No side games added, website focused primarily on the gacha system