(ns ohce.unit-tests.console-notifications-test
  (:require
    [midje.sweet :refer :all]
    [ohce.notifications :refer [console-notifier greet bye-user echo palindromes-rock]]))

(facts
  "about console notifications"

  (let [notifier (console-notifier
                   {:bye-word "Adios"
                    :celebration "¡Bonita palabra!"})]
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

    (fact
      "echoing word"

      (clojure.string/split
        (with-out-str (echo notifier "moko"))
        #"\n") => ["moko"])

    (fact
      "celebrating palindromes"

      (clojure.string/split
        (with-out-str (palindromes-rock notifier))
        #"\n") => ["¡Bonita palabra!"])

    ))

