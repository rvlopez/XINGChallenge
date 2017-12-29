# XINGChallenge

## Dependencies used:

* RxJava -> Reactive Programming (https://github.com/ReactiveX/RxJava)
* Dagger 2 -> Inject dependencies (https://google.github.io/dagger/)
* Retrofit -> Request/Response API. (http://square.github.io/retrofit/)
* GSON -> Parse JSON to Java POJOs (https://github.com/google/gson)
* ButterKnife -> Bind views to java code easily and avoiding some code boilerplate (http://jakewharton.github.io/butterknife/)

## Functionalities implemented:

* Bootstrap a new Android app.
* Request the GitHub API to show XING's public repositories and parse the JSON response.
* Display a list of repositories, each entry should show
    * repo name
    * description
    * login of the owner
* Request only 10 repos at a time. Use an endless list with a load more mechanism. The load more should be triggered when the scrolling is close to reaching the end of the list. Check the pagination documentation.
* Show a light green background if the fork flag is false or missing, a white one otherwise.
* On a long click on a list item show a dialog to ask if go to repository html_url or owner html_url which is opened then in the browser.
