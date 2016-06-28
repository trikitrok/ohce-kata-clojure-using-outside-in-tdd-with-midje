# ohce

[Ohce kata](http://garajeando.blogspot.com.es/2016/05/the-ohce-kata-short-and-simple-exercise.html)
in Clojure using outside-in TDD with Midje.

## How to run the tests

The project uses [Midje](https://github.com/marick/Midje/).

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
