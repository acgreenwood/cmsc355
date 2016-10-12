# SuccessSquad-cmsc355-android-app
# APP NAME: SEAN

On October 6th, the MainActivity, NoSuchShowExists, and AddNewSeries java and XML files were uploaded into the github repository. Difficulties uploading the files were encountered early on but quickly resolved after fixing up the string files in one of the xml files. One day later a WIP of the app's database (in the form of a temporary ArrayList) was uploaded, with work being done to it in the following days after the upload. 

October 9th, 2016: HomePage, MyArchive, AppSettings, and Profile java and XML files were added to the repository. Code changes to the existing files on the respository were made to accomodate the new files that were uploaded:
-Updated MainActivity (renamed as SearchPage), NoSuchShowExists, and AddNewSeries java and XML files.
-Updated strings.xml file to reflect new uploads and updated code strings.
-Shifted Main Activity Launcher from SearchPage to HomePage.

October 11th, 2016 Iteration 1 Report:
  Most things went as expected. Creating the interfaces proved to be easier than figuring out android studio, AVDs, Espresso, and other stuff. We came to a roadblock when trying to implement a ListView with data from the temporary database, which was caused the learning curve of the different view and intent methods. Our biggest obstacle was deciding how to implement the database for series. We attempted to use firebase, but with no gradle experience we couldn't figure out how to get it to work. We decided to implement a temporary one in memory for now, possibly moving to a local (file) database or more hopefully an online one the next iteration.
  The best improvement we could work on for next iteration is come up with a more cohesive plan and enforcing rules like downloading the latest repository very often, and not waiting too long too commit, or perhaps restricting commits to only a few classes at a time, so that there is less overlap.
  What we ended up with was a very good start to the interface, with a home page with buttons to other planned pages. The only paths implemented right now are the search page, the add new series page, and the list display page (lists the shows found after searching). We have a temporary database, and a class with specific API to access that database. Users can add shows to the archive, and search for shows using search terms.
