(ns ohce.unit-tests.console-notifications-test
  (:require
    [midje.sweet :refer :all]
    [ohce.notifications :refer [console-notifier greet bye-user]]))

(facts
  "about console notifications"

  (let [notifier (console-notifier)]
    (fact
      "greeting user"

      (clojure.string/split
        (with-out-str (greet notifier "greeting"))
        #"\n") => ["greeting"])

    (fact
      "greeting user"

      (clojure.string/split
        (with-out-str (bye-user notifier "Juan"))
        #"\n") => ["Adios Juan"])
    ))

